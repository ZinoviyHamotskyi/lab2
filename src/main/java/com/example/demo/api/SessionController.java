package com.example.demo.api;


import com.example.demo.service.ClientService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.SessionService;
import com.example.demo.service.SpecialistService;
import com.example.demo.service.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
                             SpecialistService specialistService) {
        this.sessionService = sessionService;
        this.serviceService = serviceService;
        this.clientService = clientService;
        this.specialistService = specialistService;
    }

    @PostMapping(value = "/clients/{name}/sessions")
    public ResponseEntity<Session> makeAppointment(@RequestParam String serviceName,
                                                   @PathVariable(name = "name") String clientName,
                                                   @RequestParam String specialistName,
                                                   @RequestParam String date) {
        UUID serviceId = serviceService.getId(serviceName);
        UUID clientID = clientService.getId(clientName);
        UUID specialistID = specialistService.getId(specialistName);
        return ResponseEntity.ok(sessionService.makeAppointment(serviceId, clientID,
                specialistID, date));
    }


    @GetMapping(value = "/clients/{name}/sessions")
    public ResponseEntity<List<Session>> getSessionsbyClient(@PathVariable(name = "name") String clientName) {
        UUID clientId = clientService.getId(clientName);
        return ResponseEntity.ok(sessionService.getSessionsByClient(clientId));
    }

    @GetMapping(value = "/specialists/{name}/sessions")
    public ResponseEntity<List<Session>> getSessionsbySpecialist(@PathVariable(name = "name") String specialistName) {
        UUID specialistId =  specialistService.getId(specialistName);
        return ResponseEntity.ok(sessionService.getSessionsBySpecialist(specialistId));
    }
}