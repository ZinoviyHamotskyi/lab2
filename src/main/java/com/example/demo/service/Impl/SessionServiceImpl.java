package com.example.demo.service.Impl;

import com.example.demo.repo.SessionRepo;
import com.example.demo.service.SessionService;
import com.example.demo.service.model.Client;
import com.example.demo.service.model.Session;
import com.example.demo.service.model.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepo sessionRepo;

    @Autowired
    public SessionServiceImpl(SessionRepo sessionRepo){
        this.sessionRepo = sessionRepo;
    }


    @Override
    public Session makeAppointment(com.example.demo.service.model.Service service,
                                   Client client, Specialist specialist, String date) {
        Session session = new Session(service, client,
                specialist, date);
        sessionRepo.save(session);
        return session;
    }

    @Override
    public List<Session> getSessionsBySpecialist(Specialist specialist) {
        return sessionRepo.getSessionsBySpecialist(specialist);
    }

    @Override
    public String getOrdersInfo(Session session, com.example.demo.service.model.Service service, Client client, Specialist specialist) {
        return "\nSession ID: " + session.getId()
                + "\nService name: " + service.getName()
                + "\nClient name: " + client.getName()
                + "\nSpecialist name: " + specialist.getName()
                + "\nDate: " + session.getDate()
                + "\nPrice: " + service.getPrice();

    }

    @Override
    public List<Session> getSessionsByClient(Client client){
        System.out.println(sessionRepo.getSessionsByClient(client).stream().findFirst().toString());
        List<Session> sessions = sessionRepo.getSessionsByClient(client);
        return sessions;
    }
}
