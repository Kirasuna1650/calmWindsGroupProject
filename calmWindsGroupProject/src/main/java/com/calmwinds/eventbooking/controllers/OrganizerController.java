package com.calmwinds.eventbooking.controllers;

import com.calmwinds.eventbooking.models.Event;
import com.calmwinds.eventbooking.services.EventService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OrganizerController {

    @FXML
    private TextField eventTitleField;

    @FXML
    private TextField eventDescriptionField;

    @FXML
    private TextField eventCapacityField;

    @FXML
    private Button addEventButton;

    @FXML
    private Label statusLabel;

    private EventService eventService;

    public OrganizerController() {
        this.eventService = new EventService();
    }

    @FXML
    public void initialize() {
        addEventButton.setOnAction(event -> addEvent());
    }

    private void addEvent() {
        String title = eventTitleField.getText();
        String description = eventDescriptionField.getText();
        int capacity;

        try {
            capacity = Integer.parseInt(eventCapacityField.getText());
        } catch (NumberFormatException e) {
            statusLabel.setText("Invalid capacity. Please enter a number.");
            return;
        }

        Event event = new Event(title, description, capacity);
        boolean success = eventService.addEvent(event);

        if (success) {
            statusLabel.setText("Event added successfully!");
            clearFields();
        } else {
            statusLabel.setText("Failed to add event. Please try again.");
        }
    }

    private void clearFields() {
        eventTitleField.clear();
        eventDescriptionField.clear();
        eventCapacityField.clear();
    }
}