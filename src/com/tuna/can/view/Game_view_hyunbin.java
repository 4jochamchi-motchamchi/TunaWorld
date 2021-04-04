package com.tuna.can.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tuna.can.controller.MiniGame_hyunbin;

/**
 * @author doqnt
 * <PRE>
 *   4조참치 못참지 김현빈 미니게임 클래스
 * </pre>
 *
 */
public class Game_view_hyunbin {


	
	public static void main(String[] args) {
		
		JFrame mf = new JFrame("MINI GAME!");
		JPanel topPanel = new JPanel();
		JLabel topLab = new JLabel("참치캔 찾기 못참지!!");
		mf.setLayout(null);
		mf.setSize(700,900);

	/*--------------------------------------------------------------------------*/	
		
		
		// 상단 게임 이름 패널
		topPanel.setLayout(null);
		// topLab 글씨 크기 설정
		topLab.setFont(new Font("게임" ,Font.BOLD, 30));
		// 상단 페널 크기 위치 지정
		topPanel.setBounds(0,0,700,100);
		// 라벨 위치
		topLab.setBounds(210, 27, 700, 50);
		// 라벨 추가
		topPanel.add(topLab);
		// 배경색 설정
		topPanel.setBackground(Color.PINK);
		
		
	/*--------------------------------------------------------------------------*/	
		
		
		// 센터 중간 버튼 페널
		JPanel buttonPanel = new JPanel();
		// 센터 중간 버튼 배경 색
		buttonPanel.setBackground(Color.PINK);
		// 버튼 페널 위치 설정
		buttonPanel.setBounds(100, 100, 500, 650);
		// 그리드레이아웃 버튼
		buttonPanel.setLayout(new GridLayout(5,5,5,5));
		// 버튼 생성
		
//		JButton[] jb = new JButton[25];
		
		JLabel countNum = new JLabel("남은 횟수  X  " +  5);
		countNum.setFont(new Font("게임" ,Font.BOLD, 20));
		countNum.setBounds(400, 40, 150, 30);
		
		for(int i = 1; i < 26; i++) {
			JButton button = new JButton();
			button.addActionListener(new MiniGame_hyunbin(i, button, countNum));
			buttonPanel.add(button);

			
//			buttonPanel.add(new JButton(i+ ""));
			
		}
		
	/*--------------------------------------------------------------------------*/	
		
		
		
		// 뒤로 가기 버튼
		JButton backB = new JButton("뒤로가기");
		backB.setBounds(10,10,90,25);
		topPanel.add(backB);
		
	
	/*--------------------------------------------------------------------------*/	
		// 하단 판넬 살정
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(100,750,600,300);
		bottomPanel.setBackground(Color.PINK);
		
		// 재화 박스 설정
//		JTextField textBox = new JTextField(100);
//		textBox.setBackground(Color.PINK);
//		textBox.setBounds(400, 40, 150, 30);
//		textBox.setText("참치캔 이미지 " +" X ");
		JLabel jaehwa = new JLabel("참치캔   X  갯수");
		jaehwa.setBounds(400, 70, 150, 30);
		//-----------------------------------------------------
		
		
		
		// 읽기 전용으로 만들기
//		textBox.setEditable(false);
		
		
//		bottomPanel.add(textBox);
		bottomPanel.add(countNum);
		bottomPanel.add(jaehwa);
		
		
	/*--------------------------------------------------------------------------*/	
		
		// 좌우 판넬 설정
		JPanel sidePanel1 = new JPanel();
		sidePanel1.setLayout(null);
		sidePanel1.setBounds(0,0,100,900);
		sidePanel1.setBackground(Color.PINK);
		JPanel sidePanel2 = new JPanel();
		sidePanel2.setLayout(null);
		sidePanel2.setBounds(600,0,100,750);
		sidePanel2.setBackground(Color.PINK);
		
	/*--------------------------------------------------------------------------*/	
		
		// 프레임에 페널 추가
		mf.add(topPanel);
		mf.add(buttonPanel);
		mf.add(sidePanel1);
		mf.add(sidePanel2);
		mf.add(bottomPanel);
		mf.setResizable(false);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
}
