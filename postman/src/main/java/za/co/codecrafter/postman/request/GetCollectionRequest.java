package za.co.codecrafter.postman.request;

import org.springframework.http.HttpMethod;

import java.net.URI;


/**
 * Created by arnoe on 2017/06/08.
 */
public class GetCollectionRequest extends PostmanRequest {

    public GetCollectionRequest(String uid) {
        super(HttpMethod.GET, URI.create(String.format("https://api.getpostman.com/collections/%s", uid)));
    }
}
