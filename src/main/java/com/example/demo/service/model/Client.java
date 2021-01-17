package com.example.demo.service.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "clients")
@EnableAutoConfiguration
public final class Client {
    
    @Id
    @GeneratedValue
    private  UUID id;

    private String name;
    private Date birthDate;


    public Client(String name, String birthDate) throws ParseException {
        id = UUID.randomUUID();
        this.name = name;
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Client() {}

}


