package za.co.codecrafter.ticker.integration.kraken;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.codecrafter.ticker.common.TickerResponse;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KrakenPair implements TickerResponse {


    //    a = ask array(<price>, <whole lot volume>, <lot volume>),
    @JsonProperty("a")
    private String[] a;

    public BigDecimal getAsk() {
        return asBigDecimal(a[0]);
    }

    private static BigDecimal asBigDecimal(String s) {
        return new BigDecimal(s);
    }

    //    b = bid array(<price>, <whole lot volume>, <lot volume>),
    @JsonProperty("b")
    private String[] b;

    public BigDecimal getBid() {
        return asBigDecimal(b[0]);
    }

    //    c = last trade closed array(<price>, <lot volume>),
    @JsonProperty("c")
    private String[] c;

    public BigDecimal getLast() {
        return asBigDecimal(c[0]);
    }

    //    v = volume array(<today>, <last 24 hours>),
    @JsonProperty("v")
    private String[] v;

    public BigDecimal getVolume() {
        return asBigDecimal(v[0]);
    }

    //    p = volume weighted average price array(<today>, <last 24 hours>),
    @JsonProperty("p")
    private String[] p;

    public BigDecimal getAvgLast24Hrs() {
        return asBigDecimal(p[1]);
    }

    //    t = number of trades array(<today>, <last 24 hours>),
//    @JsonProperty("t")
//    private BigDecimal[] t;
//
//
//    //    l = low array(<today>, <last 24 hours>),
//    @JsonProperty("l")
//    private BigDecimal[] l;
//
//    //    h = high array(<today>, <last 24 hours>),
//    @JsonProperty("h")
//    private BigDecimal[] h;
//
//    //    o = today's opening price
//    @JsonProperty("o")
//    private BigDecimal[] o;
}
