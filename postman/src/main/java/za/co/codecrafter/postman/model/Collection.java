package za.co.codecrafter.postman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


/**
 * Created by arnoe on 2017/06/06.
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Collection {

    // Partial
    private String uid;
    private String id;
    private String name;
    private String owner;

    // Full
    private List variables;
    private Info info;
    private List<Item> item;


}


