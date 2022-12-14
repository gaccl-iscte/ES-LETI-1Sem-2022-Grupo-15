
package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.BadLocationException;
import org.jdesktop.swingx.JXDatePicker;

import Calendar.CalendarEvent;
import ES_2022_LETI_Grupo_15.Projeto_ES.txtToObject;

/**
 * The Class GenerateMetting.
 */
public class GenerateMetting extends JFrame implements ActionListener{

	/** The JLabel's in use. */
	JLabel lblmetting, lblperiodicidade, lbltempo, lblduracao, lbldata, lblhora, lblsemanas;

	/** The JComboBox to select periodicity. */
	static JComboBox<String> periodicidade = new JComboBox<String>();

	/** The JComboBox to select time of day. */
	JComboBox<String> tempo = new JComboBox<String>();

	/** The JComboBox to select number of weeks. */
	JComboBox<Integer> semanas = new JComboBox<Integer>();

	/** The JButton's in use. */
	JButton gerar, auto, manual;

	/** The JSpinner's in use. */
	JSpinner duracao, hora;

	/** The JXDatePicker to select a date. */
	JXDatePicker data;

	/** The instance. */
	public static GenerateMetting instance;

	/** The list of events. */
	static ArrayList<CalendarEvent> events;

	/**
	 * Gets the single instance of GenerateMetting.
	 *
	 * @return single instance of GenerateMetting
	 * @throws BadLocationException the bad location exception
	 */
	public static GenerateMetting getInstance() throws BadLocationException {
		if(instance == null) 
			instance = new GenerateMetting();
		return instance;
	}

	/**
	 * Instantiates a new generate metting.
	 *
	 * @throws BadLocationException the bad location exception
	 */
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
		periodicidade.insertItemAt("Uma vez", 0);
		periodicidade.insertItemAt("Semanal", 1);
		periodicidade.setVisible(false);

		lblsemanas = new JLabel("Nº Semanas:");
		lblsemanas.setFont(new Font("Arial", Font.PLAIN, 20));
		lblsemanas.setForeground(Color.WHITE);
		Dimension sizelblsemanas = lblsemanas.getPreferredSize();
		lblsemanas.setBounds(270, 110, sizelblsemanas.width, sizelblsemanas.height);
		this.add(lblsemanas);
		lblsemanas.setVisible(false);

		semanas.addActionListener(this);
		semanas.setBounds(400, 110, 50, 25);		
		this.add(semanas);
		for(int i=0; i<15; i++) {
			semanas.insertItemAt(i+1, i);
		}
		semanas.setVisible(false);

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
		data.setBounds(170, 180, 120, sizedata.height);
		this.add(data);
		data.setVisible(false);	

		lblhora = new JLabel("Hora:");
		lblhora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblhora.setForeground(Color.WHITE);	
		Dimension sizelblhora = lblhora.getPreferredSize();
		lblhora.setBounds(30, 110, sizelblhora.width, sizelblhora.height);
		this.add(lblhora);
		lblhora.setVisible(false);		

		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.SECOND);
		hora = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(hora, "HH:mm");
		de.getTextField().setEditable( false );
		hora.setEditor(de);
		Dimension sizehora = hora.getPreferredSize();
		hora.setBounds(170, 110, sizehora.width, 25);
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

	/** The time format. */
	SimpleDateFormat format = new SimpleDateFormat("HH:mm");

	/** The date format. */
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");


	/**
	 * Action performed.
	 *
	 * @param e the action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		data(e);
		if(e.getSource() == gerar) {

			String horas = null;
			horas = format.format(duracao.getValue());
			if(data.isVisible()) {

				if(hora.getValue() == null || data.getDate() == null) {
					JOptionPane.showMessageDialog(null,"Informação insuficiente!");
					return;
				}

				if(data.getDate().toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate().getDayOfWeek() == DayOfWeek.SUNDAY 
						|| data.getDate().toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate().getDayOfWeek() == DayOfWeek.SATURDAY) {
					JOptionPane.showMessageDialog(null,"Selecione um dia útil!");
					return;
				}

				String horasI = null;
				String dia = null;
				horasI = format.format(hora.getValue());
				dia = format1.format(data.getDate());

				LocalTime horaFinal = LocalTime.parse(horasI).plusMinutes(LocalTime.parse(horas).get(ChronoField.MINUTE_OF_DAY));

				if(horaFinal.isAfter(LocalTime.of(20, 00))) {
					JOptionPane.showMessageDialog(null,"Reunião ultrapassa as 20:00!");
					return;
				}

				try {
					events = txtToObject.addEvent(txtToObject.getList(AddMember.files2Metting, AddMember.nomesMetting), AddMember.nomesMetting, dia, horasI, horas);
					new Metting();
					this.setVisible(false);
				} catch (FileNotFoundException | ParseException e1) {
					e1.printStackTrace();
				}

			}else {

				if(periodicidade.getSelectedItem() == null || tempo.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null,"Informação incompleta!");
					return;
				}

				if(periodicidade.getSelectedItem().equals((Object) "Uma vez")){
					try {
						events = txtToObject.findBestTime(txtToObject.getList(AddMember.files2Metting, AddMember.nomesMetting), horas, tempo.getSelectedItem().toString(), AddMember.nomesMetting, LocalDate.now());
						new Metting();
						this.setVisible(false);
					} catch (FileNotFoundException | ParseException e1) {
						e1.printStackTrace();
					}
				}else if (periodicidade.getSelectedItem().equals((Object) "Semanal")){
					try {
						events = txtToObject.periodicity(txtToObject.getList(AddMember.files2Metting, AddMember.nomesMetting), AddMember.nomesMetting, LocalDate.now(), semanas.getSelectedIndex() + 1, horas, tempo.getSelectedItem().toString());
						new Metting();
						this.setVisible(false);
					} catch (FileNotFoundException | ParseException e1) {
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
			lbldata.setVisible(false);
			lblhora.setVisible(false);
			hora.setVisible(false);
		}else if(e.getSource() == manual) {
			lbltempo.setVisible(false);
			tempo.setVisible(false);
			lblperiodicidade.setVisible(false);
			periodicidade.setVisible(false);	
			lblsemanas.setVisible(false);
			semanas.setVisible(false);
			lblduracao.setVisible(true);
			duracao.setVisible(true);
			lbldata.setVisible(true);
			lblhora.setVisible(true);
			hora.setVisible(true);
		}else if(e.getSource() == periodicidade) {
			if(periodicidade.getSelectedItem().equals((Object) "Semanal")){
				lblsemanas.setVisible(true);
				semanas.setVisible(true);
			}else if(periodicidade.getSelectedItem().equals((Object) "Uma vez")) {
				lblsemanas.setVisible(false);
				semanas.setVisible(false);
			}
		}
	}

	/**
	 * Sets data visible.
	 *
	 * @param e the action performed
	 */
	private void data(ActionEvent e) {
		if (e.getSource() == gerar) {
		} else if (e.getSource() == auto) {
			gerar.setVisible(true);
			data.setVisible(false);
		} else if (e.getSource() == manual) {
			gerar.setVisible(true);
			data.setVisible(true);
		}
	}

	/**
	 * Gets the frame instance.
	 *
	 * @return the frame instance
	 */
	public JFrame getFrameInstance() {
		return this;
	}
}
