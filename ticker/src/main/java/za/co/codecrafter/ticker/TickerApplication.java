package za.co.codecrafter.ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.ticker.common.TickerResponse;
import za.co.codecrafter.ticker.dao.TickerDao;
import za.co.codecrafter.ticker.integration.bitstamp.BitstampMapper;
import za.co.codecrafter.ticker.integration.bitstamp.BitstampTickerRequest;
import za.co.codecrafter.ticker.integration.bitstamp.BitstampTickerResponse;
import za.co.codecrafter.ticker.integration.cexio.CexioMapper;
import za.co.codecrafter.ticker.integration.cexio.CexioTickerRequest;
import za.co.codecrafter.ticker.integration.cexio.CexioTickerResponse;
import za.co.codecrafter.ticker.integration.fixer.FixerRequest;
import za.co.codecrafter.ticker.integration.fixer.FixerResponse;
import za.co.codecrafter.ticker.integration.luno.LunoMapper;
import za.co.codecrafter.ticker.integration.luno.LunoTickerRequest;
import za.co.codecrafter.ticker.integration.luno.LunoTickerResponse;
import za.co.codecrafter.ticker.mapper.TickerMapper;
import za.co.codecrafter.ticker.model.Source;
import za.co.codecrafter.ticker.model.Ticker;

import javax.annotation.PostConstruct;
import javax.sound.midi.MidiUnavailableException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Created by arnoe on 2017/04/27.
 */
@SpringBootApplication
@EnableScheduling
public class TickerApplication {

    private Logger logger = Logger.getLogger(getClass().getName());
    private HttpClient client = new HttpClient();
    private Map<String, String> usdBasedRates = new HashMap<>();

    @Autowired
    private TickerDao tickerDao;

    public static void main(String[] args) {
        SpringApplication.run(TickerApplication.class, args);
    }

    @PostConstruct
    public void init() {
    }

    @Scheduled(fixedRate = 10000, initialDelay = 0)
    public void tickFixerUsdBased() throws URISyntaxException {
        // ---------------
        // pull
        FixerRequest request = new FixerRequest("USD");
        FixerResponse response = client.execute(request, FixerResponse.class);
        usdBasedRates.putAll(response.getRates());
    }

    @Scheduled(fixedRate = 15000, initialDelay = 10000)
    public void tickLuno() throws URISyntaxException {
        // -------------
        // pull
        LunoTickerRequest request = new LunoTickerRequest("XBTZAR");
        LunoTickerResponse response = client.execute(request, LunoTickerResponse.class);
        // -------------
        // persist
        Ticker ticker = convert(new LunoMapper(usdBasedRates), response);
        alertAndPersistOnChange(ticker);
    }


//    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void tickCexio() throws URISyntaxException {
        // -------------
        // pull
        CexioTickerRequest request = new CexioTickerRequest();
        CexioTickerResponse response = client.execute(request, CexioTickerResponse.class);
        // -------------
        Ticker ticker = convert(new CexioMapper(), response);
//        alertAndPersistOnChange(ticker);
    }


    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void tickBitstamp() throws URISyntaxException {
        // -------------
        // pull
        BitstampTickerRequest request = new BitstampTickerRequest("btcusd");
        BitstampTickerResponse response = client.execute(request, BitstampTickerResponse.class);
        // -------------
        Ticker ticker = convert(new BitstampMapper(), response);
        alertAndPersistOnChange(ticker);
    }

    private <T extends TickerResponse> Ticker convert(TickerMapper<T> mapper, T response) {
        return mapper.apply(response);
    }

    private void alertAndPersistOnChange(Ticker ticker) {
        Ticker lastTicker = tickerDao.findFirstBySourceOrderByIdDesc(Source.Bitstamp);
        if (!ticker.equals(lastTicker)) {
            tickerDao.save(ticker);
            playPriceChangeSound(lastTicker, ticker);
        }
    }

    protected void playPriceChangeSound(Ticker lastTicker, Ticker newTicker) {
        if (lastTicker == null) {
            return;
        }
        if (newTicker == null) {
            return;
        }
        Double differenceDouble = newTicker.getPrice() - lastTicker.getPrice();
        try {
            logger.info(String.format("Change : %s | %s", differenceDouble, lastTicker));
            Tone tone = new Tone();
            if (differenceDouble > 0) {
                double v = Math.abs(differenceDouble);
                tone.goingUp((int)v);
            } else if (differenceDouble < 0) {
                double v = Math.abs(differenceDouble);
                tone.goingDown((int)v);
            }
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
}
