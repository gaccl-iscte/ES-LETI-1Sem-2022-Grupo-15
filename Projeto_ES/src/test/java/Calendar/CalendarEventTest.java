package Calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalendarEventTest {

    ArrayList<String> nomes =  new ArrayList<>();

    CalendarEvent evento;

    @BeforeEach
    void setUp() throws Exception {
    nomes.add("Gonçalo Lobato");
    evento = new CalendarEvent(LocalDate.of(2022, 12, 12), LocalTime.of(12, 30), 
            LocalTime.of(14, 00), "Junit", nomes);
    }

    @Test
    void testGetDate() {
        assertEquals(LocalDate.of(2022, 12, 12), evento.getDate());
    }

    @Test
    void testGetStart() {
        assertEquals(LocalTime.of(12,30), evento.getStart());
    }

    @Test
    void testGetEnd() {
        assertEquals(LocalTime.of(14,00), evento.getEnd());
    }

    @Test
    void testGetText() {
        assertEquals("Junit", evento.getText());
    }

    @Test
    void testGetNomes() {
        ArrayList<String> nomes1 =  new ArrayList<>(Arrays.asList("Gonçalo Lobato"));
        assertEquals(nomes1, evento.getNomes());
    }

}