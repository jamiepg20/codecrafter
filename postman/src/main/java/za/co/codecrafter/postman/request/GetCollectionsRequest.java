package za.co.codecrafter.postman.request;

import org.springframework.http.HttpMethod;

import java.net.URI;


/**
 * Created by arnoe on 2017/06/06.
 */
public class GetCollectionsRequest extends PostmanRequest {

    public GetCollectionsRequest() {
        super(HttpMethod.GET, URI.create("https://api.getpostman.com/collections"));
    }
}
