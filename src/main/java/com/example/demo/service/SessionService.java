package com.example.demo.service;

import com.example.demo.service.model.Session;

import java.util.UUID;

public interface SessionService {
    Session makeAppointment(UUID serviceId, UUID clientId,
                            UUID specialistId, String date);
}
