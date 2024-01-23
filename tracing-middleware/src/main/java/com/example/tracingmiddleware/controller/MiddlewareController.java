package com.example.tracingmiddleware.controller;

import com.example.tracingmiddleware.service.MiddlewareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/middle")
public class MiddlewareController {
    private final MiddlewareService service;


    public MiddlewareController(MiddlewareService service) {
        this.service = service;
    }

    @GetMapping("/shake")
    public ResponseEntity<Void> shakeHand() {
        service.shakeHand();
        return ResponseEntity.ok().build();
    }
}
