package WeekCalendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeekTest {

    Week week;


    @BeforeEach
    void setUp() throws Exception {
    week = new Week(LocalDate.of(2022, 12, 11));
    }

    @Test
    void testGetStartOfWeek() {
        LocalDate data = LocalDate.of(2022, 12, 5);
        assertEquals(data, Week.getStartOfWeek(LocalDate.of(2022, 12, 8)));
    }

    @Test
    void testGetDay() {
        LocalDate data = LocalDate.of(2022, 12, 5);
        assertEquals(data, week.getDay(DayOfWeek.MONDAY));
    }

    @Test
    void testNextWeek() {
        Week week1 = new Week(LocalDate.of(2022, 12, 12));
        assertEquals(week1, week.nextWeek());
    }

    @Test
    void testPrevWeek() {
        Week week1 = new Week(LocalDate.of(2022, 11, 4));
        assertEquals(week1, week.prevWeek());
    }

}