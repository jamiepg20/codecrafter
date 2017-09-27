package za.co.codecrafter.ticker.integration.icecubed;

import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;
import za.co.codecrafter.ticker.integration.kraken.KrakenData;


/**
 * Created by arnoe on 2017/05/06.
 */
@Getter
public class IceCubedResponse implements TickerResponse {

    //    {
    //       “errors”:false,
    //       ”response”:{
    //       }
    private boolean errors;
    private IceCubedTickerResponse response;

    private String[] error;
    private KrakenData result;
}
