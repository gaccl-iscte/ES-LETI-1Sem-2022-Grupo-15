/*
 * 
 */
package Calendar;

import java.util.EventListener;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving calendarEmptyClick events.
 * The class that is interested in processing a calendarEmptyClick
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCalendarEmptyClickListener<code> method. When
 * the calendarEmptyClick event occurs, that object's appropriate
 * method is invoked.
 *
 * @see CalendarEmptyClickEvent
 */
public interface CalendarEmptyClickListener extends EventListener {
    
    /**
     * Calendar empty click.
     *
     * @param e the e
     */
    // Event dispatch methods
    void calendarEmptyClick(CalendarEmptyClickEvent e);
}
