package ES_2022_LETI_Grupo_15.Projeto_ES;



import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.UnfoldingReader;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IcsToTxt {

	public static void convert(String ics) throws IOException {
		
		FileWriter writer = new FileWriter("C:\\Users\\Asus\\Desktop\\resultICS.txt");
		
		BufferedWriter writer1 = new BufferedWriter(writer);
		
		try {
			CalendarBuilder builder = new CalendarBuilder();

			final UnfoldingReader ufrdr = new UnfoldingReader(new FileReader(ics), true);

			Calendar calendar = builder.build(ufrdr);

			for (final Object o : calendar.getComponents()) {
				Component component = (Component)o;
				writer1.write("Component: " + component.getName());
				writer1.newLine();
				for (final Object o1 : component.getProperties()) {
					Property property = (Property)o1;
					//System.out.println(property.getName() + ": " + property.getValue());
					writer1.write(property.getName() + ": " + property.getValue());
					writer1.newLine();
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		writer1.close();
	}
	public static void main(String args[]) throws IOException{
		convert("C:\\Users\\Asus\\Desktop\\tmmfo1@iscte.pt_iscte-iul.ics");
	}

}