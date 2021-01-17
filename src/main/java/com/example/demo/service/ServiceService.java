package com.example.demo.service;


import com.example.demo.service.model.Service;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public interface ServiceService {
    Service addNewService(Service service);
    Service getServiceByName(String name);
    Service getServiceById(UUID id);
    List<Service> getServices();
    String deleteServiceById(UUID id);
    UUID getId(String name);
}
