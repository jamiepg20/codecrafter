package za.co.codecrafter.ticker.integration.cexio;

import za.co.codecrafter.ticker.mapper.TickerMapper;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Source;

import java.util.Date;


/**
 * Created by arnoe on 2017/06/28.
 */
public class CexioMapper extends TickerMapper<CexioTickerResponse> {

    public CexioMapper() {
        super(Source.Cexio, CurrencyPair.USDBTC);
    }

    @Override
    protected Double extractPrice(CexioTickerResponse response) {
        return response.getLast();
    }

    @Override
    protected Double extractVolume(CexioTickerResponse response) {
        return response.getLast();
    }

    @Override
    protected Double extractAsk(CexioTickerResponse response) {
        return response.getAsk();
    }

    @Override
    protected Double extractBid(CexioTickerResponse response) {
        return response.getBid();
    }

    @Override
    protected Date extractTimestamp(CexioTickerResponse response) {
        return new Date(response.getTimestamp() * 1000);
    }
}
