package za.co.codecrafter.postman.request;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;


/**
 * Created by arnoe on 2017/06/08.
 */
public class PostmanRequest extends RequestEntity<String> {

    public PostmanRequest(HttpMethod method, URI url) {
        super(method, url);
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        return httpHeaders;
    }
}
