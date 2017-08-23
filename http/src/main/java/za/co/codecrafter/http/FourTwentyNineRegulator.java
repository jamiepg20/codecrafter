package za.co.codecrafter.http;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

public class FourTwentyNineRegulator {
    private static Map<String, DateTime> key_429DateTime = new HashMap<>();
    private static Map<String, Long> key_averageWait = new HashMap<>();

    public static void record429(RequestEntity request, HttpClientErrorException response) {
        if (response.getStatusCode() != HttpStatus.TOO_MANY_REQUESTS) {
            // nothing to do here
            return;
        }

        String key = createKey(request);
        Long averageWaitMilli = key_averageWait.getOrDefault(key, 100L);
        key_averageWait.put(key, averageWaitMilli + 1000);
        key_429DateTime.put(key, new DateTime());
    }

    public static boolean safeToProceed(RequestEntity request) {
        String key = createKey(request);
        Long averageWaitMilli = key_averageWait.getOrDefault(key, 100L);
        DateTime errorDate = key_429DateTime.get(key);
        if (errorDate == null) {
            return true;
        }

        if (new DateTime().isAfter(errorDate.plusMillis(averageWaitMilli.intValue()))) {
            return true;
        }
        return false;
    }

    private static String createKey(RequestEntity request) {
        return String.format("%s:%s:", request.getMethod(), request.getUrl());
    }
}
