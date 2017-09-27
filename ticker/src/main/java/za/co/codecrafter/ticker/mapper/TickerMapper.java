package za.co.codecrafter.ticker.mapper;

import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Source;
import za.co.codecrafter.ticker.model.Ticker;

import java.util.Date;
import java.util.function.Function;


/**
 * Created by arnoe on 2017/06/28.
 */
@Getter
public abstract class TickerMapper<T extends TickerResponse> implements Function<T, Ticker> {

    private final Source source;
    private final CurrencyPair pair;

    public TickerMapper(Source source, CurrencyPair pair) {
        this.source = source;
        this.pair = pair;
    }

    @Override
    public Ticker apply(T t) {
        Ticker ticker = new Ticker();
        ticker.setCurrency(pair);
        ticker.setTimestamp(extractTimestamp(t));
        ticker.setAsk(extractAsk(t));
        ticker.setBid(extractBid(t));
        ticker.setSource(source);
        ticker.setVolume(extractVolume(t));
        ticker.setPrice(extractPrice(t));
        validate(ticker);
        return ticker;
    }


    private static void validate(Ticker ticker) {
        assert ticker.getPrice() > 0;
        assert ticker.getCurrency() != null;
        assert ticker.getSource() != null;
        assert ticker.getTimestamp() != null;
    }

    protected abstract Double extractPrice(T t);

    protected abstract Double extractVolume(T t);

    protected abstract Double extractAsk(T t);

    protected abstract Double extractBid(T t);

    protected abstract Date extractTimestamp(T t);
}
