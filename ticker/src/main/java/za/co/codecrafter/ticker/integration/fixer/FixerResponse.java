package za.co.codecrafter.ticker.integration.fixer;

import lombok.Getter;

import java.util.Currency;
import java.util.Date;
import java.util.Map;


/**
 * Created by arnoe on 2017/05/06.
 */
@Getter
public class FixerResponse {

    private Currency base;
    private Date date;
    private Map<String, String> rates;
}
