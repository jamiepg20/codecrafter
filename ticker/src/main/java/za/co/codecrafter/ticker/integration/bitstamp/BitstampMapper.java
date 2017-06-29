package za.co.codecrafter.ticker.integration.bitstamp;

import za.co.codecrafter.ticker.mapper.TickerMapper;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Source;

import java.util.Date;


/**
 * Created by arnoe on 2017/06/28.
 */
public class BitstampMapper extends TickerMapper<BitstampTickerResponse> {

    public BitstampMapper() {
        super(Source.Bitstamp, CurrencyPair.USDBTC);
    }

    @Override
    protected Double extractPrice(BitstampTickerResponse response) {
        return response.getLast();
    }

    @Override
    protected Double extractVolume(BitstampTickerResponse response) {
        return response.getLast();
    }

    @Override
    protected Double extractAsk(BitstampTickerResponse response) {
        return response.getAsk();
    }

    @Override
    protected Double extractBid(BitstampTickerResponse response) {
        return response.getBid();
    }

    @Override
    protected Date extractTimestamp(BitstampTickerResponse response) {
        return new Date(response.getTimestamp() * 1000);
    }
}
