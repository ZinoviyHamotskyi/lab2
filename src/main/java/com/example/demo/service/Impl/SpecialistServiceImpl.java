package com.example.demo.service.Impl;


import com.example.demo.repo.SpecialistRepo;
import com.example.demo.service.SpecialistService;
import com.example.demo.service.model.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Service
public final class SpecialistServiceImpl implements SpecialistService {
    private final SpecialistRepo specialistRepo;

    @Autowired
    public SpecialistServiceImpl(SpecialistRepo specialistRepo){
        this.specialistRepo = specialistRepo;
    }

    @Override
    public Specialist addNewSpecialist(Specialist specialist) {
        specialistRepo.save(specialist);
        return specialist;
    }

    @Override
    public Specialist getSpecialistByName(String name){
        Specialist specialist = specialistRepo.getSpecialistByName(name);
        if (specialist == null){
            System.out.println("Specialist is not found");

        }
        return specialist;
    }

    @Override
    public List<Specialist> getSpecialists(){
        List<Specialist> specialists = specialistRepo.findAll();
        if (specialists == null){
            System.out.println("Specialist list is empty");
        }
        return specialists;
    }


    @Override
    public String deleteSpecialistById(UUID id){
        Specialist specialist = specialistRepo.getSpecialistById(id);
        if (specialist == null){
            return "Specialist is not found";
        }
        else
            specialistRepo.delete(specialist);
            return "Specialist`s deleted";
    }

    @Override
    public UUID getId(String name){
        Specialist specialist = specialistRepo.getSpecialistByName(name);
        if (specialist == null){
            System.out.println("Specialist is not found");

        }
        return specialist.getId();
    }

    @Override
    public Specialist getSpecialistById(UUID id) {
        Specialist specialist = specialistRepo.getSpecialistById(id);
        if (specialist == null){
            System.out.println("Specialist is not found");

        }
        return specialist;
    }
}
