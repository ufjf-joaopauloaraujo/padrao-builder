package com.araujo;

import java.math.BigDecimal;

public class StockBuilder {

    private Stock stock;

    public StockBuilder() {
        stock = new Stock();
    }

    public Stock build() {
        if (null == stock.getTicker()) {
            throw new NullPointerException("Ticker inválido");
        }
        if (null == stock.getCompanyName()) {
            throw new NullPointerException("Nome inválido");
        }
        return stock;
    }

    public StockBuilder setTicker(String ticker) {
        stock.setTicker(ticker);
        return this;
    }

    public StockBuilder setCompanyName(String companyName) {
        stock.setCompanyName(companyName);
        return this;
    }

    public StockBuilder setCurrentPrice(BigDecimal currentPrice) {
        stock.setCurrentPrice(currentPrice);
        return this;
    }
}
