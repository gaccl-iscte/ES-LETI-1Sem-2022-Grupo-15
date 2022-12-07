package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import DayCalendar.DayCalendarTest;
import MonthCalendar.Main;
import WeekCalendar.WeekCalendarTest;

public class Members extends JFrame implements ActionListener{

	JLabel lblmembers, lblselect, lblcalendar;
	JButton mensal, semanal, diario, back;
	JComboBox<String> members = new JComboBox<String>();

	Members(){
		ImageIcon image = new ImageIcon("iscte_logo.png");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(Color.darkGray);
		this.setTitle("Metting");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);		
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 500, 400 );
		this.setBounds(ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		this.setLayout(null);

		back = new JButton("Back");
		back.addActionListener(this);
		Dimension sizeBack = back.getPreferredSize();
		back.setBounds(10, 10, sizeBack.width, sizeBack.height);
		this.add(back);

		lblmembers = new JLabel("Membros");
		lblmembers.setFont(new Font("Arial", Font.BOLD, 20));
		lblmembers.setForeground(Color.WHITE);		
		Dimension sizelblmembers = lblmembers.getPreferredSize();
		lblmembers.setBounds(frameSize.width / 2 - sizelblmembers.width / 2, 10, sizelblmembers.width, sizelblmembers.height);
		this.add(lblmembers);	

		lblselect = new JLabel("Selecionar Membro:");
		lblselect.setFont(new Font("Arial", Font.PLAIN, 20));
		lblselect.setForeground(Color.WHITE);	
		Dimension sizelblselect = lblselect.getPreferredSize();
		lblselect.setBounds(frameSize.width / 2 - sizelblselect.width / 2, 100, sizelblselect.width, sizelblselect.height);
		this.add(lblselect);

		members.setBounds(frameSize.width / 2 - 75,150,150,30);
		((JLabel)members.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		this.add(members);

		for(int i = 0; i < AddMember.nomes.size(); i++) {

			members.insertItemAt(AddMember.nomes.get(i), i);
		}

		lblcalendar = new JLabel("Calendário:");
		lblcalendar.setFont(new Font("Arial", Font.PLAIN, 20));
		lblcalendar.setForeground(Color.WHITE);	
		Dimension sizelblcalendar = lblcalendar.getPreferredSize();
		lblcalendar.setBounds(10, 250, sizelblcalendar.width, sizelblcalendar.height);
		this.add(lblcalendar);

		mensal = new JButton("Mensal");
		mensal.addActionListener(this);
		Dimension sizemensal = mensal.getPreferredSize();
		mensal.setBounds(20, 280, 100, sizemensal.height);
		this.add(mensal);

		semanal = new JButton("Semanal");
		semanal.addActionListener(this);
		Dimension sizesemanal = semanal.getPreferredSize();
		semanal.setBounds(190, 280, 100, sizesemanal.height);
		this.add(semanal);

		diario = new JButton("Diário");
		diario.addActionListener(this);
		Dimension sizediario = diario.getPreferredSize();
		diario.setBounds(360, 280, 100, sizediario.height);
		this.add(diario);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<String> member = new ArrayList<String>();
		ArrayList<String> file = new ArrayList<String>();
		if(e.getSource() == back) {
			this.setVisible(false);
			Metting.getInstance().getFrameInstance().setVisible(true);
		}else if(e.getSource() == mensal) {
			new Main();
		}else if(e.getSource() == semanal) {
			try {
				member.add((String) members.getSelectedItem());
				file.add(AddMember.files2.get(members.getSelectedIndex()));
				new WeekCalendarTest(file, member);
				file.remove(0);
				member.remove(0);
			} catch (FileNotFoundException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == diario) {
			try {
				member.add((String) members.getSelectedItem());
				file.add(AddMember.files2.get(members.getSelectedIndex()));
				new DayCalendarTest(file, member);
				file.remove(0);
				member.remove(0);
			} catch (FileNotFoundException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
