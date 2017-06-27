package za.co.codecrafter.ticker.luno;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;


/**
 * Created by arnoe on 2017/05/06.
 */
public class TickerFlow extends HttpFlow<TickerRequest, TickerResponse> {

    public TickerFlow(HttpClient client) {
        super(client, TickerResponse.class);
    }

    @Override
    protected void validate(TickerRequest tickerRequest, ResponseEntity<String> response) {

    }
}
