package com.projeto.estacionai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.projeto.estacionai")
public class EstacionaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionaiApplication.class, args);
	}
}
