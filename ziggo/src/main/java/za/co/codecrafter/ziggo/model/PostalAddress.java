package za.co.codecrafter.ziggo.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Created by arnoe on 2017/09/27.
 */
@Getter
@Entity
public class PostalAddress {

    @Id
    @GeneratedValue
    private Long id;

    private String zipcode;
    private String housenumber;
}
