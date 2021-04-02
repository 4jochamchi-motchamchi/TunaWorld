package com.tuna.can.view;

import java.awt.GridLayout;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

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
public class Game_hyunbin extends JFrame{

	/**
	 * <pre>
	 *  미니게임 GUI
	 * </pre>
	 */
	public Game_hyunbin() {
		// 창 이름 
		super("MINI GAME");
		// 프레임 창 크기 지정
		this.setSize(700,900);

		// 상단 판넬 
		JPanel topPanel = new JPanel();
		// 상단 라벨 추가
		JLabel topLabel = new JLabel("참치캔 찾기 못참지!!");
		
		// GridLayout 칸 나누기
		this.setLayout(new GridLayout(5,5));
		
		Set set = new LinkedHashSet();
		
		while(set.size() < 26) {
			
			set.add(new Random());
		}
		
		
		
		// 상단 판넬에 상단 라벨 추가하기
		topPanel.add(topLabel);
		
		// 상단 판넬을 이 클래스 스윙 창 북쪽에 위치시키기
		this.add(topPanel, "North");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
