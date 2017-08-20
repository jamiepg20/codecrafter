package za.co.codecrafter.ticker.integration.kraken;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter

public class KrakenData {
    @JsonProperty("XXBTZUSD")
    private KrakenPair XXBTZUSD;
}
