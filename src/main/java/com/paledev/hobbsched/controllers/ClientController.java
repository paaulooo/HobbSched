package com.paledev.hobbsched.controllers;

import com.paledev.hobbsched.dto.ClientDTO;
import com.paledev.hobbsched.models.Client;
import com.paledev.hobbsched.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }
    @GetMapping("/id")
    public ResponseEntity<Client> getClientById(@RequestParam long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO client) {
        return ResponseEntity.ok(clientService.save(client));
    }
    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody Long id,  ClientDTO client) {
        return ResponseEntity.ok(clientService.update(id ,client));
    }
    @DeleteMapping
    public ResponseEntity<Client> deleteClient(@RequestParam long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
