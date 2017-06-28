package za.co.codecrafter.ticker.luno;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import za.co.codecrafter.ticker.model.CurrencyPair;
import za.co.codecrafter.ticker.model.Ticker;

import java.util.Date;


/**
 * Created by arnoe on 2017/05/06.
 */
@EqualsAndHashCode(exclude = { "lastTrade", "pair", "rolling24HourVolume" })
@Getter
public class TickerResponse {

    @JsonProperty("error")
    private String error;

    @JsonProperty("error_code")
    private String errorCode;
    private String pair;
    private Date timestamp;
    private Double bid;
    private Double ask;

    @JsonProperty("rolling_24_hour_volume")
    private Double rolling24HourVolume;

    @JsonProperty("last_trade")
    private Double lastTrade;

    public Ticker getTicker() {
        Ticker ticker = new Ticker();
        ticker.setAsk(ask);
        ticker.setBid(bid);
        if (pair.equals("XBTZAR")) {
            ticker.setCurrency(CurrencyPair.ZARBTC);
        }
        ticker.setPrice(lastTrade);
        ticker.setTimestamp(timestamp);
        ticker.setVolume(rolling24HourVolume);
        return ticker;
    }
}
