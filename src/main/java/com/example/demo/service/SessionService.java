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
    Session makeAppointment(com.example.demo.service.model.Service serviceI,
                            Client client, Specialist specialist, String date);

    List<Session> getSessionsByClient(Client client);
    List<Session> getSessionsBySpecialist(Specialist specialist);
    String getOrdersInfo(Session session,
                         com.example.demo.service.model.Service service,
                         Client client,
                         Specialist specialist);

}
