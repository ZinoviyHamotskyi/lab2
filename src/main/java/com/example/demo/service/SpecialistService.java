package com.example.demo.service;


import com.example.demo.repo.SpecialistRepo;
import com.example.demo.service.model.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public final class SpecialistService {
    private final SpecialistRepo specialistRepo;

    @Autowired
    public SpecialistService(SpecialistRepo specialistRepo){
        this.specialistRepo = specialistRepo;
    }


    public Specialist addNewSpecialist(String name) {
        Specialist specialist = new Specialist(name);
        specialistRepo.save(specialist);
        return specialist;
    }

    public Specialist getSpecialistByName(String name){
        Specialist specialist = specialistRepo.getSpecialistByName(name);
        if (specialist == null){
            System.out.println("Specialist is not found");

        }
        return specialist;
    }




    public String deleteSpecialistByName(String name){
        Specialist specialist = specialistRepo.getSpecialistByName(name);
        if (specialist == null){
            return "Specialist is not found";
        }
        else
            specialistRepo.deleteByName(name);
            return "Client`s deleted";
    }
}
