package com.example.demo.service;


import com.example.demo.service.model.Service;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public interface ServiceService {
    Service addNewService(String name, double price);
    Service getServiceByName(String name);
    Service getServiceById(UUID id);
    List<Service> getServices();
    String deleteServiceByName(String name);
    UUID getId(String name);
}
