package ES_2022_LETI_Grupo_15.Projeto_ES;



import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.UnfoldingReader;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;

import java.io.FileReader;

public class IcsToTxt {

	public static void convert(String ics) {
		try {
			CalendarBuilder builder = new CalendarBuilder();

			final UnfoldingReader ufrdr = new UnfoldingReader(new FileReader(ics), true);

			Calendar calendar = builder.build(ufrdr);

			for (final Object o : calendar.getComponents()) {
				Component component = (Component)o;
				System.out.println("Component: " + component.getName());
				for (final Object o1 : component.getProperties()) {
					Property property = (Property)o1;
					System.out.println(property.getName() + ": " + property.getValue());
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	public static void main(String args[]){
		convert("C:\\Users\\Asus\\Desktop\\tmmfo1@iscte.pt_iscte-iul.ics");
	}

}