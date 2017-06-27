package za.co.codecrafter.ticker.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


/**
 * Created by arnoe on 2017/05/04.
 */


@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("creation_timestamp")
    private Date creationTimestamp;

    @JsonProperty("expiration_timestamp")
    private Date expirationTimestamp;

    @JsonProperty("completed_timestamp")
    private Date completedTimestamp;


    public enum Type {
        BID,
        ASK
    }


    @JsonProperty("type")
    private Type type;


    public enum State {
        PENDING,
        COMPLETE
    }


    @JsonProperty("state")
    private State state;

    @JsonProperty("limit_price")
    private Double limitPrice;

    @JsonProperty("limit_volume")
    private Double limitVolume;

    @JsonProperty("base")
    private Double base;

    @JsonProperty("counter")
    private Double counter;

    @JsonProperty("fee_base")
    private Double feeBase;

    @JsonProperty("fee_counter")
    private Double feeCounter;


    public enum Pair {
        XBTZAR
    }

    @JsonProperty("pair")
    private Pair pair;

    @JsonProperty("btc")
    private Double btc;

    @JsonProperty("zar")
    private Double zar;

    @JsonProperty("fee_btc")
    private Double feeBtc;

    @JsonProperty("fee_zar")
    private Double feeZar;
}
