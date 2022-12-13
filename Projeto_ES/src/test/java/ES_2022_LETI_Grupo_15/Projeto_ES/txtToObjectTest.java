package ES_2022_LETI_Grupo_15.Projeto_ES;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Calendar.CalendarEvent;

class txtToObjectTest {
	
	ArrayList<String> files1 =  new ArrayList<>(Arrays.asList("Lobato.txt"));
	ArrayList<String> files2 = new ArrayList<>(Arrays.asList("Gonçalo Lobato.txt"));
	ArrayList<String> nomes =  new ArrayList<>(Arrays.asList("Gonçalo Lobato"));

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testConvert() throws FileNotFoundException {
		assertEquals(files2, txtToObject.convert(files1, nomes));
	}

	@Test
	public void testGetList() throws FileNotFoundException, ParseException {
		ArrayList<CalendarEvent> eventos = txtToObject.getList(files2, nomes);
		assertEquals(eventos, txtToObject.getList(files2, nomes));
	}

	@Test
	public void testAvailableOrNot() throws FileNotFoundException, ParseException {
		String data1 = "2022-12-12 16:00";
		String data2 = "2022-12-12 17:30";
		assertEquals(true, txtToObject.availableOrNot(data1, data2, txtToObject.getList(files2, nomes), nomes));
	}

	@Test
	public void testAddEvent() throws FileNotFoundException, ParseException {
		String data = "2022-12-19";
		String hours = "16:00";
		String time = "01:30";

		ArrayList<CalendarEvent> eventos = txtToObject.addEvent(txtToObject.getList(files2, nomes), nomes, data, hours, time);
		assertEquals(eventos, txtToObject.addEvent(txtToObject.getList(files2, nomes), nomes, data, hours, time));
	}

	@Test
	public void testFindBestTime() throws FileNotFoundException, ParseException {
		String time = "01:30";
		ArrayList<CalendarEvent> eventos = txtToObject.findBestTime(txtToObject.getList(files2,nomes), time, "Tarde", nomes, LocalDate.now());
		assertEquals(eventos, txtToObject.findBestTime(txtToObject.getList(files2, nomes), time, "Tarde", nomes, LocalDate.now()));;
	}

	@Test
	void testGetNumberEventsOfDay() throws FileNotFoundException, ParseException {
		assertEquals(1, txtToObject.getNumberEventsOfDay(txtToObject.getList(files2, nomes), null, LocalDate.of(2022, 12, 5)));
	}

	@Test
	void testPeriodicity() throws FileNotFoundException, ParseException {
		ArrayList<CalendarEvent> eventos = txtToObject.getList(files2,nomes);
		eventos.add(new CalendarEvent(LocalDate.of(2022, 12, 8), LocalTime.of(8, 0), LocalTime.of(9, 0), "Reunião", nomes));
		eventos.sort(Comparator.comparing(CalendarEvent::getDate).thenComparing(CalendarEvent::getStart));
		assertEquals(eventos, txtToObject.periodicity(txtToObject.getList(files2, nomes), nomes, LocalDate.of(2022, 12, 5), 1, "01:00", "Manhã"));
	}
}