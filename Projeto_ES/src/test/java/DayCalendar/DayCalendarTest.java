package DayCalendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Calendar.CalendarEvent;

class DayCalendarTest {

    LocalDate data;
    DayCalendar day;
    ArrayList<String> nomes = new ArrayList<>();
    ArrayList<CalendarEvent> eventos = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception {

        data = LocalDate.of(2022, 12, 12);
        nomes.add("Gonçalo Lobato");
        eventos.add(new CalendarEvent(LocalDate.of(2022, 12, 12), LocalTime.of(12, 30), 
                LocalTime.of(14, 00), "Junit", nomes));
        day = new DayCalendar(eventos, data);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testDateInRange() {
        assertEquals(true, day.dateInRange(data));
    }

    @Test
    void testGetDateFromDay() {
        assertEquals(data, day.getDateFromDay(data.getDayOfWeek()));
    }

    @Test
    void testNumDaysToShow() {
        assertEquals(1, day.numDaysToShow());
    }

    @Test
    void testGetStartDay() {
        assertEquals(data.getDayOfWeek(), day.getStartDay());
    }

    @Test
    void testGetEndDay() {
        assertEquals(data.getDayOfWeek(), day.getEndDay());
    }

}
