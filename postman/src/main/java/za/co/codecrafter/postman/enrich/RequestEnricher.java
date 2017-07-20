package za.co.codecrafter.postman.enrich;

import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Header;
import za.co.codecrafter.postman.model.Request;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by arnoe on 2017/06/09.
 */
public class RequestEnricher extends Enricher<Request> {

    private StringEnricher stringEnricher;
    private HeaderEnricher headerEnricher;
    private BodyEnricher bodyEnricher;

    public RequestEnricher(Environment environment) {
        super(environment);
        this.stringEnricher = new StringEnricher(environment);
    }

    @Override
    public Request apply(Request request) {
        Request enriched = new Request();
        enriched.setMethod(request.getMethod());
        enriched.setUrl(stringEnricher.apply(request.getUrl()));
        enriched.setBody(bodyEnricher.apply(request.getBody()));
        enriched.setHeader(enrichList(request.getHeader()));
        enriched.setDescription(stringEnricher.apply(request.getDescription()));
        return enriched;
    }

    private List<Header> enrichList(List<Header> headers) {
        return headers.stream().map(headerEnricher).collect(Collectors.toList());
    }
}
