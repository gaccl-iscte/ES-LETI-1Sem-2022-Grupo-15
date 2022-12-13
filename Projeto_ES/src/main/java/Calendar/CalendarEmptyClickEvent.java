/*
 * 
 */
package Calendar;

import java.awt.*;
import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class CalendarEmptyClickEvent.
 */
public class CalendarEmptyClickEvent extends AWTEvent {
    
    /** The date time. */
    private LocalDateTime dateTime;

    /**
     * Instantiates a new calendar empty click event.
     *
     * @param source the source
     * @param dateTime the date time
     */
    public CalendarEmptyClickEvent(Object source, LocalDateTime dateTime) {
        super(source, 0);
        this.dateTime = dateTime;
    }

    /**
     * Gets the date time.
     *
     * @return the date time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
