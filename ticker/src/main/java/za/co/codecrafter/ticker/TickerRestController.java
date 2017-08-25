package za.co.codecrafter.ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.codecrafter.ticker.model.Source;
import za.co.codecrafter.ticker.model.Ticker;
import za.co.codecrafter.ticker.repo.TickerDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by arnoe on 2017/05/04.
 */
@RestController
@RequestMapping("/")
public class TickerRestController {

    @Autowired
    private TickerDao tickerDao;

    @RequestMapping("/tickers")
    public List<Ticker> tickers() {
        ArrayList<Ticker> tickers = new ArrayList<>();
        Date now = new Date();
        // -------------
        Ticker luno = tickerDao.findFirstBySourceOrderByIdDesc(Source.Luno);
        luno.setTimestamp(now);
        tickers.add(luno);
        // -------------
        Ticker bitstamp = tickerDao.findFirstBySourceOrderByIdDesc(Source.Bitstamp);
        bitstamp.setTimestamp(now);
        tickers.add(bitstamp);
        // -------------
        Ticker kraken = tickerDao.findFirstBySourceOrderByIdDesc(Source.Kraken);
        kraken.setTimestamp(now);
        tickers.add(kraken);
        // -------------
        Ticker cexio = tickerDao.findFirstBySourceOrderByIdDesc(Source.Cexio);
        cexio.setTimestamp(now);
        tickers.add(cexio);
        // -------------
        Ticker coinbase = tickerDao.findFirstBySourceOrderByIdDesc(Source.Coinbase);
        coinbase.setTimestamp(now);
        tickers.add(coinbase);
        return tickers;
    }
}
