package za.co.codecrafter.postman.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import za.co.codecrafter.postman.model.Environment;

import java.util.List;


/**
 * Created by arnoe on 2017/06/08.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEnvironmentsResponse {

    private List<Environment> environments;
}
