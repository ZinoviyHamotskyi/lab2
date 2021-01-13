package com.example.demo.service.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "services")
@EnableAutoConfiguration
public final class Service {
    @Id
    private UUID id;
    private String name;
    private double price;

    public Service(String name, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public Service() {}
}