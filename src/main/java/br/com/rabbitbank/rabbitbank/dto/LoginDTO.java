package br.com.rabbitbank.rabbitbank.dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UsernamePasswordAuthenticationToken turnDtoIntoTokenForm(){
        return new UsernamePasswordAuthenticationToken(username,password);
    }
}
