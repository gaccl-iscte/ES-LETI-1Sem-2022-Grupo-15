package WeekCalendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Calendar.CalendarEvent;

class WeekCalendarTest {

    ArrayList<String> nomes = new ArrayList<>();
    ArrayList<CalendarEvent> eventos = new ArrayList<>();
    WeekCalendar wk;

    @BeforeEach
    void setUp() throws Exception {

        nomes.add("Gonçalo Lobato");
        eventos.add(new CalendarEvent(LocalDate.of(2022, 12, 12), LocalTime.of(12, 30), 
            LocalTime.of(14, 00), "Junit", nomes));
        wk = new WeekCalendar(eventos);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testDateInRange() {
        assertEquals(true, wk.dateInRange(eventos.get(0).getDate()));
    }

    @Test
    void testGetDateFromDay() {
        assertEquals(LocalDate.of(2022, 12, 12), wk.getDateFromDay(eventos.get(0).getDate().getDayOfWeek()));
    }

    @Test
    void testNumDaysToShow() {
        assertEquals(6 ,wk.numDaysToShow());
    }

    @Test
    void testGetStartDay() {
        assertEquals(DayOfWeek.MONDAY, wk.getStartDay());
    }

    @Test
    void testGetEndDay() {
        assertEquals(DayOfWeek.SATURDAY, wk.getEndDay());
    }
}
