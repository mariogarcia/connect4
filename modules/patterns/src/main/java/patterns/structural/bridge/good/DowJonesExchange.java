package patterns.structural.bridge.good;

import java.util.List;

public class DowJonesExchange implements Exchange {
    @Override
    public List<Double> findLastMonthPricesBySymbol(String symbol) {
        return null;
    }
}
