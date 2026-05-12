package org.francesco.demo;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class WelcomeMessage {

    public String getWelcomeMessage() {
        return "Welcome to Spring Boot!!!";
    }

    @PostConstruct
    public void init() {
        System.out.println("Applicazione avviata con successo");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Applicazione distrutta con successo");
    }
}
