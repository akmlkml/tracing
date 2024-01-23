package com.example.tracingclient.controller;

import com.example.tracingclient.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/shake")
    public ResponseEntity<Void> shakeHand() {
        clientService.shakeHand();
        return ResponseEntity.ok().build();
    }
}
