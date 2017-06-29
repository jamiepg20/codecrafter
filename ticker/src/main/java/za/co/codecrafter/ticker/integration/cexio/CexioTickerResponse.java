package za.co.codecrafter.ticker.integration.cexio;

import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;


/**
 * Created by arnoe on 2017/05/06.
 */
@Getter
public class CexioTickerResponse implements TickerResponse {

    private Long timestamp;
    private Double low;
    private Double high;
    private Double last;
    private Double volume;
    private Double volume30d;
    private Double bid;
    private Double ask;
}
