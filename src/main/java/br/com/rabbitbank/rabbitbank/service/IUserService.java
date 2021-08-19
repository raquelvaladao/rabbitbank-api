package br.com.rabbitbank.rabbitbank.service;

import br.com.rabbitbank.rabbitbank.model.Transaction;
import br.com.rabbitbank.rabbitbank.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User consultEntity(String login);

    void validate(User... users);

    void insertNewBalance(Transaction transaction, Boolean isCreditCard);
}
