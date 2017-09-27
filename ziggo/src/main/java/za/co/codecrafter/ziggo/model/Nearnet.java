package za.co.codecrafter.ziggo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.*;
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
    private Date modifiedDate;
    // ----------
    private String zipcode;
    private Long housenumber;
    private String city;
    private Long zipcodechecker;
    private Long order;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

    @PreUpdate
    protected void onModify() {
        modifiedDate = new Date();
    }
}
