package br.com.rabbitbank.rabbitbank.converters;

import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import br.com.rabbitbank.rabbitbank.model.Transaction;
import br.com.rabbitbank.rabbitbank.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter extends BaseConverter<TransactionDTO, Transaction>{
    @Autowired
    private IUserService userService;

    @SuppressWarnings("unchecked")
    public Page<TransactionDTO> ParsePageEntityToDTO(Page<Transaction> entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Page<Transaction>, Page<TransactionDTO>>() {
            @Override
            protected void configure() {
            }
        });

        return modelMapper.map(entity, Page.class);
    }

    @Override
    public TransactionDTO mapEntityToDTO(Transaction entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Transaction, TransactionDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entity, TransactionDTO.class);
    }
    @Override
    public Transaction mapDTOToEntity(TransactionDTO dto) {
        return Transaction.builder()
                .code(dto.getCode())
                .time(dto.getTime())
                .value(dto.getValue())
                .destiny(userService.consultEntity(dto.getDestiny().getLogin()))
                .origin(userService.consultEntity(dto.getOrigin().getLogin()))
                .build();
    }
}
