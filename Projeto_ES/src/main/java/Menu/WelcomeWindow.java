package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeWindow extends JFrame implements ActionListener{
	
	JLabel welcome, members;
	JComboBox<Integer> numeroMembros = new JComboBox<Integer>();

	WelcomeWindow(){
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
				
		welcome = new JLabel("Bem-vindo");
		welcome.setFont(new Font("Arial", Font.BOLD, 30));
		welcome.setForeground(Color.WHITE);
		Dimension sizewelcome = welcome.getPreferredSize();
		welcome.setBounds(165, 100, sizewelcome.width, sizewelcome.height);
		this.add(welcome);
		
		members = new JLabel("Quantos membros deseja adicionar?");
		members.setFont(new Font("Arial", Font.PLAIN, 20));
		members.setForeground(Color.WHITE);
		Dimension sizemembers = members.getPreferredSize();
		members.setBounds(80, 170, sizemembers.width, sizemembers.height);
		this.add(members);
		
        numeroMembros.addActionListener(this);
        Dimension sizenumeroMembros = numeroMembros.getPreferredSize();
        numeroMembros.setBounds(220, 220, 50, sizenumeroMembros.height);
        this.add(numeroMembros);
		for(int i=1; i<11; i++) {
			numeroMembros.insertItemAt(i, i-1);
		}
		
		
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == numeroMembros) {
			if(numeroMembros.getSelectedItem() != null) {
				this.setVisible(false);
				for(int i=1; i<(int)numeroMembros.getSelectedItem()+1; i++) {
					new AddMember(i);
				}
			}
		}
	}	
}
