package br.com.rabbitbank.rabbitbank.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@JsonInclude(Include.NON_NULL)
public class UserDTO {

    @NotBlank
    private String login;

    private String password;
    private String email;
    private String fullName;
    private String cpf;
    private LocalDate birthDate;
    private Double balance;

}
