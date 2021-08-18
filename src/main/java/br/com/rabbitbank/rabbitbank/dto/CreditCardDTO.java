package br.com.rabbitbank.rabbitbank.dto;

import br.com.rabbitbank.rabbitbank.model.CreditCardFlag;
import br.com.rabbitbank.rabbitbank.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@JsonInclude(Include.NON_NULL)
public class CreditCardDTO {
    @NotBlank
    private String number;

    @NotNull
    private CreditCardFlag flag;

    @NotBlank
    private String tokenNumber;

    @NotNull
    private UserDTO user;

    @NotBlank
    private String expireDate;

    @NotBlank
    private String securityCode;

    @NotBlank
    private String ownerName;

    private Boolean isSaved = false;

}
