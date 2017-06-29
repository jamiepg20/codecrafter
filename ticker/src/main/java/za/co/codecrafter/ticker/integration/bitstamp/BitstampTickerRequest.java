package za.co.codecrafter.ticker.integration.bitstamp;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by arnoe on 2017/05/06.
 */
public class BitstampTickerRequest extends RequestEntity<String> {

    public BitstampTickerRequest(String pair) throws URISyntaxException {
        super(HttpMethod.GET, new URI(String.format("https://www.bitstamp.net/api/v2/ticker/%s/", pair)));
    }
}
