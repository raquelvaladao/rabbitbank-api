package br.com.rabbitbank.rabbitbank.config;


import br.com.rabbitbank.rabbitbank.model.User;
import br.com.rabbitbank.rabbitbank.repository.UserRepository;
import br.com.rabbitbank.rabbitbank.service.TokenService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Getter
@Setter
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserRepository userRepository;

    public AuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = gatherToken(httpServletRequest);
        Boolean tokenIsValid = tokenService.checkTokenValidity(token); //vamos validar o cliente.

        if(tokenIsValid){
            authenticateUser(token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String gatherToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }

    private void authenticateUser(String token) {
        Long gatheredUserId = tokenService.getUserIdFromGeneratedToken(token);
        User givenTokenFoundUser = userRepository.findById(gatheredUserId).get();

        UsernamePasswordAuthenticationToken authAfterTokenValidation = new UsernamePasswordAuthenticationToken(
                givenTokenFoundUser,
                null,
                givenTokenFoundUser.getAuthorities());
        //criar contexto de requisição pra que o usuário continue solicitando recursos da aplicação
        SecurityContextHolder.getContext().setAuthentication(authAfterTokenValidation);
    }
}
