package com.example.demo.service;


import com.example.demo.service.model.Client;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public interface ClientService {

    Client addNewClient(String name,
                        String birthDate) throws ParseException;
    Client getClientByName(String name);
    List<Client> getClients();
    String deleteClientByName(String name);
    UUID getId(String name);
    Client getClientById(UUID id);

}
