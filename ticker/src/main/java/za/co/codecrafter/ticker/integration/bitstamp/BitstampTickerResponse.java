package za.co.codecrafter.ticker.integration.bitstamp;

import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;


/**
 * Created by arnoe on 2017/05/06.
 */
@Getter
public class BitstampTickerResponse implements TickerResponse {

    private Double high;
    private Double last;
    private Long timestamp;
    private Double bid;
    private Double vwap;
    private Double volume;
    private Double low;
    private Double ask;
    private Double open;
}
