package patterns.structural.bridge.bad;

import java.util.List;

public class NasdaqRiskyTrader extends RiskyTrader {
    @Override
    List<Double> findLastMonthPricesBySymbol(String symbol) {
        return null;
    }
}
