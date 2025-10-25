# calmWindsGroupProject
## Event Booking System

This project is a JavaFX-based Event Booking System designed to facilitate event management for organizers and provide a seamless booking experience for attendees. 

### Features

- **Organizer View**: 
  - Add and manage events
  - Set event capacity
  - Schedule events

- **Attendee View**: 
  - View available events
  - Book tickets for events
  - Handle group bookings

- **Shared Functionalities**: 
  - Display error dialogs and confirmation messages

- **PDF Confirmation Slips**: 
  - Generate and print confirmation slips for bookings

### Project Structure

- **src/main/java/com/calmwinds/eventbooking**: Contains the main application code.
  - **MainApp.java**: Entry point of the application.
  - **controllers**: Contains controllers for managing views.
    - **OrganizerController.java**: Manages organizer functionalities.
    - **AttendeeController.java**: Manages attendee functionalities.
    - **SharedController.java**: Shared functionalities for both views.
  - **models**: Contains data models.
    - **Event.java**: Represents an event.
    - **User.java**: Represents a user (organizer or attendee).
    - **Booking.java**: Represents a booking.
  - **services**: Contains service classes for business logic.
    - **EventService.java**: Manages event-related operations.
    - **BookingService.java**: Manages booking-related operations.
    - **PdfService.java**: Generates PDF confirmation slips.
  - **utils**: Contains utility classes.
    - **DbUtil.java**: Database connection utilities.

- **src/main/resources**: Contains resources for the application.
  - **fxml**: FXML files for UI layouts.
    - **organizer_view.fxml**: Layout for the organizer view.
    - **attendee_view.fxml**: Layout for the attendee view.
    - **confirmation_print.fxml**: Layout for confirmation slips.
  - **css**: Styles for the application.
    - **styles.css**: CSS styles.
  - **i18n**: Internationalization messages.
    - **messages.properties**: Localization messages.

- **src/test/java/com/calmwinds/eventbooking**: Contains unit tests.
  - **EventServiceTest.java**: Tests for EventService.
  - **BookingServiceTest.java**: Tests for BookingService.

- **db**: Contains database schema.
  - **schema.sql**: SQL schema for the database.

- **scripts**: Contains scripts for database initialization.
  - **init-db.sh**: Script to set up the database.

- **lib**: Directory for external libraries.

- **pom.xml**: Maven configuration file.

- **.gitignore**: Specifies files to ignore in Git.

### Setup Instructions

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn install` to build the project.
4. Use `mvn javafx:run` to start the application.

### License

This project is licensed under the MIT License.