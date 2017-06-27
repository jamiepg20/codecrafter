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
                //                header.getDescription();
                //                result = "This is my {{key}}";

                environment.getValues();
                result = values;
                times = 2;


                value.getValue();
                result = "VALUE";

                //                value.getKey();
                //                result = "key";
                //                times = 1;

            }
        };
        instance = new HeaderEnricher(environment);
        Header header = new Header();
        header.setDescription("This is my {{key}}");
        header.setValue("{{key}}");
        header.setKey("key");
        Header actual = instance.apply(header);
        assertEquals("This is my VALUE", actual.getDescription());
        //        assertEquals("HEADER.VALUE", actual.getValue());
    }

}
