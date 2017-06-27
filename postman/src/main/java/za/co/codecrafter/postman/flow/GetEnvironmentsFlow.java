package za.co.codecrafter.postman.flow;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;
import za.co.codecrafter.postman.request.GetEnvironmentsRequest;
import za.co.codecrafter.postman.response.GetEnvironmentsResponse;


/**
 * Created by arnoe on 2017/06/08.
 */
public class GetEnvironmentsFlow extends HttpFlow<GetEnvironmentsRequest, GetEnvironmentsResponse> {

    public GetEnvironmentsFlow(HttpClient httpClient) {
        super(httpClient, GetEnvironmentsResponse.class);
    }

    @Override
    protected void validate(GetEnvironmentsRequest getEnvironmentsRequest, ResponseEntity<String> response) {

    }
}
