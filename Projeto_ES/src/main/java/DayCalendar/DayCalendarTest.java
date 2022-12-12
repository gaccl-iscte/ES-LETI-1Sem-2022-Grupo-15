package DayCalendar;

import javax.swing.*;

import Calendar.Calendar;
import Calendar.CalendarEvent;

import java.awt.*;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DayCalendarTest {
    public DayCalendarTest(ArrayList<CalendarEvent> events, LocalDate data) throws FileNotFoundException, ParseException {
        JFrame frm = new JFrame();
        ImageIcon image = new ImageIcon("iscte_logo.png");
		frm.setIconImage(image.getImage());       

        DayCalendar cal = new DayCalendar(events, data);

        cal.addCalendarEventClickListener(e -> System.out.println(e.getCalendarEvent()));
        cal.addCalendarEmptyClickListener(e -> {
            System.out.println(e.getDateTime());
            System.out.println(Calendar.roundTime(e.getDateTime().toLocalTime(), 30));
        });

        JButton goToTodayBtn = new JButton("Today");
        goToTodayBtn.addActionListener(e -> cal.goToToday());

        JButton nextDayBtn = new JButton(">");
        nextDayBtn.addActionListener(e -> cal.nextDay());

        JButton prevDayBtn = new JButton("<");
        prevDayBtn.addActionListener(e -> cal.prevDay());

        JPanel weekControls = new JPanel();
        weekControls.add(prevDayBtn);
        weekControls.add(goToTodayBtn);
        weekControls.add(nextDayBtn);

        frm.add(weekControls, BorderLayout.NORTH);

        frm.add(cal, BorderLayout.CENTER);
        frm.setSize(1000, 900);
        frm.setVisible(true);
//        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
