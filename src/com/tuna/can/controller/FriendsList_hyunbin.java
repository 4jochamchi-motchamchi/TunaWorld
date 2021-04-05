package com.tuna.can.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

class FriendsList_hyunbin implements ActionListener {
	
	private JButton button;
	private JLabel label;
	private ImageIcon photo;
	
	public FriendsList_hyunbin(ImageIcon photo, JLabel label, JButton button) {
		this.photo = photo;
		this.label = label;
		this.button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == button) {
			label.setText("드디어 버튼이 눌려졌습니다");
		}
	}
	
}
