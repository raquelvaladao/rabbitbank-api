package br.com.rabbitbank.rabbitbank.resource;


import br.com.rabbitbank.rabbitbank.dto.UserDTO;
import br.com.rabbitbank.rabbitbank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource extends BaseResource<UserDTO> {

    @Autowired
    private IUserService userService;

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> consultUser(@PathVariable String login){
        UserDTO userDTO = userService.consult(login);
        return answerSuccessWithItem(userDTO);
    }
    @GetMapping("/contacts")
    public ResponseEntity<List<UserDTO>> lists(@RequestParam String login){
        List<UserDTO> userDTOList = userService.listUsers(login);
        return answerListOfItems(userDTOList);
    }

    @GetMapping("/{login}/balance")
    public ResponseEntity<UserDTO> consultBalance(@PathVariable String login){
        UserDTO userDTO = userService.consult(login);
        return answerSuccessWithItem(userDTO);
    }
}
