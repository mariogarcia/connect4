package design.patterns.structural.bridge.good;

import java.util.List;

public interface Exchange {
    List<Double> findLastMonthPricesBySymbol(String symbol);
}
