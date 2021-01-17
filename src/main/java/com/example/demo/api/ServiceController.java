package com.example.demo.api;


import com.example.demo.service.ServiceService;
import com.example.demo.service.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }

    @GetMapping(value = "/services")
    public List<Service> getServices(){
        return serviceService.getServices();
    }

    @GetMapping(value = "/services/{id}")
    public Service getServiceByName(@PathVariable(name = "id")UUID id){
        return serviceService.getServiceById(id);
    }

    @PostMapping(value = "/services")
    public Service addNewService(@Validated @RequestBody Service service){
        return serviceService.addNewService(service);
    }

    @DeleteMapping(value = "/services/{id}")
    public String deleteServiceByName(@PathVariable(name = "id") UUID id){
        return serviceService.deleteServiceById(id);
    }
}
