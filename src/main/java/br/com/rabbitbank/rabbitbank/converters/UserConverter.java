package br.com.rabbitbank.rabbitbank.converters;

import br.com.rabbitbank.rabbitbank.dto.UserDTO;
import br.com.rabbitbank.rabbitbank.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<UserDTO, User> {
    @Override
    public UserDTO mapEntityToDTO(User entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entity, UserDTO.class);
    }

    @Override
    public User mapDTOToEntity(UserDTO dto) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(dto, User.class);
    }
}
