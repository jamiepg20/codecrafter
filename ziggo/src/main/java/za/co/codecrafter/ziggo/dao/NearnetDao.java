package za.co.codecrafter.ziggo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.codecrafter.ziggo.model.Nearnet;

import java.util.Optional;


/**
 * Created by arnoe on 2017/09/27.
 */
@RepositoryRestResource(path = "nearnet")
public interface NearnetDao extends CrudRepository<Nearnet, Long> {

    Optional<Nearnet> findAllByZipcodeAndHousenumber(String zipcode, Long housenumber);
}
