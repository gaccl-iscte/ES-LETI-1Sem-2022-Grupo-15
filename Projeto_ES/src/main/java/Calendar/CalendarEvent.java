package Calendar;


import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Menu.AddMember;

public class CalendarEvent {

	private static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;
	
	private Color azulClaro = new Color(102,178,255);
	private Color azulEscuro = new Color(0,102,204);

	private LocalDate date;
	private LocalTime start;
	private LocalTime end;
	private String text;
	private Color color;
	private ArrayList<String> nomes;
	private double x;

	public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, ArrayList<String> nomes) {
		this(date, start, end, text, nomes, DEFAULT_COLOR);
	}

	public CalendarEvent(LocalDate date, LocalTime start, LocalTime end, String text, ArrayList<String> nomes, Color color) {
		this.date = date;
		this.start = start;
		this.end = end;
		this.text = text;
		this.nomes = nomes;
		this.color = color;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStart() {
		return start;
	}

	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}

	public void setEnd(LocalTime end) {
		this.end = end;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> getNomes() {
		return nomes;
	}

	public void setNomes(ArrayList<String> nomes) {
		
		this.nomes = nomes;

		if(nomes.size() >= 3) {
			
			this.color = azulEscuro;
			
		} else if (nomes.size() < 3 && nomes.size() >= 2 ) {
			
			this.color = azulClaro;
		}
	}

	public String toString() {
		return "Data: " + getDate() + " " + getStart() + "-" + getEnd() + " | " + "Sumário: " + getText() + " | " + "Alunos: " + getNomes();
	}

	public Color getColor() {
		return color;
	}
	
	public double getX() {
        return this.x;
    }

    public void setX(double d) {
        this.x = d;
    }
	
//	public int compareTo(CalendarEvent o) {
//	    return getDate().compareTo(o.getDate());
//	  }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CalendarEvent that = (CalendarEvent) o;

		if (!date.equals(that.date)) return false;
		if (!start.equals(that.start)) return false;
		return end.equals(that.end);

	}

	@Override
	public int hashCode() {
		int result = date.hashCode();
		result = 31 * result + start.hashCode();
		result = 31 * result + end.hashCode();
		return result;
	}
}