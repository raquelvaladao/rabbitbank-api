package br.com.rabbitbank.rabbitbank.resource;

import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import br.com.rabbitbank.rabbitbank.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends BaseResource<TransactionDTO> {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDTO> saveTransaction(@RequestBody @Valid TransactionDTO transactionDTO, UriComponentsBuilder uriBuilder){
        TransactionDTO resultOfTransaction = transactionService.process(transactionDTO);
        return answerCreatedItemWithURI(resultOfTransaction,
                uriBuilder,
                "/transactions/{code}",
                resultOfTransaction.getCode());
    }

    @GetMapping
    public ResponseEntity<Page<TransactionDTO>> listTransactions(@PageableDefault(page = 0, size = 20) PageableDefault pagination,
                                                           @RequestParam String login) {
        Page<TransactionDTO> dtoTransactions = transactionService.listItems(pagination, login);
        return answerPaginatedListOfItems(dtoTransactions);
    }

    }
