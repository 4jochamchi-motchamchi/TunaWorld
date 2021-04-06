package com.tuna.can.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MiniGame implements ActionListener {

	// 버튼에 각각 번호를 부여하기 위한 필드
	// for문으로 받은 매개변수
	private int buttonNum;

	private static int countNum = 7;

	// Game_view에서 만든 Label의 주소값을 담아오기 위해
	private JLabel can;

	// 매개변수로 받은
	private JButton button;
	// 난수 발생 하는 필드
	// static으로 준 이유 : 버튼 16개의 버튼객체들이 공유하기 위해
	// final 인이유 값을 변경하기 싫어서
	private static final int answerNum = (int) (Math.random() * 16) + 1;
//	private static int num1 = 1;

	// 사용한 카드를 비활성화 하기 위한 필드
	private boolean checkUsedCard = true;
	
	// view 클래스에 객체 생성
	public MiniGame() {
		
	}
	
	// countNum 값을 view 클래스로 가져가기 위한 getter
	public static int getCountNum() {
		return countNum;
	}


	public MiniGame(int buttonNum, JButton button, JLabel can) {
		this.buttonNum = buttonNum;
		this.button = button;
		this.can = can;
//		button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		countNum--;
			if (countNum < 0) {
				
				int result = JOptionPane.showConfirmDialog(null, "참치 통조림을 결국 찾지 못했습니다. \n 아쉽겠네요 ㅋ", "게임 종료", -1);
				if(result == JOptionPane.YES_OPTION) {
					
					System.out.println("ㅋㅋ");
				}
				
			} else {

//				if (checkUsedCard) {
				if (e.getSource() == button) {

					// 담아온 주소값을 이용해서 setText() 메소드를 사용하기 위해
					can.setText("남은 횟수  X  " + countNum);

					// 버튼 비활성화 스위치
					checkUsedCard = false;
					// 버튼 비활성화 하는 메소드
//					button.setEnabled(checkUsedCard);
					
					System.out.println(buttonNum);

					if (buttonNum == answerNum) {

//						System.out.println("정답");
						ImageIcon can2 = new ImageIcon("image/naraCan.PNG");
						button.setIcon(can2);
						
						int result = JOptionPane.showConfirmDialog(null, "참치 통조림을 찾았습니다 \n 축하드려요!", "참치캔 획득!", -1);
						// 참치캔을 찾았을때 카운터를 0으로 변환
						countNum = 0;
						
						if(result == JOptionPane.YES_OPTION) {
							System.out.println("안녕?");
						}
						

					} else {
						System.out.println(answerNum);
						ImageIcon can = new ImageIcon("image/zcat.PNG");
						button.setIcon(can);
						
//						System.out.println("오답");

					}
				}
			}
	}
}