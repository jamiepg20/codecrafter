package za.co.codecrafter.ticker.integration.cexio;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;


/**
 * Created by arnoe on 2017/06/28.
 */
public class CexioTickerFlow extends HttpFlow<CexioTickerRequest, CexioTickerResponse> {

    public CexioTickerFlow(HttpClient httpClient) {
        super(httpClient, CexioTickerResponse.class);
    }

    @Override
    protected void validate(CexioTickerRequest tickerRequest, ResponseEntity<String> response) {

    }
}
