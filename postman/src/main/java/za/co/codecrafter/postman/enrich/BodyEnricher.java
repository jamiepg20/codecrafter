package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Body;
import za.co.codecrafter.postman.model.Environment;


/**
 * Created by arnoe on 2017/06/10.
 */
public class BodyEnricher extends Enricher<Body> {

    public BodyEnricher(Environment environment) {
        super(environment);
    }

    @Override
    public Body apply(Body body) {
        return body;
    }
}
