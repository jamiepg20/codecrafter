package za.co.codecrafter.ticker.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by arnoe on 2017/05/04.
 */
@ToString(exclude = { "id", "volume", "ask", "bid" })
@EqualsAndHashCode(exclude = { "timestamp", "id", "volume" })
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "index")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {

    @Id
    @GeneratedValue
    private Long id;
    private Date timestamp;
    @Enumerated(EnumType.STRING)
    private CurrencyPair currency;
    private Double price;

    private Double bid;
    private Double ask;

    private Double volume;

    @Enumerated(EnumType.STRING)
    private Source source;
}
