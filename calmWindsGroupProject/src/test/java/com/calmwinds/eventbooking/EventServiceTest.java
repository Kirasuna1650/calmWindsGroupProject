import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.calmwinds.eventbooking.models.Event;
import com.calmwinds.eventbooking.services.EventService;

import java.util.List;

class EventServiceTest {
    private EventService eventService;

    @BeforeEach
    void setUp() {
        eventService = new EventService();
    }

    @Test
    void testAddEvent() {
        Event event = new Event("Concert", "Live music concert", 100, "2023-12-01T20:00:00");
        eventService.addEvent(event);
        List<Event> events = eventService.getAllEvents();
        assertTrue(events.contains(event));
    }

    @Test
    void testUpdateEvent() {
        Event event = new Event("Concert", "Live music concert", 100, "2023-12-01T20:00:00");
        eventService.addEvent(event);
        event.setDescription("Updated description");
        eventService.updateEvent(event);
        Event updatedEvent = eventService.getEventById(event.getId());
        assertEquals("Updated description", updatedEvent.getDescription());
    }

    @Test
    void testGetAllEvents() {
        Event event1 = new Event("Concert", "Live music concert", 100, "2023-12-01T20:00:00");
        Event event2 = new Event("Workshop", "Coding workshop", 50, "2023-12-05T10:00:00");
        eventService.addEvent(event1);
        eventService.addEvent(event2);
        List<Event> events = eventService.getAllEvents();
        assertEquals(2, events.size());
    }

    @Test
    void testEventCapacity() {
        Event event = new Event("Concert", "Live music concert", 100, "2023-12-01T20:00:00");
        eventService.addEvent(event);
        assertEquals(100, event.getCapacity());
    }
}