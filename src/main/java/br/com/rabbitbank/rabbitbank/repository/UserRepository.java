package br.com.rabbitbank.rabbitbank.repository;

import br.com.rabbitbank.rabbitbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String login);
}
