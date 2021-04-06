package com.tuna.can.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Store {

	public static void main(String[] args) {
		Font font = new Font("상점폰트", Font.BOLD, 50);

		JFrame frame = new JFrame("Store");
		frame.setLayout(null);
		frame.setSize(700, 900);

		// 최상단 패널
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 700, 125);
		topPanel.setBackground(Color.pink);

		// 상점 글씨
		JLabel storeLabel = new JLabel("상점~~~");
		storeLabel.setBounds(270, 40, 150, 50);
		storeLabel.setFont(font);
		topPanel.add(storeLabel);

		// 뒤로가기 버튼
		JButton backButton = new JButton("back");
		backButton.setBounds(10, 10, 90, 25);
		topPanel.add(backButton);

		//////////////////////////////////////////

		// 중간 패널
		JPanel midPanel = new JPanel();
		midPanel.setLayout(new GridLayout(1, 3));
		midPanel.setBounds(45, 170, 600, 130);
		midPanel.setBackground(Color.blue);

		JButton characterButton = new JButton("캐릭터");

		JButton backgroundButton = new JButton("배경");

		JButton fontButton = new JButton("폰트");

		midPanel.add(characterButton);
		midPanel.add(backgroundButton);
		midPanel.add(fontButton);
		
		JLabel buyLabel = new JLabel("gdgdgddd");
		buyLabel.setBounds(300, 300, 300, 50);
		buyLabel.setFont(new Font("구매폰트", Font.BOLD, 20));
		frame.add(buyLabel);
		

		////////////////////////////////////////

		// 하단 패널
//		하단 패널에 버튼 9개씩 추가하여 
//		중간 패널 버튼 클릭시 하단패널 버튼 변경
//		중간에 ~선택 ~ 구매 하시겠습니까 ~ 현재 금액 생성
		JPanel botPanel = new JPanel();
		CardLayout card = new CardLayout();
		botPanel.setLayout(card);
		botPanel.setBounds(45, 350, 600, 500);

		JPanel characterPanel = new JPanel();
		characterPanel.setLayout(new GridLayout(3,3));
		characterPanel.setBounds(45, 350, 600, 500);
		characterPanel.setBackground(Color.pink);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new GridLayout(3,3));
		backgroundPanel.setBounds(45, 350, 600, 500);
		backgroundPanel.setBackground(Color.orange);

		JPanel fontPanel = new JPanel();
		fontPanel.setLayout(new GridLayout(3,3));
		fontPanel.setBounds(45, 350, 600, 500);
		fontPanel.setBackground(Color.gray);
		
		JButton storeButton1 = new JButton("캐릭터 1");
		JButton storeButton2 = new JButton();
		JButton storeButton3 = new JButton();
		JButton storeButton4 = new JButton();
		JButton storeButton5 = new JButton();
		JButton storeButton6 = new JButton();
		JButton storeButton7 = new JButton();
		JButton storeButton8 = new JButton();
		JButton storeButton9 = new JButton();
		
		JButton storeButton10 = new JButton("배경 1");
		JButton storeButton11 = new JButton();
		JButton storeButton12 = new JButton();
		JButton storeButton13 = new JButton();
		JButton storeButton14 = new JButton();
		JButton storeButton15 = new JButton();
		JButton storeButton16 = new JButton();
		JButton storeButton17 = new JButton();
		JButton storeButton18 = new JButton();
		
		JButton storeButton19 = new JButton("폰트 1");
		JButton storeButton20 = new JButton();
		JButton storeButton21 = new JButton();
		JButton storeButton22 = new JButton();
		JButton storeButton23 = new JButton();
		JButton storeButton24 = new JButton();
		JButton storeButton25 = new JButton();
		JButton storeButton26 = new JButton();
		JButton storeButton27 = new JButton();
		
//		상점 1버튼 클릭시 텍스트 입력
		storeButton1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				buyLabel.setText(" 캐릭터 구매? ");
			}
			
			
		});
		
		storeButton10.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				buyLabel.setText(" 배경 구매?");
			}
			
			
		});
		
		storeButton19.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				buyLabel.setText(" 폰트 구매?");
			}
			
			
		});
		
		characterPanel.add(storeButton1);
		characterPanel.add(storeButton2);
		characterPanel.add(storeButton3);
		characterPanel.add(storeButton4);
		characterPanel.add(storeButton5);
		characterPanel.add(storeButton6);
		characterPanel.add(storeButton7);
		characterPanel.add(storeButton8);
		characterPanel.add(storeButton9);
		
		backgroundPanel.add(storeButton10);
		backgroundPanel.add(storeButton11);
		backgroundPanel.add(storeButton12);
		backgroundPanel.add(storeButton13);
		backgroundPanel.add(storeButton14);
		backgroundPanel.add(storeButton15);
		backgroundPanel.add(storeButton16);
		backgroundPanel.add(storeButton17);
		backgroundPanel.add(storeButton18);
		
		fontPanel.add(storeButton19);
		fontPanel.add(storeButton20);
		fontPanel.add(storeButton21);
		fontPanel.add(storeButton22);
		fontPanel.add(storeButton23);
		fontPanel.add(storeButton24);
		fontPanel.add(storeButton25);
		fontPanel.add(storeButton26);
		fontPanel.add(storeButton27);

		botPanel.add("character", characterPanel);
		botPanel.add("background", backgroundPanel);
		botPanel.add("font", fontPanel);

		// 실행하자 마자 보이게
		card.show(botPanel, "character");

		characterButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				card.show(botPanel, "character");

			}
		});

		backgroundButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				card.show(botPanel, "background");

			}
		});

		fontButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				card.show(botPanel, "font");

			}
		});

		frame.add(topPanel);
		frame.add(midPanel);
		frame.add(botPanel);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
