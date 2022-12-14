package Calendar;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;

/**
 * The Class CalendarProduct2.
 */
public class CalendarProduct2 implements Serializable {
	
	/** The time scale. */
	private double timeScale;

	/**
	 * Sets the time scale.
	 *
	 * @param timeScale the new time scale
	 */
	public void setTimeScale(double timeScale) {
		this.timeScale = timeScale;
	}

	/**
	* Time to pixel.
	* @param time  the time
	* @return  the double
	*/
	public double timeToPixel(LocalTime time) {
		return ((time.toSecondOfDay() - Calendar.START_TIME.toSecondOfDay()) * timeScale) + Calendar.HEADER_HEIGHT;
	}

	/**
	* Pixel to time.
	* @param y  the y coordinate
	* @return  the local time
	*/
	public LocalTime pixelToTime(double y) {
		return LocalTime
				.ofSecondOfDay((int) ((y - Calendar.HEADER_HEIGHT) / timeScale) + Calendar.START_TIME.toSecondOfDay())
				.truncatedTo(ChronoUnit.MINUTES);
	}
}