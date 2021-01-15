package com.example.demo.service;

import com.example.demo.service.model.Client;
import com.example.demo.service.model.Session;
import com.example.demo.service.model.Specialist;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.List;
import java.util.UUID;

@Service
public interface SessionService {
    Session makeAppointment(UUID serviceId, UUID clientId,
                            UUID specialistId, String date);

    List<Session> getSessionsByClient(UUID id);
    List<Session> getSessionsBySpecialist(UUID id);
    String getOrdersInfo(Session session,
                         com.example.demo.service.model.Service service,
                         Client client,
                         Specialist specialist);

}
