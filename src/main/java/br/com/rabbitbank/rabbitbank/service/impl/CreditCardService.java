package br.com.rabbitbank.rabbitbank.service.impl;

import br.com.rabbitbank.rabbitbank.converters.CreditCardConverter;
import br.com.rabbitbank.rabbitbank.dto.CreditCardDTO;
import br.com.rabbitbank.rabbitbank.model.CreditCard;
import br.com.rabbitbank.rabbitbank.repository.CreditCardRepository;
import br.com.rabbitbank.rabbitbank.service.ICreditCardService;
import br.com.rabbitbank.rabbitbank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements ICreditCardService {

    @Autowired
    private IUserService userService;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardConverter creditCardConverter;

    @Override
    public CreditCardDTO saveCreditCard(CreditCardDTO creditCardDTO) {
        CreditCardDTO creditCardReturn = null;
        if (creditCardDTO.getIsSaved()) {
            CreditCard creditCard = creditCardConverter.mapDTOToEntity(creditCardDTO);
            userService.validate(creditCard.getUser());
            CreditCard savedCreditCard = creditCardRepository.save(creditCard);
            creditCardReturn = creditCardConverter.mapEntityToDTO(savedCreditCard);
        }

        return creditCardReturn;
    }
}
