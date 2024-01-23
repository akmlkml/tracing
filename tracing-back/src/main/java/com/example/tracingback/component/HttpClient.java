package com.example.tracingback.component;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;

@Component
public class HttpClient {
    private final RestTemplate restTemplate;

    public HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> sendGetRequest(final URI uri) {
        return restTemplate.exchange(
            uri,
            HttpMethod.GET,
            new HttpEntity<>(buildHeaders()),
            String.class);
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
