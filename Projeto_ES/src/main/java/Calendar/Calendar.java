/*
 * 
 */
package Calendar;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;

// TODO: Auto-generated Javadoc
/**
 * The Class Calendar.
 */
public abstract class Calendar extends JComponent {
	
	private CalendarProduct2 calendarProduct2 = new CalendarProduct2();

	private CalendarProduct calendarProduct = new CalendarProduct();

	/** The Constant START_TIME. */
	protected static final LocalTime START_TIME = LocalTime.of(7, 0);
	
	/** The Constant END_TIME. */
	protected static final LocalTime END_TIME = LocalTime.of(21, 0);

	/** The Constant MIN_WIDTH. */
	protected static final int MIN_WIDTH = 600;
	
	/** The Constant MIN_HEIGHT. */
	protected static final int MIN_HEIGHT = MIN_WIDTH;

	/** The Constant HEADER_HEIGHT. */
	protected static final int HEADER_HEIGHT = 30;
	
	/** The Constant TIME_COL_WIDTH. */
	protected static final int TIME_COL_WIDTH = 100;

	// An estimate of the width of a single character (not exact but good
	/** The Constant FONT_LETTER_PIXEL_WIDTH. */
	// enough)
	private static final int FONT_LETTER_PIXEL_WIDTH = 7;
	
	/** The events. */
	private ArrayList<CalendarEvent> events;
	
	/** The day width. */
	private double dayWidth;
	
	/** The g 2. */
	private Graphics2D g2;

	/**
	 * Instantiates a new calendar.
	 */
	public Calendar() {
		this(new ArrayList<>());
	}

	/**
	 * Instantiates a new calendar.
	 *
	 * @param events the events
	 */
	protected Calendar(ArrayList<CalendarEvent> events) {
		this.events = events;
		setupEventListeners();
		setupTimer();
	}

	/**
	 * Round time.
	 *
	 * @param time the time
	 * @param minutes the minutes
	 * @return the local time
	 */
	public static LocalTime roundTime(LocalTime time, int minutes) {
		LocalTime t = time;

		if (t.getMinute() % minutes > minutes / 2) {
			t = t.plusMinutes(minutes - (t.getMinute() % minutes));
		} else if (t.getMinute() % minutes < minutes / 2) {
			t = t.minusMinutes(t.getMinute() % minutes);
		}

		return t;
	}

