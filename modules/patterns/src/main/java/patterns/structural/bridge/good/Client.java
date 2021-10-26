package patterns.structural.bridge.good;

import java.util.List;

public class Client {
    public static void main(String args[]) {
        Exchange nasdaqExchange = new NasdaqExchange();
        Exchange dowJonesExchange = new DowJonesExchange();

        TradingBot riskyNasdaq = new RiskyTrader(nasdaqExchange);
        TradingBot riskyDow = new RiskyTrader(dowJonesExchange);
        TradingBot cautiousNasdaq = new CautiousTrader(nasdaqExchange);
        TradingBot cautiousDow = new CautiousTrader(dowJonesExchange);

        List.of(riskyNasdaq, riskyDow, cautiousDow, cautiousNasdaq)
            .stream()
            .forEach(bot -> bot.buy("AI"));
    }
}
