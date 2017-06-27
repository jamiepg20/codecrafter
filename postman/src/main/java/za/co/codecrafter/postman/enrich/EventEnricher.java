package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Event;


/**
 * Created by arnoe on 2017/06/10.
 */
public class EventEnricher extends Enricher<Event>{

    public EventEnricher(Environment environment) {
        super(environment);
    }

    @Override
    public Event apply(Event event) {
        Event enriched = new Event();
        return enriched;
    }
}