	/**
	 * Setup event listeners.
	 */
	private void setupEventListeners() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (!checkCalendarEventClick(e.getPoint())) {
					checkCalendarEmptyClick(e.getPoint());
				}
			}
		});
	}

	/**
	 * Date in range.
	 *
	 * @param date the date
	 * @return true, if successful
	 */
	protected abstract boolean dateInRange(LocalDate date);

	/**
	 * Check calendar event click.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	private boolean checkCalendarEventClick(Point p) {
		double x0, x1, y0, y1;
		for (CalendarEvent event : events) {
			if (!dateInRange(event.getDate())) continue;

			x0 = dayToPixel(event.getDate().getDayOfWeek());
			y0 = calendarProduct2.timeToPixel(event.getStart());
			x1 = dayToPixel(event.getDate().getDayOfWeek()) + dayWidth;
			y1 = calendarProduct2.timeToPixel(event.getEnd());

			if (p.getX() >= x0 && p.getX() <= x1 && p.getY() >= y0 && p.getY() <= y1) {
				calendarProduct.fireCalendarEventClick(event, this);
				return true;
			}
		}
		return false;
	}

	/**
	 * Check calendar empty click.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	private boolean checkCalendarEmptyClick(Point p) {
		final double x0 = dayToPixel(getStartDay());
		final double x1 = dayToPixel(getEndDay()) + dayWidth;
		final double y0 = calendarProduct2.timeToPixel(START_TIME);
		final double y1 = calendarProduct2.timeToPixel(END_TIME);

		if (p.getX() >= x0 && p.getX() <= x1 && p.getY() >= y0 && p.getY() <= y1) {
			LocalDate date = getDateFromDay(pixelToDay(p.getX()));
			calendarProduct.fireCalendarEmptyClick(LocalDateTime.of(date, calendarProduct2.pixelToTime(p.getY())), this);
			return true;
		}
		return false;
	}

	/**
	 * Gets the date from day.
	 *
	 * @param day the day
	 * @return the date from day
	 */
	protected abstract LocalDate getDateFromDay(DayOfWeek day);

	// CalendarEventClick methods

	/**
	 * Adds the calendar event click listener.
	 *
	 * @param l the l
	 */
	public void addCalendarEventClickListener(CalendarEventClickListener l) {
		calendarProduct.addCalendarEventClickListener(l);
	}

	/**
	 * Removes the calendar event click listener.
	 *
	 * @param l the l
	 */
	public void removeCalendarEventClickListener(CalendarEventClickListener l) {
		calendarProduct.removeCalendarEventClickListener(l);
	}

	

	// CalendarEmptyClick methods

	/**
	 * Adds the calendar empty click listener.
	 *
	 * @param l the l
	 */
	public void addCalendarEmptyClickListener(CalendarEmptyClickListener l) {
		calendarProduct.addCalendarEmptyClickListener(l);
	}

	/**
	 * Removes the calendar empty click listener.
	 *
	 * @param l the l
	 */
	public void removeCalendarEmptyClickListener(CalendarEmptyClickListener l) {
		calendarProduct.removeCalendarEmptyClickListener(l);
	}

	/**
	 * Calculate scale vars.
	 */
	private void calculateScaleVars() {
		int width = width();
		int height = height();
		// Units are pixels per second
		calendarProduct2.setTimeScale(
				(double) (height - HEADER_HEIGHT) / (END_TIME.toSecondOfDay() - START_TIME.toSecondOfDay()));
		dayWidth = (width - TIME_COL_WIDTH) / numDaysToShow();
	}

	private int height() {
		int height = getHeight();
		if (height < MIN_HEIGHT) {
			height = MIN_HEIGHT;
		}
		return height;
	}

	private int width() {
		int width = getWidth();
		if (width < MIN_WIDTH) {
			width = MIN_WIDTH;
		}
		return width;
	}

	/**
	 * Num days to show.
	 *
	 * @return the int
	 */
	protected abstract int numDaysToShow();

	/**
	 * Day to pixel.
	 *
	 * @param dayOfWeek the day of week
	 * @return the double
	 */
	// Gives x val of left most pixel for day col
	protected abstract double dayToPixel(DayOfWeek dayOfWeek);

	/**
	 * Pixel to day.
	 *
	 * @param x the x
	 * @return the day of week
	 */
	private DayOfWeek pixelToDay(double x) {
		double pixel;
		DayOfWeek day;
		for (int i = getStartDay().getValue(); i <= getEndDay().getValue(); i++) {
			day = DayOfWeek.of(i);
			pixel = dayToPixel(day);
			if (x >= pixel && x < pixel + dayWidth) {
				return day;
			}
		}
		return null;
	}

	/**
	 * Paint component.
	 *
	 * @param g the g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		calculateScaleVars();
		g2 = (Graphics2D) g;

		// Rendering hints try to turn anti-aliasing on which improves quality
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Set background to white
		g2.setColor(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());

		// Set paint colour to black
		g2.setColor(Color.black);

		drawDayHeadings();
		drawTodayShade();
		drawGrid();
		drawTimes();
		setXEvents();
		drawEvents();
		drawCurrentTimeLine();
	}

	/**
	 * Gets the start day.
	 *
	 * @return the start day
	 */
	protected abstract DayOfWeek getStartDay();

	/**
	 * Gets the end day.
	 *
	 * @return the end day
	 */
	protected abstract DayOfWeek getEndDay();

	/**
	 * Draw day headings.
	 */
	private void drawDayHeadings() {
		int y = 20;
		int x;
		LocalDate day;
		DayOfWeek dayOfWeek;

		for (int i = getStartDay().getValue(); i <= getEndDay().getValue(); i++) {
			dayOfWeek = DayOfWeek.of(i);
			day = getDateFromDay(dayOfWeek);

			String text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + day.getDayOfMonth() + "/" + day.getMonthValue();
			x = (int) (dayToPixel(DayOfWeek.of(i)) + (dayWidth / 2) - (FONT_LETTER_PIXEL_WIDTH * text.length() / 2));
			g2.drawString(text, x, y);
		}
	}

	/**
	 * Draw grid.
	 */
	private void drawGrid() {
		// Save the original colour
		final Color ORIG_COLOUR = g2.getColor();

		// Set colour to grey with half alpha (opacity)
		Color alphaGray = new Color(128, 128, 128, 128);
		Color alphaGrayLighter = new Color(200, 200, 200, 128);
		g2.setColor(alphaGray);

		// Draw vertical grid lines
		double x;
		for (int i = getStartDay().getValue(); i <= getEndDay().getValue(); i++) {
			x = dayToPixel(DayOfWeek.of(i));
			g2.draw(new Line2D.Double(x, HEADER_HEIGHT, x, calendarProduct2.timeToPixel(END_TIME)));
		}

		// Draw horizontal grid lines
		double y;
		int x1=0;
		for (LocalTime time = START_TIME; time.compareTo(END_TIME) <= 0; time = time.plusMinutes(30)) {
			y = calendarProduct2.timeToPixel(time);
			x1 = x1(x1, time);
			if (time.getMinute() == 0) {
				g2.setColor(alphaGray);
			} else {
				g2.setColor(alphaGrayLighter);
			}
			g2.draw(new Line2D.Double(x1, y, dayToPixel(getEndDay()) + dayWidth, y));
		}

		// Reset the graphics context's colour
		g2.setColor(ORIG_COLOUR);
	}

	private int x1(int x1, LocalTime time) {
		if (time.getMinute() == 0) {
			x1 = 0;
		} else {
			x1 = TIME_COL_WIDTH;
		}
		return x1;
	}

	/**
	 * Draw today shade.
	 */
	private void drawTodayShade() {
		LocalDate today = LocalDate.now();

		// Check that date range being viewed is current date range
		if (!dateInRange(today)) return;

		final double x = dayToPixel(today.getDayOfWeek());
		final double y = calendarProduct2.timeToPixel(START_TIME);
		final double width = dayWidth;
		final double height = calendarProduct2.timeToPixel(END_TIME) - calendarProduct2.timeToPixel(START_TIME);

		final Color origColor = g2.getColor();
		Color alphaGray = new Color(200, 200, 200, 64);
		g2.setColor(alphaGray);
		g2.fill(new Rectangle2D.Double(x, y, width, height));
		g2.setColor(origColor);
	}

	/**
	 * Draw current time line.
	 */
	private void drawCurrentTimeLine() {
		LocalDate today = LocalDate.now();

		// Check that date range being viewed is current date range
		if (!dateInRange(today)) return;

		final double x0 = dayToPixel(today.getDayOfWeek());
		final double x1 = dayToPixel(today.getDayOfWeek()) + dayWidth;
		final double y = calendarProduct2.timeToPixel(LocalTime.now());

		final Color origColor = g2.getColor();
		final Stroke origStroke = g2.getStroke();

		g2.setColor(new Color(255, 127, 110));
		g2.setStroke(new BasicStroke(2));
		g2.draw(new Line2D.Double(x0, y, x1, y));

		g2.setColor(origColor);
		g2.setStroke(origStroke);
	}

	/**
	 * Draw times.
	 */
	private void drawTimes() {
		int y;
		for (LocalTime time = START_TIME; time.compareTo(END_TIME) <= 0; time = time.plusHours(1)) {
			y = (int) calendarProduct2.timeToPixel(time) + 15;
			g2.drawString(time.toString(), TIME_COL_WIDTH - (FONT_LETTER_PIXEL_WIDTH * time.toString().length()) - 5, y);
		}
	}

	/**
	 * Draw events.
	 */
	private void drawEvents() {
		double x;
		double y0;
		

		for (CalendarEvent event : events) {
			if (!dateInRange(event.getDate())) continue;

			x = event.getX();
			y0 = calendarProduct2.timeToPixel(event.getStart());
			Rectangle2D rect = rect(x, y0, event);

			//AQUI

			Color origColor = g2.getColor();
			g2.setColor(event.getColor());
			g2.fill(rect);
			g2.setColor(origColor);
			g2.drawRect((int)x, (int)y0, (int)dayWidth / getNumEvents(event), (int)(calendarProduct2.timeToPixel(event.getEnd()) - calendarProduct2.timeToPixel(event.getStart())));

			// Draw time header

			// Store the current font state
			Font origFont = g2.getFont();

			final float fontSize = origFont.getSize() - 1.6F;

			// Create a new font with same properties but bold
			Font newFont = origFont.deriveFont(Font.BOLD, fontSize);
			g2.setFont(newFont);

			g2.drawString(event.getStart() + " - " + event.getEnd(), (int) x + 5, (int) y0 + 11);

			// Unbolden
			g2.setFont(origFont.deriveFont(fontSize));

			// Draw the event's text
			g2.drawString("Sumário: " + event.getText(), (int) x + 5, (int) y0 + 23);
			// Draw the event's student

			int j = 35;

			for(int i = 0 ; i < event.getNomes().size() ; i++) {

				g2.drawString("Aluno: " + event.getNomes().get(i) , (int) x + 5, (int) y0 + j);

				j+=12;
			}

			// Reset font
			g2.setFont(origFont);            
		}
	}

	private Rectangle2D rect(double x, double y0, CalendarEvent event) {
		x = event.getX();
		y0 = calendarProduct2.timeToPixel(event.getStart());
		Rectangle2D rect = new Rectangle2D.Double(x, y0, dayWidth / getNumEvents(event),
				(calendarProduct2.timeToPixel(event.getEnd()) - calendarProduct2.timeToPixel(event.getStart())));
		return rect;
	}


	/**
	 * Gets the num events.
	 *
	 * @param e the e
	 * @return the num events
	 */
	private int getNumEvents(CalendarEvent e) {
		int count = 1;
		ArrayList<CalendarEvent> equal = new ArrayList<>();
		equal.add(e);
		for(CalendarEvent event : events) {
			if(event.getDate().equals(e.getDate()) && !event.equals(e)) {
				if(event.getStart().isAfter(e.getStart()) && event.getEnd().isBefore(e.getEnd())
						|| event.getStart().isBefore(e.getEnd()) && event.getEnd().isAfter(e.getEnd())
						||event.getStart().isBefore(e.getStart()) && event.getEnd().isAfter(e.getStart())
						||event.getStart().equals(e.getStart()) && event.getEnd().equals(e.getEnd())
						||event.getStart().equals(e.getStart()) && event.getEnd().isBefore(e.getEnd())
						|| event.getStart().equals(e.getStart()) && event.getEnd().isAfter(e.getEnd())){
					count++;
					equal.add(event);
				}
			}
		}
		for(CalendarEvent event : equal) {
			for(CalendarEvent event1 : equal) {
				if(event.getStart().equals(event1.getEnd())) {
					count --;
				}
			}
		}
		return count;
	}

	/**
	 * Sets the X events.
	 */
	private void setXEvents() {
		for(CalendarEvent event : events) {
			ArrayList<CalendarEvent> equal = new ArrayList<>();
			equal.add(event);
			for(CalendarEvent e : events) {
				if(event.getDate().equals(e.getDate()) && !event.equals(e)) {
					if(event.getStart().isAfter(e.getStart()) && event.getEnd().isBefore(e.getEnd())
							|| event.getStart().isBefore(e.getEnd()) && event.getEnd().isAfter(e.getEnd())
							|| event.getStart().isBefore(e.getStart()) && event.getEnd().isAfter(e.getStart())
							|| event.getStart().equals(e.getStart()) && event.getEnd().equals(e.getEnd())
							|| event.getStart().equals(e.getStart()) && event.getEnd().isBefore(e.getEnd())
							|| event.getStart().equals(e.getStart()) && event.getEnd().isAfter(e.getEnd())){
						equal.add(e);
					}
				}
			}
			double i = 0;
			for(int x = 0; x<equal.size(); x++) {
				equal.get(x).setX(dayToPixel(equal.get(x).getDate().getDayOfWeek())+i);
				i = i + dayWidth / getNumEvents(event);
			}
		}
	}




	/**
	 * Gets the day width.
	 *
	 * @return the day width
	 */
	protected double getDayWidth() {
		return dayWidth;
	}

	/**
	 * Setup timer.
	 */
	// Repaints every minute to update the current time line
	private void setupTimer() {
		Timer timer = new Timer(1000*60, e -> repaint());
		timer.start();
	}

	/**
	 * Sets the range to today.
	 */
	protected abstract void setRangeToToday();

	/**
	 * Go to today.
	 */
	public void goToToday() {
		setRangeToToday();
		repaint();
	}

	/**
	 * Adds the event.
	 *
	 * @param event the event
	 */
	public void addEvent(CalendarEvent event) {
		events.add(event);
		repaint();
	}

	/**
	 * Removes the event.
	 *
	 * @param event the event
	 * @return true, if successful
	 */
	public boolean removeEvent(CalendarEvent event) {
		boolean removed = events.remove(event);
		repaint();
		return removed;
	}

	/**
	 * Sets the events.
	 *
	 * @param events the new events
	 */
	public void setEvents(ArrayList<CalendarEvent> events) {
		this.events = events;
		repaint();
	}
}