
package com.tuna.can.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;


public class FriendsList extends JFrame{

	public FriendsList() {
		super("Friends List");
//		public static void main(String[] args) {
//			JPanel friends = null;

			// 미니 창 이름 설정
//			JFrame mf = new JFrame("Friend List");
			Border border = BorderFactory.createLineBorder(Color.BLACK, 1);	
			this.setLayout(null);
			this.setSize(700, 900);
			this.setLocation(600, 50);
			
			try {
				this.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// 상단 판넬
			JPanel topPanel = new JPanel();
			topPanel.setLayout(null);
			topPanel.setBounds(0,0,700,100);
			topPanel.setBackground(Color.pink);
			
			// 상단 라벨
			JLabel topLabel = new JLabel("친구 목록");
			topLabel.setLayout(null);
			topLabel.setBounds(270, 27, 700, 50);
			topLabel.setFont(new Font("휴먼둥근헤드라인" ,Font.PLAIN, 30));
			
			// 상단 판넬에 라벨 
			topPanel.add(topLabel);
			
			// 뒤로 가기 버튼
			
			ImageIcon home = new ImageIcon("image/home.PNG");
			Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
			JButton backB = new JButton(home);
			backB.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Main_page();
						dispose();
				}
			});
			backB.setBounds(30, 25, 55, 55);
			backB.setBackground(Color.pink);
			backB.setBorder(pinkborder);
			topPanel.add(backB);
			
			/*------------------------------------------------------------------------------------------*/
			
			JPanel middlePanel = new JPanel();
			
			
			middlePanel.setBackground(Color.pink);
			JPanel friends = null;
			
			for(int i = 0; i < 10; i++) {
				
				middlePanel.setLayout(null);
//			middlePanel.setBounds(0,100,685,500);
				middlePanel.setPreferredSize(new Dimension(640,i*100));
				friends = new JPanel();
				
				friends.setBackground(Color.WHITE);
				friends.setLayout(null);
				
				friends.setBounds(0,(i * 100),682,100);
				
				friends.setBorder(border);
				friends.setBackground(new Color(255, 240, 245));
				
//				friends.setBackground(Color.pink);
				
				JLabel nickName = new JLabel("다라미");
				nickName.setLayout(null);
				nickName.setBounds(310, 27, 700, 50);
				friends.add(nickName);
//				mf.add(friends);
				ImageIcon photo = new ImageIcon("image/profile.png");
				
				JLabel imageLabel = new JLabel(photo);
				imageLabel.setLayout(null);
				imageLabel.setBounds(57,27,72,60);
				friends.add(imageLabel);
				
				JButton button = new JButton("삭제");
//				button.setLayout(null);
				button.setBounds(550,27,90,40);
				button.addActionListener(new com.tuna.can.controller.FriendsList(button));
				
				friends.add(button);
				middlePanel.add(friends);
				
			}
			
			JScrollPane scrollbar = new JScrollPane(middlePanel);
			scrollbar.setPreferredSize(new Dimension(685,700));
			scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			int width = scrollbar.getPreferredSize().width;
			int height = scrollbar.getPreferredSize().height;
			scrollbar.setBounds(0,100,width,height);
			scrollbar.setBorder(pinkborder);
//			middlePanel.add(scrollbar);
			
//			Scrollbar scr_Ver1 = new Scrollbar(Scrollbar.VERTICAL, 0, 20, 0, 255);
//		        scr_Ver1.setSize(15, 100);
//		        scr_Ver1.setLocation(40, 30);
			
//			scrollbar.setLayout(null);
//			scrollbar.setBounds(0,0, 30, 500);
			//scrollbar.setViewportView(middlePanel);
			//middlePanel.add(scrollbar);
			/*------------------------------------------------------------------------------------------*/
			
			// 하단 판넬
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(null);
//			bottomPanel.setLocation(0,750);
//			bottomPanel.setSize(700,150);
			bottomPanel.setBackground(Color.pink);
			
			bottomPanel.setBounds(0, 800, 700, 70);
			// 마이 프레임에 판넬 추가
			
			this.getContentPane().add(scrollbar);
			this.add(topPanel);
			this.add(bottomPanel);
//			mf.add(middlePanel);
			this.setResizable(false);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
	public static void main(String[] args) {
		
		new FriendsList();
	}
}

	

