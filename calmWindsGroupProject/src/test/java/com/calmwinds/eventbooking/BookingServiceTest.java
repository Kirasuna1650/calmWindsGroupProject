import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.calmwinds.eventbooking.models.Booking;
import com.calmwinds.eventbooking.models.Event;
import com.calmwinds.eventbooking.models.User;
import com.calmwinds.eventbooking.services.BookingService;

public class BookingServiceTest {

    private BookingService bookingService;
    private Event event;
    private User user;

    @BeforeEach
    public void setUp() {
        bookingService = new BookingService();
        event = new Event("Concert", "Live music concert", 100, "2023-12-01T20:00:00");
        user = new User("John Doe", "john.doe@example.com", "attendee");
    }

    @Test
    public void testCreateBooking() {
        Booking booking = bookingService.createBooking(event, user, 2);
        assertNotNull(booking);
        assertEquals(event, booking.getEvent());
        assertEquals(user, booking.getUser());
        assertEquals(2, booking.getNumberOfTickets());
    }

    @Test
    public void testBookingCapacity() {
        bookingService.createBooking(event, user, 2);
        assertEquals(98, event.getAvailableCapacity());
    }

    @Test
    public void testGenerateConfirmationSlip() {
        Booking booking = bookingService.createBooking(event, user, 1);
        String confirmationSlip = bookingService.generateConfirmationSlip(booking);
        assertNotNull(confirmationSlip);
        assertTrue(confirmationSlip.contains("Booking Confirmation"));
        assertTrue(confirmationSlip.contains("Event: Concert"));
    }

    @Test
    public void testBookingExceedsCapacity() {
        bookingService.createBooking(event, user, 100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookingService.createBooking(event, user, 1);
        });
        assertEquals("Not enough capacity available", exception.getMessage());
    }
}