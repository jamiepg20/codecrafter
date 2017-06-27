package za.co.codecrafter.postman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


/**
 * Created by arnoe on 2017/06/08.
 */
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Environment {

    //Partial
    private String id;
    private String name;
    private String owner;
    private String uid;


    //Full
    private List<Value> values;
}
