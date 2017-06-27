package za.co.codecrafter.postman.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * Created by arnoe on 2017/06/06.
 */
@Getter
@Setter
public class Body {

    /*
    "mode": "formdata",
    "formdata": [
      {
        "key": "username",
        "value": "abc",
        "type": "text"
      },
      {
        "key": "password",
        "value": "blah",
        "type": "text"
      }
    ]
     */
    private String mode;
    private List formdata;

}
