package za.co.codecrafter.postman.flow;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;
import za.co.codecrafter.postman.request.GetEnvironmentRequest;
import za.co.codecrafter.postman.response.GetEnvironmentResponse;


/**
 * Created by arnoe on 2017/06/08.
 */
public class GetEnvironmentFlow extends HttpFlow<GetEnvironmentRequest, GetEnvironmentResponse> {

    public GetEnvironmentFlow(HttpClient httpClient) {
        super(httpClient, GetEnvironmentResponse.class);
    }

    @Override
    protected void validate(GetEnvironmentRequest request, ResponseEntity<String> response) {

    }
}
