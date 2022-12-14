package MonthCalendar;


import java.io.Serializable;

/**
 * The Class CalendarCustomProduct2.
 */
public class CalendarCustomProduct2 implements Serializable {
	
	/** The calendar custom product. */
	private CalendarCustomProduct calendarCustomProduct = new CalendarCustomProduct();
	
	/** The JButton cmdBack. */
	private javax.swing.JButton cmdBack;
	
	/** The JButton cmdNext. */
	private javax.swing.JButton cmdNext;
	
	/** The JLayeredPane jLayeredPane1. */
	private javax.swing.JLayeredPane jLayeredPane1;

	/**
	 * Gets the calendar custom product.
	 *
	 * @return the calendar custom product
	 */
	public CalendarCustomProduct getCalendarCustomProduct() {
		return calendarCustomProduct;
	}

	/**
	 * Gets the JLayeredPane jLayeredPane1.
	 *
	 * @return the JLayeredPane jLayeredPane1
	 */
	public javax.swing.JLayeredPane getJLayeredPane1() {
		return jLayeredPane1;
	}

	/**
	 * Calendar custom product.
	 *
	 * @param calendarCustom the custom calendar 
	 */
	public void calendarCustomProduct(CalendarCustom calendarCustom) {
		cmdBack(calendarCustom);
		cmdNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		cmdNext.setContentAreaFilled(false);
		cmdNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

	/**
	 * Sets JLayeredPane jLayeredPane1.
	 *
	 * @param calendarCustom the custom calendar
	 */
	public void jLayeredPane1(CalendarCustom calendarCustom) {
		calendarCustomProduct(calendarCustom);
		jLayeredPane1 = new javax.swing.JLayeredPane();
		jLayeredPane1.setLayer(cmdBack, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.setLayer(calendarCustomProduct.getLbMonthYear(), javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLayeredPane1.setLayer(cmdNext, javax.swing.JLayeredPane.DEFAULT_LAYER);
		javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
		jLayeredPane1.setLayout(jLayeredPane1Layout);
		jLayeredPane1Layout.setHorizontalGroup(jLayeredPane1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jLayeredPane1Layout.createSequentialGroup().addContainerGap()
						.addComponent(cmdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(calendarCustomProduct.getLbMonthYear(), javax.swing.GroupLayout.DEFAULT_SIZE, 264,
								Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cmdNext,
								javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jLayeredPane1Layout.setVerticalGroup(jLayeredPane1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jLayeredPane1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(cmdBack, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(calendarCustomProduct.getLbMonthYear(),
										javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(cmdNext, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
	}

	/**
	 * Sets JButton cmdBack.
	 *
	 * @param calendarCustom the calendar custom
	 */
	public void cmdBack(final CalendarCustom calendarCustom) {
		calendarCustom.setSlide(new MonthCalendar.PanelSlide());
		cmdBack = new javax.swing.JButton("<");
		calendarCustomProduct.setLbMonthYear(new javax.swing.JLabel());
		cmdNext = new javax.swing.JButton(">");
		cmdBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		cmdBack.setContentAreaFilled(false);
		cmdBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		cmdBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				calendarCustomProduct.cmdBackActionPerformed(evt, calendarCustom.getSlide());
			}
		});
		cmdNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				calendarCustomProduct.cmdNextActionPerformed(evt, calendarCustom.getSlide());
			}
		});
	}
}