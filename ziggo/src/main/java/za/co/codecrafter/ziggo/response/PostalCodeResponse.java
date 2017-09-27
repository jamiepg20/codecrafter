package za.co.codecrafter.ziggo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import za.co.codecrafter.ziggo.model.Nearnet;


/**
 * Created by arnoe on 2017/09/27.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostalCodeResponse {

    private String error;
    private String errormessage;
    private Nearnet nearnet;
}
