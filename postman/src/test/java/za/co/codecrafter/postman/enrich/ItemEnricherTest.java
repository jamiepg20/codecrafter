package za.co.codecrafter.postman.enrich;

import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Item;
import za.co.codecrafter.postman.model.Request;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Created by arnoe on 2017/07/20.
 */
public class ItemEnricherTest {

    private ItemEnricher instance;
    @Mocked
    private Environment environment;
    @Mocked
    private EventEnricher eventEnricher;
    @Mocked
    private RequestEnricher requestEnricher;
    @Mocked
    private ResponseEnricher responseEnricher;
    @Mocked
    private Request request;


    @Before
    public void setUp() throws Exception {
        instance = new ItemEnricher(environment);
        ReflectionTestUtils.setField(instance, "eventEnricher", eventEnricher);
        ReflectionTestUtils.setField(instance, "requestEnricher", requestEnricher);
        ReflectionTestUtils.setField(instance, "responseEnricher", responseEnricher);
    }

    @Test
    public void apply() throws Exception {

        Item item = new Item();
        item.set_postman_id("POSTMANID");
        item.setName("NAME");
        item.setEvent(new ArrayList<>());
        item.setRequest(request);
        item.setResponse(new ArrayList<>());

        Item actual = instance.apply(item);
        assertEquals("POSTMANID", actual.get_postman_id());
        assertEquals("", actual.getEvent());
    }

}
