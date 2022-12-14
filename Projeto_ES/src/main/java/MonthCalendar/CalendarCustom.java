
package MonthCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class CalendarCustom.
 */
public class CalendarCustom extends javax.swing.JPanel {

    /** The calendar custom product 2. */
    private CalendarCustomProduct2 calendarCustomProduct2 = new CalendarCustomProduct2();

	/**
     * Instantiates a new calendar custom.
     */
    public CalendarCustom() {
        initComponents();
        calendarCustomProduct2.getCalendarCustomProduct().thisMonth();
        slide.show(new PanelDate(calendarCustomProduct2.getCalendarCustomProduct().getMonth(), calendarCustomProduct2.getCalendarCustomProduct().getYear()), PanelSlide.AnimateType.TO_RIGHT);
        calendarCustomProduct2.getCalendarCustomProduct().showMonthYear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd/MM-yyyy");
                    String time = tf.format(date);
                    lbTime.setText(time.split(" ")[0]);
                    lbType.setText(time.split(" ")[1]);
                    lbDate.setText(df.format(date));
                }
            }
        }).start();
    }

    /**
     * Inits the components.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        slide();
		lbTime();
		lbType();
		lbDate();
		setBackground(new java.awt.Color(255, 255, 255));

        calendarCustomProduct2.getCalendarCustomProduct().getLbMonthYear().setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        calendarCustomProduct2.getCalendarCustomProduct().getLbMonthYear().setForeground(new java.awt.Color(0, 0, 0));
        calendarCustomProduct2.getCalendarCustomProduct().getLbMonthYear().setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calendarCustomProduct2.getCalendarCustomProduct().getLbMonthYear().setText("Month - Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slide, 1000, 1000, Short.MAX_VALUE)
                    .addComponent(calendarCustomProduct2.getJLayeredPane1()))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(calendarCustomProduct2.getJLayeredPane1(), javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide, 850, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

	/**
	 * Sets lbType.
	 */
	private void lbType() {
		lbType = new javax.swing.JLabel();
		lbType.setFont(new java.awt.Font("sansserif", 1, 25));
		lbType.setForeground(new java.awt.Color(201, 201, 201));
		lbType.setText("PM");
	}

	/**
	 * Sets lbTime.
	 */
	private void lbTime() {
		lbTime = new javax.swing.JLabel();
		lbTime.setFont(new java.awt.Font("sansserif", 1, 48));
		lbTime.setForeground(new java.awt.Color(201, 201, 201));
		lbTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		lbTime.setText("9:32:00");
	}

	/**
	 * Sets lbDate.
	 */
	private void lbDate() {
		lbDate = new javax.swing.JLabel();
		lbDate.setFont(new java.awt.Font("sansserif", 0, 18));
		lbDate.setForeground(new java.awt.Color(201, 201, 201));
		lbDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbDate.setText("Sunday, 30/05/2021");
	}

	/**
	 * Sets panelSlide.
	 */
	private void slide() {
		calendarCustomProduct2.jLayeredPane1(this);
		slide.setBackground(new java.awt.Color(255, 255, 255));
		javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
		slide.setLayout(slideLayout);
		slideLayout.setHorizontalGroup(slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		slideLayout.setVerticalGroup(slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 321, Short.MAX_VALUE));
	}

	/** The JLabel lbdate. */
    private javax.swing.JLabel lbDate;
    
    /** The JLabel lbtime. */
    private javax.swing.JLabel lbTime;
    
    /** The JLabel lbtype. */
    private javax.swing.JLabel lbType;
    
    /** The PanelSlide slide. */
    private MonthCalendar.PanelSlide slide;
    // End of variables declaration//GEN-END:variables

	/**
     * Sets the slide.
     *
     * @param slide the new slide
     */
    public void setSlide(MonthCalendar.PanelSlide slide) {
		this.slide = slide;
	}

	/**
	 * Gets the slide.
	 *
	 * @return the slide
	 */
	public MonthCalendar.PanelSlide getSlide() {
		return slide;
	}
}
