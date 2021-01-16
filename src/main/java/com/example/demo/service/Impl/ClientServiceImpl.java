package com.example.demo.service.Impl;

import com.example.demo.repo.ClientRepo;
import com.example.demo.service.ClientService;
import com.example.demo.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public final class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client addNewClient(String name, String birthDate) throws ParseException {
        Client client = new Client(name, birthDate);
        clientRepo.save(client);
        return client;
    }

    @Override
    public Client getClientByName(String name){
        Client client = clientRepo.getClientByName(name);
        if (client == null){
            System.out.println("Client is not found");
        }
        return client;
    }

    @Override
    public List<Client> getClients(){
        List<Client> clients = clientRepo.findAll();
        if (clients == null){
            System.out.println("Client list is empty");
        }
        return clients;
    }

    @Override
    public String deleteClientByName(String name){
        Client client = clientRepo.getClientByName(name);
        if (client == null){
            return "Client is not found";
        }
        else
            clientRepo.delete(clientRepo.getClientByName(name));
            return "Client`s deleted";
    }

    @Override
    public UUID getId(String name){
        Client client = clientRepo.getClientByName(name);
        if (client == null){
            System.out.println("Client list is empty");
        }
        return client.getId();
    }

    @Override
    public Client getClientById(UUID id) {
        Client client = clientRepo.getClientById(id);
        if (client == null){
            System.out.println("Client is not found");
        }
        return client;
    }
}


