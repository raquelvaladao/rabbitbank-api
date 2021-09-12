package br.com.rabbitbank.rabbitbank.service;

import br.com.rabbitbank.rabbitbank.enums.ValidationMessage;
import br.com.rabbitbank.rabbitbank.model.User;
import br.com.rabbitbank.rabbitbank.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
       User userToCheck = userService.consultEntity(userLogin);

       //validação
        if(!validateUser(userToCheck)){
            throw new UsernameNotFoundException(ValidationMessage.USER_NOT_FOUND_OR_PEMITTED);
        }
        return userToCheck;
    }

    private boolean validateUser(User user) {
        boolean userValidated = false;

        if(user != null && user.getPermissionType() != null && user.getActive()){
            userValidated = true;
        }
        return userValidated;
    }
}
