package design.patterns.structural.bridge.bad;

import java.util.List;

public abstract class CautiousTrader extends TradingBot {
    @Override
    boolean shouldBuy(List<Double> prices) {
        return false;
    }
}
