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
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.tuna.can.controller.MyPage_Button;
import com.tuna.can.controller.TunaController;
import com.tuna.can.model.dto.MemberDTO;

public class MyPage extends JFrame {
	
	TunaController tunaController = new TunaController();

	
	public MyPage() {

		myPageMainFrame();
	}
	public static void main(String[] args) {

		MyPage mypage = new MyPage();
		
		mypage.myPageMainFrame();

	}
	
	public void myPageMainFrame() {
		JFrame frame = new JFrame("MyPage");
		frame.setSize(700, 900);
		
		frame.setLayout(null);
		
		frame.add(topPanel());
		frame.add(mypageInfo());
		frame.add(inventory());

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public JPanel mypageInfo() {
		
		MemberDTO member = new MemberDTO();
		
		member = tunaController.selectMemberInfo("user01");
		System.out.println(member);

		JPanel bottomPanel1 = new JPanel();

		bottomPanel1.setLayout(null);
		bottomPanel1.setLocation(0, 250);
		bottomPanel1.setSize(350, 650);
		bottomPanel1.setBackground(Color.white);

		Label infoLabel = new Label("information");
		infoLabel.setBounds(20, 20, 200, 50);
		infoLabel.setFont(new Font("SansSerif", Font.BOLD, 30));

		Font font = new Font("Centaur", Font.BOLD, 18);

		Label userIdLabel = new Label("userId");
		userIdLabel.setBounds(20, 100, 90, 30);
		userIdLabel.setFont(font);

		Label phoneLabel = new Label("phone");
		phoneLabel.setBounds(30, 190, 80, 30);
		phoneLabel.setFont(font);

		Label emailLabel = new Label("email");
		emailLabel.setBounds(30, 280, 80, 30);
		emailLabel.setFont(font);

		Label nicknameLabel = new Label("nickname");
		nicknameLabel.setBounds(30, 370, 80, 30);
		nicknameLabel.setFont(font);

		Label pwdLabel = new Label("password");
		pwdLabel.setBounds(30, 460, 80, 30);
		pwdLabel.setFont(font);

		JTextField userIdText = new JTextField(10);
		userIdText.setBounds(130, 100, 186, 35);
//		userIdText.setText(member.getUserID());

		JTextField phoneText = new JTextField(10);
		phoneText.setBounds(130, 190, 186, 35);
//		phoneText.setText(member.getPhone());

		JTextField emailText = new JTextField(10);
		emailText.setBounds(130, 280, 186, 35);
//		emailText.setText(member.getMeail());

		JTextField nicknameText = new JTextField(10);
		nicknameText.setBounds(130, 370, 186, 35);
//		nicknameText.setText(member.getNickName());

		JTextField pwdText = new JTextField(10);
		pwdText.setBounds(130, 460, 186, 35);
//		pwdText.setText(member.getUserPwd());

		JButton userCommit = new JButton("commit");
		userCommit.setBounds(240, 530, 80, 40);

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
				dispose();
			}
		});
		backB.setBounds(30, 25, 55, 55);
		backB.setBackground(Color.pink);
		backB.setBorder(pinkborder);
		topPanel.add(backB);

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
		JLabel myCharacterLabel = new JLabel("내 캐릭터");
		myCharacterButton.add(myCharacterLabel);
		myCharacterLabel.setFont(myfont);

		JButton myBackgroundButton = new JButton();
		JLabel myBackgroundLabel = new JLabel("내 배경색");
		myBackgroundButton.add(myBackgroundLabel);
		myBackgroundLabel.setFont(myfont);

		JButton myFontButton = new JButton();
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

		for (int i = 1; i < 19; i++) {
			if (i < 7) {
				characterPanel.add(new MyPage_Button());
			} else if (i < 13) {
				backgroundPanel.add(new MyPage_Button());
			} else {
				fontPanel.add(new MyPage_Button());
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
