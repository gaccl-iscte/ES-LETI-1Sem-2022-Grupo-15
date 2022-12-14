package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import Calendar.CalendarEvent;

/**
 * The Class txtToObject.
 */
public class txtToObject {

	/** The reuniao final. */
	public static CalendarEvent reuniaoFinal = null;

	/**
	 * Filtra os ficheiros .txt obtidos pelo o url ou o ficheiro ics.
	 *
	 * @param files e a lista os nomes dos ficheiros que sao obtitos pelas as funções da classe toTxt
	 * @param nomes e a lista com o nomes do membros
	 * @return ArrayList com o nome dos ficheiros com a informacao filtrada
	 * @throws FileNotFoundException the file not found exception
	 */
	public static ArrayList<String> convert(ArrayList<String> files, ArrayList<String> nomes) throws FileNotFoundException {

		ArrayList<String> files2 = new ArrayList<>();

		for(int i = 0 ; i < files.size(); i++) {

			PrintStream out = new PrintStream(nomes.get(i)+".txt");
			System.setOut(out);

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
	
	/**
	 * Obtem a lista de eventos(aulas) a partir da informacao dos ficheiros filtrados da funcao convert()
	 *
	 * @param files2 e a lista os nomes do ficheiros
	 * @param nomes e a lista com o nomes do membros
	 * @return lista de eventos.
	 * @throws FileNotFoundException the file not found exception
	 * @throws ParseException the parse exception
	 */
	public static ArrayList<CalendarEvent> getList(ArrayList<String> files2, ArrayList<String> nomes) throws FileNotFoundException, ParseException {

		ArrayList<CalendarEvent> eventos = new ArrayList<>();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HHmmss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

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

		eventos.sort(Comparator.comparing(CalendarEvent::getDate).thenComparing(CalendarEvent::getStart));

		PrintStream out = new PrintStream("HorárioIndividual.txt");
		System.setOut(out);

		eventos.forEach(x -> System.out.println(x.toString()));

		return eventos;

	}

	/**
	 * Verifica se o intervalo de tempo esta disponivel ou nao
	 *
	 * @param dataI e a data do inicio da hora da reuniao
	 * @param dataF e a data do fim da hora da reuniao
	 * @param eventos e a lista de eventos
	 * @param nomes e a lista com o nomes do membros
	 * @return the boolean
	 * @throws FileNotFoundException the file not found exception
	 * @throws ParseException the parse exception
	 */
	public static Boolean availableOrNot(String dataI, String dataF, ArrayList<CalendarEvent> eventos, ArrayList<String> nomes) throws FileNotFoundException, ParseException {

		String[] dtstart = dataI.split(" ");
		LocalDate date = LocalDate.parse(dtstart[0]);
		LocalTime start = LocalTime.parse(dtstart[1]);

		String[] dtend = dataF.split(" ");
		LocalTime end = LocalTime.parse(dtend[1]);

		for(CalendarEvent event : eventos) {

			if(event.getDate().equals(date)) {

				if(event.getStart().isAfter(start) && event.getEnd().isBefore(end) && !Collections.disjoint(event.getNomes(), nomes) 

						|| event.getStart().isBefore(end) && event.getEnd().isAfter(end) && !Collections.disjoint(event.getNomes(), nomes) 

						|| event.getStart().isBefore(start) && event.getEnd().isAfter(start) && !Collections.disjoint(event.getNomes(), nomes)

						|| event.getStart().equals(start) && event.getEnd().equals(end) && !Collections.disjoint(event.getNomes(), nomes)

						|| event.getStart().equals(start) && event.getEnd().isBefore(end) && !Collections.disjoint(event.getNomes(), nomes) 

						|| event.getStart().equals(start) && event.getEnd().isAfter(end) && !Collections.disjoint(event.getNomes(), nomes)

						|| event.getStart().isBefore(start) && event.getEnd().equals(end) && !Collections.disjoint(event.getNomes(), nomes)

						|| event.getStart().isAfter(start) && event.getEnd().equals(end) && !Collections.disjoint(event.getNomes(), nomes)) {

					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Adiciona uma reuniao à lista de eventos
	 *
	 * @param eventos e a lista de eventos
	 * @param nomes e a lista com o nomes do membros
	 * @param data e a data do evento
	 * @param inicio e a hora do inicio da reuniao
	 * @param duracao e a duracao da reuniao
	 * @return lista a de eventos com a reuniao
	 * @throws ParseException the parse exception
	 * @throws FileNotFoundException the file not found exception
	 */
	public static ArrayList<CalendarEvent> addEvent(ArrayList<CalendarEvent> eventos, ArrayList<String> nomes, String data, String inicio, String duracao) throws ParseException, FileNotFoundException {

		PrintStream out = new PrintStream("Horário.txt");
		System.setOut(out);

		LocalDate date = LocalDate.parse(data);
		LocalTime start = LocalTime.parse(inicio);
		LocalTime duration = LocalTime.parse(duracao);

		int result = duration.get(ChronoField.MINUTE_OF_DAY);

		LocalTime end = start.plusMinutes(result);
		String dateToString = date.toString() + " " + start.toString();
		String endToString = date.toString() + " " + end.toString();

		if(availableOrNot(dateToString, endToString, eventos, nomes)) {

			CalendarEvent reuniao = new CalendarEvent(date, start, end, "reuniao", nomes);

			eventos.add(reuniao);
			reuniaoFinal = reuniao;
			
			eventos.sort(Comparator.comparing(CalendarEvent::getDate).thenComparing(CalendarEvent::getStart));

		}

		eventos.forEach(x -> System.out.println(x.toString()));
		

		return eventos;
	}

	/**
	 * Encontra a melhor hora para marcar a reuniao
	 *
	 * @param eventos e a lista de eventos
	 * @param duracao e a duracao da reuniao
	 * @param alturaDoDia e a altura do dia(manha ou tarde)
	 * @param nomes e a lista com o nomes do membros
	 * @param data e a data da reuniao
	 * @return lista de eventos com a reuniao 
	 * @throws FileNotFoundException the file not found exception
	 * @throws ParseException the parse exception
	 */
	public static ArrayList<CalendarEvent> findBestTime(ArrayList<CalendarEvent> eventos, String duracao, String alturaDoDia, ArrayList<String> nomes, LocalDate data) throws FileNotFoundException, ParseException {
		
		LocalDate hoje = data;

		if(DayOfWeek.from(hoje).getValue() == 6 || DayOfWeek.from(hoje).getValue() == 7) {

			hoje = hoje.plusDays(8 - DayOfWeek.from(hoje).getValue());
		}

		int day = DayOfWeek.from(hoje).getValue();
		CalendarEvent reuniao = null;

		int horaI = horaI(alturaDoDia);
		int horaF = horaF(alturaDoDia);
		LocalDate dateFinal = hoje;

		int x = 0;
		int z = getNumberEventsOfDay(eventos, nomes, hoje);

		for(int i = 1 ; i < 6-day ; i++) {

			x = x(eventos, nomes, hoje, x);
			hoje = hoje.plusDays(1);
			if(x < z) {

				z = x;				
				dateFinal = hoje;
			}
		}

		outerloop:
			for(int h = horaI ; h < horaF ; h++) 
				for(int m = 0; m < 60 ; m=m+15) {

					String dataI = dataI(dateFinal, h, m);
					LocalTime fim = fim(duracao, h, m);
					LocalTime inicio = LocalTime.of(h, m);
					String dataF = dateFinal.toString() + " " + fim.toString();

					if(availableOrNot(dataI, dataF, eventos, nomes)) {
						reuniao = new CalendarEvent(dateFinal, inicio, fim, "reuniao", nomes);
						break outerloop;
					}
				}

		PrintStream out = new PrintStream("Horário.txt");
		System.setOut(out);
		
		eventos.add(reuniao);
		reuniaoFinal = reuniao;
		eventos.sort(Comparator.comparing(CalendarEvent::getDate).thenComparing(CalendarEvent::getStart));
		eventos.forEach(y -> System.out.println(y.toString()));
		return eventos;
	}

	/**
	 * Obtem o numero de eventos do dia
	 *
	 * @param eventos e a lista de eventos
	 * @param nomes e a lista de nomes
	 * @param data e a data do dia
	 * @return o numero de eventos do dia
	 */
	private static int x(ArrayList<CalendarEvent> eventos, ArrayList<String> nomes, LocalDate data, int x) {
		
		data = data.plusDays(1);
		x = 0;
		x = getNumberEventsOfDay(eventos, nomes, data);
		return x;
	}

	/**
	 * Obtem a hora de inicio da altura do dia
	 *
	 * @param alturaDoDia e a altura do dia
	 * @return da hora de inicio da altura do dia
	 */
	private static int horaI(String alturaDoDia) {
		int horaI = 0;
		if (alturaDoDia.equals("Manhã")) {
			horaI = 8;
		} else {
			horaI = 14;
		}
		return horaI;
	}

	/**
	 * Obtem a hora de fim da altura do dia
	 *
	 * @param alturaDoDia e a altura do dia
	 * @return da hora de fim da altura do dia
	 */
	private static int horaF(String alturaDoDia) {
		int horaF = 0;
		if (alturaDoDia.equals("Manhã")) {
			horaF = 14;
		} else {
			horaF = 20;
		}
		return horaF;
	}

	/**
	 * Obtem a data do inicio em formato String
	 *
	 * @param dateFinal e a data
	 * @param h e as horas
	 * @param m e os minutos
	 * @return data em formato String
	 */
	private static String dataI(LocalDate dateFinal, int h, int m) {
		String dataI = dateFinal.toString();
		LocalTime inicio = LocalTime.of(h, m);
		String timeI = inicio.toString();
		dataI = dataI + " " + timeI;
		return dataI;
	}

	/**
	 * Obtem a hora do fim da reuniao
	 *
	 * @param duracao e a duracao da reuniao
	 * @param h e as horas
	 * @param m e os minutos
	 * @return hora do fim da reuniao
	 */
	private static LocalTime fim(String duracao, int h, int m) {
		LocalTime inicio = LocalTime.of(h, m);
		LocalTime fim = null;
		LocalTime duration = LocalTime.parse(duracao);
		int result = duration.get(ChronoField.MINUTE_OF_DAY);
		fim = inicio.plusMinutes(result);
		return fim;
	}

	/**
	 * Obtem o numero de eventos do dia
	 *
	 * @param eventos e a lista de eventos
	 * @param nomes e a lista de nomes
	 * @param data e a data do dia
	 * @return o numero de eventos do dia
	 */
	public static int getNumberEventsOfDay(ArrayList<CalendarEvent> eventos, ArrayList<String> nomes, LocalDate data) {

		int x = 0;

		for(CalendarEvent e : eventos) {

			if(nomes == null) {

				if(e.getDate().equals(data)) {
					x++;
				}
			} else {
				if(e.getDate().equals(data) && !Collections.disjoint(e.getNomes(), nomes)) {
					x++;
				}
			}
		}

		return x;
	}

	/**
	 * Adicione reunioes periodicamente
	 *
	 * @param eventos e a lista de eventos
	 * @param nomes e a lista de nomes dos membros
	 * @param data the data
	 * @param semanas e o numero de semanas
	 * @param duracao e a duracao da reuniao
	 * @param alturaDoDia e a altura do dia(manha/tarde)
	 * @return lista de eventos com as reunioes
	 * @throws FileNotFoundException the file not found exception
	 * @throws ParseException the parse exception
	 */
	public static ArrayList<CalendarEvent> periodicity(ArrayList<CalendarEvent> eventos, ArrayList<String> nomes, LocalDate data, int semanas, String duracao, String alturaDoDia) throws FileNotFoundException, ParseException {

		try {
			eventos = findBestTime(eventos, duracao, alturaDoDia, nomes, data);
		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < semanas - 1; i++) {

			int addDays = 8 - DayOfWeek.from(data).getValue();

			LocalDate dataWithWeeks = data.plusDays(addDays + 7*i);

			eventos = findBestTime(eventos, duracao, alturaDoDia, nomes, dataWithWeeks);

		}

		PrintStream out = new PrintStream("Horário.txt");
		System.setOut(out);

		eventos.sort(Comparator.comparing(CalendarEvent::getDate).thenComparing(CalendarEvent::getStart));
		eventos.forEach(x -> System.out.println(x.toString()));

		return eventos;
	}
}
