package za.co.codecrafter.ziggo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.ziggo.dao.NearnetDao;
import za.co.codecrafter.ziggo.dao.PostalAddressDao;
import za.co.codecrafter.ziggo.model.Nearnet;
import za.co.codecrafter.ziggo.model.PostalAddress;
import za.co.codecrafter.ziggo.request.PostalCodeRequest;
import za.co.codecrafter.ziggo.response.PostalCodeResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;


/**
 * Created by arnoe on 2017/09/27.
 */
@Slf4j
@SpringBootApplication
@EnableScheduling
public class ZiggoApplication {

    @Autowired
    private PostalAddressDao postalAddressDao;

    @Autowired
    private NearnetDao nearnetDao;

    private HttpClient httpClient = new HttpClient();

    public static void main(String[] args) {
        SpringApplication.run(ZiggoApplication.class, args);
    }

    @Scheduled(fixedRate = 10000L)
    public void crawl() {
        Iterator<PostalAddress> iterator = postalAddressDao.findAll().iterator();
        ArrayList<PostalAddress> result = new ArrayList<>();
        iterator.forEachRemaining(result::add);

        result.stream()//
                .map(p -> convert(p.getZipcode(), p.getHousenumber())) //
                .filter(Objects::nonNull) //
                .forEach(nearnet -> {
                    Optional<Nearnet>
                            existing =
                            nearnetDao.findAllByZipcodeAndHousenumber(nearnet.getZipcode(), nearnet.getHousenumber());
                    if (existing.isPresent()) {
                        log.info("already exists");
                    } else {
                        nearnetDao.save(nearnet);
                    }
                });
    }

    private Nearnet convert(String zipcode, String housenumber) {
        PostalCodeRequest request = new PostalCodeRequest(zipcode, housenumber);
        try {
            return httpClient.execute(request, PostalCodeResponse.class).getNearnet();
        } catch (HttpMessageNotReadableException e) {
            return null;
        }
    }
}
