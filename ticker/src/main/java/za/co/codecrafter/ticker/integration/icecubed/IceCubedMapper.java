package za.co.codecrafter.ticker.integration.icecubed;

import za.co.codecrafter.ticker.mapper.TickerMapper;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Source;

import java.util.Date;
import java.util.Map;


/**
 * Created by arnoe on 2017/09/04.
 */
public class IceCubedMapper extends TickerMapper<IceCubedTicker> {

    private Map<String, String> usdBasedConversionRates;

    public IceCubedMapper(Map<String, String> usdBasedConversionRates) {
        super(Source.IceCubed, CurrencyPair.USDBTC);
        this.usdBasedConversionRates = usdBasedConversionRates;
    }

    private Double zarToUsd(Double zar) {
        return zar / Double.parseDouble(usdBasedConversionRates.get("ZAR"));
    }

    @Override
    protected Double extractPrice(IceCubedTicker iceCubedTicker) {
        return zarToUsd(new Double(iceCubedTicker.getLast_price()));
    }

    @Override
    protected Double extractVolume(IceCubedTicker iceCubedTicker) {
        return new Double(iceCubedTicker.getVol());
    }

    @Override
    protected Double extractAsk(IceCubedTicker iceCubedTicker) {
        return new Double("0.0");
    }

    @Override
    protected Double extractBid(IceCubedTicker iceCubedTicker) {
        return new Double("0.0");
    }

    @Override
    protected Date extractTimestamp(IceCubedTicker iceCubedTicker) {
        return new Date();
    }
}
