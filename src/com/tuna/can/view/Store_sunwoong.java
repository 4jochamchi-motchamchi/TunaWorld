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

public class Store_sunwoong {

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

		JButton characterButton = new JButton();

		JButton backgroundButton = new JButton();

		JButton fontButton = new JButton();

		midPanel.add(characterButton);
		midPanel.add(backgroundButton);
		midPanel.add(fontButton);

		////////////////////////////////////////

		// 하단 패널
//		하단 패널에 버튼 9개씩 추가하여 
//		중간 패널 버튼 클릭시 하단패널 버튼 변경
//		중간에 ~선택 ~ 구매 하시겠습니까 ~ 현재 금액 생성
		JPanel botPanel = new JPanel();
		CardLayout card = new CardLayout();
		botPanel.setLayout(card);
		botPanel.setBounds(45, 350, 600, 600);

		JPanel characterPanel = new JPanel();
		characterPanel.setBounds(45, 350, 600, 600);
		characterPanel.setBackground(Color.pink);
		JButton storeButton1 = new JButton();

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBounds(45, 350, 600, 600);
		backgroundPanel.setBackground(Color.orange);

		JPanel fontPanel = new JPanel();
		fontPanel.setBounds(45, 350, 600, 600);
		fontPanel.setBackground(Color.gray);

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
