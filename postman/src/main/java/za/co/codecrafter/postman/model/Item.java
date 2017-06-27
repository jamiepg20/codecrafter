package za.co.codecrafter.postman.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Created by arnoe on 2017/06/06.
 */
@Getter
@Setter
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private String _postman_id;
    private String name;
    private List<Event> event;
    //    private String id;
    private Request request;
    private List<Response> response;
}
