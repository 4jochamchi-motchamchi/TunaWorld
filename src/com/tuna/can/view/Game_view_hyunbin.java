package com.tuna.can.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author doqnt
 * <PRE>
 *   4조참치 못참지 김현빈 미니게임 클래스
 * </pre>
 *
 */
public class Game_view_hyunbin extends JFrame{

	/**
	 * <pre>
	 *  미니게임 GUI
	 * </pre>
	 */
	public Game_view_hyunbin() {
		// 창 이름 
		super("MINI GAME");
		// 프레임 창 크기 지정
		this.setSize(700,900);
//		this.setBackground(Color.PINK);
		

		// 상단 판넬 
		JPanel topPanel = new JPanel();
		// 상단 라벨 추가
		JLabel topLabel = new JLabel("참치캔 찾기 못참지!!");
		topPanel.setBackground(Color.PINK);
		
		// GridLayout 칸 나누기
		this.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.PINK);
		buttonPanel.setLayout(new GridLayout(5,5,5,5));
		
		// 상단 판넬에 상단 라벨 추가하기
		topPanel.add(topLabel);
		
		// 버튼 판넬 가운데 
//		String[] str = String[25]
		
		for(int i = 1; i < 26; i++) {
			// JButton에는 문자열만 매개 변수로 받기 때문에 문자열 합치기로 버튼 생ㅅㅇ
			buttonPanel.add(new JButton(i+ ""));
		}
//		centerPanel.add();
		
		// 상단 판넬을 이 클래스 스윙 창 북쪽에 위치시키기
		this.add(topPanel, "North");
		
		// 버튼 판넬 중간 위치
		this.add(buttonPanel, "Center");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

		
}
