
package WeekCalendar;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Calendar.Calendar;
import Calendar.CalendarEvent;


/**
 * The Class WeekCalendarTest.
 */
public class WeekCalendarTest {
	
	/**
	 * Instantiates a new week calendar test.
	 *
	 * @param events the events
	 * @throws FileNotFoundException the file not found exception
	 * @throws ParseException the parse exception
	 */
	public WeekCalendarTest(ArrayList<CalendarEvent> events) throws FileNotFoundException, ParseException {
        JFrame frm = new JFrame();
        ImageIcon image = new ImageIcon("iscte_logo.png");
		frm.setIconImage(image.getImage());

        WeekCalendar cal = new WeekCalendar(events);

        cal.addCalendarEventClickListener(e -> System.out.println(e.getCalendarEvent()));
        cal.addCalendarEmptyClickListener(e -> {
            System.out.println(e.getDateTime());
            System.out.println(Calendar.roundTime(e.getDateTime().toLocalTime(), 30));
        });

        JButton goToTodayBtn = new JButton("Today");
        goToTodayBtn.addActionListener(e -> cal.goToToday());

        JButton nextWeekBtn = new JButton(">");
        nextWeekBtn.addActionListener(e -> cal.nextWeek());

        JButton prevWeekBtn = new JButton("<");
        prevWeekBtn.addActionListener(e -> cal.prevWeek());

        JButton nextMonthBtn = new JButton(">>");
        nextMonthBtn.addActionListener(e -> cal.nextMonth());

        JButton prevMonthBtn = new JButton("<<");
        prevMonthBtn.addActionListener(e -> cal.prevMonth());

        JPanel weekControls = new JPanel();
        weekControls.add(prevMonthBtn);
        weekControls.add(prevWeekBtn);
        weekControls.add(goToTodayBtn);
        weekControls.add(nextWeekBtn);
        weekControls.add(nextMonthBtn);

        frm.add(weekControls, BorderLayout.NORTH);

        frm.add(cal, BorderLayout.CENTER);
        frm.setSize(1000, 900);
        frm.setVisible(true);
//        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
