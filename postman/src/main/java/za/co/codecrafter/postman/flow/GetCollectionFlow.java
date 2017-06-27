package za.co.codecrafter.postman.flow;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;
import za.co.codecrafter.postman.request.GetCollectionRequest;
import za.co.codecrafter.postman.response.GetCollectionResponse;


/**
 * Created by arnoe on 2017/06/08.
 */

public class GetCollectionFlow extends HttpFlow<GetCollectionRequest, GetCollectionResponse> {

    public GetCollectionFlow(HttpClient httpClient) {
        super(httpClient, GetCollectionResponse.class);
    }

    @Override
    protected void validate(GetCollectionRequest getCollectionRequest, ResponseEntity<String> response) {
    }
}
