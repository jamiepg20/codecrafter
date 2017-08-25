package za.co.codecrafter.ticker.integration.coinbase;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by arnoe on 2017/05/06.
 */
public class CoinbaseTickerRequest extends RequestEntity<String> {

    public CoinbaseTickerRequest() throws URISyntaxException {
        super(HttpMethod.GET, new URI(String.format("https://api.coinbase.com/v2/exchange-rates?currency=BTC")));
    }
}
