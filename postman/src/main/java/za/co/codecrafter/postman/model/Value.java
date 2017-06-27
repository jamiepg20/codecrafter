package za.co.codecrafter.postman.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Created by arnoe on 2017/06/09.
 */
@Getter
@Setter
@ToString
public class Value {

    private boolean enabled;
    private String key;
    private String value;
    private String type;
}
