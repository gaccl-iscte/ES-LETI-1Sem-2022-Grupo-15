package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;

import DayCalendar.DayCalendarTest;
import ES_2022_LETI_Grupo_15.Projeto_ES.txtToObject;
import MonthCalendar.Main;
import WeekCalendar.WeekCalendarTest;

public class Metting extends JFrame implements ActionListener{

	JLabel lblmetting, lblproposta, lbldata, lblcalendar;
	JButton back, mensal, semanal, diario, members;
	public static Metting instance;

	public static Metting getInstance() {
		if(instance == null) 
			instance = new Metting();
		return instance;
	}

	Metting(){
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

		lblmetting = new JLabel("Reunião:");
		lblmetting.setFont(new Font("Arial", Font.BOLD, 20));
		lblmetting.setForeground(Color.WHITE);		
		Dimension sizelblmetting = lblmetting.getPreferredSize();
		lblmetting.setBounds(200, 10, sizelblmetting.width, sizelblmetting.height);
		this.add(lblmetting);		

		if(!GenerateMetting.periodicidade.isVisible() || GenerateMetting.periodicidade.getSelectedItem().equals((Object) "Uma vez")) {

			lblproposta = new JLabel("Reunião proposta para:");
			lblproposta.setFont(new Font("Arial", Font.PLAIN, 20));
			lblproposta.setForeground(Color.WHITE);	
			Dimension sizelblproposta = lblproposta.getPreferredSize();
			lblproposta.setBounds(140, 100, sizelblproposta.width, sizelblproposta.height);
			this.add(lblproposta);

			String proposta = txtToObject.reuniaoFinal.toString();
			String[] split = proposta.split(" ");
			lbldata = new JLabel(split[0] + " " + split[1] + " " + split[2]);
			lbldata.setFont(new Font("Arial", Font.PLAIN, 20));
			lbldata.setForeground(Color.WHITE);	
			Dimension sizelbldata = lbldata.getPreferredSize();
			lbldata.setBounds(100, 130, sizelbldata.width, sizelbldata.height);
			this.add(lbldata);		
		}
		members = new JButton("Ver Membros");
		members.addActionListener(this);
		Dimension sizemembers = members.getPreferredSize();
		members.setBounds(165, 190, 150, sizemembers.height);
		this.add(members);

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
		if(e.getSource() == mensal) {

			new Main(GenerateMetting.events, AddMember.nomesMetting);

		}else if(e.getSource() == semanal) {

			try {
				new WeekCalendarTest(GenerateMetting.events);
			} catch (FileNotFoundException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else if(e.getSource() == diario) {		

			try {
				new DayCalendarTest(GenerateMetting.events, LocalDate.now());
			} catch (FileNotFoundException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else if(e.getSource() == members) {

			new Members();
			this.setVisible(false);

		}else if(e.getSource() == back) {

			this.setVisible(false);
			try {
				GenerateMetting.getInstance().getFrameInstance().setVisible(true);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public JFrame getFrameInstance() {
		return this;
	}
}
