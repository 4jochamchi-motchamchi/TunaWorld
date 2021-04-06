package com.tuna.can.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class FriendsList implements ActionListener {
	
	private JButton button;
	private static JScrollPane scrollbar;

	
	
	
	public FriendsList() {
		super();
	}

	public FriendsList(JButton button) {

		this.button = button;
//		this.scrollbar = scrollbar;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == button) {
			
			button.setEnabled(false);
		}
	}
	
}