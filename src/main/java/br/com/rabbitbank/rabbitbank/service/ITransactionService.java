package br.com.rabbitbank.rabbitbank.service;

import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService {
    TransactionDTO process(TransactionDTO transactionDTO);
}
