package za.co.codecrafter.ticker.integration.cexio;

import org.springframework.http.HttpHeaders;
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

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = super.getHeaders();
//        headers.add("Cookie", "__cfduid=d90839d00ab0df1e52a7b52f234911b2d1495627281; ref=Direct%3Acex.io%3A%2F; cex-prod-session=s%3A9KNUk17pjoJWraD08Xvn4AtQ.VGdN6GDWSIQYhVJosPmPaZhZH8q1aynIRW6oNw%2F1Ivs; _ga=GA1.2.521219485.1495627285; _gid=GA1.2.783458304.1498487670; __zlcmid=gggT8QMGFntAZM");
        return headers;
    }
}
