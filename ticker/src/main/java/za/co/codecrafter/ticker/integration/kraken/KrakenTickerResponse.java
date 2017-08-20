package za.co.codecrafter.ticker.integration.kraken;

import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;


/**
 * Created by arnoe on 2017/05/06.
 */
@Getter
public class KrakenTickerResponse implements TickerResponse {
    private String[] error;
    private KrakenData result;
}
