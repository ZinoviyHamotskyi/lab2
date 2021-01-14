package com.example.demo.repo;

import com.example.demo.service.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SessionRepo extends JpaRepository<Session, UUID> {
}
