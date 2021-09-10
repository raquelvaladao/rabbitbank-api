package br.com.rabbitbank.rabbitbank.service;

import br.com.rabbitbank.rabbitbank.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    //injetamos o tempo de expiracao do app.yml
    @Value("${rabbitbank.jwt.expiration}")
    private String expiration;

    @Value("${rabbitbank.jwt.expiration}")
    private String secretString;

    //vamos gerar um token para autenticar o usuário.
    //ele irá guardar algumas infos do usuário (User)
    public String generateToken(Authentication authenticate) {
       User loggedUser = (User) authenticate.getPrincipal(); //aqui ele está logado. getPrincipal me envia infos dele.
       Date today = new Date();
       Date expirationTime = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts
                .builder()
                .setIssuer("Rabbitbank token")
                .setSubject(loggedUser.getId().toString())
                .setIssuedAt(expirationTime)
                .signWith(SignatureAlgorithm.HS256, secretString)
                .compact();
    }
}
