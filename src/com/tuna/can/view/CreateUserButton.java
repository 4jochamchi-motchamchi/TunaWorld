package com.tuna.can.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreateUserButton implements ActionListener {

	private JButton createUserBtn;
	
	public CreateUserButton() {}
	
	
	public CreateUserButton(JButton createUserBtn) {
		super();
		this.createUserBtn = createUserBtn;
	}
	public static void changePanel(JFrame jf, JPanel oldp, JPanel newp) {
		jf.remove(oldp);
		jf.add(newp);
		jf.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createUserBtn) {
		
			signUp.show
		
	}
		
	}

}
