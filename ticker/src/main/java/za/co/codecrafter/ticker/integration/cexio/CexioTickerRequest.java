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
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "__cfduid=d8997f9186fdd050b61d18f63bdc429071503443531; ref=Direct%3Acex.io%3A%2F; cex-prod-session=s%3AidFm5CzuzUTozi_2AtY9QotM.pGCVVKyl8T7tGv9dk4vWL8HOvsZJpQrjnlnciex%2FL00; _ga=GA1.2.430545536.1503443536; _gid=GA1.2.246581963.1503443536");
        headers.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36" );
        return headers;
    }
}
