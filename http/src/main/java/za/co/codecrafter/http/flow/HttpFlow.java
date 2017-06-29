package za.co.codecrafter.http.flow;

//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import za.co.codecrafter.http.HttpClient;

import java.io.IOException;
import java.util.function.Function;


/**
 * Created by arnoe on 2017/05/06.
 */
public abstract class HttpFlow<Request extends RequestEntity<String>, Response> implements Function<Request, Response> {

    private ObjectMapper mapper;
    private HttpClient httpClient;
    private Class<Response> klass;

    public HttpFlow(HttpClient httpClient, Class<Response> klass) {
        this.httpClient = httpClient;
        this.klass = klass;
        mapper = new ObjectMapper();
    }

    @Override
    public Response apply(Request request) {
        //        ResponseEntity<String> response = httpClient.execute(request, String.class);
        //        validate(request, response);
        //        return convert(response);
        return null;
    }

    private Response convert(ResponseEntity<String> response) {
        try {
            return mapper.readValue(response.getBody(), klass);
        } catch (IOException e) {
            throw new UnsupportedOperationException(e.getMessage(), e);
        }
    }

    protected abstract void validate(Request request, ResponseEntity<String> response);
}
