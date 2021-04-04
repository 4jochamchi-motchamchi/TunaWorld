package com.tuna.can.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MiniGame_hyunbin implements ActionListener {
	
	// 버튼에 각각 번호를 부여하기 위한 필드
	// for문으로 받은 매개변수
	private int buttonNum;
	
	private static int countNum = 5;
	
	// Game_view에서 만든 Label의 주소값을 가져와서 클릭 이벤트가 발생 할때마다
	// 카운트를 하기 위해
	private JLabel can;
	
	// 매개변수로 받은 
	private JButton button;
	// 난수 발생 하는 필드 
	// static으로 준 이유 : 버튼 25개의 버튼객체들이 공유하기 위해
	// final 인이유 값을 변경하기 싫어서
	private static final int answerNum = (int) (Math.random() * 25) + 1;
	// 사용한 카드를 비활성화 하기 위한 필드
	private boolean checkUsedCard = true;
	
	public MiniGame_hyunbin(int buttonNum, JButton button, JLabel can) {
		this.buttonNum = buttonNum;
		this.button = button;
		this.can = can;
//		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		countNum--;
		
		
		if(countNum < 0) {
			
			return;
			
		} else {
		
			if(e.getSource() == button) {
				
				can.setText("남은 횟수  X  " +  countNum);
				System.out.println(buttonNum);
				
				checkUsedCard = false;
				
				button.setEnabled(checkUsedCard);
				
				if(buttonNum == answerNum) {
					System.out.println("정답");
				} else {
					System.out.println("오답");
				}
			}
		}
	}
}