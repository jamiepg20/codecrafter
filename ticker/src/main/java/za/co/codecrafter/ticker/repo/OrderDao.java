package za.co.codecrafter.ticker.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.codecrafter.ticker.model.Order;


/**
 * Created by arnoe on 2017/05/04.
 */
//@RestResource(path = "order", rel = "order")
@RepositoryRestResource(path = "order")
public interface OrderDao extends CrudRepository<Order, Long> {

}
