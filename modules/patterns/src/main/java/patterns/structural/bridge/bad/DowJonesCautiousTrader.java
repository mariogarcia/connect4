package patterns.structural.bridge.bad;

import java.util.List;

public class DowJonesCautiousTrader extends CautiousTrader {
    @Override
    List<Double> findLastMonthPricesBySymbol(String symbol) {
        return null;
    }
}
