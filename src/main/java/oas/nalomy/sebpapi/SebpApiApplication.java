package oas.nalomy.sebpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SebpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SebpApiApplication.class, args);
	}

}
