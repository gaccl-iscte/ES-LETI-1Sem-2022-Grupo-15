package ES_2022_LETI_Grupo_15.Projeto_ES;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;



public class GUI extends JFrame implements ActionListener {

	JButton submit;
	JButton file;
	JTextField textField;

	GUI(){		

		ImageIcon image = new ImageIcon("iscte_logo.png");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(Color.darkGray);


		textField = new JTextField();
		textField.setPreferredSize(new Dimension(500,40));
		textField.setFont(new Font("Arial", Font.PLAIN, 35));
		this.add(textField);
		this.pack();
		this.setVisible(true);

		submit = new JButton("Submit");
		submit.setBounds(200, 100, 100, 50);
		submit.setSize(200, 200);
		submit.addActionListener(this);	
		this.setVisible(true);
		this.add(submit);

		file = new JButton("Select File");
		file.setSize(200, 200);
		file.setLocation(800, 400);
		file.addActionListener(this);
		this.setVisible(true);
		this.add(file);

		this.setTitle("Meeting planner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600,600);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == submit) {
				try {
					toTxt.convert(textField.getText(), "C:\\Users\\Asus\\Desktop\\testeICS.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		if(e.getSource() == file) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            try {
                toTxt.convert(fileChooser.getSelectedFile(), "C:\\Users\\Asus\\Desktop\\testeICS.txt");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
	}
}
