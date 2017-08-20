package za.co.codecrafter.ticker.integration.kraken;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by arnoe on 2017/05/06.
 */
public class KrakenTickerRequest extends RequestEntity<String> {

    public KrakenTickerRequest(String pair) throws URISyntaxException {
        super(HttpMethod.GET, new URI(String.format("https://api.kraken.com/0/public/Ticker?pair=%s", pair)));
    }
}
