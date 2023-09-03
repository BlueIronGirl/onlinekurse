package com.example.springframeworkineasysteps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringframeworkInEasyStepsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringframeworkInEasyStepsApplication.class, args);

        new TicketReservation();
    }

}
