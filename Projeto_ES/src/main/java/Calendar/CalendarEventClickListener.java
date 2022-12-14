/*
 * 
 */
package Calendar;


import java.util.EventListener;

/**
 * The listener interface for receiving calendarEventClick events.
 * The class that is interested in processing a calendarEventClick
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCalendarEventClickListener<code> method. When
 * the calendarEventClick event occurs, that object's appropriate
 * method is invoked.
 *
 * @see CalendarEventClickEvent
 */
public interface CalendarEventClickListener extends EventListener {
    
    /**
     * Calendar event click.
     *
     * @param e the CalendarEventClickEvent
     */
    void calendarEventClick(CalendarEventClickEvent e);
}
