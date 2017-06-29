package za.co.codecrafter.ticker.integration.luno;

import za.co.codecrafter.ticker.mapper.TickerMapper;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Source;

import java.util.Date;
import java.util.Map;


/**
 * Created by arnoe on 2017/06/28.
 */
public class LunoMapper extends TickerMapper<LunoTickerResponse> {

    private final Map<String, String> usdBasedRates;

    public LunoMapper(Map<String, String> usdBasedRates) {
        super(Source.Luno, CurrencyPair.USDBTC);
        this.usdBasedRates = usdBasedRates;
    }

    @Override
    protected Double extractPrice(LunoTickerResponse response) {
        return zarToUsd(response.getLastTrade());
    }

    private Double zarToUsd(Double zar) {
        return zar / Double.parseDouble(usdBasedRates.get("ZAR"));
    }

    @Override
    protected Double extractVolume(LunoTickerResponse response) {
        return response.getRolling24HourVolume();
    }

    @Override
    protected Double extractAsk(LunoTickerResponse response) {
        return zarToUsd(response.getAsk());
    }

    @Override
    protected Double extractBid(LunoTickerResponse response) {
        return zarToUsd(response.getBid());
    }

    @Override
    protected Date extractTimestamp(LunoTickerResponse response) {
        return response.getTimestamp();
    }
}
