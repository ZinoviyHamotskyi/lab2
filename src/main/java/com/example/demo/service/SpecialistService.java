package com.example.demo.service;


import com.example.demo.service.model.Specialist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface SpecialistService {
    Specialist addNewSpecialist(Specialist specialist);
    Specialist getSpecialistByName(String name);
    List<Specialist> getSpecialists();
    String deleteSpecialistById(UUID id);
    UUID getId(String name);
    Specialist getSpecialistById(UUID id);

}
