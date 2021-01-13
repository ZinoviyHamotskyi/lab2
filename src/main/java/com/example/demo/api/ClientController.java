package com.example.demo.api;

import com.example.demo.service.ClientService;
import com.example.demo.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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

    @GetMapping(value = "/clients/{name}")
    public ResponseEntity<Client> getClient(@PathVariable(name = "name") String name) {
        return ResponseEntity.ok(clientService.getClientByName(name));
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<Client> addClient(@RequestParam String name,
                                            @RequestParam String birthDate) throws ParseException {
        return ResponseEntity.ok(clientService.addNewClient(name, birthDate));
    }

    @DeleteMapping(value = "/clients")
    public ResponseEntity<String> deleteManagerByName(@RequestParam String name) {
        return ResponseEntity.ok(clientService.deleteClientByName(name));
    }

}
