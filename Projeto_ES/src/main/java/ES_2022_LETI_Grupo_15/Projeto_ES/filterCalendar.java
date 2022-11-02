package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class filterCalendar {

	public static void filter(String fileName) throws IOException, ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm");

		String date = sdf.format(Calendar.getInstance().getTime());

		Date date1 = sdf.parse(date);

		PrintStream out = new PrintStream(new File("filtrado.txt"));
		System.setOut(out);

		File file = new File(fileName);

		Scanner scanner = new Scanner(file);

		while(scanner.hasNext()) {

			if(scanner.next().equals("Begin:")) {

				String start = scanner.nextLine();

				Date date2 = sdf.parse(start);

				if(date2.after(date1)) {

					String end = scanner.nextLine();

					System.out.println("Begin:" + start);
					System.out.println(end + "\n");
				}
			}
		}

		scanner.close();
	}

	public static void main(String args[]) throws IOException, ParseException {
		filter("resultado.txt");
	}
}