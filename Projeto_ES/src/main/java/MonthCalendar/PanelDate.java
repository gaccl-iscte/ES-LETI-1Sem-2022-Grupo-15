package MonthCalendar;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

import DayCalendar.DayCalendarTest;
import ES_2022_LETI_Grupo_15.Projeto_ES.txtToObject;
import Menu.GenerateMetting;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelDate.
 */
public class PanelDate extends JPanel{

	/** The year. */
	private int month, year;
	
	/** The cells. */
	private static ArrayList<Cell> cells = new ArrayList<>();

	/**
	 * Instantiates a new panel date.
	 *
	 * @param month the month
	 * @param year the year
	 */
	public PanelDate(int month, int year) {
		initComponents();
		this.month = month;
		this.year = year;
		init();
	}

	/**
	 * Inits the.
	 */
	private void init() {
		seg.asTitle();
		ter.asTitle();
		qua.asTitle();
		qui.asTitle();
		sex.asTitle();
		sab.asTitle();
		dom.asTitle();
		setDate();
	}

	/**
	 * Sets the date.
	 */
	private void setDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);  //  month jan as 0 so start from 0
		calendar.set(Calendar.DATE, 1);
		int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;  //  get day of week -1 to index
		calendar.add(Calendar.DATE, -startDay);
		ToDay toDay = getToDay();
		for (Component com : getComponents()) {
			Cell cell = (Cell) com;
			if (!cell.isTitle()) {
				cell.setText(calendar.get(Calendar.DATE) + "");
				cell.setDate(calendar.getTime());
				cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
				cell.setOpaque(true);
				if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
					cell.setAsToDay();
				}
				LocalDate data = cell.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int numEvents = txtToObject.getNumberEventsOfDay(Main.eventos, Main.nomes, data);
				if( numEvents >= 6) {
					cell.setBackground(new Color(0, 102, 204));
				}else if( numEvents < 6 && numEvents >= 3) {
					cell.setBackground(new Color(51, 153, 255));
				}else if( numEvents < 3 && numEvents >= 1) {
					cell.setBackground(new Color(153, 204, 255));
				}else {
					cell.setBackground(new Color(169, 169, 169));
				}
				calendar.add(Calendar.DATE, 1); //  up 1 day
			}
		}
	}

	/**
	 * Gets the to day.
	 *
	 * @return the to day
	 */
	private ToDay getToDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {

		dom = new Cell();   
		dom.setBackground(Color.RED);
		seg = new Cell();
		ter = new Cell();
		qua = new Cell();
		qui = new Cell();
		sex = new Cell();
		sab = new Cell();
		cell8 = new Cell();
		cell9 = new Cell();
		cell10 = new Cell();
		cell11 = new Cell();
		cell12 = new Cell();
		cell13 = new Cell();
		cell14 = new Cell();
		cell15 = new Cell();
		cell16 = new Cell();
		cell17 = new Cell();
		cell18 = new Cell();
		cell19 = new Cell();
		cell20 = new Cell();
		cell21 = new Cell();
		cell22 = new Cell();
		cell23 = new Cell();
		cell24 = new Cell();
		cell25 = new Cell();
		cell26 = new Cell();
		cell27 = new Cell();
		cell28 = new Cell();
		cell29 = new Cell();
		cell30 = new Cell();
		cell31 = new Cell();
		cell32 = new Cell();
		cell33 = new Cell();
		cell34 = new Cell();
		cell35 = new Cell();
		cell36 = new Cell();
		cell37 = new Cell();
		cell38 = new Cell();
		cell39 = new Cell();
		cell40 = new Cell();
		cell41 = new Cell();
		cell42 = new Cell();
		cell43 = new Cell();
		cell44 = new Cell();
		cell45 = new Cell();
		cell46 = new Cell();
		cell47 = new Cell();
		cell48 = new Cell();
		cell49 = new Cell();
		
		setLayout(new java.awt.GridLayout(7, 7));

		dom.setForeground(new java.awt.Color(222, 12, 12));
		dom.setText("Dom");
		dom.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		add(dom);

		seg.setText("Seg");
		seg.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		add(seg);

		ter.setText("Ter");
		ter.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		add(ter);

		qua.setText("Qua");
		qua.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		add(qua);

		qui.setText("Qui");
		qui.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		add(qui);

		sex.setText("Sex");
		sex.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		add(sex);

		sab.setForeground(new java.awt.Color(222, 12, 12));
		sab.setText("Sab");       
		sab.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		add(sab);

		cell8.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell8.addActionListener(new open());
		add(cell8);
		cells.add(cell8);

		cell9.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell9.addActionListener(new open());
		add(cell9);
		cells.add(cell9);

		cell10.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell10.addActionListener(new open());
		add(cell10);
		cells.add(cell10);

		cell11.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell11.addActionListener(new open());
		add(cell11);
		cells.add(cell11);

		cell12.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell12.addActionListener(new open());
		add(cell12);
		cells.add(cell12);

		cell13.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell13.addActionListener(new open());
		add(cell13);
		cells.add(cell13);

		cell14.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell14.addActionListener(new open());
		add(cell14);
		cells.add(cell14);

		cell15.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell15.addActionListener(new open());
		add(cell15);
		cells.add(cell15);

		cell16.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell16.addActionListener(new open());
		add(cell16);
		cells.add(cell16);

		cell17.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell17.addActionListener(new open());
		add(cell17);
		cells.add(cell17);

		cell18.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell18.addActionListener(new open());
		add(cell18);
		cells.add(cell18);

		cell19.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell19.addActionListener(new open());
		add(cell19);
		cells.add(cell19);

		cell20.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell20.addActionListener(new open());
		add(cell20);
		cells.add(cell20);

		cell21.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell21.addActionListener(new open());
		add(cell21);
		cells.add(cell21);

		cell22.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell22.addActionListener(new open());
		add(cell22);
		cells.add(cell22);

		cell23.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell23.addActionListener(new open());
		add(cell23);
		cells.add(cell23);

		cell24.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell24.addActionListener(new open());
		add(cell24);
		cells.add(cell24);

		cell25.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell25.addActionListener(new open());
		add(cell25);
		cells.add(cell25);

		cell26.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell26.addActionListener(new open());
		add(cell26);
		cells.add(cell26);

		cell27.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell27.addActionListener(new open());
		add(cell27);
		cells.add(cell27);

		cell28.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell28.addActionListener(new open());
		add(cell28);
		cells.add(cell28);

		cell29.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell29.addActionListener(new open());
		add(cell29);
		cells.add(cell29);

		cell30.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell30.addActionListener(new open());
		add(cell30);
		cells.add(cell30);

		cell31.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell31.addActionListener(new open());
		add(cell31);
		cells.add(cell31);

		cell32.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell32.addActionListener(new open());
		add(cell32);
		cells.add(cell32);

		cell33.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell33.addActionListener(new open());
		add(cell33);
		cells.add(cell33);

		cell34.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell34.addActionListener(new open());
		add(cell34);
		cells.add(cell34);

		cell35.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell35.addActionListener(new open());
		add(cell35);
		cells.add(cell35);

		cell36.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell36.addActionListener(new open());
		add(cell36);
		cells.add(cell36);

		cell37.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell37.addActionListener(new open());
		add(cell37);
		cells.add(cell37);

		cell38.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell38.addActionListener(new open());
		add(cell38);
		cells.add(cell38);

		cell39.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell39.addActionListener(new open());
		add(cell39);
		cells.add(cell39);

		cell40.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell40.addActionListener(new open());
		add(cell40);
		cells.add(cell40);

		cell41.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell41.addActionListener(new open());
		add(cell41);
		cells.add(cell41);

		cell42.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell42.addActionListener(new open());
		add(cell42);
		cells.add(cell42);

		cell43.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell43.addActionListener(new open());
		add(cell43);
		cells.add(cell43);

		cell44.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell44.addActionListener(new open());
		add(cell44);
		cells.add(cell44);

		cell45.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell45.addActionListener(new open());
		add(cell45);
		cells.add(cell45);

		cell46.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell46.addActionListener(new open());
		add(cell46);
		cells.add(cell46);

		cell47.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell47.addActionListener(new open());
		add(cell47);
		cells.add(cell47);

		cell48.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell48.addActionListener(new open());
		add(cell48);
		cells.add(cell48);

		cell49.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
		cell49.addActionListener(new open());
		add(cell49);
		cells.add(cell49);
	}// </editor-fold>//GEN-END:initComponents


	/** The cell 10. */
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private Cell cell10;
	
	/** The cell 11. */
	private Cell cell11;
	
	/** The cell 12. */
	private Cell cell12;
	
	/** The cell 13. */
	private Cell cell13;
	
	/** The cell 14. */
	private Cell cell14;
	
	/** The cell 15. */
	private Cell cell15;
	
	/** The cell 16. */
	private Cell cell16;
	
	/** The cell 17. */
	private Cell cell17;
	
	/** The cell 18. */
	private Cell cell18;
	
	/** The cell 19. */
	private Cell cell19;
	
	/** The cell 20. */
	private Cell cell20;
	
	/** The cell 21. */
	private Cell cell21;
	
	/** The cell 22. */
	private Cell cell22;
	
	/** The cell 23. */
	private Cell cell23;
	
	/** The cell 24. */
	private Cell cell24;
	
	/** The cell 25. */
	private Cell cell25;
	
	/** The cell 26. */
	private Cell cell26;
	
	/** The cell 27. */
	private Cell cell27;
	
	/** The cell 28. */
	private Cell cell28;
	
	/** The cell 29. */
	private Cell cell29;
	
	/** The cell 30. */
	private Cell cell30;
	
	/** The cell 31. */
	private Cell cell31;
	
	/** The cell 32. */
	private Cell cell32;
	
	/** The cell 33. */
	private Cell cell33;
	
	/** The cell 34. */
	private Cell cell34;
	
	/** The cell 35. */
	private Cell cell35;
	
	/** The cell 36. */
	private Cell cell36;
	
	/** The cell 37. */
	private Cell cell37;
	
	/** The cell 38. */
	private Cell cell38;
	
	/** The cell 39. */
	private Cell cell39;
	
	/** The cell 40. */
	private Cell cell40;
	
	/** The cell 41. */
	private Cell cell41;
	
	/** The cell 42. */
	private Cell cell42;
	
	/** The cell 43. */
	private Cell cell43;
	
	/** The cell 44. */
	private Cell cell44;
	
	/** The cell 45. */
	private Cell cell45;
	
	/** The cell 46. */
	private Cell cell46;
	
	/** The cell 47. */
	private Cell cell47;
	
	/** The cell 48. */
	private Cell cell48;
	
	/** The cell 49. */
	private Cell cell49;
	
	/** The cell 8. */
	private Cell cell8;
	
	/** The cell 9. */
	private Cell cell9;
	
	/** The sex. */
	private Cell sex;
	
	/** The seg. */
	private Cell seg;
	
	/** The sab. */
	private Cell sab;
	
	/** The dom. */
	private Cell dom;
	
	/** The qui. */
	private Cell qui;
	
	/** The ter. */
	private Cell ter;
	
	/** The qua. */
	private Cell qua;
	// End of variables declaration//GEN-END:variables

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
			for(Cell cell : cells) {
				if(e.getSource() == cell) {
					LocalDate data = cell.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					try {
						new DayCalendarTest(Main.eventos, data);
					} catch (FileNotFoundException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

}


