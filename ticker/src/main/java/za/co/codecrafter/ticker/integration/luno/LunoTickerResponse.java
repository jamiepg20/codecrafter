package za.co.codecrafter.ticker.integration.luno;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;

import java.util.Date;


/**
 * Created by arnoe on 2017/05/06.
 */
@Getter
public class LunoTickerResponse implements TickerResponse {

    private String pair;
    private Date timestamp;
    private Double bid;
    private Double ask;

    @JsonProperty("rolling_24_hour_volume")
    private Double rolling24HourVolume;

    @JsonProperty("last_trade")
    private Double lastTrade;
}
