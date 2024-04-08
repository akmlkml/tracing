package com.example.tracingclient.service;

import com.example.tracingclient.component.ExternalServiceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientService {
    private final ExternalServiceAdapter adapter;

    public ClientService(ExternalServiceAdapter adapter) {
        this.adapter = adapter;
    }

    public void shakeHand() {
        log.info("Client. Shaking hand");
        log.info("Trace {}", MDC.get("traceId"));
        log.info("Device-Info {}", MDC.get("X-Device-Info"));
        adapter.shakeHand();
    }
}
