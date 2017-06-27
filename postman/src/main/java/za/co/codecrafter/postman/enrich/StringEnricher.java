package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Value;

import java.util.List;


/**
 * Created by arnoe on 2017/06/09.
 */
public class StringEnricher extends Enricher<String> {


    public StringEnricher(Environment environment) {
        super(environment);
    }

    @Override
    public String apply(String s) {
        List<Value> values = environment.getValues();
        String enriched = s;
        for (Value value : values) {
            enriched = enriched.replaceAll(String.format("\\{\\{%s\\}\\}", value.getKey()), value.getValue());
        }
        return enriched;
    }
}
