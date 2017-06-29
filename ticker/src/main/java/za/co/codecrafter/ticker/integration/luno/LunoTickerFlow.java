package za.co.codecrafter.ticker.integration.luno;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;


/**
 * Created by arnoe on 2017/05/06.
 */
public class LunoTickerFlow extends HttpFlow<LunoTickerRequest, LunoTickerResponse> {

    public LunoTickerFlow(HttpClient client) {
        super(client, LunoTickerResponse.class);
    }

    @Override
    protected void validate(LunoTickerRequest tickerRequest, ResponseEntity<String> response) {

    }
}
