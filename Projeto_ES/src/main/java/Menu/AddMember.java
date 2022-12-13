package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import ES_2022_LETI_Grupo_15.Projeto_ES.toTxt;
import ES_2022_LETI_Grupo_15.Projeto_ES.txtToObject;


public class AddMember extends JFrame implements ActionListener{

	JTextField url, nome, apelido;
	JLabel lblurl, lblnome, lblapelido, lblmembers, lblmetting;
	JButton file, adicionar;
	JCheckBox metting;
	int i;
	File file1;
	public static ArrayList<String> files = new ArrayList<String>();
	public static ArrayList<String> nomes = new ArrayList<String>();
	public static ArrayList<String> files2 = new ArrayList<String>();
	public static ArrayList<String> filesMetting = new ArrayList<String>();
	public static ArrayList<String> nomesMetting = new ArrayList<String>();
	public static ArrayList<String> files2Metting = new ArrayList<String>();

	AddMember(int i){
		this.i = i;
		ImageIcon image = new ImageIcon("iscte_logo.png");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(Color.darkGray);
		this.setTitle("Members");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension ( 500, 400 );
		this.setBounds(ss.width / 2 - frameSize.width / 2, ss.height / 2 - frameSize.height / 2, frameSize.width, frameSize.height );
		this.setLayout(null);

		lblmembers = new JLabel("Membro nº"+i);
		lblmembers.setFont(new Font("Arial", Font.BOLD, 20));
		lblmembers.setForeground(Color.WHITE);
		Dimension sizelblmembers = lblmembers.getPreferredSize();
		lblmembers.setBounds(190, 10, sizelblmembers.width, sizelblmembers.height);
		this.add(lblmembers);

		lblurl = new JLabel("URL:");
		lblurl.setFont(new Font("Arial", Font.PLAIN, 20));
		lblurl.setForeground(Color.WHITE);	
		Dimension sizelblurl = lblurl.getPreferredSize();
		lblurl.setBounds(10, 70, sizelblurl.width, sizelblurl.height);
		this.add(lblurl);

		url = new JTextField();
		url.setFont(new Font("Arial", Font.PLAIN, 17));
		Dimension sizeurl = url.getPreferredSize();
		url.setBounds(sizelblurl.width+30, 70, 300, sizeurl.height);
		this.add(url);

		file = new JButton();
		file.setIcon(new ImageIcon("note.png"));
		Dimension sizefile = file.getPreferredSize();
		file.setBounds(350+sizelblurl.width, 70, sizefile.width, sizefile.height);
		file.addActionListener(this);
		this.add(file);

		lblnome = new JLabel("Primeiro Nome:");
		lblnome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblnome.setForeground(Color.WHITE);
		Dimension sizelblnome = lblnome.getPreferredSize();
		lblnome.setBounds(10, 120, sizelblnome.width, sizelblnome.height);
		this.add(lblnome);

		nome = new JTextField();
		nome.setFont(new Font("Arial", Font.PLAIN, 17));
		Dimension sizenome = nome.getPreferredSize();
		nome.setBounds(sizelblnome.width+30, 120, 100, sizenome.height);
		this.add(nome);

		lblapelido = new JLabel("Último Nome:");
		lblapelido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblapelido.setForeground(Color.WHITE);
		Dimension sizelblapelido = lblapelido.getPreferredSize();
		lblapelido.setBounds(10, 170, sizelblapelido.width, sizelblapelido.height);
		this.add(lblapelido);

		apelido = new JTextField();
		apelido.setFont(new Font("Arial", Font.PLAIN, 17));
		Dimension sizeapelido = apelido.getPreferredSize();
		apelido.setBounds(sizelblnome.width+30, 170, 100, sizeapelido.height);
		this.add(apelido);

		lblmetting = new JLabel("Adicionar à reunião:");
		lblmetting.setFont(new Font("Arial", Font.PLAIN, 20));
		lblmetting.setForeground(Color.WHITE);
		Dimension sizelblmetting = lblmetting.getPreferredSize();
		lblmetting.setBounds(10, 220, sizelblmetting.width, sizelblmetting.height);
		this.add(lblmetting);

		metting = new JCheckBox();
		metting.setBackground(Color.DARK_GRAY);
		Dimension sizemetting = metting.getPreferredSize();
		metting.setBounds(sizelblmetting.width+20, 223, sizemetting.width, sizemetting.height);
		this.add(metting);

		adicionar = new JButton("Adicionar");
		adicionar.addActionListener(this);
		Dimension sizeadicionar = adicionar.getPreferredSize();
		adicionar.setBounds(200, 300, sizeadicionar.width, sizeadicionar.height);
		this.add(adicionar);

		this.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if( e.getSource() == adicionar) {

			this.setVisible(false);

			String name = nome.getText();
			String lastname = apelido.getText();
			String link = url.getText();
			link = link.replace("webcal", "https");
			String file = lastname+".txt";

			try {
				try {
					toTxt.convert(link, file);
				} catch (IOException e1){
					toTxt.convert(file1, file);
				}
				files.add(file);
				nomes.add(name+" "+lastname);
				if(metting.isSelected()) {
					filesMetting.add(file);
					nomesMetting.add(name+" "+lastname);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			if(i==1) {
				try {
					files2Metting = txtToObject.convert(filesMetting, nomesMetting);					
					files2 = txtToObject.convert(files, nomes);

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					new GenerateMetting();
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(e.getSource() == file) {
			JFileChooser fileChooser = new JFileChooser();
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				file1 = new File(fileChooser.getSelectedFile().getAbsolutePath());				
			}
		}
	}
}