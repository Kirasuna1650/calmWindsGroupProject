package com.calmwinds.eventbooking.controllers;

import com.calmwinds.eventbooking.models.Event;
import com.calmwinds.eventbooking.services.BookingService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;

public class AttendeeController {

    @FXML
    private ListView<Event> eventListView;

    @FXML
    private TextField numberOfTicketsField;

    @FXML
    private Button bookButton;

    private BookingService bookingService;

    public AttendeeController() {
        this.bookingService = new BookingService();
    }

    @FXML
    public void initialize() {
        loadEvents();
        bookButton.setOnAction(event -> bookTickets());
    }

    private void loadEvents() {
        List<Event> events = bookingService.getAvailableEvents();
        eventListView.getItems().addAll(events);
    }

    private void bookTickets() {
        Event selectedEvent = eventListView.getSelectionModel().getSelectedItem();
        String ticketsInput = numberOfTicketsField.getText();

        if (selectedEvent == null) {
            showAlert("Please select an event to book.");
            return;
        }

        int numberOfTickets;
        try {
            numberOfTickets = Integer.parseInt(ticketsInput);
            if (numberOfTickets <= 0) {
                showAlert("Number of tickets must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Invalid number of tickets.");
            return;
        }

        boolean success = bookingService.bookTickets(selectedEvent, numberOfTickets);
        if (success) {
            showAlert("Booking successful!");
        } else {
            showAlert("Booking failed. Please check the event capacity.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}