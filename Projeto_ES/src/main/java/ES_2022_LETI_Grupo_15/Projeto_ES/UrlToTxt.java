package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;


import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.util.*;

public class UrlToTxt {

	public static void readStringFromURL(String url) throws IOException, ParserException
	{
		URL url1 = new URL(url);
		PrintStream out = new PrintStream(new File("C:\\Users\\Asus\\Desktop\\URL.txt"));
		System.setOut(out);

		
		InputStream is = url1.openStream();
		try {
		   Calendar cal = new CalendarBuilder().build(is);
		   System.out.println(cal.toString());
		} finally {
		  is.close();
		}
	}
	
	public static void main(String args[]) throws IOException, ParserException{
		readStringFromURL("https://fenix.iscte-iul.pt/publico/publicPersonICalendar.do?method=iCalendar&username=tmmfo1@iscte.pt&password=oN93nFF9kYTy0A5nUzsLh3wWkwPPkxJeZlYWXHbqGQNgQq2r57pTpOPlpPzcx1gjfgjFReV1Wp3OjNe1SdVSg8NuGDUy06UQ17URCUFVbRAeucNLayOdmeTHk3wEn96g");
	}
}