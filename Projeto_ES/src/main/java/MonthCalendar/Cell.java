/*
 * 
 */
package MonthCalendar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;



// TODO: Auto-generated Javadoc
/**
 * The Class Cell.
 */
public class Cell extends JButton {

    /** The date. */
    private Date date;
    
    /** The title. */
    private boolean title;
    
    /** The is to day. */
    private boolean isToDay;

    /**
     * Instantiates a new cell.
     */
    public Cell() {
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
        addActionListener(new open());
    }

    /**
     * As title.
     */
    public void asTitle() {
        title = true;
    }

    /**
     * Checks if is title.
     *
     * @return true, if is title
     */
    public boolean isTitle() {
        return title;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * Gets the date.
     *
     * @return the date
     */
    public Date getDate() {
    	return date;
    }

    /**
     * Current month.
     *
     * @param act the act
     */
    public void currentMonth(boolean act) {
        if (act) {
            setForeground(new Color(0, 0, 0));
        } else {
            setForeground(new Color(68, 68, 68));
        }
    }

    /**
     * Sets the as to day.
     */
    public void setAsToDay() {
        isToDay = true;
        setForeground(Color.RED);
    }

    /**
     * Paint component.
     *
     * @param grphcs the grphcs
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        if (title) {
            grphcs.setColor(new Color(0, 0, 0));
            grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }
        if (isToDay) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(97, 49, 237));
            int x = getWidth() / 2 - 17;
            int y = getHeight() / 2 - 17;
            g2.fillRoundRect(x, y, 35, 35, 100, 100);
        }
        super.paintComponent(grphcs);
    }
    
    /**
     * The Class open.
     */
    static class open implements ActionListener{
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed (ActionEvent e){

		}
	}

}
