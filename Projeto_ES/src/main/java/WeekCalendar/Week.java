
package WeekCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Class Week.
 */
public class Week {

	/** The days. */
	private ArrayList<LocalDate> days;

	/**
	 * Instantiates a new week.
	 *
	 * @param date the date
	 */
	// Gets week variables from any date (can be within week)
	public Week(LocalDate date) {
		days = new ArrayList<>();
		LocalDate monday = getStartOfWeek(date);
		days.add(monday);
		for (int i = 1; i < 6; i++) {
			days.add(monday.plusDays(i));
		}
	}

	/**
	 * Gets the start of week.
	 *
	 * @param date the date
	 * @return the start of week
	 */
	public static LocalDate getStartOfWeek(LocalDate date) {
		LocalDate day = date;
		while (day.getDayOfWeek() != DayOfWeek.MONDAY) {
			day = day.minusDays(1);
		}
		return day;
	}

	/**
	 * Gets the day.
	 *
	 * @param dayOfWeek the day of week
	 * @return the day
	 */
	public LocalDate getDay(DayOfWeek dayOfWeek) {
		// DayOfWeek enum starts with monday == 1
		return days.get(dayOfWeek.getValue() - 1);
	}

	/**
	 * Next week.
	 *
	 * @return the week
	 */
	public Week nextWeek() {
		final LocalDate saturday = getDay(DayOfWeek.SATURDAY);
		return new Week(saturday.plusDays(2));
	}

	/**
	 * Prev week.
	 *
	 * @return the week
	 */
	public Week prevWeek() {
		final LocalDate monday = getDay(DayOfWeek.MONDAY);
		return new Week(monday.minusDays(2));
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Week of the " + getDay(DayOfWeek.MONDAY);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		Week currentWeek = new Week(now);
		System.out.println(currentWeek);
		System.out.println(currentWeek.prevWeek());
		System.out.println(currentWeek.nextWeek());
	}

}

