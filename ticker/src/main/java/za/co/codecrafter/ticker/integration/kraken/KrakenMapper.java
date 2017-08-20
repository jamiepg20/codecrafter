package za.co.codecrafter.ticker.integration.kraken;

import za.co.codecrafter.ticker.mapper.TickerMapper;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Source;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by arnoe on 2017/06/28.
 */
public class KrakenMapper extends TickerMapper<KrakenTickerResponse> {

    public KrakenMapper() {
        super(Source.Kraken, CurrencyPair.USDBTC);
    }

    @Override
    protected Double extractPrice(KrakenTickerResponse response) {
        return asDouble(extractXXBTZUSD(response).getLast());
    }

    @Override
    protected Double extractVolume(KrakenTickerResponse response) {
        return asDouble(extractXXBTZUSD(response).getVolume());
    }

    @Override
    protected Double extractAsk(KrakenTickerResponse response) {
        return asDouble(extractXXBTZUSD(response).getAsk());    }

    @Override
    protected Double extractBid(KrakenTickerResponse response) {
        return asDouble(extractXXBTZUSD(response).getBid());    }

    @Override
    protected Date extractTimestamp(KrakenTickerResponse response) {
        return new Date();
    }



    private double asDouble(BigDecimal last) {
        return Double.parseDouble(last.toString());
    }

    private KrakenPair extractXXBTZUSD(KrakenTickerResponse response) {
        return response.getResult().getXXBTZUSD();
    }
}
