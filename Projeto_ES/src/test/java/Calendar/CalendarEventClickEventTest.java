package Calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarEventClickEventTest {

    ArrayList<String> nomes =  new ArrayList<>();

    CalendarEventClickEvent calendar;

    @BeforeEach
    void setUp() throws Exception {
        nomes.add("Gonçalo Lobato");
        calendar = new CalendarEventClickEvent(Object.class, new CalendarEvent(LocalDate.of(2022, 12, 12), LocalTime.of(12, 30), 
                LocalTime.of(14, 00), "Junit", nomes));
    }

    @Test
    void testGetCalendarEvent() {
        CalendarEvent evento = new CalendarEvent(LocalDate.of(2022, 12, 12), LocalTime.of(12, 30), 
                LocalTime.of(14, 00), "Junit", nomes);
        assertEquals(evento, calendar.getCalendarEvent());
    }

}