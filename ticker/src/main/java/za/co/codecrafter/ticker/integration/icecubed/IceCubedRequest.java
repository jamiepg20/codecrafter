package za.co.codecrafter.ticker.integration.icecubed;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by arnoe on 2017/09/04.
 */
public class IceCubedRequest extends RequestEntity<String> {

    public IceCubedRequest() throws URISyntaxException {
        super(HttpMethod.GET, new URI("https://ice3x.com/api/v1/stats/marketdepthfull?pair_id=3"));
    }
}
