package com.example.demo.api;

import com.example.demo.service.ClientService;
import com.example.demo.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }



    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> getClient() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping(value = "/clients")
    public void addClient(@Validated @RequestBody Client client) throws ParseException {
        clientService.addNewClient(client);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void deleteManagerByName(@PathVariable(name = "id") UUID id ) {

        System.out.println(clientService.deleteClientById(id));
    }

}
