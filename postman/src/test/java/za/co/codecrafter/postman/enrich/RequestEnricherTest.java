package za.co.codecrafter.postman.enrich;

import mockit.Expectations;
import mockit.Mocked;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import za.co.codecrafter.postman.model.Body;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.model.Request;
import za.co.codecrafter.postman.model.Value;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;


/**
 * Created by arnoe on 2017/07/19.
 */
public class RequestEnricherTest {


    private RequestEnricher instance;
    @Mocked
    private Environment environment;
    @Mocked
    private Value value1;
    @Mocked
    private Value value2;
    @Mocked
    private HeaderEnricher headerEnricher;
    @Mocked
    private BodyEnricher bodyEnricher;
    @Mocked
    private Body body;

    @Before
    public void setUp() throws Exception {
        instance = new RequestEnricher(environment);
        ReflectionTestUtils.setField(instance, "headerEnricher", headerEnricher);
        ReflectionTestUtils.setField(instance, "bodyEnricher", bodyEnricher);
    }

    @Test
    public void apply() throws Exception {

        ArrayList<Value> values = new ArrayList<>();
        values.add(value1);
        values.add(value2);
        new Expectations() {

            {
                // URL
                environment.getValues();
                result = values;

                value1.getKey();
                result = "key1";

                value1.getValue();
                result = "VALUE1";

                value2.getKey();
                result = "key2";

                value2.getValue();
                result = "VALUE2";

                bodyEnricher.apply(body);
                result = body;

                // Description
                environment.getValues();
                result = values;

                value1.getKey();
                result = "key1";

                value1.getValue();
                result = "VALUE1";

                value2.getKey();
                result = "key2";

                value2.getValue();
                result = "VALUE2";
            }
        };
        Request request = new Request();
        request.setMethod("GET");
        request.setUrl("http://www.google.com/{{key1}}/{{key2}}");
        request.setBody(body);
        request.setHeader(Lists.emptyList());
        request.setDescription("Description {{key1}} :-: {{key2}}");

        Request actual = instance.apply(request);

        assertNotNull("http://www.google.com/VALUE1/VALUE2", actual.getUrl());
        assertNotNull("Description VALUE1 :-: VALUE2", actual.getDescription());
    }

}
