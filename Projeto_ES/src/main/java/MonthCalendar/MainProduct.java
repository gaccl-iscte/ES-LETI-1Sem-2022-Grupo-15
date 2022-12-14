package MonthCalendar;


import javax.swing.GroupLayout;
import java.io.Serializable;

/**
 * The Class MainProduct.
 */
public class MainProduct implements Serializable {
	
	/** The calendar custom 2. */
	private CalendarCustom calendarCustom2;

	/**
	 * Sets the GroupPanel jPanel1Layout.
	 *
	 * @param main the main
	 * @return the group layout
	 */
	public GroupLayout jPanel1Layout(Main main) {
		main.setJPanel1(new javax.swing.JPanel());
		calendarCustom2();
		main.getJPanel1().setBackground(new java.awt.Color(255, 255, 255));
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(main.getJPanel1());
		main.getJPanel1().setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(48, 48, 48)
						.addComponent(calendarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(381, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(27, 27, 27)
						.addComponent(calendarCustom2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(122, Short.MAX_VALUE)));
		return jPanel1Layout;
	}

	/**
	 * Creates a CalendarCustom.
	 */
	public void calendarCustom2() {
		calendarCustom2 = new CalendarCustom();
		calendarCustom2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	}
}