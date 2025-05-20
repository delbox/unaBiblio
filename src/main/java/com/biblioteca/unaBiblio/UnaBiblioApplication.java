package com.biblioteca.unaBiblio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class UnaBiblioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnaBiblioApplication.class, args);
	
	}

}
