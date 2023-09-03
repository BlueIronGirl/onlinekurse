package springcore;

import jakarta.annotation.PostConstruct;

public class TicketReservation {
    @PostConstruct
    public void initialize() {
        System.out.println("Init");
    }

    public void cleanUp() {
        System.out.println("CleanUp");
    }
}
