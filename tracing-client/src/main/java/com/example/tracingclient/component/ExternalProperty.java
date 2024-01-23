package com.example.tracingclient.component;


import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ExternalProperty {
    private static final int port = 8091;
    private static final String host = "localhost";
    private static final String path = "/api/middle/shake";

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
