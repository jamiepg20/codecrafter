package za.co.codecrafter.ticker.integration.cexio;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by arnoe on 2017/05/06.
 */
public class CexioTickerRequest extends RequestEntity<String> {

    public CexioTickerRequest() throws URISyntaxException {
        super(HttpMethod.GET, new URI(String.format("https://cex.io/api/ticker/BTC/USD")));
    }
}
