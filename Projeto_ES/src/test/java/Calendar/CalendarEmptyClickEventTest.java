package Calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarEmptyClickEventTest {

    CalendarEmptyClickEvent calendar;

    @BeforeEach
    void setUp() throws Exception {
        calendar = new CalendarEmptyClickEvent(Object.class, LocalDateTime.of(2022, 12, 12, 12, 30));
    }

    @Test
    void testGetDateTime() {
        assertEquals(LocalDateTime.of(2022, 12, 12, 12, 30), calendar.getDateTime());
    }

}