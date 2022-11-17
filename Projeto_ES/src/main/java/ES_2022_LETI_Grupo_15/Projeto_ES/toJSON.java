package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class toJSON {

	@SuppressWarnings("unchecked")
	public static void convert(File file) throws IOException, ParseException{

		SimpleDateFormat format = new SimpleDateFormat(" yyyyMMdd HHmmss");

		Scanner scan = new Scanner (file);

		while (scan.hasNextLine()) {

			scan.next();

			String next = scan.nextLine();
			next = next.trim();
			Scanner line = new Scanner(next);
			line.next();

			String x = line.next();

			if(x.equals("Exame")){

				String summary = next;
				scan.next();
				String dtstart = scan.nextLine();
				dtstart = dtstart.trim();
				scan.next();
				String dtend = scan.nextLine();
				dtend = dtend.trim();
				
				System.out.println("Summary: " + summary);
				System.out.println("Início: " + dtstart);
				System.out.println("Fim: " + dtend);

			} else if (x.equals("Teste") || x.equals("Avaliação")) {

				String summary = next;
				scan.next();
				String dtstart = scan.nextLine();
				dtstart = dtstart.trim();
				scan.next();
				String dtend = scan.nextLine();
				dtend = dtend.trim();
				
				System.out.println("Summary: " + summary);
				System.out.println("Início: " + dtstart);
				System.out.println("Fim: " + dtend);

			} else {

				String summary = next;
				scan.next();
				String dtstart = scan.nextLine();
				dtstart = dtstart.trim();
				scan.next();
				String dtend = scan.nextLine();
				
				System.out.println("Summary: " + summary);
				System.out.println("Início: " + dtstart);
				System.out.println("Fim: " + dtend);
				
			}

			scan.nextLine();

		}
		scan.close();

	}
}