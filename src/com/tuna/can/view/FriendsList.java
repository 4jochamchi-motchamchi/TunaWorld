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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import com.tuna.can.controller.TunaController;
import com.tuna.can.model.dto.FriendDTO;
import com.tuna.can.service.TunaService;


public class FriendsList extends JFrame{

	public FriendsList() {
		// 미니 창 이름 설정
		super("Friends List");
				
			
			Border panelborder = BorderFactory.createLineBorder(Color.BLACK, 1);
			Border button2 = BorderFactory.createLineBorder(new Color(255, 240, 245));
			this.setLayout(null);
			this.setSize(700, 900);
			this.setLocation(600, 50);

			
			try {
				this.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.setBackground(Color.pink);
			
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
			
			Border lightgrayborder = BorderFactory.createLineBorder(Color.lightGray, 1);
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
//			middlePanel.setBounds(0, 100, 700, 9000);
//			middlePanel.setBackground(Color.BLACK);
//			middlePanel.setPreferredSize(new Dimension(700,900));
			
			
//			middlePanel.setPreferredSize(new Dimension(640,300));
			List<FriendDTO> friends = new ArrayList<FriendDTO>();
			TunaController controller = new TunaController();
			FriendDTO friend = new FriendDTO();
			friends = controller.selectFriendsList(3);
			
			// 버튼 이미지 
			ImageIcon delete = new ImageIcon("image/delete.png");
			ImageIcon deletered = new ImageIcon("image/deleteRed.png");
			JPanel friendsPanel = null;
			JLabel nickName = null;
			JLabel imageLabel = null;
			// 페널 객체만들기
			for(int i = 0; i <friends.size(); i++) {
				
				middlePanel.setLayout(null);
				middlePanel.setPreferredSize(new Dimension(660, 100*(i+1)));
				
				// 친구 페널
				friendsPanel = new JPanel();
				friendsPanel.setLayout(null);
//				friendsPanel.setLocation(0,200);
//				friendsPanel.setPreferredSize(new Dimension(600,100));
				friendsPanel.setBounds(0,i*100,670,100);
				friendsPanel.setBackground(new Color(255, 240, 245));
				friendsPanel.setBorder(lightgrayborder);
			
				
				// 닉네임
				nickName = new JLabel();
				Integer no = friends.get(i).getUserNO();
				JLabel userNo = new JLabel(no.toString());
				userNo.setVisible(false);
				nickName.setLayout(null);
				Integer fno = friends.get(i).getFriendsNo();
				JLabel friendNo = new JLabel(fno.toString());
			    friendNo.setVisible(false);
				nickName.setBounds(310, 27, 700, 50);
				// 객체 연결용
				nickName.setText(friends.get(i).getFriendsNickname());
//				nickName.setText("다라미");
				// 이미지 용
				
				imageLabel = new JLabel();
				imageLabel.setLayout(null);
				imageLabel.setBounds(57,27,72,60);
//				ImageIcon photo = new ImageIcon("image/profile.png");
//				imageLabel.setIcon(friend.getImage());
				
				JButton button = new JButton(delete);
				button.setLayout(null);
				button.setBackground(new Color(255, 240, 245));
				button.setBorder(button2);
				button.setBounds(550,27,90,40);
				button.setRolloverIcon(deletered);
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(null, "정말 친구를 삭제하시겠습니까? \n 정말요?", "친구 목록 삭제",0);
						if(result == JOptionPane.YES_OPTION) {
							
							// 딜리트
							TunaService ts = new TunaService();
//							System.out.println(Integer.parseInt(userNo.getText()) + " : " + Integer.parseInt(friendNo.getText()));
							ts.deleteFriend(Integer.parseInt(userNo.getText()), Integer.parseInt(friendNo.getText()));
							
						} else {
							System.out.println("삭제 취소");
						}						
					}
				});
				
				
				friendsPanel.add(button);
				friendsPanel.add(imageLabel);
				friendsPanel.add(nickName);
				middlePanel.add(friendsPanel);
				
				}
			
			
			
	
//			for(int i = 0; i < friends.size(); i++) {
//				friend = friends.get(i);
//				
//				// 친구 목록 페널
//				friendsPanel = new JPanel();
////				friendsPanel.setBackground(Color.WHITE);
//				friendsPanel.setLayout(null);
//				friendsPanel.setBorder(panelborder);
//				friendsPanel.setBackground(new Color(255, 240, 245));
//				
//				// 삭제 버튼
//				JButton button = new JButton(delete);
//				button.setLayout(null);
//				button.setBackground(new Color(255, 240, 245));
//				button.setBorder(button2);
//				button.setBounds(550,27,90,40);
//				button.setRolloverIcon(deletered);
//				
//				// 친구 닉네임 라벨
//				JLabel nickName = new JLabel();
//				nickName.setLayout(null);
//				nickName.setBounds(310, 27, 700, 50);
//				
//				// 친구 이미지
//				JLabel imageLabel = new JLabel();
//				imageLabel.setLayout(null);
//				imageLabel.setBounds(57,27,72,60);
//				
//				// 미드 페널 설정
//				middlePanel.setLocation(0, 100);
//				middlePanel.setPreferredSize(new Dimension(665,100*(i+1)));
////				middlePanel.setBounds(0, 100, 700, (i * 100)+100);
////				middlePanel.setPreferredSize(new Dimension(700, (i * 100)+100));
//				middlePanel.add(new FriendsList_controller(i,friendsPanel, this, friend, nickName, button, imageLabel));
//				
//			}
//			middlePanel.setBackground(new Color(255, 240, 245));
			
			// 스크롤
			JScrollPane scrollbar = new JScrollPane(middlePanel);
			scrollbar.setPreferredSize(new Dimension(685,700));
			scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			int width = scrollbar.getPreferredSize().width;
			int height = scrollbar.getPreferredSize().height;
			scrollbar.setBounds(0,100,width,height);
			scrollbar.setBorder(pinkborder);
			scrollbar.setBackground(Color.pink);

			
			/*------------------------------------------------------------------------------------------*/
			
			// 하단 판넬
			JPanel bottomPanel = new JPanel();
			bottomPanel.setLayout(null);

			bottomPanel.setBackground(Color.pink);
			
			bottomPanel.setBounds(0, 800, 700, 70);
			
			// 마이 프레임에 판넬 추가
			this.add(topPanel);
			this.add(bottomPanel);
//			this.add(middlePanel);
			this.getContentPane().add(scrollbar);
			this.setResizable(false);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

			if(true) {
				
				int result = JOptionPane.showConfirmDialog(null, "친구 추가 요청이 왔어요!", "친구수락", 0);
				if(result == JOptionPane.YES_OPTION) {
					
					
				} else {
					
					
				}
				  
			}
		}
	
	public static void main(String[] args) {
		
		new FriendsList();
	}
}

	



