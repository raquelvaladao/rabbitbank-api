package br.com.rabbitbank.rabbitbank.service;

import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


public interface ITransactionService {
    TransactionDTO process(TransactionDTO transactionDTO);

    Page<TransactionDTO> listItems(Pageable pagination, String login);
}
