package com.tuna.can.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import com.tuna.can.controller.FriendsList_controller;
import com.tuna.can.controller.TunaController;
import com.tuna.can.model.dto.FriendDTO;


public class FriendsList extends JFrame{

	public FriendsList() {
		// 미니 창 이름 설정
		super("Friends List");

			
			Border panelborder = BorderFactory.createLineBorder(Color.BLACK, 1);
			Border button2 = BorderFactory.createLineBorder(new Color(255, 240, 245));
			this.setLayout(null);
			this.setSize(700, 900);
			this.setLocation(600, 50);
			this.getContentPane().setBackground(Color.black);

			
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
			
			Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
			ImageIcon home = new ImageIcon("image/home.PNG");
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
			middlePanel.setLayout(null);
			
			
//			middlePanel.setPreferredSize(new Dimension(640,300));
			List<FriendDTO> friends = new ArrayList<FriendDTO>();
			TunaController controller = new TunaController();
			FriendDTO friend = new FriendDTO();
			friends = controller.selectFriendsList(1);
			
			// 버튼 이미지 
			ImageIcon delete = new ImageIcon("image/delete.png");
			ImageIcon deletered = new ImageIcon("image/deleteRed.png");
			
			
			// 페널 객체만들기
			for(int i = 1; i <= 3; i++) {
				friend = friends.get(i);
				
				// 친구 목록 페널
				JPanel friendsPanel = new JPanel();
				friendsPanel.setBackground(Color.WHITE);
				friendsPanel.setLayout(null);
				friendsPanel.setBorder(panelborder);
				friendsPanel.setBackground(new Color(255, 240, 245));
				
				// 삭제 버튼
				JButton button = new JButton(delete);
				button.setLayout(null);
				button.setBackground(new Color(255, 240, 245));
				button.setBorder(button2);
				button.setBounds(550,27,90,40);
				button.setRolloverIcon(deletered);
				
				// 친구 닉네임 라벨
				JLabel nickName = new JLabel();
				nickName.setLayout(null);
				nickName.setBounds(310, 27, 700, 50);
				
				// 친구 이미지
				JLabel imageLabel = new JLabel();
				imageLabel.setLayout(null);
				imageLabel.setBounds(57,27,72,60);
				
				// 미드 페널 설정
				middlePanel.setBounds(0, 100, 700, i * 100);
				middlePanel.add(new FriendsList_controller(i,friendsPanel, this, friend, nickName, button, imageLabel));
				
			}
//			middlePanel.setBackground(new Color(255, 240, 245));
			
			// 스크롤
			JScrollPane scrollbar = new JScrollPane(middlePanel);
			scrollbar.setPreferredSize(new Dimension(685,700));
			scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			int width = scrollbar.getPreferredSize().width;
			int height = scrollbar.getPreferredSize().height;
			scrollbar.setBounds(0,100,width,height);
			scrollbar.setBorder(pinkborder);

			
			/*------------------------------------------------------------------------------------------*/
			
			// 하단 판넬
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(null);

			bottomPanel.setBackground(Color.pink);
			
			bottomPanel.setBounds(0, 800, 700, 70);
			
			// 마이 프레임에 판넬 추가
			this.getContentPane().add(scrollbar);
			this.add(topPanel);
			this.add(bottomPanel);
			this.add(middlePanel);
			this.setResizable(false);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
	public static void main(String[] args) {
		
		new FriendsList();
	}
}

	


