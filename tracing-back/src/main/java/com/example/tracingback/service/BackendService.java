package com.example.tracingback.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BackendService {
    public void shakeHand() {
        log.info("Backend. Shaking hand");
        log.info("Backend. Hand shook");
    }
}
