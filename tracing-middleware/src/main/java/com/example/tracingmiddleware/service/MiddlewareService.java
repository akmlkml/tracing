package com.example.tracingmiddleware.service;

import com.example.tracingmiddleware.component.ExternalServiceAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MiddlewareService {
    private final ExternalServiceAdapter adapter;

    public MiddlewareService(ExternalServiceAdapter adapter) {
        this.adapter = adapter;
    }

    public void shakeHand() {
        log.info("Middleware. Shaking hand");
        adapter.shakeHand();
    }
}
