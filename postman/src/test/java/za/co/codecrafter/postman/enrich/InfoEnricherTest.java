package za.co.codecrafter.postman.enrich;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Test;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Info;

import static org.junit.Assert.assertEquals;


/**
 * Created by arnoe on 2017/06/12.
 */
public class InfoEnricherTest {

    private InfoEnricher instance;
    @Mocked
    private Environment environment;

    @Test
    public void apply() throws Exception {
        new Expectations(){
            {

            }
        };

        instance = new InfoEnricher(environment);
        Info info = new Info();
        Info actual = instance.apply(info);
        assertEquals("", actual.get_postman_id());
        assertEquals("", actual.getDescription());
        assertEquals("", actual.getName());
    }

}
