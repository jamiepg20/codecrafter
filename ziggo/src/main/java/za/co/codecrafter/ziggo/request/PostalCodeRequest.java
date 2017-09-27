package za.co.codecrafter.ziggo.request;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;


/**
 * Created by arnoe on 2017/09/27.
 */
public class PostalCodeRequest extends RequestEntity {

    public PostalCodeRequest(String zipcode, Long housenumber) {
        super(HttpMethod.GET,
                URI.create(String.format("https://restapi.ziggo.nl/1.0/nearnet/?zipcode=%s&housenumber=%s",
                        zipcode,
                        housenumber)));
    }
}
