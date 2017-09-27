package za.co.codecrafter.ziggo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by arnoe on 2017/09/27.
 */
@Getter
@Setter
@Entity
public class PostalAddress {

    @Id
    @GeneratedValue
    private Long id;
    private Date createdDate;
    private Date modifiedDate;
    // ----------
    private String zipcode;
    private Long housenumber;
    private Boolean nearnet;

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

    @PreUpdate
    protected void onModify() {
        modifiedDate = new Date();
    }
}
