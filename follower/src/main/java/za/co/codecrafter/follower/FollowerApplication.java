package za.co.codecrafter.follower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;


/**
 * Created by arnoe on 2017/05/06.
 */
@SpringBootApplication
@EnableScheduling
public class FollowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FollowerApplication.class, args);
    }

    @PostConstruct
    public void init() {

    }

    @Scheduled(fixedRate = 500, initialDelay = 0)
    public void reportCurrentTime() {

    }
}
