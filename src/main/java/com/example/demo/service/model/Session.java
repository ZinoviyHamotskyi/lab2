package com.example.demo.service.model;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "sessions")
@EnableAutoConfiguration
public final class Session {
    @Id
    private UUID id;
    private UUID service_id;
    private UUID client_id;
    private UUID specialist_id;
    private Date date;
    private boolean finished;


    public Session(UUID service_id, UUID client_id,
                   UUID specialist_id, String date) {

        this.id = UUID.randomUUID();
        this.service_id = service_id;
        this.client_id = client_id;
        this.specialist_id = specialist_id;
        this.finished = false;
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Session() {

    }
}
