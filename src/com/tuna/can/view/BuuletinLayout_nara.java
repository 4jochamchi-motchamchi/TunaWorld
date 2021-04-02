package com.tuna.can.view;

import java.awt.BorderLayout;
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
public class BuuletinLayout_nara {

	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		
		mainFrame.setTitle("게시글보기");
		mainFrame.setSize(700,900);
		
		JPanel topPanel = new JPanel();
		JLabel topLabel = new JLabel("제목");
		JPanel backPanel = new JPanel();
		JButton backButton = new JButton("뒤로");
		
		topPanel.setLayout(new BorderLayout());
		
		System.out.println(topPanel.getLayout());

		topPanel.add(topLabel);
		
		
		
		
	
		
		
		mainFrame.add(topPanel, "North");
		
		
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
