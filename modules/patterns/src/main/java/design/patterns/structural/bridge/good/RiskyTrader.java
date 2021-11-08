package design.patterns.structural.bridge.good;

import java.util.List;

public class RiskyTrader extends TradingBot {
    public RiskyTrader(Exchange exchange) {
        super(exchange);
    }

    @Override
    boolean shouldBuy(List<Double> prices) {
        return false;
    }
}
