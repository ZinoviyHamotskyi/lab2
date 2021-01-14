package com.example.demo.repo;

import com.example.demo.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepo extends JpaRepository<Service, UUID> {

    Service getServiceByName(String serviceByName);
    void deleteByName(String name);
}
