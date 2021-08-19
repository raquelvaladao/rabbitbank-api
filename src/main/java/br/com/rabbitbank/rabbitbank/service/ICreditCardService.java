package br.com.rabbitbank.rabbitbank.service;


import br.com.rabbitbank.rabbitbank.dto.CreditCardDTO;



public interface ICreditCardService {
    CreditCardDTO saveCreditCard(CreditCardDTO creditCardDTO);
}
