package com.theodorol.api.controller;

import com.theodorol.api.model.Client;
import com.theodorol.api.service.ClientService;
import jakarta.servlet.Servlet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        var client = clientService.findById(id);
        return ResponseEntity.ok(client);

    }
    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){
        var clientCreated = clientService.create(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.getId())
                .toUri();
        return ResponseEntity.created(location).body(clientCreated);

    }
}
