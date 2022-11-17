package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class toJSON {

	@SuppressWarnings("unchecked")
	public static void convert(File file) throws IOException, ParseException{

		SimpleDateFormat format = new SimpleDateFormat(" yyyyMMdd HHmmss");

		Scanner scan = new Scanner (file);
		JSONArray eventList = new JSONArray();
		JSONArray testList = new JSONArray();
		JSONArray examList = new JSONArray();

		FileWriter fileJSON = new FileWriter("event.json");

		while (scan.hasNextLine()) {

			scan.next();

			String next = scan.nextLine();
			next = next.trim();
			Scanner line = new Scanner(next);
			line.next();

			String x = line.next();

			if(x.equals("Exame")){

				JSONObject examDetails = new JSONObject();
				String summary = next;
				scan.next();
				String dtstart = scan.nextLine();
				dtstart = dtstart.trim();
				scan.next();
				String dtend = scan.nextLine();
				dtend = dtend.trim();
				examDetails.put("Sumário", summary);
				examDetails.put("Início", dtstart);
				examDetails.put("Fim", dtend);
				JSONObject examObject = new JSONObject(); 
				examObject.put("Exame", examDetails);
				examList.add(examObject);

			} else if (x.equals("Teste") || x.equals("Avaliação")) {

				JSONObject testDetails = new JSONObject();
				String summary = next;
				scan.next();
				String dtstart = scan.nextLine();
				dtstart = dtstart.trim();
				scan.next();
				String dtend = scan.nextLine();
				dtend = dtend.trim();
				testDetails.put("Sumário", summary);
				testDetails.put("Início", dtstart);
				testDetails.put("Fim", dtend);
				JSONObject testObject = new JSONObject(); 
				testObject.put("Teste", testDetails);
				testList.add(testObject);

			} else {

				JSONObject eventDetails = new JSONObject();
				String summary = next;
				scan.next();
				String dtstart = scan.nextLine();
				dtstart = dtstart.trim();
				scan.next();
				String dtend = scan.nextLine();
				dtend = dtend.trim();
				eventDetails.put("Sumário", summary);
				eventDetails.put("Início", dtstart);
				eventDetails.put("Fim", dtend);
				JSONObject eventObject = new JSONObject(); 
				eventObject.put("Evento", eventDetails);
				eventList.add(eventObject);

			}

			scan.nextLine();

		}
		scan.close();

		fileJSON.write(examList.toJSONString());
		fileJSON.write(eventList.toJSONString());
		fileJSON.write(testList.toJSONString());
		fileJSON.flush();
	}

	public static void main(String[] args) throws IOException, ParseException {
		File file = new File ("filtrado2.txt");
		convert(file);
	}
}