package com.tuna.can.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FontTest {

	public static void main(String[] args) {
		
		Font font1 = new Font("휴먼편지체", Font.PLAIN ,25);
		Font font2 = new Font("고딕체", Font.PLAIN ,25);
		Font font = new Font("돋움체", Font.PLAIN ,25);
		
		String color = "Black";
		String color22 = "#01203231";
		
		JFrame frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setSize(300, 200);
		panel.setBackground(Color.decode("#ffff64"));
		
		frame.add(panel);
		
		
//		JLabel label = new JLabel("      테스트 입니다         ");
//		label.setFont(font);
//		label.setSize(300, 200);
		
//		JLabel label2 = new JLabel("      테스트 입니다         ");
//		label2.setFont(font2);
//		label2.setSize(300, 500);
//		
//		JLabel label3 = new JLabel("      테스트 입니다         ");
//		label3.setFont(font3);
//		label3.setSize(300, 800);
		
		
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 500, 1000);
		
		
		
		
	}
	
}
