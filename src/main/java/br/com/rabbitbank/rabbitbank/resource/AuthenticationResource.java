package br.com.rabbitbank.rabbitbank.resource;

import br.com.rabbitbank.rabbitbank.dto.LoginDTO;
import br.com.rabbitbank.rabbitbank.dto.TokenDTO;
import br.com.rabbitbank.rabbitbank.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationResource extends BaseResource<TokenDTO> {

    @Autowired
    private AuthenticationManager authManager;         //configuraremos o service que irá buscar o usuário no banco.

    private TokenService tokenService;

    public ResponseEntity<TokenDTO> authenticateUser(LoginDTO loginDto){
        UsernamePasswordAuthenticationToken loginData = loginDto.turnDtoIntoTokenForm();

        try {
            //vai para a camada de autenticação de serviço. Se der certo
            Authentication authenticate = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authenticate);
            return answerSuccessWithItem(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e) {
            return answerBadRequestCall();
        }
    }

}
