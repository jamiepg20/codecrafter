package za.co.codecrafter.ticker;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.codecrafter.ticker.model.Ticker;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TickerApplication.class)
public class TickerApplicationTests {

    private TickerApplication instance;
    @Mocked
    private Ticker lastTicker;
    @Mocked
    private Ticker newTicker;

    @Before
    public void setUp() throws Exception {
        instance = new TickerApplication();
    }

    @Test
    public void contextLoads() {
    }


    @Test
    public void playPriceChangeSound() throws Exception {
        new Expectations() {

            {
                newTicker.getPrice();
                result = 500;

                lastTicker.getPrice();
                result = 1000;
            }
        };
        instance.playPriceChangeSound(lastTicker, newTicker);
    }

    @Test
    public void tickCexio() throws Exception {
        instance.tickCexio();
    }
}
