package br.com.rabbitbank.rabbitbank.repository;

import br.com.rabbitbank.rabbitbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);

    @Modifying
    @Query("update User u set u.balance = u.balance + ?2 where u.login = ?1")
    void updateIncrementBalance(String login, Double value);

    @Modifying
    @Query("update User u set u.balance = u.balance - ?2 where u.login = ?1")
    void updateDecrementBalance(String login, Double value);

}
