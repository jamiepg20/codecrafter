package za.co.codecrafter.ziggo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.codecrafter.ziggo.model.PostalAddress;

import java.util.Collection;


/**
 * Created by arnoe on 2017/09/27.
 */
@RepositoryRestResource(path = "postaladdress")
public interface PostalAddressDao extends CrudRepository<PostalAddress, Long> {

    Collection<PostalAddress> findAllByNearnetFalseOrNearnetNull();

    PostalAddress findAllByZipcodeAndHousenumber(String zipcode, Long housenumber);
}
