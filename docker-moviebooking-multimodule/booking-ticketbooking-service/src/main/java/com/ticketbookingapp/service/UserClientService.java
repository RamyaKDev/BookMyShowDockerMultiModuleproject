package com.ticketbookingapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import com.ticketbookingapp.model.User;

@Service
public class UserClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user-service.service.url}")
    private String USERBASEURL;

    @CircuitBreaker(name = "user-cbservice", fallbackMethod = "fallbackGetUserDetails")
    public  ResponseEntity<User> getUserDetails(int userId, String jwtToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", jwtToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = USERBASEURL + "/users-service/v1/users/userId/" + userId;

        return restTemplate.exchange(url, HttpMethod.GET, entity, User.class);
        
    }

    public ResponseEntity<User> fallbackGetUserDetails(int userId, String jwtToken, Throwable t) {
        System.err.println("⚠️ Fallback triggered for User Service: " + t.getMessage());
        User fallbackUser = new User();
        fallbackUser.setUserId(userId);
        fallbackUser.setErrorMessage("User Service is unavailable.");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackUser);
    }
}

