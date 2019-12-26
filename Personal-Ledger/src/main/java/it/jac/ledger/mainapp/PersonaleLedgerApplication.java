package it.jac.ledger.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "it.jac.ledger")
public class PersonaleLedgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaleLedgerApplication.class, args);
	}

}
