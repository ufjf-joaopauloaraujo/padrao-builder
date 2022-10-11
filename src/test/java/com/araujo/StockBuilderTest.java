package com.araujo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StockBuilderTest {

    @Test
    void validateMissingTickerError() {
        StockBuilder stockBuilder = new StockBuilder();
        try {
            Stock stock = stockBuilder
                    .setCompanyName("Microsoft")
                    .setCurrentPrice(new BigDecimal("233.50"))
                    .build();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Ticker inválido", e.getMessage());
        }
    }

    @Test
    void validateMissingCompanyNameError() {
        StockBuilder stockBuilder = new StockBuilder();
        try {
            Stock stock = stockBuilder
                    .setTicker("MSFT")
                    .setCurrentPrice(new BigDecimal("233.50"))
                    .build();
            fail();
        } catch (NullPointerException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void validateStockBuilderSuccess() {
        StockBuilder stockBuilder = new StockBuilder();
        Stock stock = stockBuilder
                .setTicker("MSFT")
                .setCompanyName("Microsoft")
                .setCurrentPrice(new BigDecimal("233.50"))
                .build();

        assertEquals("MSFT", stock.getTicker());
        assertEquals("Microsoft", stock.getCompanyName());
        assertEquals(new BigDecimal("233.50"), stock.getCurrentPrice());
    }
}