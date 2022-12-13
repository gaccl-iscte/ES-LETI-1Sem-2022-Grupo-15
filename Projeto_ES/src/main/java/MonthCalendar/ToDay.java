/*
 * 
 */
package MonthCalendar;

// TODO: Auto-generated Javadoc
/**
 * The Class ToDay.
 */
public class ToDay {

    /**
     * Gets the day.
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day.
     *
     * @param day the new day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Gets the month.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month.
     *
     * @param month the new month
     */
    public void setMonth(int month) {
        this.month = month;
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
     * Sets the year.
     *
     * @param year the new year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Instantiates a new to day.
     *
     * @param day the day
     * @param month the month
     * @param year the year
     */
    public ToDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Instantiates a new to day.
     */
    public ToDay() {
    }

    /** The day. */
    private int day;
    
    /** The month. */
    private int month;
    
    /** The year. */
    private int year;

    /**
     * Checks if is to day.
     *
     * @param date the date
     * @return true, if is to day
     */
    public boolean isToDay(ToDay date) {
        return day == date.getDay() && month == date.getMonth() && year == date.getYear();
    }
}
