package br.com.rabbitbank.rabbitbank.service;

import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService {
    TransactionDTO process(TransactionDTO transactionDTO);

    Page<TransactionDTO> listItems(PageableDefault pagination, String login);
}
