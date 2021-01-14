package com.example.demo.api;


import com.example.demo.service.ClientService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.SessionService;
import com.example.demo.service.SpecialistService;
import com.example.demo.service.model.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    private final SessionService sessionService;
    private final ServiceService serviceService;
    private final ClientService clientService;
    private final SpecialistService specialistService;

    @Autowired
    public SessionController(SessionService sessionService,
                             ServiceService serviceService,
                             ClientService clientService,
                             SpecialistService specialistService){
        this.sessionService = sessionService;
        this.serviceService = serviceService;
        this.clientService = clientService;
        this.specialistService = specialistService;
    }


}
