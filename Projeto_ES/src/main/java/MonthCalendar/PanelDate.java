package MonthCalendar;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;

public class PanelDate extends JPanel{

	private int month, year;
	
	public PanelDate(int month, int year) {
		initComponents();
		this.month = month;
		this.year = year;
		init();
	}
	
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
            	//ADICIONAR PINTAR QUANDO OCUPADO
                cell.setText(calendar.get(Calendar.DATE) + "");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(Calendar.MONTH) == month - 1);
                if (toDay.isToDay(new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)))) {
                    cell.setAsToDay();
                }
                calendar.add(Calendar.DATE, 1); //  up 1 day
            }
        }
    }

    private ToDay getToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new ToDay(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }
	
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
        add(cell8);

        cell9.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell9);

        cell10.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell10);

        cell11.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell11);

        cell12.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell12);

        cell13.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell13);

        cell14.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell14);

        cell15.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell15);

        cell16.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell16);

        cell17.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell17);

        cell18.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell18);

        cell19.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell19);

        cell20.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell20);

        cell21.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell21);

        cell22.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell22);

        cell23.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell23);

        cell24.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell24);

        cell25.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell25);

        cell26.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell26);

        cell27.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell27);

        cell28.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell28);

        cell29.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell29);

        cell30.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell30);

        cell31.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell31);

        cell32.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell32);

        cell33.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell33);

        cell34.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell34);

        cell35.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell35);

        cell36.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell36);

        cell37.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell37);

        cell38.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell38);

        cell39.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell39);

        cell40.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell40);

        cell41.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell41);

        cell42.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell42);

        cell43.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell43);

        cell44.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell44);

        cell45.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell45);

        cell46.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell46);

        cell47.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell47);

        cell48.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell48);

        cell49.setFont(new java.awt.Font("sansserif", 0, 25)); // NOI18N
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Cell cell10;
    private Cell cell11;
    private Cell cell12;
    private Cell cell13;
    private Cell cell14;
    private Cell cell15;
    private Cell cell16;
    private Cell cell17;
    private Cell cell18;
    private Cell cell19;
    private Cell cell20;
    private Cell cell21;
    private Cell cell22;
    private Cell cell23;
    private Cell cell24;
    private Cell cell25;
    private Cell cell26;
    private Cell cell27;
    private Cell cell28;
    private Cell cell29;
    private Cell cell30;
    private Cell cell31;
    private Cell cell32;
    private Cell cell33;
    private Cell cell34;
    private Cell cell35;
    private Cell cell36;
    private Cell cell37;
    private Cell cell38;
    private Cell cell39;
    private Cell cell40;
    private Cell cell41;
    private Cell cell42;
    private Cell cell43;
    private Cell cell44;
    private Cell cell45;
    private Cell cell46;
    private Cell cell47;
    private Cell cell48;
    private Cell cell49;
    private Cell cell8;
    private Cell cell9;
    private Cell sex;
    private Cell seg;
    private Cell sab;
    private Cell dom;
    private Cell qui;
    private Cell ter;
    private Cell qua;
    // End of variables declaration//GEN-END:variables
}


