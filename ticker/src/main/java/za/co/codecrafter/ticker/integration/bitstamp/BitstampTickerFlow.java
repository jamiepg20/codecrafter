package za.co.codecrafter.ticker.integration.bitstamp;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;


/**
 * Created by arnoe on 2017/06/28.
 */
public class BitstampTickerFlow extends HttpFlow<BitstampTickerRequest, BitstampTickerResponse> {

    public BitstampTickerFlow(HttpClient httpClient) {
        super(httpClient, BitstampTickerResponse.class);
    }

    @Override
    protected void validate(BitstampTickerRequest tickerRequest, ResponseEntity<String> response) {

    }
}
