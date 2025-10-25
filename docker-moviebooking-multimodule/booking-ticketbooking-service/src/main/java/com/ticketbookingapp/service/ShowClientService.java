package com.ticketbookingapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import com.ticketbookingapp.model.Show;

@Service
public class ShowClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${show-service.service.url}")
    private String SHOWBASEURL;

    @CircuitBreaker(name = "show-cbservice", fallbackMethod = "fallbackGetShowDetails")
    public ResponseEntity<Show> getShowDetails(int showId, String jwtToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", jwtToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = SHOWBASEURL + "/shows-service/v1/shows/showId/" + showId;
        return restTemplate.exchange(url, HttpMethod.GET, entity, Show.class);
    }

    public ResponseEntity<Show> fallbackGetShowDetails(int showId, String jwtToken, Throwable t) {
        Show fallbackShow = new Show();
        fallbackShow.setShowId(showId);
        fallbackShow.setErrorMessage("Show Service is unavailable. Please try again later.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackShow);
    }
}

