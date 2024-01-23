package com.example.tracingmiddleware.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExternalServiceAdapter {
    HttpClient httpClient;

    public ExternalServiceAdapter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void shakeHand() {
        var uri = ExternalProperty.toURI();
        var response = httpClient.sendGetRequest(uri);
        var responseStatus = response.getStatusCode();
        var responseBody = response.getBody();

        if (responseStatus != HttpStatus.OK) {
            log.error("Middleware. Sheet happened, {}", responseBody);
        }
    }
}
