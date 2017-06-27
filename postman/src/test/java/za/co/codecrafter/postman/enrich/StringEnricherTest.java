package za.co.codecrafter.postman.enrich;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Value;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Created by arnoe on 2017/06/10.
 */
public class StringEnricherTest {

    private StringEnricher instance;
    @Mocked
    private Environment environment;

    @Test
    public void getEnriched() throws Exception {
        ArrayList<Value> values = new ArrayList<>();
        Value value = new Value();
        value.setKey("key");
        value.setValue("NEW_VALUE");
        values.add(value);
        new Expectations() {

            {
                environment.getValues();
                result = values;
            }
        };
        instance = new StringEnricher(environment);
        assertEquals("this is my new NEW_VALUE", instance.apply("this is my new {{key}}"));
    }

}
