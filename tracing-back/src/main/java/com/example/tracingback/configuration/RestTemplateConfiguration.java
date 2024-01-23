package com.example.tracingback.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class RestTemplateConfiguration {

    private final RequestResponseInterceptor requestResponseInterceptor;

    public RestTemplateConfiguration(RequestResponseInterceptor requestResponseInterceptor) {
        this.requestResponseInterceptor = requestResponseInterceptor;
    }

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
        final RestTemplate restTemplate = restTemplateBuilder
//            .requestFactory(() -> new BufferingClientHttpRequestFactory(getClientHttpRequestFactory()))
            .build();

        restTemplate.setInterceptors(List.of(requestResponseInterceptor));

        return restTemplate;
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }
}
