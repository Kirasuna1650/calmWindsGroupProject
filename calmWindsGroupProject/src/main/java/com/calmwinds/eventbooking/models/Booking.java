package com.calmwinds.eventbooking.models;

public class Booking {
    private Event event;
    private User user;
    private int numberOfTickets;
    private String bookingDetails;

    public Booking(Event event, User user, int numberOfTickets, String bookingDetails) {
        this.event = event;
        this.user = user;
        this.numberOfTickets = numberOfTickets;
        this.bookingDetails = bookingDetails;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(String bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
}