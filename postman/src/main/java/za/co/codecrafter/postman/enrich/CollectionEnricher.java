package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Collection;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Item;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by arnoe on 2017/06/10.
 */
public class CollectionEnricher extends Enricher<Collection> {

    private StringEnricher stringEnricher;
    private InfoEnricher infoEnricher;
    private ItemEnricher itemEnricher;

    public CollectionEnricher(Environment environment) {
        super(environment);
    }

    @Override
    public Collection apply(Collection collection) {
        Collection enriched = new Collection();
        enriched.setUid(collection.getUid());
        enriched.setId(collection.getId());
        enriched.setName(stringEnricher.apply(collection.getName()));
        enriched.setOwner(collection.getOwner());
        enriched.setVariables(collection.getVariables());
        enriched.setInfo(infoEnricher.apply(collection.getInfo()));
        enriched.setItem(enrichItems(collection.getItem()));
        return enriched;
    }

    private List<Item> enrichItems(List<Item> items) {
        return items.stream().map(itemEnricher).collect(Collectors.toList());
    }
}
