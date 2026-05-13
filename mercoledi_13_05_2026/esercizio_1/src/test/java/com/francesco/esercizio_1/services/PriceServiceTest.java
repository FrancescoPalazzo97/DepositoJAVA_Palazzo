package com.francesco.esercizio_1.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceServiceTest {

    @Test
    void calcDiscountedPriceReturnsPriceAfterPercentageDiscount() {
        PriceService priceService = new PriceService();

        double discountedPrice = priceService.calcDiscountedPrice(100.0, 20);

        assertEquals(80.0, discountedPrice);
    }
}
