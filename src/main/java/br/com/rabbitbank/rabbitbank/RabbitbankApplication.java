package br.com.rabbitbank.rabbitbank;

import br.com.rabbitbank.rabbitbank.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class RabbitbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitbankApplication.class, args);
	}

}
