package com.francesco.esercizio_1.services;

import org.springframework.stereotype.Service;

@Service
public class PriceService {
    public double calcDiscountedPrice(double price, int discount) {
        return price - (price * discount / 100.0);
    }
}
