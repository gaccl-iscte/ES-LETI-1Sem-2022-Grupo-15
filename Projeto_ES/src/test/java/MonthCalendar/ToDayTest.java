package MonthCalendar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDayTest {

    ToDay day;

    @BeforeEach
    void setUp() throws Exception {

        day = new ToDay(13,12,2022);

    }

    @Test
    void testGetDay() {
        assertEquals(13, day.getDay());
    }

    @Test
    void testGetMonth() {
        assertEquals(12, day.getMonth());
    }

    @Test
    void testGetYear() {
        assertEquals(2022, day.getYear());
    }

    @Test
    void testIsToDay() {
        ToDay day2 = new ToDay(2022,12,14);
        assertEquals(false, day2.isToDay(day));
    }

}
