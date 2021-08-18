package br.com.rabbitbank.rabbitbank.resource;

import br.com.rabbitbank.rabbitbank.dto.TransactionDTO;
import br.com.rabbitbank.rabbitbank.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
