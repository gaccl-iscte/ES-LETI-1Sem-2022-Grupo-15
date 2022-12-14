package MonthCalendar;


import java.util.Calendar;
import java.awt.Component;
import java.time.LocalDate;
import java.time.ZoneId;
import ES_2022_LETI_Grupo_15.Projeto_ES.txtToObject;
import java.awt.Color;
import java.util.Date;
import java.io.Serializable;

/**
 * The Class PanelDateProduct.
 */
public class PanelDateProduct implements Serializable {
	
	/** The month. */
	private int month;
	
	/** The year. */
	private int year;

	/**
	 * Sets the month.
	 *
	 * @param month the new month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Sets the date.
	 *
	 * @param panelDate the new date
	 */
	public void setDate(PanelDate panelDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, 1);
		int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, -startDay);
		ToDay toDay = getToDay();
		for (Component com : panelDate.getComponents()) {
			Cell cell = cell(calendar, toDay, com);
			if (!cell.isTitle()) {
				calendar.add(Calendar.DATE, 1);
			}
		}
	}

	/**
	 * Creates cell's.
	 *
	 * @param calendar the calendar
	 * @param toDay the toDay
	 * @param com the component
	 * @return the cell
	 */
	private Cell cell(Calendar calendar, ToDay toDay, Component com) {
		Cell cell = (Cell) com;
		if (!cell.isTitle()) {
			cell.setText(calendar.get(Calendar.DATE) + "");
			cell.setDate(calendar.getTime());
			cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
			cell.setOpaque(true);
			if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1,
					calendar.get(Calendar.YEAR)))) {
				cell.setAsToDay();
			}
			LocalDate data = cell.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int numEvents = txtToObject.getNumberEventsOfDay(Main.eventos, Main.nomes, data);
			if (numEvents >= 6) {
				cell.setBackground(new Color(0, 102, 204));
			} else if (numEvents < 6 && numEvents >= 3) {
				cell.setBackground(new Color(51, 153, 255));
			} else if (numEvents < 3 && numEvents >= 1) {
				cell.setBackground(new Color(153, 204, 255));
			} else {
				cell.setBackground(new Color(169, 169, 169));
			}
		}
		return cell;
	}

	/**
	* Gets the toDay.
	* @return the toDay
	*/
	public ToDay getToDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
	}
}