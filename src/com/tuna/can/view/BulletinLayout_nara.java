package com.tuna.can.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * <pre>
 *  게시글 보기 레이아웃
 * </pre> 
 * @author 위나라
 *
 */
public class BulletinLayout_nara {

	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		
		mainFrame.setTitle("게시글보기");
		mainFrame.setSize(700,900);
		
		
		// 글 제목 라벨, 메인으로 버튼
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("제목");
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		JButton backButton = new JButton("뒤로");
		topPanel.setBackground(Color.PINK);
		
		// topPanel에 뒤로버튼, 제목 추가
		topPanel.setLayout(new BorderLayout());
		topPanel.add(backButton,"West");
		topPanel.add(topLabel,"Center");
		
		
		
		
		
		// 게시글 라벨
		JPanel centerPanel = new JPanel();
		JLabel Bulletin = new JLabel("게에에에에시이이이이이그으으으으을");
		Bulletin.setHorizontalAlignment(JLabel.CENTER);
		centerPanel.setBackground(Color.PINK);
		
		// 친구추가 버튼, 작성자닉네임 라벨 
		JPanel nickAndPlus = new JPanel();
		JButton plusButton = new JButton("친구추가");
		JLabel nickName = new JLabel("작성자닉네임   ");
		nickName.setHorizontalAlignment(JLabel.RIGHT);
		nickAndPlus.setBackground(Color.PINK);
	
		// centerPanel에 게시글
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(Bulletin, "Center");
		
		// nickAndPlus에 작성자닉네임, 친구차가 추가
		nickAndPlus.setLayout(new BorderLayout());
		nickAndPlus.add(nickName,"Center");
		nickAndPlus.add(plusButton,"East");
		centerPanel.add(nickAndPlus,"North");
		
		
		
		
		
	
		
		
		mainFrame.add(topPanel, "North");
		mainFrame.add(centerPanel, "Center");
		
		
		mainFrame.setVisible(true);			
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
//	public void bulletinMain() {
//		
//		JFrame mainFrame = new JFrame();
//		
//		mainFrame.setTitle("게시글보기");
//		
//		mainFrame.setVisible(true);
//		
//		mainFrame.setSize(700,900);
//				
//		JButton back = new JButton(" ");
//		
//		JPanel topPanel = new JPanel();
//		topPanel.set
//		
//	
//		
//		
//		
//		
//		
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
	
}
