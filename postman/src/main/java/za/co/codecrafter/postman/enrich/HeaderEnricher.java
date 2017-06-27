package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Header;


/**
 * Created by arnoe on 2017/06/10.
 */
public class HeaderEnricher extends Enricher<Header> {

    private StringEnricher stringEnricher;

    public HeaderEnricher(Environment environment) {
        super(environment);
        this.stringEnricher = new StringEnricher(environment);
    }

    @Override
    public Header apply(Header header) {
        Header enriched = new Header();
        enriched.setDescription(stringEnricher.apply(header.getDescription()));
        enriched.setValue(stringEnricher.apply(header.getValue()));
        return enriched;
    }
}
