package za.co.codecrafter.postman.flow;

import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.http.flow.HttpFlow;
import za.co.codecrafter.postman.request.GetCollectionsRequest;
import za.co.codecrafter.postman.response.GetCollectionsResponse;


/**
 * Created by arnoe on 2017/06/06.
 */
public class GetCollectionsFlow extends HttpFlow<GetCollectionsRequest, GetCollectionsResponse> {

    public GetCollectionsFlow(HttpClient httpClient) {
        super(httpClient, GetCollectionsResponse.class);
    }

    @Override
    protected void validate(GetCollectionsRequest getCollectionsRequest, ResponseEntity<String> response) {

    }
}
