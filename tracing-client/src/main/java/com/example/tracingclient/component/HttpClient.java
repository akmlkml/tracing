package com.example.tracingclient.component;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import uz.b2c.kapitalbank.observability.autoconfiguration.ObservabilityAutoConfiguration;

@Slf4j
@Component
@ImportAutoConfiguration(classes = ObservabilityAutoConfiguration.class)
public class HttpClient {
    private final RestTemplate restTemplate;

    public HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> sendGetRequest(final URI uri) {
        try {
            return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                new HttpEntity<>(buildHeaders()),
                String.class);
        } catch (Exception ex) {
            log.error("Failed to process request", ex);
            throw ex;
        }
    }

    public <T> ResponseEntity<String> sendPostRequest(final URI uri, final T request) {
        return restTemplate.exchange(
                uri,
                HttpMethod.POST,
                new HttpEntity<>(request, buildHeaders()),
                String.class);
    }

    private HttpHeaders buildHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return headers;
    }
}
