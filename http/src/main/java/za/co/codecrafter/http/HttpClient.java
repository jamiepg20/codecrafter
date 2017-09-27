package za.co.codecrafter.http;

/**
 * Created by arnoe on 2017/01/27.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import za.co.codecrafter.http.exception.InternalPushBackException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by benjamin on 2017/01/19.
 */
public class HttpClient {

    private final RestTemplate restTemplate;

    public HttpClient() {
        restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        messageConverters.addAll(buildMessageConverters());
        restTemplate.setMessageConverters(messageConverters);
    }

    public <T> T execute(RequestEntity request, Class<T> responseClass) {
        if (FourTwentyNineRegulator.safeToProceed(request)) {
            try {
                ResponseEntity<T> response = restTemplate.exchange(request, responseClass);
                return response.getBody();
            }catch (HttpClientErrorException e){
                FourTwentyNineRegulator.record429(request, e);
                return null;
            }
        }
        throw new InternalPushBackException("Internal Threshold exceeded");
    }


    protected List<HttpMessageConverter<?>> buildMessageConverters() {
        HttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
        HttpMessageConverter stringHttpMessageConverternew = new StringHttpMessageConverter();
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.setObjectMapper(new ObjectMapper());

        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(new MediaType("*", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET));
        jsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(formHttpMessageConverter);
        messageConverters.add(stringHttpMessageConverternew);
        messageConverters.add(jsonHttpMessageConverter);
        return messageConverters;
    }
}
