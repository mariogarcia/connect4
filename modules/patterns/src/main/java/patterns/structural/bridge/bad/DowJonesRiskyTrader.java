package patterns.structural.bridge.bad;

import java.util.List;

public class DowJonesRiskyTrader extends RiskyTrader {
    @Override
    List<Double> findLastMonthPricesBySymbol(String symbol) {
        return null;
    }
}
