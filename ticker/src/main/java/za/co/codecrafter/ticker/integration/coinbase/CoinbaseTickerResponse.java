package za.co.codecrafter.ticker.integration.coinbase;

import lombok.Getter;
import za.co.codecrafter.ticker.common.TickerResponse;

@Getter
public class CoinbaseTickerResponse implements TickerResponse {

    private CoinbaseData data;
}
