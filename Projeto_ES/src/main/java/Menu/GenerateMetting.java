package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.BadLocationException;
import org.jdesktop.swingx.JXDatePicker;

import Calendar.CalendarEvent;
import ES_2022_LETI_Grupo_15.Projeto_ES.txtToObject;



public class GenerateMetting extends JFrame implements ActionListener{

	JLabel lblmetting, lblperiodicidade, lbltempo, lblduracao, lbldata, lblhora;
	JComboBox<String> periodicidade = new JComboBox<String>();
	JComboBox<String> tempo = new JComboBox<String>();
	JButton gerar, auto, manual;
	JSpinner duracao, hora;
	JXDatePicker data;
	public static GenerateMetting instance;
	static ArrayList<CalendarEvent> events;

	public static GenerateMetting getInstance() throws BadLocationException {
		if(instance == null) 
			instance = new GenerateMetting();
		return instance;
	}

	GenerateMetting() throws BadLocationException{
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

		lblmetting = new JLabel("Reunião:");
		lblmetting.setFont(new Font("Arial", Font.BOLD, 20));
		lblmetting.setForeground(Color.WHITE);	
		Dimension sizelblmetting = lblmetting.getPreferredSize();
		lblmetting.setBounds(200, 10, sizelblmetting.width, sizelblmetting.height);
		this.add(lblmetting);

		auto = new JButton("Automaticamente");
		auto.addActionListener(this);
		Dimension sizeauto = auto.getPreferredSize();
		auto.setBounds(frameSize.width / 2 - 150, 60, 150, sizeauto.height);
		this.add(auto);

		manual = new JButton("Manualmente");
		manual.addActionListener(this);
		Dimension sizemanual = manual.getPreferredSize();
		manual.setBounds(frameSize.width / 2 , 60, 150, sizemanual.height);
		this.add(manual);

		lblperiodicidade = new JLabel("Periodicidade:");
		lblperiodicidade.setFont(new Font("Arial", Font.PLAIN, 20));
		lblperiodicidade.setForeground(Color.WHITE);
		Dimension sizelblperiodicidade = lblperiodicidade.getPreferredSize();
		lblperiodicidade.setBounds(30, 110, sizelblperiodicidade.width, sizelblperiodicidade.height);
		this.add(lblperiodicidade);
		lblperiodicidade.setVisible(false);

		periodicidade.addActionListener(this);		
		periodicidade.setBounds(170, 110, 80, 25);
		this.add(periodicidade);
		periodicidade.insertItemAt("Diária", 0);
		periodicidade.insertItemAt("Semanal", 1);
		periodicidade.setVisible(false);

		lbltempo = new JLabel("Tempo do Dia:");
		lbltempo.setFont(new Font("Arial", Font.PLAIN, 20));
		lbltempo.setForeground(Color.WHITE);	
		Dimension sizelbltempo = lbltempo.getPreferredSize();
		lbltempo.setBounds(30, 180, sizelbltempo.width, sizelbltempo.height);
		this.add(lbltempo);
		lbltempo.setVisible(false);

		tempo.addActionListener(this);
		tempo.setBounds(170, 180, 80, 25);		
		this.add(tempo);
		tempo.insertItemAt("Manhã", 0);
		tempo.insertItemAt("Tarde",1);
		tempo.setVisible(false);

		lbldata = new JLabel("Data:");
		lbldata.setFont(new Font("Arial", Font.PLAIN, 20));
		lbldata.setForeground(Color.WHITE);	
		Dimension sizelbldata = lbldata.getPreferredSize();
		lbldata.setBounds(30, 180, sizelbldata.width, sizelbldata.height);
		this.add(lbldata);
		lbldata.setVisible(false);

		data = new JXDatePicker();
		data.setFont(new Font("Arial", Font.PLAIN, 18));
		Dimension sizedata = lbldata.getPreferredSize();
		data.setBounds(170, 180, 100, sizedata.height);
		this.add(data);
		data.setVisible(false);	

		lblhora = new JLabel("Hora:");
		lblhora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblhora.setForeground(Color.WHITE);	
		Dimension sizelblhora = lblhora.getPreferredSize();
		lblhora.setBounds(300, 180, sizelblhora.width, sizelblhora.height);
		this.add(lblhora);
		lblhora.setVisible(false);		

		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.SECOND);
		hora = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(hora, "HH:mm");
		de.getTextField().setEditable( false );
		hora.setEditor(de);
		Dimension sizehora = hora.getPreferredSize();
		hora.setBounds(380, 180, sizehora.width, 25);
		this.add(hora);
		hora.setVisible(false);

		lblduracao = new JLabel("Duração:");
		lblduracao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblduracao.setForeground(Color.WHITE);		
		Dimension sizelblduracao = lblduracao.getPreferredSize();
		lblduracao.setBounds(30, 250, sizelblduracao.width, sizelblduracao.height);
		this.add(lblduracao);
		lblduracao.setVisible(false);

		Date date1 = new Date();
		SpinnerDateModel sm1 = new SpinnerDateModel(date1, null, null, Calendar.SECOND);
		duracao = new JSpinner(sm1);
		JSpinner.DateEditor de1 = new JSpinner.DateEditor(duracao, "HH:mm");
		de1.getTextField().setEditable( false );
		duracao.setEditor(de1);
		Dimension sizeduracao = duracao.getPreferredSize();
		duracao.setBounds(170, 250, sizeduracao.width, 25);
		this.add(duracao);
		duracao.setVisible(false);

		gerar = new JButton("Gerar");
		gerar.addActionListener(this);
		Dimension sizegerar = gerar.getPreferredSize();
		gerar.setBounds(210, 300, sizegerar.width, sizegerar.height);
		this.add(gerar);
		gerar.setVisible(false);

		this.setVisible(true);				
	}

	SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == gerar) {
			if(!periodicidade.isVisible()) {					
					System.out.println("erro");
			}else {
				String horas = null;
				periodicidade.getSelectedItem();
				horas = format.format(duracao.getValue());
				if(data.isVisible()) {
					String horasI = null;
					String dia = null;
					horasI = format.format(hora.getValue());
					dia = format1.format(data.getDate());
					try {
						events = txtToObject.addEvent(txtToObject.getList(AddMember.files2Metting, AddMember.nomesMetting), AddMember.nomesMetting, dia, horasI, horas);
						new Metting();
						this.setVisible(false);
					} catch (FileNotFoundException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else {
					try {
						events = txtToObject.findBestTime(txtToObject.getList(AddMember.files2Metting, AddMember.nomesMetting), horas, tempo.getSelectedItem().toString(), AddMember.nomesMetting, LocalDate.now());
						new Metting();
						this.setVisible(false);
					} catch (FileNotFoundException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}else if(e.getSource() == auto) {
			lblperiodicidade.setVisible(true);
			periodicidade.setVisible(true);
			lblduracao.setVisible(true);
			duracao.setVisible(true);
			lbltempo.setVisible(true);
			tempo.setVisible(true);
			gerar.setVisible(true);
			lbldata.setVisible(false);
			data.setVisible(false);
			lblhora.setVisible(false);
			hora.setVisible(false);
		}else if(e.getSource() == manual) {
			lbltempo.setVisible(false);
			tempo.setVisible(false);
			lblperiodicidade.setVisible(true);
			periodicidade.setVisible(true);
			lblduracao.setVisible(true);
			duracao.setVisible(true);
			gerar.setVisible(true);
			lbldata.setVisible(true);
			data.setVisible(true);
			lblhora.setVisible(true);
			hora.setVisible(true);
		}
	}

	public JFrame getFrameInstance() {
		return this;
	}
}
