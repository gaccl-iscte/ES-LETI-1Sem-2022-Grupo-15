/*
 * 
 */
package Calendar;


import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


/**
 * The Class CalendarEvent.
 */
public class CalendarEvent {
	
	/** The Color azul claro. */
	private static Color azulClaro = new Color(153,204,255);
	
	/** The Color azul intermédio. */
	private static Color azulIntermedio = new Color(51,153,255);
	
	/** The Color azul escuro. */
	private static Color azulEscuro = new Color(0,102,204);

	/** The date. */
	private LocalDate date;
	
	/** The start time. */
	private LocalTime start;
	
	/** The end time. */
	private LocalTime end;
	
	/** The summary text. */
	private String text;
	
	/** The color. */
	private Color color;
	
	/** The list of names. */
	private ArrayList<String> nomes;
	
	/** The x coordinate. */
	private double x;

	/**
	 * Instantiates a new calendar event.
	 *
	 * @param date the date
	 * @param start the start time
	 * @param end the end time
	 * @param text the suumary text
	 * @param nomes the list of names
	 */
	public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, ArrayList<String> nomes) {
		this(date, start, end, text, nomes, azulClaro);
	}

	/**
	 * Instantiates a new calendar event.
	 *
	 * @param date the date
	 * @param start the start time
	 * @param end the end time
	 * @param text the summary text
	 * @param nomes the list of names
	 * @param color the color
	 */
	public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, ArrayList<String> nomes, Color color) {
		this.date = date;
		this.start = start;
		this.end = end;
		this.text = text;
		this.nomes = nomes;
		this.color = color;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public LocalTime getStart() {
		return start;
	}

	/**
	 * Sets the start time.
	 *
	 * @param start the new start time
	 */
	public void setStart(LocalTime start) {
		this.start = start;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public LocalTime getEnd() {
		return end;
	}

	/**
	 * Sets the end time.
	 *
	 * @param end the new end time
	 */
	public void setEnd(LocalTime end) {
		this.end = end;
	}

	/**
	 * Gets the summary text.
	 *
	 * @return the summary text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the summary text.
	 *
	 * @param text the new summary text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the list of names.
	 *
	 * @return the list of names
	 */
	public ArrayList<String> getNomes() {
		return nomes;
	}

	/**
	 * Sets the list of names.
	 *
	 * @param nomes the new list of names
	 */
	public void setNomes(ArrayList<String> nomes) {
		
		this.nomes = nomes;

		if(nomes.size() >= 3) {
			
			this.color = azulEscuro;			
		} else if (nomes.size() < 3 && nomes.size() >= 2 ) {
			
			this.color = azulIntermedio;
		} else if (nomes.size() == 1) {
			
			this.color = azulClaro;
		}
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Data: " + getDate() + " " + getStart() + "-" + getEnd() + " | " + "Sumário: " + getText() + " | " + "Alunos: " + getNomes();
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Gets the x coordinate.
	 *
	 * @return the x coordinate
	 */
	public double getX() {
        return this.x;
    }

    /**
     * Sets the x coordinate.
     *
     * @param d the new x coordinate
     */
    public void setX(double d) {
        this.x = d;
    }

 /**
 * Equals.
 *
 * @param o the object
 * @return true, if successful
 */
@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CalendarEvent that = (CalendarEvent) o;

		if (!date.equals(that.date)) return false;
		if (!start.equals(that.start)) return false;
		return end.equals(that.end);

	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		int result = date.hashCode();
		result = 31 * result + start.hashCode();
		result = 31 * result + end.hashCode();
		return result;
	}
}