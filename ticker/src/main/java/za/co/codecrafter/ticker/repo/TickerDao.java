package za.co.codecrafter.ticker.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.codecrafter.ticker.model.Source;
import za.co.codecrafter.ticker.model.Ticker;


/**
 * Created by arnoe on 2017/05/04.
 */
@RepositoryRestResource(path = "ticker")
public interface TickerDao extends CrudRepository<Ticker, Long> {

    @Override
    Iterable<Ticker> findAll();

    Ticker findFirstByOrderByIdDesc();

    Ticker findFirstBySourceOrderByIdDesc(Source source);

    Page<Ticker> findAll(Pageable pageable);

    Iterable<Ticker> findBySource(Source source);
}
