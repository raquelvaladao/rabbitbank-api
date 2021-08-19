package br.com.rabbitbank.rabbitbank.service;


import br.com.rabbitbank.rabbitbank.dto.CreditCardDTO;
import org.springframework.stereotype.Service;

@Service
public interface ICreditCardService {
    CreditCardDTO saveCreditCard(CreditCardDTO creditCardDTO);
}
