package Dto;

import java.time.LocalDate;

public class EventLog {

    private String event;
    private LocalDate date =  LocalDate.now();

    public EventLog(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getDate() {
        return date;
    }
}
