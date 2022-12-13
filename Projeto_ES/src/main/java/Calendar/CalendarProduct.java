package Calendar;


import javax.swing.event.EventListenerList;
import java.time.LocalDateTime;
import java.io.Serializable;

public class CalendarProduct implements Serializable {
	private EventListenerList listenerList = new EventListenerList();

	/**
	* Adds the calendar event click listener.
	* @param l  the l
	*/
	public void addCalendarEventClickListener(CalendarEventClickListener l) {
		listenerList.add(CalendarEventClickListener.class, l);
	}

	/**
	* Removes the calendar event click listener.
	* @param l  the l
	*/
	public void removeCalendarEventClickListener(CalendarEventClickListener l) {
		listenerList.remove(CalendarEventClickListener.class, l);
	}

	/**
	* Adds the calendar empty click listener.
	* @param l  the l
	*/
	public void addCalendarEmptyClickListener(CalendarEmptyClickListener l) {
		listenerList.add(CalendarEmptyClickListener.class, l);
	}

	/**
	* Removes the calendar empty click listener.
	* @param l  the l
	*/
	public void removeCalendarEmptyClickListener(CalendarEmptyClickListener l) {
		listenerList.remove(CalendarEmptyClickListener.class, l);
	}

	/**
	* Fire calendar event click.
	* @param calendarEvent  the calendar event
	*/
	public void fireCalendarEventClick(CalendarEvent calendarEvent, Calendar calendar) {
		Object[] listeners = listenerList.getListenerList();
		CalendarEventClickEvent calendarEventClickEvent;
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == CalendarEventClickListener.class) {
				calendarEventClickEvent = new CalendarEventClickEvent(calendar, calendarEvent);
				((CalendarEventClickListener) listeners[i + 1]).calendarEventClick(calendarEventClickEvent);
			}
		}
	}

	/**
	* Fire calendar empty click.
	* @param dateTime  the date time
	*/
	public void fireCalendarEmptyClick(LocalDateTime dateTime, Calendar calendar) {
		Object[] listeners = listenerList.getListenerList();
		CalendarEmptyClickEvent calendarEmptyClickEvent;
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == CalendarEmptyClickListener.class) {
				calendarEmptyClickEvent = new CalendarEmptyClickEvent(calendar, dateTime);
				((CalendarEmptyClickListener) listeners[i + 1]).calendarEmptyClick(calendarEmptyClickEvent);
			}
		}
	}
}