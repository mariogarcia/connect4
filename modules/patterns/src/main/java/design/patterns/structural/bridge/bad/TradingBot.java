package design.patterns.structural.bridge.bad;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public abstract class TradingBot {
    void buy(String symbol) {
        List<Double> lastMonthPrices = this.findLastMonthPricesBySymbol(symbol);

        if (shouldBuy(lastMonthPrices)) {
            Double lastPrice = lastMonthPrices.get(lastMonthPrices.size() - 1);
            System.out.printf("buying %s at price %f \n", symbol, lastPrice);
        }
    }
    abstract List<Double> findLastMonthPricesBySymbol(String symbol);
    abstract boolean shouldBuy(List<Double> prices);
}
