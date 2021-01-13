package com.example.demo.service;

import com.example.demo.repo.ClientRepo;
import com.example.demo.service.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public final class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addNewClient(String name, String birthDate) throws ParseException {
        Client client = new Client(name, birthDate);
        clientRepo.save(client);
        return client;
    }

    public Client getClientByName(String name){
        Client client = clientRepo.getClientByName(name);
        if (client == null){
            System.out.println("Client is not found");
        }
        return client;
    }

    public List<Client> getClients(){
        List<Client> clients = clientRepo.findAll();
        if (clients == null){
            System.out.println("Client list is empty");
        }
        return clients;
    }

    public String deleteClientByName(String name){
        Client client = clientRepo.getClientByName(name);
        if (client == null){
            return "Client is not found";
        }
        else
            clientRepo.deleteByName(name);
            return "Client`s deleted";
    }


}


