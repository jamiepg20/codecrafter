package za.co.codecrafter.ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.ticker.dao.TickerDao;
import za.co.codecrafter.ticker.luno.TickerFlow;
import za.co.codecrafter.ticker.luno.TickerRequest;
import za.co.codecrafter.ticker.luno.TickerResponse;
import za.co.codecrafter.ticker.model.Ticker;

import javax.annotation.PostConstruct;
import javax.sound.midi.MidiUnavailableException;
import java.net.URISyntaxException;
import java.util.logging.Logger;


/**
 * Created by arnoe on 2017/04/27.
 */
@SpringBootApplication
@EnableScheduling
public class TickerApplication {

    private Logger logger = Logger.getLogger(getClass().getName());
    private HttpClient client = new HttpClient();

    @Autowired
    private TickerDao tickerDao;


    public static void main(String[] args) {
        SpringApplication.run(TickerApplication.class, args);
    }

    @PostConstruct
    public void init() {
    }

    @Scheduled(fixedRate = 15000, initialDelay = 0)
    public void reportCurrentTime() throws URISyntaxException {
        // -------------
        TickerRequest request = new TickerRequest("XBTZAR");
        TickerFlow tickerFlow = new TickerFlow(client);
        TickerResponse tickerResponse = tickerFlow.apply(request);
        Ticker ticker = tickerResponse.getTicker();
        // -------------
        Ticker lastTicker = tickerDao.findFirstByOrderByIdDesc();
        if (!ticker.equals(lastTicker)) {
            tickerDao.save(ticker);
            if (lastTicker != null) {
                playPriceChangeSound(lastTicker, ticker);
            }
        }
    }

    protected void playPriceChangeSound(Ticker lastTicker, Ticker newTicker) {
        Double differenceDouble = newTicker.getPrice() - lastTicker.getPrice();
        try {
            logger.info(String.format("Change : %s | %s", differenceDouble, lastTicker));
            Tone tone = new Tone();
            if (differenceDouble > 0) {
                double v = Math.abs(differenceDouble / 10);
                tone.goingUp((int)v);
            } else if (differenceDouble < 0) {
                double v = Math.abs(differenceDouble / 10);
                tone.goingDown((int)v);
            }
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
}
