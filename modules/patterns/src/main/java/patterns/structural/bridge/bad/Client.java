package patterns.structural.bridge.bad;

import java.util.List;

public class Client {
    public static void main(String args[]) {
        TradingBot tradingBot1 = new DowJonesCautiousTrader();
        TradingBot tradingBot2 = new NasdaqRiskyTrader();
        TradingBot tradingBot3 = new DowJonesRiskyTrader();
        TradingBot tradingBot4 = new NasdaqCautiousTrader();

        List.of(tradingBot1, tradingBot2, tradingBot3, tradingBot4)
            .stream()
            .forEach(bot -> bot.buy("AI"));
    }
}
