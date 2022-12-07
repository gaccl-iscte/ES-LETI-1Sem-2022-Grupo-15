package MonthCalendar;

import javax.swing.JPanel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarCustom extends javax.swing.JPanel {

    private int month;
    private int year;

    public CalendarCustom() {
        initComponents();
        thisMonth();
        slide.show(new PanelDate(5, 2021), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slide = new MonthCalendar.PanelSlide();
        lbTime = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        cmdBack = new javax.swing.JButton("<");
        lbMonthYear = new javax.swing.JLabel();
        cmdNext = new javax.swing.JButton(">");
        
        setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        lbTime.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        lbTime.setForeground(new java.awt.Color(201, 201, 201));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTime.setText("9:32:00");

        lbType.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        lbType.setForeground(new java.awt.Color(201, 201, 201));
        lbType.setText("PM");

        lbDate.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbDate.setForeground(new java.awt.Color(201, 201, 201));
        lbDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDate.setText("Sunday, 30/05/2021");

        cmdBack.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdBack.setContentAreaFilled(false);
        cmdBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackActionPerformed(evt);
            }
        });

        lbMonthYear.setFont(new java.awt.Font("sansserif", 1, 30)); // NOI18N
        lbMonthYear.setForeground(new java.awt.Color(0, 0, 0));
        lbMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMonthYear.setText("Month - Year");

        //cmdNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        cmdNext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmdNext.setContentAreaFilled(false);
        cmdNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNextActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(cmdBack, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbMonthYear, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(cmdNext, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMonthYear, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdNext, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMonthYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                //.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slide, 1000, 1000, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide, 850, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNextActionPerformed
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_LEFT);
        showMonthYear();
    }//GEN-LAST:event_cmdNextActionPerformed

    private void cmdBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBackActionPerformed
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }
        slide.show(new PanelDate(month, year), PanelSlide.AnimateType.TO_RIGHT);
        showMonthYear();
    }//GEN-LAST:event_cmdBackActionPerformed

    private void thisMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());   //  today
        month = calendar.get(Calendar.MONTH) + 1;
        year = calendar.get(Calendar.YEAR);
    }

    private void showMonthYear() {
    	String[] months =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        lbMonthYear.setText(months[month-1] + " - " +df.format(calendar.getTime()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBack;
    private javax.swing.JButton cmdNext;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbMonthYear;
    private javax.swing.JLabel lbTime;
    private javax.swing.JLabel lbType;
    private MonthCalendar.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
