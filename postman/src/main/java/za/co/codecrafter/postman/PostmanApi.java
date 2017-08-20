package za.co.codecrafter.postman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import za.co.codecrafter.http.HttpClient;
import za.co.codecrafter.postman.flow.GetCollectionFlow;
import za.co.codecrafter.postman.flow.GetCollectionsFlow;
import za.co.codecrafter.postman.flow.GetEnvironmentFlow;
import za.co.codecrafter.postman.flow.GetEnvironmentsFlow;
import za.co.codecrafter.postman.model.Collection;
import za.co.codecrafter.postman.model.Environment;
import za.co.codecrafter.postman.request.GetCollectionRequest;
import za.co.codecrafter.postman.request.GetCollectionsRequest;
import za.co.codecrafter.postman.request.GetEnvironmentRequest;
import za.co.codecrafter.postman.request.GetEnvironmentsRequest;
import za.co.codecrafter.postman.response.GetCollectionsResponse;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * Created by arnoe on 2017/06/05.
 */
@SpringBootApplication
@EnableScheduling
public class PostmanApi {

    private static final Logger log = LoggerFactory.getLogger(PostmanApi.class);

    public static void main(String args[]) {
        SpringApplication.run(PostmanApi.class, args);
    }

//    public static void main(String[] args) {
//        List<Environment> environments = getEnvironments();
//        environments.forEach(environment -> log.info(environment.getUid()));
//        Environment environment = environments.iterator().next();
//        log.info(getEnvironment(environment.getUid()).toString());
//    }

    @PostConstruct
    public void init() {
        //        List<Collection> collections = getCollections();
        //        collections.forEach(c -> log.info(c.getUid()));
        //        Collection collection = getCollection(collections.iterator().next().getUid());
        //        log.info(collection.toString());
        List<Environment> environments = getEnvironments();
        environments.forEach(environment -> log.info(environment.getUid()));
        Environment environment = environments.iterator().next();
        log.info(getEnvironment(environment.getUid()).toString());
    }

    private static Environment getEnvironment(String uid) {
        GetEnvironmentFlow flow = new GetEnvironmentFlow(new HttpClient());
        GetEnvironmentRequest request = new GetEnvironmentRequest(uid);
        return flow.apply(request).getEnvironment();
    }

    public List<Collection> getCollections() {
        GetCollectionsFlow flow = new GetCollectionsFlow(new HttpClient());
        GetCollectionsRequest request = new GetCollectionsRequest();
        GetCollectionsResponse response = flow.apply(request);
        return response.getCollections();
    }

    public Collection getCollection(String uid) {
        GetCollectionFlow flow = new GetCollectionFlow(new HttpClient());
        GetCollectionRequest request = new GetCollectionRequest(uid);
        return flow.apply(request).getCollection();
    }

    public static List<Environment> getEnvironments() {
        GetEnvironmentsFlow flow = new GetEnvironmentsFlow(new HttpClient());
        GetEnvironmentsRequest request = new GetEnvironmentsRequest();
        return flow.apply(request).getEnvironments();
    }
}
