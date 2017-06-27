package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;

import java.util.function.Function;


/**
 * Created by arnoe on 2017/06/10.
 */
public abstract class Enricher<T> implements Function<T, T> {

    protected final Environment environment;

    public Enricher(Environment environment) {
        this.environment = environment;
    }
}
