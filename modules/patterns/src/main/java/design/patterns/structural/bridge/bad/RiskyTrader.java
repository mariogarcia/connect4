package design.patterns.structural.bridge.bad;

import java.util.List;

public abstract class RiskyTrader extends TradingBot {
    @Override
    boolean shouldBuy(List<Double> prices) {
        return false;
    }
}
