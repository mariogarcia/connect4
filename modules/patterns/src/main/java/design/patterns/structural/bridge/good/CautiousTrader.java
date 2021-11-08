package design.patterns.structural.bridge.good;

import java.util.List;

public class CautiousTrader extends TradingBot {
    public CautiousTrader(Exchange exchange) {
        super(exchange);
    }

    @Override
    boolean shouldBuy(List<Double> prices) {
        return false;
    }
}
