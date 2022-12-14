
package Menu;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import MonthCalendar.Main;
import DayCalendar.DayCalendarTest;
import ES_2022_LETI_Grupo_15.Projeto_ES.txtToObject;
import WeekCalendar.WeekCalendarTest;

/**
 * The Class Members.
 */
public class Members extends JFrame implements ActionListener{

	/** The JLabel's in use. */
	JLabel lblmembers, lblselect, lblcalendar;
	
	/** The JButton's in use. */
	JButton mensal, semanal, diario, back, txt;
	
	/** The JComboBox to select members. */
	JComboBox<String> members = new JComboBox<String>();

	/**
	 * Instantiates a new members.
	 */
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
		
		txt = new JButton("Ver txt");
		txt.addActionListener(this);
		Dimension sizetxt = txt.getPreferredSize();
		txt.setBounds(360, 10, 100, sizetxt.height);
		this.add(txt);

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

	/**
	 * Action performed.
	 *
	 * @param e the action performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> member = new ArrayList<String>();
		ArrayList<String> file = new ArrayList<String>();
		if(e.getSource() == back) {
			this.setVisible(false);
			Metting.getInstance().getFrameInstance().setVisible(true);
		}else if(e.getSource() == mensal) {
			try {
				member.clear();
				file.clear();
				member.add((String) members.getSelectedItem());
				file.add(AddMember.files2.get(members.getSelectedIndex()));
				new Main(txtToObject.getList(file, member), member);
			} catch (FileNotFoundException | ParseException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == semanal) {
			try {
				member.clear();
				file.clear();
				member.add((String) members.getSelectedItem());
				file.add(AddMember.files2.get(members.getSelectedIndex()));
				new WeekCalendarTest(txtToObject.getList(file, member));
			} catch (FileNotFoundException | ParseException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == diario) {
			try {
				member.clear();
				file.clear();
				member.add((String) members.getSelectedItem());
				file.add(AddMember.files2.get(members.getSelectedIndex()));
				new DayCalendarTest(txtToObject.getList(file, member), LocalDate.now());
			} catch (FileNotFoundException | ParseException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource() == txt) {
			try {
				member.clear();
				file.clear();
				member.add((String) members.getSelectedItem());
				file.add(AddMember.files2.get(members.getSelectedIndex()));
				txtToObject.getList(file, member);
				Desktop.getDesktop().open(new File("HorárioIndividual.txt"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
	}

}
