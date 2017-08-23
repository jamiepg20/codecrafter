package za.co.codecrafter.ticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.codecrafter.ticker.repo.TickerDao;
import za.co.codecrafter.ticker.model.Source;
import za.co.codecrafter.ticker.model.Ticker;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by arnoe on 2017/05/04.
 */
@Controller
public class TickerViewController {

    @Autowired
    private TickerDao tickerDao;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("luno", toTwoDimensionalArray(toList(tickerDao.findBySource(Source.Luno))));
        model.addAttribute("bitstamp", toTwoDimensionalArray(toList(tickerDao.findBySource(Source.Bitstamp))));
        model.addAttribute("kraken", toTwoDimensionalArray(toList(tickerDao.findBySource(Source.Kraken))));
        model.addAttribute("cexio", toTwoDimensionalArray(toList(tickerDao.findBySource(Source.Cexio))));
        return "home";
    }

    private List<Ticker> toList(Iterable<Ticker> iterable) {
        ArrayList<Ticker> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    private Object[][] toTwoDimensionalArray(List<Ticker> list) {
        Object[][] array = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Ticker ticker = list.get(i);
            array[i][0] = ticker.getTimestamp().getTime();
            array[i][1] = ticker.getPrice();
        }
        return array;
    }
}
