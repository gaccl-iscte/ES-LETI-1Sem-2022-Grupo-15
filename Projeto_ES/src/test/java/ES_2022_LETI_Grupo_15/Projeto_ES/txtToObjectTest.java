package ES_2022_LETI_Grupo_15.Projeto_ES;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import Calendar.CalendarEvent;

class txtToObjectTest {

	ArrayList<String> files =  new ArrayList<>();
	ArrayList<String> nomes =  new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		files.add("Lobato.txt");
		nomes.add("Gonçalo Lobato");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvert() throws FileNotFoundException {
		assertEquals(files, txtToObject.convert(files, nomes));
	}

	@Test
	public void testGetList() throws FileNotFoundException, ParseException {
		ArrayList<CalendarEvent> eventos = txtToObject.getList(files, nomes);
		assertEquals(eventos, txtToObject.getList(files, nomes));
	}

	@Test
	public void testAvailableOrNot() throws FileNotFoundException, ParseException {
		String data1 = "2022-12-12 16:00";
		String data2 = "2022-12-12 17:30";
		assertEquals(true, txtToObject.availableOrNot(data1, data2, txtToObject.getList(files, nomes), nomes));
	}

	@Test
	public void testAddEvent() throws FileNotFoundException, ParseException {
		String data = "2022-12-19";
		String hours = "16:00";
		String time = "01:30";

		ArrayList<CalendarEvent> eventos = txtToObject.addEvent(txtToObject.getList(files, nomes), nomes, data, hours, time);
		assertEquals(eventos, txtToObject.addEvent(txtToObject.getList(files, nomes), nomes, data, hours, time));
	}

	@Test
	public void testFindBestTime() throws FileNotFoundException, ParseException {
		String time = "01:30";
		ArrayList<CalendarEvent> resultGonçalo = txtToObject.findBestTime(txtToObject.getList(files,nomes), time, "Tarde", nomes, LocalDate.now());
		assertEquals(resultGonçalo, txtToObject.findBestTime(txtToObject.getList(files, nomes), time, "Tarde", nomes, LocalDate.now()));;
	}
}