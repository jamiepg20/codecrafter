package za.co.codecrafter.postman.request;

import org.springframework.http.HttpMethod;

import java.net.URI;


/**
 * Created by arnoe on 2017/06/08.
 */
public class GetEnvironmentsRequest  extends PostmanRequest {

    public GetEnvironmentsRequest() {
        super(HttpMethod.GET, URI.create("https://api.getpostman.com/environments"));
    }
}
