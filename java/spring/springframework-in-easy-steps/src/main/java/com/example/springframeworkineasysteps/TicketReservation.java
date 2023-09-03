package com.example.springframeworkineasysteps;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class TicketReservation {

    @PostConstruct
    public void init() {
        System.out.println("Init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }
}
