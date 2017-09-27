package za.co.codecrafter.ticker.integration.icecubed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;


/**
 * Created by arnoe on 2017/09/04.
 */
@Getter
public class IceCubedTicker implements TickerResponse {

    @JsonProperty("pair_id")
    private String pairId;

    @JsonProperty("min")
    private String min;

    @JsonProperty("max")
    private String max;

    @JsonProperty("avg")
    private String avg;

    @JsonProperty("vol")
    private String vol;

    @JsonProperty("last_price")
    private String last_price;

    @JsonProperty("pair_name")
    private String pair_name;
}
