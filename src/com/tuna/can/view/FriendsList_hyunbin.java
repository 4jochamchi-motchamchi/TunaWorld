package com.tuna.can.view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class FriendsList_hyunbin {

	public static void main(String[] args) {

		// 미니 창 이름 설정
		JFrame mf = new JFrame("Friend List");
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);	
		mf.setLayout(null);
		mf.setSize(700, 900);
		
		try {
			mf.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 상단 판넬
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0,0,700,100);
		topPanel.setBackground(Color.pink);
		
		// 상단 라벨
		JLabel topLabel = new JLabel("친구 목록");
		topLabel.setLayout(null);
		topLabel.setBounds(270, 27, 700, 50);
		topLabel.setFont(new Font("친구 목록" ,Font.BOLD, 30));
		
		// 상단 판넬에 라벨 
		topPanel.add(topLabel);
		
		// 뒤로 가기 버튼
		
		ImageIcon home = new ImageIcon("image/home.PNG");
		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
		JButton backB = new JButton(home);
		backB.setBounds(30, 25, 55, 55);
		backB.setBackground(Color.pink);
		backB.setBorder(pinkborder);
		topPanel.add(backB);
		
		/*------------------------------------------------------------------------------------------*/
		
		for(int i = 1; i < 7; i++) {
			
			JPanel friends = new JPanel();
			friends.setLayout(null);
			friends.setBounds(0, 100 * i,700,100 );
			friends.setBorder(border);
//			friends.setBackground(Color.pink);
			
			
			JLabel nickName = new JLabel("다라미");
			nickName.setLayout(null);
			nickName.setBounds(310, 27, 700, 50);
			friends.add(nickName);
			mf.add(friends);
			ImageIcon photo = new ImageIcon("image/home.PNG");
			
			JLabel imageLabel = new JLabel(photo);
			imageLabel.setLayout(null);
			imageLabel.setBounds(50,27,90,40);
			friends.add(imageLabel);
			
			JButton button = new JButton("삭제");
			button.setLayout(null);
			button.setBounds(550,27,90,40);
			friends.add(button);
			
		}
		
		/*------------------------------------------------------------------------------------------*/
		
		// 하단 판넬
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
//		bottomPanel.setLocation(0,750);
//		bottomPanel.setSize(700,150);
		bottomPanel.setBackground(Color.pink);
		
		bottomPanel.setBounds(0, 750, 700, 110);
		// 마이 프레임에 판넬 추가
		
		mf.add(topPanel);
		mf.add(bottomPanel);
		
		mf.setResizable(false);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

