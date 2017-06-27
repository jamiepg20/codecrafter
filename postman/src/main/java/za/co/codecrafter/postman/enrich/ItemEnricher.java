package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Event;
import za.co.codecrafter.postman.model.Item;
import za.co.codecrafter.postman.model.Response;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by arnoe on 2017/06/10.
 */
public class ItemEnricher extends Enricher<Item> {

    private StringEnricher stringEnricher;
    private EventEnricher eventEnricher;
    private RequestEnricher requestEnricher;
    private ResponseEnricher responseEnricher;

    public ItemEnricher(Environment environment) {
        super(environment);
    }

    @Override
    public Item apply(Item item) {
        Item enricher = new Item();
        enricher.set_postman_id(item.get_postman_id());
        enricher.setName(stringEnricher.apply(item.getName()));
        enricher.setEvent(enrichEvents(item.getEvent()));
        enricher.setRequest(requestEnricher.apply(item.getRequest()));
        enricher.setResponse(enrichResponse(item.getResponse()));
        return enricher;
    }

    private List<Response> enrichResponse(List<Response> response) {
        return response.stream().map(responseEnricher).collect(Collectors.toList());
    }

    private List<Event> enrichEvents(List<Event> event) {
        return event.stream().map(eventEnricher).collect(Collectors.toList());
    }
}
