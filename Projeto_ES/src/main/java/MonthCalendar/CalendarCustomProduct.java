package MonthCalendar;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

/**
 * The Class CalendarCustomProduct.
 */
public class CalendarCustomProduct implements Serializable {
	
	/** The month. */
	private int month;
	
	/** The year. */
	private int year;
	
	/** The JLabel lbMonthYear. */
	private javax.swing.JLabel lbMonthYear;

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Gets the JLabel lbMonthYear.
	 *
	 * @return the JLabel lbMonthYear
	 */
	public javax.swing.JLabel getLbMonthYear() {
		return lbMonthYear;
	}

	/**
	 * Sets the JLabel lbMonthYear.
	 *
	 * @param lbMonthYear the new JLabel lbMonthYear
	 */
	public void setLbMonthYear(javax.swing.JLabel lbMonthYear) {
		this.lbMonthYear = lbMonthYear;
	}

	/**
	 * Cmdnext action performed.
	 *
	 * @param evt  the action performed
	 * @param thisSlide the slide
	 */
	public void cmdNextActionPerformed(java.awt.event.ActionEvent evt, PanelSlide thisSlide) {
		thisSlide1(thisSlide);
		showMonthYear();
	}

	/**
	 * Sets slide to left.
	 *
	 * @param thisSlide the slide
	 */
	private void thisSlide1(PanelSlide thisSlide) {
		if (month == 12) {
			month = 1;
			year++;
		} else {
			month++;
		}
		thisSlide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_LEFT);
	}

	/**
	 * Cmdback action performed.
	 *
	 * @param evt  the action performed
	 * @param thisSlide the slide
	 */
	public void cmdBackActionPerformed(java.awt.event.ActionEvent evt, PanelSlide thisSlide) {
		thisSlide(thisSlide);
		showMonthYear();
	}

	/**
	 * Sets slide to rigth.
	 *
	 * @param thisSlide the slide
	 */
	private void thisSlide(PanelSlide thisSlide) {
		if (month == 1) {
			month = 12;
			year--;
		} else {
			month--;
		}
		thisSlide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_RIGHT);
	}

	/**
	* Updates lbMonthYear.
	*/
	public void showMonthYear() {
		String[] months = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro" };
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DATE, 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		lbMonthYear.setText(months[month - 1] + " - " + df.format(calendar.getTime()));
	}

	/**
	* Sets this month.
	*/
	public void thisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		month = calendar.get(Calendar.MONTH) + 1;
		year = calendar.get(Calendar.YEAR);
	}
}