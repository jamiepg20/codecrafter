package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Response;


/**
 * Created by arnoe on 2017/06/10.
 */
public class ResponseEnricher extends Enricher<Response>{

    public ResponseEnricher(Environment environment) {
        super(environment);
    }

    @Override
    public Response apply(Response response) {
        return new Response();
    }
}
