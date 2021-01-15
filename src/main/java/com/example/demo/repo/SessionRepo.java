package com.example.demo.repo;

import com.example.demo.service.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SessionRepo extends JpaRepository<Session, UUID> {


    List<Session> getSessionsByClient(UUID id);
    List<Session> getSessionsBySpecialist(UUID id);
}
