package com.example.demo.service.Impl;


import com.example.demo.repo.ServiceRepo;
import com.example.demo.service.ServiceService;
import com.example.demo.service.model.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Service
public final class ServiceServiceImpl implements ServiceService {
    private final ServiceRepo serviceRepo ;

    @Autowired
    public ServiceServiceImpl(ServiceRepo serviceRepo){
        this.serviceRepo = serviceRepo;
    }

    public Service addNewService(String name, double price){
        Service service = new Service(name, price);
        serviceRepo.save(service);
        return service;
    }

    @Override
    public Service getServiceByName(String name){
        Service service = serviceRepo.getServiceByName(name);
        if (service == null){
            System.out.println("Service is not found");
        }
        return service;
    }

    @Override
    public List<Service> getServices(){
        List<Service> services = serviceRepo.findAll();
        if (services == null){
            System.out.println("Service list is empty");
        }
        return services;
    }


    @Override
    public String deleteServiceByName(String name){
        Service service = serviceRepo.getServiceByName(name);
        if (service == null){
            return "Service is not found";
        }
        else
            serviceRepo.deleteByName(name);
        return "Service`s deleted";
    }

    @Override
    public UUID getId(String name){
        Service service = serviceRepo.getServiceByName(name);
        if (service == null){
            System.out.println("Service is not found");
        }
        return service.getId();
    }
}
