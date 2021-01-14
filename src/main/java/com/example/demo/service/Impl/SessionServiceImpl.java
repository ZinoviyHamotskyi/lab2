package com.example.demo.service.Impl;

import com.example.demo.repo.SessionRepo;
import com.example.demo.service.SessionService;
import com.example.demo.service.model.Session;
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

    public Session makeAppointment(UUID serviceId,
                                   UUID clientId,
                                   UUID specialistId,
                                   String date){
        Session session = new Session(serviceId, clientId,
                specialistId, date);
        sessionRepo.save(session);
        return session;
    }

    @Override
    public List<Session> getSessionsBySpecialist(UUID id) {
        return sessionRepo.getSessionsBySpecialist_id(id);
    }

    @Override
    public List<Session> getSessionsByClient(UUID id){
        return sessionRepo.getSessionsByClient_id(id);
    }
}
