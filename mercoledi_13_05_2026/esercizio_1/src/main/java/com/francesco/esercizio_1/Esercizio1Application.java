package com.francesco.esercizio_1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.francesco.esercizio_1.services.ProductService;

@SpringBootApplication
public class Esercizio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio1Application.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			System.out.println("\n=========\n");
			productService.printCatalogue(20);
			System.out.println("\n=========\n");
			productService.printCatalogue(50);
			System.out.println("\n=========\n");
		};
	}

}
