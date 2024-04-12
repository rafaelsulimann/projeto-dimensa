package com.sulimann.dimensa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DimensaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DimensaApplication.class, args);
	}

}
