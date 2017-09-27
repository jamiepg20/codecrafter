package za.co.codecrafter.ziggo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import java.util.Date;


/**
 * Created by arnoe on 2017/09/27.
 */
@Getter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nearnet {

    @Id
    @GeneratedValue
    private Long id;
    private Date createdDate;
    private String zipcode;
    private Long housenumber;
    private String city;
    private Long zipcodechecker;
    private Long order;

    @PostPersist
    private void onCreate() {
        createdDate = new Date();
    }
}
