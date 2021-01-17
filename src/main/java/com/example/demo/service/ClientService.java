package com.example.demo.service;


import com.example.demo.service.model.Client;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {

    void addNewClient(Client client) throws ParseException;
    List<Client> getClients();
    String deleteClientById(UUID id);
    UUID getId(String name);
    Client getClientById(UUID id);

}
