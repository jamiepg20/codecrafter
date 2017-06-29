package za.co.codecrafter.ticker.integration.fixer;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by arnoe on 2017/05/06.
 */
public class FixerRequest extends RequestEntity<String> {

    public FixerRequest(String base) throws URISyntaxException {
        super(HttpMethod.GET, new URI(String.format("http://api.fixer.io/latest?base=%s", base)));
    }
}
