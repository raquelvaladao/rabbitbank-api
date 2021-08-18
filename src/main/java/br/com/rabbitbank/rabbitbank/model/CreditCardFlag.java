package br.com.rabbitbank.rabbitbank.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum CreditCardFlag {

    VISA("Visa"),
    MASTERCARD("Mastercard"),
    ELO("Elo");

    private final String description;

    CreditCardFlag(String description) {
        this.description = description;
    }

}
