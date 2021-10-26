package patterns.structural.bridge.bad;

import java.util.List;

public class NasdaqCautiousTrader extends CautiousTrader {

    @Override
    List<Double> findLastMonthPricesBySymbol(String symbol) {
        return null;
    }
}
