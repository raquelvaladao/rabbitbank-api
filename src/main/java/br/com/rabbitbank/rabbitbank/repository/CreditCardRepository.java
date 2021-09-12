package br.com.rabbitbank.rabbitbank.repository;

import br.com.rabbitbank.rabbitbank.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
