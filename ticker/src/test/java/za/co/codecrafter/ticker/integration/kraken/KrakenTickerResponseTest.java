package za.co.codecrafter.ticker.integration.kraken;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;

public class KrakenTickerResponseTest {
    String value = "{\"error\":[],\"result\":{\"XXBTZUSD\":{\"a\":[\"4126.78800\",\"1\",\"1.000\"],\"b\":[\"4118.50300\",\"1\",\"1.000\"],\"c\":[\"4118.39600\",\"0.04680000\"],\"v\":[\"1313.81611337\",\"4775.81053977\"],\"p\":[\"4114.43037\",\"4108.12116\"],\"t\":[4164,13422],\"l\":[\"4071.00000\",\"4002.63600\"],\"h\":[\"4195.00000\",\"4211.68300\"],\"o\":\"4179.73300\"}}}";

    @Test
    public void name() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(new JSONObject(value).toString(1));
        KrakenTickerResponse response = mapper.readValue(value, KrakenTickerResponse.class);
        KrakenPair xxbtzusd = response.getResult().getXXBTZUSD();
    }
}