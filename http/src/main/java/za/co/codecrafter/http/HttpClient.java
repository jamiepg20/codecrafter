package za.co.codecrafter.http;

/**
 * Created by arnoe on 2017/01/27.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * Created by benjamin on 2017/01/19.
 */
public class HttpClient {

    protected static final Log logger = LogFactory.getLog(HttpClient.class);
    private RestTemplate restTemplate = new RestTemplate();

    public <Payload, T> ResponseEntity<T> execute(RequestEntity<Payload> request, Class<T> responseClass) {
        return restTemplate.exchange(request, responseClass);
    }
}
