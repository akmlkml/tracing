package com.example.tracingclient.configuration;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RequestResponseInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, final ClientHttpRequestExecution execution) throws IOException {
        final ZonedDateTime start = LocalDateTime.now().atZone(ZoneId.systemDefault());
        final ClientHttpResponse response = execution.execute(request, body);
        final ZonedDateTime end = LocalDateTime.now().atZone(ZoneId.systemDefault());

        logResponse(response, request, body, start, end);
        return response;
    }

    private void logResponse(final ClientHttpResponse response,
                             final HttpRequest request,
                             final byte[] body,
                             final ZonedDateTime start,
                             final ZonedDateTime end) throws IOException {
        final long difference = end.toInstant().toEpochMilli() - start.toInstant().toEpochMilli();
        log.info("************* Begin Request/Response *************");
        log.info("Request URI                 : {}", request.getURI());
        log.info("Request Headers             : {}", request.getHeaders());
        log.info("Response status code        : {}", response.getStatusCode());
        final String PATTERN = "dd.MM.yyyy HH:mm:ss";
        log.info("Response Finished at        : {}", DateTimeFormatter.ofPattern(PATTERN).format(end));
        log.info("Total request time          : {}ms", difference);
        log.info("*************** End Request/Response **************");
    }
}
