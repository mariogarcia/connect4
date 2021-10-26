package patterns.structural.bridge.good;

import java.util.List;

public abstract class TradingBot {
    private final Exchange exchange;

    public TradingBot(Exchange exchange) {
        this.exchange = exchange;
    }

    void buy(String symbol) {
        List<Double> lastMonthPrices = this.exchange.findLastMonthPricesBySymbol(symbol);

        if (shouldBuy(lastMonthPrices)) {
            Double lastPrice = lastMonthPrices.get(lastMonthPrices.size() - 1);
            System.out.printf("buying %s at price %f \n", symbol, lastPrice);
        }
    }

    abstract boolean shouldBuy(List<Double> prices);
}
