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
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class Main_page {
	
	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		mainFrame.setLayout(null);
		mainFrame.setTitle("MainPage");
		mainFrame.setSize(700,900);
		try {
			mainFrame.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JPanel profilePanel = new JPanel();		// 프로필사진, 닉네임 들어갈 패널
//		JPanel listPanel = new JPanel(new GridLayout(6,1));		// 다른 페이지로 넘어갈 리스트 들어갈 패널
		JPanel storePanel = new JPanel();		// 상점으로 이동할 버튼 들어갈 패널
		
		ImageIcon profileImage = new ImageIcon("image/basicprofile.PNG");		// 프로필 이미지
		ImageIcon store = new ImageIcon("image/store.PNG");
		JLabel imageLabel = new JLabel(profileImage);	// 이미지 들어갈 라벨
		JLabel nickName = new JLabel("닉네임");			// 닉네임 들어갈 라벨
		JButton button1 = new JButton("전체글보기");		// 전체글보기 버튼
		JButton button2 = new JButton("비밀글보기");		// 비밀글보기 버튼
		JButton button3 = new JButton("친구글보기");		// 친구글보기 버튼
		JButton button4 = new JButton("친구 목록");		// 친구목록 버튼
		JButton button5 = new JButton("마이페이지");		// 마이페이지 버튼
		JButton button6 = new JButton("출석게임");			// 미니게임 출석하기 버튼
		JButton storeButton = new JButton(store);		// 상점 버튼
		
		// profilePanel 설정
		profilePanel.setLayout(null);
		profilePanel.setBounds(0, 0, 700, 300);
		profilePanel.setBackground(Color.pink);
		
		// profileImage 설정
		imageLabel.setBounds(50, 30, 600, 220);
		imageLabel.setBackground(Color.pink);
		profilePanel.add(imageLabel);
		
		// nickName 설정
		nickName.setBounds(200, 250, 300, 50);
		nickName.setFont(new Font("",Font.BOLD,20));
		nickName.setHorizontalAlignment(JLabel.CENTER);
		profilePanel.add(nickName);
		
		
		
	
//------------------------------------------------		
		
		
//		// listPanel 설정
//		listPanel.setBackground(Color.pink);
////		
////		// button들 설정
		button1.setBounds(50, 0, 570, 80);
		button2.setBounds(50, 90, 570, 80);
		button3.setBounds(50, 180, 570, 80);
		button4.setBounds(50, 270, 570, 80);
		button5.setBounds(50, 360, 570, 80);
		button6.setBounds(50, 450, 570, 80);

//        // scroll 생성
//        JScrollPane scroll = new JScrollPane(listPanel);
//        scroll.setBounds(0, 300, 700, 450);
//        scroll.setPreferredSize(new Dimension(600, 450));      
      
		JPanel listPanel = new JPanel();
		listPanel.setBackground(Color.pink);
        listPanel.add(button1);
        listPanel.add(button2);
        listPanel.add(button3);
        listPanel.add(button4);
        listPanel.add(button5);
        listPanel.add(button6);
//        
//        scroll.add(listPanel);
        
        listPanel.setBounds(0, 300, 680, 450);
        listPanel.setLayout(null);

//        JScrollPane scrollPane = new JScrollPane(listPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane scrollPane = new JScrollPane(listPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 300, 685, 450);
        mainFrame.getContentPane().add(scrollPane);
		
// -----------------------------------------------------		
		
        
        
		
		// storePanel 설정
		storePanel.setLayout(null);
		storePanel.setBounds(0, 750, 700, 150);
		storePanel.setBackground(Color.pink);
		
		// storeButton 설정
		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
		storeButton.setBounds(30, 30, 55, 55);
		storeButton.setBackground(Color.pink);
		storeButton.setBorder(pinkborder);
		storePanel.add(storeButton);
		
		
		mainFrame.add(storePanel);
		mainFrame.add(profilePanel);
//		mainFrame.add(scroll);
		
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}