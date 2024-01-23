package com.example.tracingback.controller;

import com.example.tracingback.service.BackendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/backend")
public class BackendController {
    private final BackendService backendService;


    public BackendController(BackendService backendService) {
        this.backendService = backendService;
    }

    @GetMapping("/shake")
    public ResponseEntity<Void> shakeHand() {
        backendService.shakeHand();
        return ResponseEntity.ok().build();
    }
}
