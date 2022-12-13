/*
 * 
 */
package Calendar;


import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Menu.AddMember;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarEvent.
 */
public class CalendarEvent {

	/** The Constant DEFAULT_COLOR. */
	private static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;
	
	/** The azul claro. */
	private Color azulClaro = new Color(102,178,255);
	
	/** The azul escuro. */
	private Color azulEscuro = new Color(0,102,204);

	/** The date. */
	private LocalDate date;
	
	/** The start. */
	private LocalTime start;
	
	/** The end. */
	private LocalTime end;
	
	/** The text. */
	private String text;
	
	/** The color. */
	private Color color;
	
	/** The nomes. */
	private ArrayList<String> nomes;
	
	/** The x. */
	private double x;

	/**
	 * Instantiates a new calendar event.
	 *
	 * @param date the date
	 * @param start the start
	 * @param end the end
	 * @param text the text
	 * @param nomes the nomes
	 */
	public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, ArrayList<String> nomes) {
		this(date, start, end, text, nomes, DEFAULT_COLOR);
	}

	/**
	 * Instantiates a new calendar event.
	 *
	 * @param date the date
	 * @param start the start
	 * @param end the end
	 * @param text the text
	 * @param nomes the nomes
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
	 * Gets the start.
	 *
	 * @return the start
	 */
	public LocalTime getStart() {
		return start;
	}

	/**
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	public void setStart(LocalTime start) {
		this.start = start;
	}

	/**
	 * Gets the end.
	 *
	 * @return the end
	 */
	public LocalTime getEnd() {
		return end;
	}

	/**
	 * Sets the end.
	 *
	 * @param end the new end
	 */
	public void setEnd(LocalTime end) {
		this.end = end;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the nomes.
	 *
	 * @return the nomes
	 */
	public ArrayList<String> getNomes() {
		return nomes;
	}

	/**
	 * Sets the nomes.
	 *
	 * @param nomes the new nomes
	 */
	public void setNomes(ArrayList<String> nomes) {
		
		this.nomes = nomes;

		if(nomes.size() >= 3) {
			
			this.color = azulEscuro;
			
		} else if (nomes.size() < 3 && nomes.size() >= 2 ) {
			
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
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
        return this.x;
    }

    /**
     * Sets the x.
     *
     * @param d the new x
     */
    public void setX(double d) {
        this.x = d;
    }
	
//	public int compareTo(CalendarEvent o) {
//	    return getDate().compareTo(o.getDate());
//	  }

	/**
 * Equals.
 *
 * @param o the o
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