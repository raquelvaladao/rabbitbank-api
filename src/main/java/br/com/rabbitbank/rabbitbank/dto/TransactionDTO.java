package br.com.rabbitbank.rabbitbank.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@JsonInclude(Include.NON_NULL)
public class TransactionDTO {

    @NotBlank
    private String code;

    @NotNull
    private UserDTO origin;

    @NotNull
    private UserDTO destiny;

    @NotNull
    private LocalDate time;

    @NotNull
    private Double value;

    private CreditCardDTO creditCard;
    private Boolean isCreditCard = false;
}
