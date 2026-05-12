package org.francesco.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.francesco.demo.run.Location;
import org.francesco.demo.run.RunRecord;
import org.francesco.demo.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		System.out.println("=== JAVA BEANS ===");
		String[] beansNames = ctx.getBeanDefinitionNames();

		for (String name : beansNames) {
			if (!name.contains("org.springframework")) {
				System.out.println(" - " + name);
			}
		}

		WelcomeMessage welcomeMessage = new WelcomeMessage();
		System.out.println(welcomeMessage.getWelcomeMessage());

		RunRecord r = new RunRecord(
				1,
				"Corsetta",
				LocalDateTime.of(2026, 5, 12, 8, 0),
				LocalDateTime.of(2026, 5, 12, 10, 0),
				5,
				Location.OUTDOOR);

		System.out.println(r.title());
		System.out.println(r.startedOn());
		System.out.println(r.completedOn());
		System.out.println(r.miles());
	}

	@Bean
	CommandLineRunner runner(OrderService orderService) {
		return args -> {
			RunRecord run = new RunRecord(
					2,
					"Corsa mattutina",
					LocalDateTime.now(),
					LocalDateTime.now().plus(1, ChronoUnit.HOURS),
					3,
					Location.INDOOR);

			System.out.println("Run " + run);

			orderService.processOrder("1234");
			orderService.processOrder("0987");
		};
	}

}
