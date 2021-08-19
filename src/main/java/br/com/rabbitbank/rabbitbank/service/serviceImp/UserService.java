package br.com.rabbitbank.rabbitbank.service.serviceImp;

import br.com.rabbitbank.rabbitbank.exceptions.RulesException;
import br.com.rabbitbank.rabbitbank.model.Transaction;
import br.com.rabbitbank.rabbitbank.repository.UserRepository;
import br.com.rabbitbank.rabbitbank.model.User;
import br.com.rabbitbank.rabbitbank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

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
    public void insertNewBalance(Transaction transaction, Boolean isCreditCard) {

    }
}
