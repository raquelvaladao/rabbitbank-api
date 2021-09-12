package br.com.rabbitbank.rabbitbank.repository;

import br.com.rabbitbank.rabbitbank.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByOrigin_LoginOrDestiny_Login(String login, String login1, Pageable pagination);
}
