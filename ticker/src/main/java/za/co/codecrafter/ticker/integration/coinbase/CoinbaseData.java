package za.co.codecrafter.ticker.integration.coinbase;

import lombok.Getter;

import java.util.Map;

@Getter
public class CoinbaseData {
    private String currency;
    private Map<String, String> rates;
}
