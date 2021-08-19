package br.com.rabbitbank.rabbitbank.service.serviceImp;

import br.com.rabbitbank.rabbitbank.converters.TransactionConverter;
import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import br.com.rabbitbank.rabbitbank.model.Transaction;
import br.com.rabbitbank.rabbitbank.repository.TransactionRepository;
import br.com.rabbitbank.rabbitbank.service.ICreditCardService;
import br.com.rabbitbank.rabbitbank.service.ITransactionService;
import br.com.rabbitbank.rabbitbank.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionConverter transactionConverter;

    @Autowired
    private IUserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ICreditCardService creditCardService;

    @Override
    public TransactionDTO process(TransactionDTO transactionDTO) {
        Transaction transaction = saveTransaction(transactionDTO);
        creditCardService.saveCreditCard(transactionDTO.getCreditCard());
        //async task, check if it is used, since the transaction already happened.
        userService.insertNewBalance(transaction, transactionDTO.getIsCreditCard());
        return transactionConverter.mapEntityToDTO(transaction);
    }

    @Override
    public Page<TransactionDTO> listItems(PageableDefault pagination, String login) {
        Page<Transaction> transactionsPaged = transactionRepository.findByOrigin_LoginOrDestiny_Login(login, login, pagination);
        return transactionConverter.ParsePageEntityToDTO(transactionsPaged);
    }

    private Transaction saveTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionConverter.mapDTOToEntity(transactionDTO);

        userService.validate(transaction.getDestiny(), transaction.getOrigin());
        return transactionRepository.save(transaction);
    }


}
