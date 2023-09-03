package com.example.springtest;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
    public HelloWorld() {
        System.out.println("Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("test");
    }

    @Scheduled(cron = "0 * * * * *")
    public void schedule() {
        System.out.println("jetzt");
    }
}
