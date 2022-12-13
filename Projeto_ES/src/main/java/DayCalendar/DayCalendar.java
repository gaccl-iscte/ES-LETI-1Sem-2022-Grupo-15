/*
 * 
 */
package DayCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import Calendar.Calendar;
import Calendar.CalendarEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class DayCalendar.
 */
public class DayCalendar extends Calendar {

    /** The cal date. */
    private LocalDate calDate;

    /**
     * Instantiates a new day calendar.
     *
     * @param events the events
     * @param data the data
     */
    public DayCalendar(ArrayList<CalendarEvent> events, LocalDate data) {
        super(events);
        calDate = data;
    }

    /**
     * Date in range.
     *
     * @param date the date
     * @return true, if successful
     */
    @Override
    protected boolean dateInRange(LocalDate date) {
        return calDate.equals(date);
    }

    /**
     * Gets the date from day.
     *
     * @param day the day
     * @return the date from day
     */
    @Override
    protected LocalDate getDateFromDay(DayOfWeek day) {
        return calDate;
    }

    /**
     * Num days to show.
     *
     * @return the int
     */
    @Override
    protected int numDaysToShow() {
        return 1;
    }

    /**
     * Gets the start day.
     *
     * @return the start day
     */
    @Override
    protected DayOfWeek getStartDay() {
        return calDate.getDayOfWeek();
    }

    /**
     * Gets the end day.
     *
     * @return the end day
     */
    @Override
    protected DayOfWeek getEndDay() {
        return calDate.getDayOfWeek();
    }

    /**
     * Sets the range to today.
     */
    @Override
    protected void setRangeToToday() {
        calDate = LocalDate.now();
    }

    /**
     * Day to pixel.
     *
     * @param dayOfWeek the day of week
     * @return the double
     */
    @Override
    protected double dayToPixel(DayOfWeek dayOfWeek) {
        return TIME_COL_WIDTH;
    }

    /**
     * Next day.
     */
    public void nextDay() {
        calDate = calDate.plusDays(1);
        repaint();
    }

    /**
     * Prev day.
     */
    public void prevDay() {
        calDate = calDate.minusDays(1);
        repaint();
    }
}
