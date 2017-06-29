package za.co.codecrafter.ticker.integration.fixer;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;


/**
 * Created by arnoe on 2017/06/28.
 */
public class FixerFlow extends HttpFlow<FixerRequest, FixerResponse> {

    public FixerFlow(HttpClient httpClient) {
        super(httpClient, FixerResponse.class);
    }

    @Override
    protected void validate(FixerRequest fixerRequest, ResponseEntity<String> response) {

    }
}
