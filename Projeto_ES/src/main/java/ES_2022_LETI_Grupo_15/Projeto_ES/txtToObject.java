package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

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

}
