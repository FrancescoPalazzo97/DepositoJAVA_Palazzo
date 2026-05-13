package com.francesco.esercizio_1.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
    List<String> productsNames;
    Map<String, Double> productsPrices;

    private final PriceService priceService;

    public ProductService(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostConstruct
    private void insertInitialData() {
        productsNames = new ArrayList<>(List.of("Laptop Pro 15", "Mouse Wireless", "Tastiera meccanica"));
        productsPrices = new HashMap<>();
        productsPrices.put("Laptop Pro 15", 1500.0);
        productsPrices.put("Mouse Wireless", 25.0);
        productsPrices.put("Tastiera meccanica", 100.0);
    }

    public void printCatalogue(int discount) {
        for (String name : productsNames) {
            double price = productsPrices.get(name);
            double discountedPrice = priceService.calcDiscountedPrice(price, discount);
            System.out.println("Nome: " + name + " | Prezzo: " + discountedPrice + "$");
        }
    }
}
