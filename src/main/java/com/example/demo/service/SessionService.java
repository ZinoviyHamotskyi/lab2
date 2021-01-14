package com.example.demo.service;

import com.example.demo.service.model.Session;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SessionService {
    Session makeAppointment(UUID serviceId, UUID clientId,
                            UUID specialistId, String date);

    List<Session> getSessionsByClient(UUID id);
    List<Session> getSessionsBySpecialist(UUID id);

}
