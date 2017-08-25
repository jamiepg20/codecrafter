package za.co.codecrafter.ticker.integration.coinbase;

import za.co.codecrafter.ticker.mapper.TickerMapper;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Source;

import java.util.Date;

public class CoinbaseMapper extends TickerMapper<CoinbaseTickerResponse> {
    public CoinbaseMapper() {
        super(Source.Coinbase, CurrencyPair.USDBTC);
    }

    @Override
    protected Double extractPrice(CoinbaseTickerResponse ticker) {
        return Double.parseDouble(ticker.getData().getRates().get("USD"));
    }

    @Override
    protected Double extractVolume(CoinbaseTickerResponse ticker) {
        return 0D;
    }

    @Override
    protected Double extractAsk(CoinbaseTickerResponse ticker) {
        return 0D;
    }

    @Override
    protected Double extractBid(CoinbaseTickerResponse ticker) {
        return 0D;
    }

    @Override
    protected Date extractTimestamp(CoinbaseTickerResponse ticker) {
        return new Date();
    }
}
