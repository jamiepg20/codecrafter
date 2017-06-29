package za.co.codecrafter.ticker.integration.luno;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by arnoe on 2017/05/06.
 */
public class LunoTickerRequest extends RequestEntity<String> {

    public LunoTickerRequest(String pair) throws URISyntaxException {

        super(HttpMethod.GET, new URI(String.format("https://api.mybitx.com/api/1/ticker?pair=%s", pair)));
    }
}
