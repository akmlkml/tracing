package com.example.tracingmiddleware.component;


import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ExternalProperty {
    private static final int port = 8092;
    private static final String host = "localhost";
    private static final String path = "/api/backend/shake";

    public static URI toURI() {
        return UriComponentsBuilder
            .newInstance()
            .scheme("http")
            .host(host)
            .port(port)
            .path(path)
            .build()
            .toUri();
    }
}
