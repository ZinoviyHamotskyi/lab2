package com.example.demo.api;


import com.example.demo.service.SpecialistService;
import com.example.demo.service.model.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class SpecialistController {
    private final SpecialistService specialistService;

    @Autowired
    public SpecialistController(SpecialistService specialistService){
        this.specialistService = specialistService;
    }

    @GetMapping(value = "/specialists")
    public ResponseEntity<List<Specialist>> getSpecialists(){
        return ResponseEntity.ok(specialistService.getSpecialists());
    }

    @PostMapping(value = "/specialists")
    public ResponseEntity<Specialist> addNewSpecialist(@Validated @RequestBody Specialist specialist) {
        return ResponseEntity.ok(specialistService.addNewSpecialist(specialist));
    }

    @GetMapping(value = "/specialists/{id}")
    public  ResponseEntity<Specialist> getSpecialistByName(@PathVariable(name = "id") UUID id){
        return ResponseEntity.ok(specialistService.getSpecialistById(id));
    }

    @DeleteMapping(value = "/specialists/{id}")
    public void deleteSpecialistByName(@PathVariable(name = "id") UUID id) {
        System.out.println(specialistService.deleteSpecialistById(id));
    }
}
