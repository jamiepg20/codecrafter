package za.co.codecrafter.postman.request;

import org.springframework.http.HttpMethod;

import java.net.URI;


/**
 * Created by arnoe on 2017/06/09.
 */
public class GetEnvironmentRequest extends PostmanRequest {

    public GetEnvironmentRequest(String uid) {
        super(HttpMethod.GET, URI.create(String.format("https://api.getpostman.com/environments/%s", uid)));
    }
}
