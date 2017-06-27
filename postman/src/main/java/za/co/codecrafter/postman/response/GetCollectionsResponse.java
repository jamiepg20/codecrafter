package za.co.codecrafter.postman.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import za.co.codecrafter.postman.model.Collection;

import java.util.List;


/**
 * Created by arnoe on 2017/06/06.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCollectionsResponse {

    List<Collection> collections;
}
