package za.co.codecrafter.postman.enrich;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Info;
import za.co.codecrafter.postman.model.Value;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Created by arnoe on 2017/06/12.
 */
public class InfoEnricherTest {

    private InfoEnricher instance;
    @Mocked
    private Environment environment;
    @Mocked
    private Value value;

    @Test
    public void apply() throws Exception {
        ArrayList<Value> values = new ArrayList<>();
        values.add(value);
        new Expectations(){
            {
                environment.getValues();
                result = values;

                value.getKey();
                result = "key";

                value.getValue();
                result = "VALUE";
            }
        };

        instance = new InfoEnricher(environment);
        Info info = new Info();
        info.setSchema("SCHEMA");
        info.setName("NAME");
        info.setDescription("Description with {{key}}");
        info.set_postman_id("postman_id");
        Info actual = instance.apply(info);
        assertEquals("SCHEMA", actual.getSchema());
        assertEquals("postman_id", actual.get_postman_id());
        assertEquals("Description with VALUE", actual.getDescription());
        assertEquals("NAME", actual.getName());
    }

}
