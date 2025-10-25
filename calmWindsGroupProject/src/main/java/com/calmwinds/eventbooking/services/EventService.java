package com.calmwinds.eventbooking.services;

import com.calmwinds.eventbooking.models.Event;
import java.util.ArrayList;
import java.util.List;

public class EventService {
    private List<Event> events;

    public EventService() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void updateEvent(Event event) {
        int index = events.indexOf(event);
        if (index != -1) {
            events.set(index, event);
        }
    }

    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public Event getEventById(int id) {
        return events.stream()
                .filter(event -> event.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }
}