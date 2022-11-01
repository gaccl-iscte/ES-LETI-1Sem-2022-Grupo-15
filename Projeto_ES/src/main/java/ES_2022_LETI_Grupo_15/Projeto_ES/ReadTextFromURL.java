package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.io.FileWriter;

public class ReadTextFromURL {

	public static void readURL(String url) {

		try {

			URL url1 = new URL(url);
			
			try {
				File myObj = new File("file.txt");
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}


			BufferedReader in = new BufferedReader(new InputStreamReader(url1.openStream()));

			String line;
			FileWriter myWriter = new FileWriter("file.txt");
			while ((line = in.readLine()) != null) {
				try {
					myWriter.write(line);
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}
			in.close();
			myWriter.close();
		}
		catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		}
	}
	public static void main(String args[]){
		readURL("https://fenix.iscte-iul.pt/publico/publicPersonICalendar.do?method=iCalendar&username=tmmfo1@iscte.pt&password=oN93nFF9kYTy0A5nUzsLh3wWkwPPkxJeZlYWXHbqGQNgQq2r57pTpOPlpPzcx1gjfgjFReV1Wp3OjNe1SdVSg8NuGDUy06UQ17URCUFVbRAeucNLayOdmeTHk3wEn96g");
	}
	
}