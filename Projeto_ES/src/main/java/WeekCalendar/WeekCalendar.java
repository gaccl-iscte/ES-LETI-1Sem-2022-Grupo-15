
package WeekCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

import Calendar.Calendar;
import Calendar.CalendarEvent;

/**
 * The Class WeekCalendar.
 */
public class WeekCalendar extends Calendar {

    /** The week. */
    private Week week;

    /**
     * Instantiates a new week calendar.
     *
     * @param events the events
     */
    public WeekCalendar(ArrayList<CalendarEvent> events) {
        super(events);
        week = new Week(LocalDate.now());
    }

    /**
     * Date in range.
     *
     * @param date the date
     * @return true, if successful
     */
    @Override
    protected boolean dateInRange(LocalDate date) {
        return Week.getStartOfWeek(date).equals(week.getDay(DayOfWeek.MONDAY));
    }

    /**
     * Gets the date from day.
     *
     * @param day the day
     * @return the date from day
     */
    @Override
    protected LocalDate getDateFromDay(DayOfWeek day) {
        return week.getDay(day);
    }

    /**
     * Num days to show.
     *
     * @return the int
     */
    protected int numDaysToShow() {
        return 6;
    }

    /**
     * Gets the start day.
     *
     * @return the start day
     */
    @Override
    protected DayOfWeek getStartDay() {
        return DayOfWeek.MONDAY;
    }

    /**
     * Gets the end day.
     *
     * @return the end day
     */
    @Override
    protected DayOfWeek getEndDay() {
        return DayOfWeek.SATURDAY;
    }

    /**
     * Sets the range to today.
     */
    @Override
    protected void setRangeToToday() {
        week = new Week(LocalDate.now());
    }

    /**
     * Day to pixel.
     *
     * @param dayOfWeek the day of week
     * @return the double
     */
    @Override
    protected double dayToPixel(DayOfWeek dayOfWeek) {
        return TIME_COL_WIDTH + getDayWidth() * (dayOfWeek.getValue() - 1);
    }

    /**
     * Next week.
     */
    public void nextWeek() {
        week = week.nextWeek();
        repaint();
    }

    /**
     * Prev week.
     */
    public void prevWeek() {
        week = week.prevWeek();
        repaint();
    }

    /**
     * Next month.
     */
    public void nextMonth() {
        week = new Week(week.getDay(DayOfWeek.MONDAY).plusWeeks(4));
        repaint();
    }

    /**
     * Prev month.
     */
    public void prevMonth() {
        week = new Week(week.getDay(DayOfWeek.MONDAY).minusWeeks(4));
        repaint();
    }

}