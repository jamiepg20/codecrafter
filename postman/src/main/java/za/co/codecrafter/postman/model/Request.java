package za.co.codecrafter.postman.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Created by arnoe on 2017/06/06.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Request {

    private String url;
    private String method;
    private List<Header> header;
    private Body body;
    private String description;
}
