package com.example.demo.api;


import com.example.demo.service.ServiceService;
import com.example.demo.service.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/services")
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getServices(){
        return serviceService.getServices();
    }

    @GetMapping(value = "/{name}")
    public Service getServiceByName(@PathVariable(name = "name") String name){
        return serviceService.getServiceByName(name);
    }

    @PostMapping
    public Service addNewService(@RequestParam String name,
                                 @RequestParam double price){
        return serviceService.addNewService(name, price);
    }

    @DeleteMapping(value = "/{name}")
    public String deleteServiceByName(@PathVariable(name = "name") String name){
        return deleteServiceByName(name);
    }
}
