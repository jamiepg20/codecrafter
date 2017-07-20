package za.co.codecrafter.postman.enrich;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Header;
import za.co.codecrafter.postman.model.Value;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Created by arnoe on 2017/06/11.
 */
public class HeaderEnricherTest {

    private HeaderEnricher instance;
    @Mocked
    private Environment environment;
    @Mocked
    private Value value;

    @Test
    public void apply() throws Exception {
        ArrayList<Value> values = new ArrayList<>();
        values.add(value);

        new Expectations() {

            {
                environment.getValues();
                result = values;

                value.getKey();
                result = "key";

                value.getValue();
                result = "VALUE";

                environment.getValues();
                result = values;

                value.getKey();
                result = "key";

                value.getValue();
                result = "VALUE";
            }
        };
        instance = new HeaderEnricher(environment);

        Header before = new Header();
        before.setDescription("This is my {{key}}");
        before.setValue("{{key}}");
        before.setKey("key");
        Header actual = instance.apply(before);
        assertEquals("This is my VALUE", actual.getDescription());
        assertEquals("key", actual.getKey());
        assertEquals("VALUE", actual.getValue());
        //        assertEquals("HEADER.VALUE", actual.getValue());
    }

    //    private Value createValue(String key, String value) {
    //        Value result = new Value();
    //        result.setKey(key);
    //        result.setValue(value);
    //        return result;
    //    }
}
