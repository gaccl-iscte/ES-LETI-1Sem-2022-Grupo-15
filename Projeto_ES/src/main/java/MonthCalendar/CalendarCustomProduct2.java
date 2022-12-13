package MonthCalendar;


import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.BorderFactory;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;

public class CalendarCustomProduct2 implements Serializable {
	private CalendarCustomProduct calendarCustomProduct = new CalendarCustomProduct();
	private javax.swing.JButton cmdBack;
	private javax.swing.JButton cmdNext;
	private javax.swing.JLayeredPane jLayeredPane1;

	public CalendarCustomProduct getCalendarCustomProduct() {
		return calendarCustomProduct;
	}

	public javax.swing.JLayeredPane getJLayeredPane1() {
		return jLayeredPane1;
	}

	public void calendarCustomProduct(CalendarCustom calendarCustom) {
		cmdBack(calendarCustom);
		cmdNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		cmdNext.setContentAreaFilled(false);
		cmdNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}

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