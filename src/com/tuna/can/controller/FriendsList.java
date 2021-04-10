package com.tuna.can.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.tuna.can.model.dto.FriendDTO;

public class FriendsList extends JPanel implements ActionListener {
	
	private int number;
	private JButton button;
	private JPanel friendsPanel;
	private JLabel nickName;

	
	
	
	public FriendsList() {
		super();
	}

	public FriendsList(int number) {
		this.number = number;
		
		
		List<FriendDTO> friends = new ArrayList<FriendDTO>();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);	
		TunaController controller = new TunaController();
		Border button2 = BorderFactory.createLineBorder(new Color(255, 240, 245));
		friends = controller.selectFriendsList(1);
		
		FriendDTO friend = new FriendDTO();
		friend = friends.get(number);
		
		friendsPanel = new JPanel();
		friendsPanel.setBackground(Color.WHITE);
		friendsPanel.setLayout(null);
		friendsPanel.setBorder(border);
		friendsPanel.setBounds(0,(number * 100),665,100);
		friendsPanel.setBackground(new Color(255, 240, 245));

		
		JLabel nickName = new JLabel(friend.getFriendsNickname());
		nickName.setLayout(null);
		nickName.setBounds(310, 27, 700, 50);
		friendsPanel.add(nickName);
//		mf.add(friends);
//		ImageIcon photo = new ImageIcon(friend.getImage());
		
		JLabel imageLabel = new JLabel();
		imageLabel.setLayout(null);
		imageLabel.setBounds(57,27,72,60);
		friendsPanel.add(imageLabel);
		
		ImageIcon delete = new ImageIcon("image/delete.png");
		ImageIcon deletered = new ImageIcon("image/deleteRed.png");
		
		JButton button = new JButton(delete);
//		button.setLayout(null);
		button.setBackground(new Color(255, 240, 245));
		button.setBorder(button2);
		button.setBounds(550,27,90,40);
		button.setRolloverIcon(deletered);
//		button.addActionListener(new com.tuna.can.controller.FriendsList(i, button, friendsPanel, nickName));
		
		friendsPanel.add(button);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == button) {
			
			button.setEnabled(false);
		}
	}
	
}