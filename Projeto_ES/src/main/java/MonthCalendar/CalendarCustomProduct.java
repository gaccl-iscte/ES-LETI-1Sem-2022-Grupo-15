package MonthCalendar;


import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

public class CalendarCustomProduct implements Serializable {
	private int month;
	private int year;
	private javax.swing.JLabel lbMonthYear;

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public javax.swing.JLabel getLbMonthYear() {
		return lbMonthYear;
	}

	public void setLbMonthYear(javax.swing.JLabel lbMonthYear) {
		this.lbMonthYear = lbMonthYear;
	}

	/**
	* Cmd next action performed.
	* @param evt  the evt
	*/
	public void cmdNextActionPerformed(java.awt.event.ActionEvent evt, PanelSlide thisSlide) {
		thisSlide1(thisSlide);
		showMonthYear();
	}

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
	* Cmd back action performed.
	* @param evt  the evt
	*/
	public void cmdBackActionPerformed(java.awt.event.ActionEvent evt, PanelSlide thisSlide) {
		thisSlide(thisSlide);
		showMonthYear();
	}

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
	* Show month year.
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
	* This month.
	*/
	public void thisMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		month = calendar.get(Calendar.MONTH) + 1;
		year = calendar.get(Calendar.YEAR);
	}
}