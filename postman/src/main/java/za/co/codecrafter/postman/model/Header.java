package za.co.codecrafter.postman.model;

import lombok.Getter;
import lombok.Setter;


/**
 * Created by arnoe on 2017/06/06.
 */
@Setter
@Getter
public class Header {
    private String key;
    private String value;
    private String description;
}
