package com.tuna.can.view;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.tuna.can.controller.InventoryButtonController;
import com.tuna.can.controller.TunaController;
import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;

public class MyPage extends JFrame {
	
	TunaController tunaController = new TunaController();
	UserDTO member = null;
	JFrame frame = null;

	public MyPage() {

		myPageMainFrame();
	}
	public static void main(String[] args) {

		new MyPage();

	}
	
	public JFrame myPageMainFrame() {
		
		
		frame = new JFrame("MyPage");
		frame.setLocation(600, 50);
		frame.setSize(700, 900);
		
		frame.setLayout(null);
		
		frame.add(topPanel());
		frame.add(mypageInfo());
		frame.add(inventory());

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return frame;
		
	}

	public JPanel mypageInfo() {
		
		member = new UserDTO();
		
		member = tunaController.selectMemberInfo("user01");

		JPanel bottomPanel1 = new JPanel();

		bottomPanel1.setLayout(null);
		bottomPanel1.setLocation(0, 250);
		bottomPanel1.setSize(350, 650);
		bottomPanel1.setBackground(new Color(255, 240, 245));

		Label infoLabel = new Label("information");
		infoLabel.setBounds(20, 20, 200, 50);
		infoLabel.setFont(new Font("SansSerif", Font.BOLD, 30));

		Font font = new Font("Centaur", Font.BOLD, 18);

		Label userIdLabel = new Label("userId");
		userIdLabel.setBounds(20, 100, 90, 30);
		userIdLabel.setFont(font);

		Label nicknameLabel = new Label("nickname");
		nicknameLabel.setBounds(30, 190, 80, 30);
		nicknameLabel.setFont(font);
		
		Label pwdLabel = new Label("password");
		pwdLabel.setBounds(30, 280, 80, 30);
		pwdLabel.setFont(font);
		
		Label phoneLabel = new Label("phone");
		phoneLabel.setBounds(30, 370, 80, 30);
		phoneLabel.setFont(font);

		Label emailLabel = new Label("email");
		emailLabel.setBounds(30, 460, 80, 30);
		emailLabel.setFont(font);



		JTextField userIdText = new JTextField(10);
		userIdText.setBounds(130, 100, 186, 35);
		userIdText.setText(member.getUserID());
		userIdText.setEditable(false);

		JTextField nicknameText = new JTextField(10);
		nicknameText.setBounds(130, 190, 186, 35);
		nicknameText.setText(member.getNickName());
		nicknameText.setEditable(false);
		
		JTextField pwdText = new JTextField(10);
		pwdText.setBounds(130, 280, 186, 35);
		pwdText.setText(member.getUserPwd());
		
		JTextField phoneText = new JTextField(10);
		phoneText.setBounds(130, 370, 186, 35);
		phoneText.setText(member.getPhone());

		JTextField emailText = new JTextField(10);
		emailText.setBounds(130, 460, 186, 35);
		emailText.setText(member.getEmail());

		
		JButton userCommit = new JButton("commit");
		userCommit.setBounds(240, 530, 80, 40);
		
		userCommit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				UserDTO updateUserInfo = new UserDTO();
				updateUserInfo.setUserNo(member.getUserNo());
				updateUserInfo.setPhone(phoneText.getText());
				updateUserInfo.setEmail(emailText.getText());
				updateUserInfo.setUserPwd(pwdText.getText());
				
				result = tunaController.updateUserInformation(updateUserInfo);
				
				if(result > 0) {
					JOptionPane.showMessageDialog(null, "업데이트 성공.", "업데이트 성공", 0);
					
				} else {
					JOptionPane.showMessageDialog(null, "업데이트 실패.", "업데이트 실패", 0);
				}
				
			}
		});

		bottomPanel1.add(infoLabel);
		bottomPanel1.add(userIdLabel);
		bottomPanel1.add(phoneLabel);
		bottomPanel1.add(emailLabel);
		bottomPanel1.add(nicknameLabel);
		bottomPanel1.add(pwdLabel);

		bottomPanel1.add(userIdText);
		bottomPanel1.add(phoneText);
		bottomPanel1.add(emailText);
		bottomPanel1.add(nicknameText);
		bottomPanel1.add(pwdText);

		bottomPanel1.add(userCommit);

		return bottomPanel1;

	}

	public JPanel topPanel() {

		JPanel topPanel = new JPanel();

		topPanel.setLayout(null);
		topPanel.setLocation(0, 0);
		topPanel.setSize(700, 250);
		topPanel.setBackground(Color.pink);

		Image icon = new ImageIcon("image/logoBig.png").getImage().getScaledInstance(200, 200, 0);

		JLabel imageLabel = new JLabel(new ImageIcon(icon));

		imageLabel.setBounds(250, 25, 200, 200);

		topPanel.add(imageLabel);

		// 홈 가기 버튼
		ImageIcon home = new ImageIcon("image/home.PNG");
		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
		JButton backB = new JButton(home);
		backB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Main_page();
				frame.dispose();
			}
		});
		backB.setBounds(30, 25, 55, 55);
		backB.setBackground(Color.pink);
		backB.setBorder(pinkborder);
		topPanel.add(backB);
		
		JButton refreshButton = new JButton("새로고침");
		refreshButton.setBounds(600, 220, 50, 20);
		
		refreshButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myPageMainFrame().repaint();
			}
		});
		
		topPanel.add(refreshButton);
		
		return topPanel;

	}

	public JPanel inventory() {
		
		JPanel bottomPanel2 = new JPanel();

//	      우측 하단 내 위쪽 패널
		JPanel bottomTopPanel = new JPanel();

//	      우측 하단 내 하단 패널
		JPanel bottomBottomPanel = new JPanel();
		Font myfont = new Font("내캐릭터 폰트", Font.BOLD, 18);

		JButton myCharacterButton = new JButton();
//		myCharacterButton = new JButton();
		JLabel myCharacterLabel = new JLabel("내 캐릭터");
		myCharacterButton.add(myCharacterLabel);
		myCharacterLabel.setFont(myfont);

		JButton myBackgroundButton = new JButton();
//		myBackgroundButton = new JButton();
		JLabel myBackgroundLabel = new JLabel("내 배경색");
		myBackgroundButton.add(myBackgroundLabel);
		myBackgroundLabel.setFont(myfont);

		JButton myFontButton = new JButton();
//		myFontButton = new JButton();
		JLabel myFontLabel = new JLabel("내 폰트");
		myFontButton.add(myFontLabel);
		myFontLabel.setFont(myfont);

		bottomTopPanel.add(myCharacterButton);
		bottomTopPanel.add(myBackgroundButton);
		bottomTopPanel.add(myFontButton);

//		      우측 하단 패널   
		bottomPanel2.setLayout(null);
		bottomPanel2.setLocation(350, 250);
		bottomPanel2.setSize(350, 650);
		bottomPanel2.setBackground(Color.pink);

//		      우측 하단 상단 패널
//		      버튼 클릭시 
//		     bottomTopPanel 버튼 변경
		bottomTopPanel.setLayout(new GridLayout(0, 3));
		bottomTopPanel.setSize(350, 100);
		bottomTopPanel.setLocation(0, 0);

//		      우측 하단 하단 패널
//		      new GridLayout(3, 2, 20, 20)
		CardLayout card = new CardLayout();

		bottomBottomPanel.setLayout(card);
		bottomBottomPanel.setLocation(0, 100);
		bottomBottomPanel.setSize(350, 525);
		bottomBottomPanel.setBackground(Color.pink);

		JPanel characterPanel = new JPanel();
		characterPanel.setLayout(new GridLayout(3, 3));
		characterPanel.setLocation(0, 100);
		characterPanel.setSize(350, 525);
		characterPanel.setBackground(Color.blue);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(new GridLayout(3, 3));
		backgroundPanel.setLocation(0, 100);
		backgroundPanel.setSize(350, 525);
		backgroundPanel.setBackground(Color.gray);

		JPanel fontPanel = new JPanel();
		fontPanel.setLayout(new GridLayout(3, 3));
		fontPanel.setLocation(0, 100);
		fontPanel.setSize(350, 525);
		fontPanel.setBackground(Color.green);
		
		Map<Integer, ArrayList<UserInventoryDTO>> invMap = new HashMap<Integer, ArrayList<UserInventoryDTO>>();
		
		invMap = tunaController.selectUserInventory(1);
		
		List<UserInventoryDTO> equipItemList = new ArrayList<UserInventoryDTO>();
		
		equipItemList = invMap.get(4);
		
		
		if(equipItemList.get(0) != null) {
			
			myCharacterLabel.setText(equipItemList.get(0).getItemImg());
		}
		if(equipItemList.get(1) != null) {
			
			myBackgroundLabel.setText(equipItemList.get(1).getItemImg());
		}
		if(equipItemList.get(2) != null) {
			
			myFontLabel.setText(equipItemList.get(2).getItemImg());
		}
		
		
		
		for(int i = 0; i < 6; i++) {
			if(i < invMap.get(1).size()) {
				
				characterPanel.add(new InventoryButtonController(invMap.get(1).get(i)));
			} else {
				
				characterPanel.add(new JButton("아이템 없음"));
			}
		}
		
		for(int i = 0; i < 6; i++) {
			if(i < invMap.get(2).size()) {
				backgroundPanel.add(new InventoryButtonController(invMap.get(2).get(i)));
			} else {
				
				backgroundPanel.add(new JButton("아이템 없음"));
			}
		}
		
		for(int i = 0; i < 6; i++) {
			if(i < invMap.get(3).size()) {
				fontPanel.add(new InventoryButtonController(invMap.get(3).get(i)));
			} else {
				
				fontPanel.add(new JButton("아이템 없음"));
			}
		}
		

		bottomBottomPanel.add("character", characterPanel);
		bottomBottomPanel.add("background", backgroundPanel);
		bottomBottomPanel.add("font", fontPanel);

		card.show(bottomBottomPanel, "character");

		myCharacterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == myCharacterButton) {
					card.show(bottomBottomPanel, "character");
				}
				
			}
		});
		myBackgroundButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				card.show(bottomBottomPanel, "background");
			}

		});
		myFontButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				card.show(bottomBottomPanel, "font");
			}

		});

		bottomPanel2.add(bottomTopPanel);
		bottomPanel2.add(bottomBottomPanel);
		
		
		return bottomPanel2;

	}
	
}
