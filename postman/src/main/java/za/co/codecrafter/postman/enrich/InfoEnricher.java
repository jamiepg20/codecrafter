package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Info;


/**
 * Created by arnoe on 2017/06/10.
 */
public class InfoEnricher extends Enricher<Info> {

    private final StringEnricher stringEnricher;

    public InfoEnricher(Environment environment) {
        super(environment);
        this.stringEnricher = new StringEnricher(environment);
    }

    @Override
    public Info apply(Info info) {
        Info enriched = new Info();
        enriched.setName(info.getName());
        enriched.set_postman_id(info.get_postman_id());
        enriched.setDescription(stringEnricher.apply(info.getDescription()));
        enriched.setSchema(info.getSchema());
        return enriched;
    }
}
