package br.com.rabbitbank.rabbitbank.converters;

import br.com.rabbitbank.rabbitbank.dto.CreditCardDTO;
import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import br.com.rabbitbank.rabbitbank.model.CreditCard;
import br.com.rabbitbank.rabbitbank.model.Transaction;
import br.com.rabbitbank.rabbitbank.service.IUserService;
import br.com.rabbitbank.rabbitbank.utils.CreditCardUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditCardConverter extends BaseConverter<CreditCardDTO, CreditCard> {

    @Autowired
    private IUserService userService;

    @Override
    public CreditCardDTO mapEntityToDTO(CreditCard entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<CreditCard, CreditCardDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entity, CreditCardDTO.class);
    }

    @Override
    public CreditCard mapDTOToEntity(CreditCardDTO dto) {
        return CreditCard
                .builder()
                .flag(dto.getFlag())
                .number(CreditCardUtil.maskNumber(dto.getNumber()))
                .tokenNumber(dto.getTokenNumber())
                .user(userService.consultEntity(dto.getUser().getLogin()))
                .build();
    }
}
