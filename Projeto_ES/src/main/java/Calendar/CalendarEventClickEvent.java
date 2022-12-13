/*
 * 
 */
package Calendar;

import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarEventClickEvent.
 */
public class CalendarEventClickEvent extends AWTEvent {

    /** The calendar event. */
    private CalendarEvent calendarEvent;

    /**
     * Instantiates a new calendar event click event.
     *
     * @param source the source
     * @param calendarEvent the calendar event
     */
    public CalendarEventClickEvent(Object source, CalendarEvent calendarEvent) {
        super(source, 0);
        this.calendarEvent = calendarEvent;
    }

    /**
     * Gets the calendar event.
     *
     * @return the calendar event
     */
    public CalendarEvent getCalendarEvent() {
        return calendarEvent;
    }
}
