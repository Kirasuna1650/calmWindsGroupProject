package com.calmwinds.eventbooking.services;

import com.calmwinds.eventbooking.models.Booking;
import com.calmwinds.eventbooking.models.Event;
import com.calmwinds.eventbooking.models.User;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private List<Booking> bookings;

    public BookingService() {
        this.bookings = new ArrayList<>();
    }

    public Booking createBooking(Event event, User user, int numberOfTickets) {
        if (event.getCapacity() >= numberOfTickets) {
            Booking booking = new Booking(event, user, numberOfTickets);
            bookings.add(booking);
            event.setCapacity(event.getCapacity() - numberOfTickets);
            return booking;
        } else {
            throw new IllegalArgumentException("Not enough capacity for the requested number of tickets.");
        }
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public void generateConfirmationSlip(Booking booking) {
        // Logic to generate PDF confirmation slip
    }
}