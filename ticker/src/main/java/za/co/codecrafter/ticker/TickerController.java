package za.co.codecrafter.ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import za.co.codecrafter.ticker.dao.TickerDao;


/**
 * Created by arnoe on 2017/05/04.
 */
@Controller
public class TickerController {

    @Autowired
    private TickerDao tickerDao;

    @RequestMapping("/hi")
    public String chart(){
        return "graph";
    }
//
//    @RequestMapping("/{name}")
//    public String hello(Map model,
//            @PathVariable
//                    String name) {
//        model.put("name", name);
//        HashSet<String> value = new HashSet<>();
//        Iterable<Ticker> all = tickerDao.findAll();
//        for (Ticker ticker : all) {
//            value.add(ticker.toString());
//        }
//        model.put("strings", value);
//        return "tickers";
//    }
//
//    @RequestMapping("/all")
//    public @ResponseBody Iterable<Ticker> findAll() {
//        return tickerDao.findAll();
//    }
}
