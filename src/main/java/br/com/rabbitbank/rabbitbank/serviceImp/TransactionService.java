package br.com.rabbitbank.rabbitbank.serviceImp;

import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import br.com.rabbitbank.rabbitbank.model.Transaction;
import br.com.rabbitbank.rabbitbank.service.ITransactionService;

public class TransactionService implements ITransactionService {
    @Override
    public TransactionDTO process(TransactionDTO transactionDTO) {
        Transaction transaction = saveTransaction(transactionDTO);
        creditCardService.save(transactionDTO.getCreditCard());
        //async task, check if it is used, since the transaction already happened.
        userService.insertNewBalance(transaction, transactionDTO.getIsCreditCard());
        return transactionConverter.mapEntityToDTO(transaction);
    }

    private Transaction saveTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = transactionConverter.mapDTOToEntity(transactionDTO);

        userService.validate(transaction.getDestiny(), transaction.getOrigin());
        return transactionRepository.save(transaction);
    }
}
