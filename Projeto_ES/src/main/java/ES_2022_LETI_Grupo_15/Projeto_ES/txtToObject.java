package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import Calendar.CalendarEvent;

public class txtToObject {


	public static ArrayList<String> convert(ArrayList<String> files, ArrayList<String> nomes) throws FileNotFoundException {

		//		for(int i = 0 ; i < nomes.size() ; i++) {
		//			nomes.set(i, nomes.get(i).replace(" ", ""));
		//		}

		ArrayList<String> files2 = new ArrayList<>();

		for(int i = 0 ; i < files.size(); i++) {

			PrintStream out = new PrintStream(nomes.get(i)+".txt");
			System.setOut(out);

			// criar os nomes do ficheiros
			files2.add(nomes.get(i)+".txt");

			File file2 = new File(files.get(i));

			Scanner scanner = new Scanner(file2);

			while(scanner.hasNextLine()) {

				if(scanner.nextLine().equals("BEGIN:VEVENT")) {

					scanner.nextLine();

					String start = scanner.nextLine();
					start = start.replace(":", " ");

					Scanner scanner2 = new Scanner(start);
					scanner2.next();
					start = scanner2.next();
					start = start.replace("T", " ");
					start = start.replace("Z", "");

					String end = scanner.nextLine();
					end = end.replace(":", " ");

					Scanner scanner3 = new Scanner(end);
					scanner3.next();
					end = scanner3.next();
					end = end.replace("T", " ");
					end = end.replace("Z", "");

					String cadeira = scanner.nextLine();	
					cadeira = cadeira.replace(":", " ");
					String[] cadeira2 = cadeira.split("-");

					System.out.println(cadeira2[0]);
					System.out.println("DTSTART" + " " + start);
					System.out.println("DTEND" + " " + end + "\n");

					scanner2.close();
					scanner3.close();
				}
			}

			scanner.close();
		}

		return files2;
	}
	public static ArrayList<CalendarEvent> getList(ArrayList<String> files2, ArrayList<String> nomes) throws FileNotFoundException, ParseException {

		ArrayList<CalendarEvent> eventos = new ArrayList<>();

		//		String nome = primeiro + " " + ultimo;

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HHmmss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  


		//loop para obter o nome do ficheiro
		for(int i = 0 ; i < files2.size(); i++) {

			File file = new File(files2.get(i));

			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {

				scanner.next();

				String next = scanner.nextLine();
				next = next + " x";

				next = StringUtils.chop(next);
				next = next.trim().replaceAll(" +", " ");			
				String summary = next;

				// para abreviar os nomes das cadeiras que possuam demasiadas letras
				String[] palavras = summary.split(" ");
				summary = "";

				if(palavras[0].equals("Exame")) {
					summary = summary + palavras[0]+" ";

					for(int k = 1 ; k < palavras.length ; k++) {
						char x = palavras[k].charAt(0);

						if(Character.isUpperCase(x))
							summary = summary + x;

					}} else if(palavras[0].equals("Avaliação")) {
						summary = summary + palavras[0]+ " " + "Contínua ";

						for(int k = 2 ; k < palavras.length ; k++) {
							char x = palavras[k].charAt(0);

							if(Character.isUpperCase(x))
								summary = summary + x;


						}} else if(palavras[0].equals("Teste")) {
							summary = summary + palavras[0]+" ";

							for(int k = 1 ; k < palavras.length ; k++) {
								char x = palavras[k].charAt(0);

								if(Character.isUpperCase(x))
									summary = summary + x;

							}} else {

								for(int k = 0 ; k < palavras.length ; k++) {
									char x = palavras[k].charAt(0);

									if(Character.isUpperCase(x))
										summary = summary + x;
								}
							}

				scanner.next();

				String dtstart = scanner.nextLine();
				dtstart = dtstart.trim();
				Date date1 = format.parse(dtstart);
				dtstart = dateFormat.format(date1);

				String[] dtstart2 = dtstart.split(" ");
				LocalDate date = LocalDate.parse(dtstart2[0]);
				LocalTime start = LocalTime.parse(dtstart2[1]);

				scanner.next();

				String dtend = scanner.nextLine();
				dtend = dtend.trim();
				Date date2 = format.parse(dtend);
				dtend = dateFormat.format(date2);

				String[] dtend2 = dtend.split(" ");
				LocalTime end = LocalTime.parse(dtend2[1]);

				ArrayList<String> nomesDoObj = new ArrayList<String>();

				nomesDoObj.add(nomes.get(i));

				CalendarEvent evento = new CalendarEvent(date, start, end, summary, nomesDoObj);

				for(CalendarEvent event : new ArrayList<CalendarEvent>(eventos)) {

					if(evento.getText().equals(event.getText()) && evento.getDate().equals(event.getDate()) && evento.getStart().equals(event.getStart()) && evento.getEnd().equals(event.getEnd())) {

						if(!event.getNomes().equals(evento.getNomes())) {

							event.getNomes().addAll(evento.getNomes());
							evento.setNomes(event.getNomes());

							eventos.remove(event);

						}
					}
				}

				eventos.add(evento);

				scanner.nextLine();

			}

			scanner.close();
		}

		Comparator<CalendarEvent> comparatorAsc = (prod1, prod2) -> prod1.getDate()
				.compareTo(prod2.getDate());

		Collections.sort(eventos, comparatorAsc);

		PrintStream out = new PrintStream("teste1.txt");
		System.setOut(out);

		eventos.forEach(x -> System.out.println(x.toString()));

		return eventos;

	}

}
