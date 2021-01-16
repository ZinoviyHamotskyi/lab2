package com.example.demo.repo;

import com.example.demo.service.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepo extends JpaRepository<Client, UUID> {
    Client getClientByName(String name);
    Client getByName(String name);

    Client getClientById(UUID id);


    @Override
    void delete(Client client);
}
