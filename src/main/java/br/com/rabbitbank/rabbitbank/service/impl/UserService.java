package br.com.rabbitbank.rabbitbank.service.impl;

import br.com.rabbitbank.rabbitbank.converters.UserConverter;
import br.com.rabbitbank.rabbitbank.dto.UserDTO;
import br.com.rabbitbank.rabbitbank.exceptions.RulesException;
import br.com.rabbitbank.rabbitbank.model.Transaction;
import br.com.rabbitbank.rabbitbank.repository.UserRepository;
import br.com.rabbitbank.rabbitbank.model.User;
import br.com.rabbitbank.rabbitbank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public User consultEntity(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void validate(User... users) {
        List<User> userList = new ArrayList<User>(Arrays.asList(users));

        userList.stream().forEach(user -> {
            if (user == null){
                throw new RulesException("O usuário não existe");
            }
        });


    }

    @Override
    @Async("asyncExecutor")
    public void insertNewBalance(Transaction transaction, Boolean isCreditCard) {
        incrementBalance(transaction);
        decrementBalance(transaction, isCreditCard);
    }

    @Override
    public UserDTO consult(String login) {
        User user = consultEntity(login);
        return userConverter.mapEntityToDTO(user);
    }

    @Override
    public List<UserDTO> listUsers(String login) {
        List<User> users = userRepository.findAll();
        List<User> collect = users.stream().filter(u -> !u.getLogin().equals(login))
                .collect(Collectors.toList());
        return userConverter.mapEntitiesToDTOs(collect);
    }

    private void decrementBalance(Transaction transaction, Boolean isCreditCard) {
        if(!isCreditCard) {
            userRepository.updateDecrementBalance(transaction.getOrigin().getLogin(), transaction.getValue());
        }
    }

    private void incrementBalance(Transaction transaction) {
        userRepository.updateIncrementBalance(transaction.getDestiny().getLogin(), transaction.getValue());
    }


}
