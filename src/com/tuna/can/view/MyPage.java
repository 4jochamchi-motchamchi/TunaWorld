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
	MemberDTO member = null;

	public JPanel mypageInfo() {
		
		JPanel bottomPanel1 = new JPanel();
		
		
//		member = tunaController.selectMemberInfo();

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
		userIdText.setText(member.getUserID());
		
		JTextField phoneText = new JTextField(10);
		phoneText.setBounds(130, 190, 186, 35);
		phoneText.setText(member.getPhone());
		
		JTextField emailText = new JTextField(10);
		emailText.setBounds(130, 280, 186, 35);
		emailText.setText(member.getMeail());
		
		JTextField nicknameText = new JTextField(10);
		nicknameText.setBounds(130, 370, 186, 35);
		nicknameText.setText(member.getNickName());
		
		JTextField pwdText = new JTextField(10);
		pwdText.setBounds(130, 460, 186, 35);
		pwdText.setText(member.getUserPwd());

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
	
	
	
	
	
	

	public MyPage() {
		super("MyPage");

//		  public static void main(String[] args) {

//		      JFrame frame = new JFrame("MyPage");

		this.setLayout(null);

		this.setSize(700, 900);

//		      위쪽 패널
		Panel topPanel = new Panel();

//		      좌측 하단 패널
		Panel bottomPanel1 = new Panel();

//		      우측 하단 패널
		Panel bottomPanel2 = new Panel();

//		      우측 하단 내 위쪽 패널
		Panel bottomTopPanel = new Panel();

//		      우측 하단 내 하단 패널
		Panel bottomBottomPanel = new Panel();

//		      위쪽 패널
//		      이미지 넣기
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

//		      좌측 하단 패널
//		      bottomPanel1.setLayout(null);
//		      bottomPanel1.setLocation(0, 250);
//		      bottomPanel1.setSize(350, 650);
//		      bottomPanel1.setBackground(Color.white);
//		      
//		      Label infoLabel = new Label("information");
//		      infoLabel.setBounds(20, 20, 200, 50);
//		      infoLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
//		      
//		      Font font = new Font("Centaur",Font.BOLD, 18);
//		      
//		      Label nameLabel = new Label("username");
//		      nameLabel.setBounds(20, 100, 90, 30);
//		      nameLabel.setFont(font);
//		      Label phoneLabel = new Label("phone");
//		      phoneLabel.setBounds(30, 190, 80, 30);
//		      phoneLabel.setFont(font);
//		      Label emailLabel = new Label("email");
//		      emailLabel.setBounds(30, 280, 80, 30);
//		      emailLabel.setFont(font);
//		      Label genderLabel = new Label("gender");
//		      genderLabel.setBounds(30, 370, 80, 30);
//		      genderLabel.setFont(font);
//		      Label ageLabel = new Label("age");
//		      ageLabel.setBounds(30, 460, 80, 30);
//		      ageLabel.setFont(font);
//		      
//		      JTextField nameText = new JTextField(10);
//		      nameText.setBounds(130, 100, 186, 35);
//		      JTextField phoneText = new JTextField(10);
//		      phoneText.setBounds(130, 190, 186, 35);
//		      JTextField emailText = new JTextField(10);
//		      emailText.setBounds(130, 280, 186, 35);
//		      JTextField genderText = new JTextField(10);
//		      genderText.setBounds(130, 370, 186, 35);
//		      JTextField ageText = new JTextField(10);
//		      ageText.setBounds(130, 460, 186, 35);
//		      
//		      JButton userCommit = new JButton("commit");
//		      userCommit.setBounds(240, 530, 80, 40);
//		     
//		      bottomPanel1.add(infoLabel);
//		      bottomPanel1.add(nameLabel);
//		      bottomPanel1.add(phoneLabel);
//		      bottomPanel1.add(emailLabel);
//		      bottomPanel1.add(genderLabel);
//		      bottomPanel1.add(ageLabel);
//		      
//		      bottomPanel1.add(nameText);
//		      bottomPanel1.add(phoneText);
//		      bottomPanel1.add(emailText);
//		      bottomPanel1.add(genderText);
//		      bottomPanel1.add(ageText);
//		      
//		      bottomPanel1.add(userCommit);

//		    d우측 하단 my캐릭터, 배경색, 폰트  변경
//		      버튼or라벨
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
		this.add(topPanel);
		this.add(mypageInfo());
		this.add(bottomPanel2);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MyPage();
	}

}

//   public static void main(String[] args) {
//      
//      JFrame frame = new JFrame("MyPage");
//      
//      frame.setLayout(null);
//      
//      frame.setSize(700,900);
//      
////      위쪽 패널
//      Panel topPanel = new Panel();
//      
////      좌측 하단 패널
//      Panel bottomPanel1 = new Panel();
//      
////      우측 하단 패널
//      Panel bottomPanel2 = new Panel();
//      
////      우측 하단 내 위쪽 패널
//      Panel bottomTopPanel = new Panel();
//      
////      우측 하단 내 하단 패널
//      Panel bottomBottomPanel = new Panel();
//      
////      위쪽 패널
////      이미지 넣기
//      topPanel.setLayout(null);
//      topPanel.setLocation(0, 0);
//      topPanel.setSize(700, 250);
//      topPanel.setBackground(Color.pink);
//      
//      Image icon = new ImageIcon("image/logoBig.png").getImage().getScaledInstance(200, 200, 0);
//      
//      JLabel imageLabel = new JLabel(new ImageIcon(icon));
//      
//      imageLabel.setBounds(250, 25, 200, 200);
//      
//      topPanel.add(imageLabel);
//      
//      
//      JButton backButton = new JButton("back");
//      backButton.setBounds(10, 10, 90, 25);
//      
//      topPanel.add(backButton);
//      
////      좌측 하단 패널
//      bottomPanel1.setLayout(null);
//      bottomPanel1.setLocation(0, 250);
//      bottomPanel1.setSize(350, 650);
//      bottomPanel1.setBackground(Color.white);
//      
//      Label infoLabel = new Label("information");
//      infoLabel.setBounds(20, 20, 200, 50);
//      infoLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
//      
//      Font font = new Font("Centaur",Font.BOLD, 18);
//      
//      Label nameLabel = new Label("username");
//      nameLabel.setBounds(20, 100, 90, 30);
//      nameLabel.setFont(font);
//      Label phoneLabel = new Label("phone");
//      phoneLabel.setBounds(30, 190, 80, 30);
//      phoneLabel.setFont(font);
//      Label emailLabel = new Label("email");
//      emailLabel.setBounds(30, 280, 80, 30);
//      emailLabel.setFont(font);
//      Label genderLabel = new Label("gender");
//      genderLabel.setBounds(30, 370, 80, 30);
//      genderLabel.setFont(font);
//      Label ageLabel = new Label("age");
//      ageLabel.setBounds(30, 460, 80, 30);
//      ageLabel.setFont(font);
//      
//      JTextField nameText = new JTextField(10);
//      nameText.setBounds(130, 100, 186, 35);
//      JTextField phoneText = new JTextField(10);
//      phoneText.setBounds(130, 190, 186, 35);
//      JTextField emailText = new JTextField(10);
//      emailText.setBounds(130, 280, 186, 35);
//      JTextField genderText = new JTextField(10);
//      genderText.setBounds(130, 370, 186, 35);
//      JTextField ageText = new JTextField(10);
//      ageText.setBounds(130, 460, 186, 35);
//      
//      JButton userCommit = new JButton("commit");
//      userCommit.setBounds(240, 530, 80, 40);
//     
//      bottomPanel1.add(infoLabel);
//      bottomPanel1.add(nameLabel);
//      bottomPanel1.add(phoneLabel);
//      bottomPanel1.add(emailLabel);
//      bottomPanel1.add(genderLabel);
//      bottomPanel1.add(ageLabel);
//      
//      bottomPanel1.add(nameText);
//      bottomPanel1.add(phoneText);
//      bottomPanel1.add(emailText);
//      bottomPanel1.add(genderText);
//      bottomPanel1.add(ageText);
//      
//      bottomPanel1.add(userCommit);
//      
//      
////      우측 하단 패널   
//      bottomPanel2.setLayout(null);
//      bottomPanel2.setLocation(350, 250);
//      bottomPanel2.setSize(350, 650);
//      bottomPanel2.setBackground(Color.pink);
//      
////      우측 하단 상단 패널
////      버튼 클릭시 
////     bottomTopPanel 버튼 변경
//      bottomTopPanel.setLayout(new GridLayout(0,3));
//      bottomTopPanel.setSize(350,100);
//      bottomTopPanel.setLocation(0, 0);
////      bottomTopPanel.setBackground(Color.green);
//
////      bottomTopPanel.add(comp);
////      bottomTopPanel.add(comp);
////      bottomTopPanel.add(comp);
//      
////    좌측 하단 my캐릭터, 배경색, 폰트  변경
////      버튼or라벨
//      Font myfont = new Font("내캐릭터 폰트", Font.BOLD, 18);
//      
//      JButton myCharacterButton = new JButton();
//      JLabel myCharacterLabel = new JLabel("내 캐릭터");
//      myCharacterButton.add(myCharacterLabel);
//      myCharacterLabel.setFont(myfont);
//      
//      JButton myBackgroundButton = new JButton();
//      JLabel myBackgroundLabel = new JLabel("내 배경색");
//      myBackgroundButton.add(myBackgroundLabel);
//      myBackgroundLabel.setFont(myfont);
//      
//      JButton myFontButton = new JButton();
//      JLabel myFontLabel = new JLabel("내 폰트");
//      myFontButton.add(myFontLabel);
//      myFontLabel.setFont(myfont);
//      
//      
////      Panel bottomTopPanel1 = new Panel();
////      bottomTopPanel1.setBackground(Color.CYAN);
////      Panel bottomTopPanel2 = new Panel();
////      bottomTopPanel2.setBackground(Color.PINK);
////      Panel bottomTopPanel3 = new Panel();
////      bottomTopPanel3.setBackground(Color.RED);
//      
//      bottomTopPanel.add(myCharacterButton);
//      bottomTopPanel.add(myBackgroundButton);
//      bottomTopPanel.add(myFontButton);
//      
////      우측 하단 하단 패널
////      new GridLayout(3, 2, 20, 20)
//      CardLayout card = new CardLayout();
//      
//      bottomBottomPanel.setLayout(card);
//      bottomBottomPanel.setLocation(0, 100);
//      bottomBottomPanel.setSize(350, 525);
//      bottomBottomPanel.setBackground(Color.pink);
//      
//      JPanel characterPanel = new JPanel();
//      characterPanel.setLayout(new GridLayout(3,3));
//      characterPanel.setLocation(0, 100);
//      characterPanel.setSize(350, 525);
//      characterPanel.setBackground(Color.blue);
//      
//      JPanel backgroundPanel = new JPanel();
//      backgroundPanel.setLayout(new GridLayout(3,3));
//      backgroundPanel.setLocation(0, 100);
//      backgroundPanel.setSize(350, 525);
//      backgroundPanel.setBackground(Color.gray);
//      
//      JPanel fontPanel = new JPanel();
//      fontPanel.setLayout(new GridLayout(3,3));
//      fontPanel.setLocation(0, 100);
//      fontPanel.setSize(350, 525);
//      fontPanel.setBackground(Color.green);
//      
//      for(int i = 1; i < 19; i++) {
//    	  if(i < 7) {
//    		  characterPanel.add(new MyPage_Button());
//    	  } else if(i < 13) {
//    		  backgroundPanel.add(new MyPage_Button());
//    	  } else {
//    		  fontPanel.add(new MyPage_Button());
//    	  }
//      }
//      
//      
////      JButton inventory1 = new JButton("1~6 ㅎㅎ");
////      inventory1.setBounds(35, 30, 120, 120);
////      JButton inventory2 = new JButton("위 클릭하면");
////      inventory2.setBounds(185, 30, 120, 120);
////      JButton inventory3 = new JButton("바뀜");
////      inventory3.setBounds(35, 180, 120, 120);
////      JButton inventory4 = new JButton();
////      inventory4.setBounds(185, 180, 120, 120);
////      JButton inventory5 = new JButton();
////      inventory5.setBounds(35, 330, 120, 120);
////      JButton inventory6 = new JButton();
////      inventory6.setBounds(185, 330, 120, 120);
////
////      JButton inventory7 = new JButton("7~12 ㅎㅎ");
////      inventory7.setBounds(35, 30, 120, 120);
////      JButton inventory8 = new JButton();
////      inventory8.setBounds(185, 30, 120, 120);
////      JButton inventory9 = new JButton();
////      inventory9.setBounds(35, 180, 120, 120);
////      JButton inventory10 = new JButton();
////      inventory10.setBounds(185, 180, 120, 120);
////      JButton inventory11 = new JButton();
////      inventory11.setBounds(35, 330, 120, 120);
////      JButton inventory12 = new JButton();
////      inventory12.setBounds(185, 330, 120, 120);
////      
////      JButton inventory13 = new JButton("13~18 ㅎㅎ");
////      inventory13.setBounds(35, 30, 120, 120);
////      JButton inventory14 = new JButton();
////      inventory14.setBounds(185, 30, 120, 120);
////      JButton inventory15 = new JButton();
////      inventory15.setBounds(35, 180, 120, 120);
////      JButton inventory16 = new JButton();
////      inventory16.setBounds(185, 180, 120, 120);
////      JButton inventory17 = new JButton();
////      inventory17.setBounds(35, 330, 120, 120);
////      JButton inventory18 = new JButton();
////      inventory18.setBounds(185, 330, 120, 120);
//      
////    인벤 1번 클릭시 이벤트
////      inventory1.addMouseListener(new MouseAdapter() {
////
////		@Override
////		public void mouseClicked(MouseEvent e) {
////
////		}
////    	  
////    	  
////	});
//      
//      bottomBottomPanel.add("character", characterPanel);
//      bottomBottomPanel.add("background", backgroundPanel);
//      bottomBottomPanel.add("font", fontPanel);
//      
////      characterPanel.add(inventory1);
////      characterPanel.add(inventory2);
////      characterPanel.add(inventory3);
////      characterPanel.add(inventory4);
////      characterPanel.add(inventory5);
////      characterPanel.add(inventory6);
////      
////      backgroundPanel.add(inventory7);
////      backgroundPanel.add(inventory8);
////      backgroundPanel.add(inventory9);
////      backgroundPanel.add(inventory10);
////      backgroundPanel.add(inventory11);
////      backgroundPanel.add(inventory12);
////      
////      fontPanel.add(inventory13);
////      fontPanel.add(inventory14);
////      fontPanel.add(inventory15);
////      fontPanel.add(inventory16);
////      fontPanel.add(inventory17);
////      fontPanel.add(inventory18);
//      
//      card.show(bottomBottomPanel, "character");
//      
//      
//      myCharacterButton.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//			if(e.getSource() == myCharacterButton) {
//				card.show(bottomBottomPanel, "character");
//			}
//			
//		}
//	});
//      myBackgroundButton.addMouseListener(new MouseAdapter() {
//
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			card.show(bottomBottomPanel, "background");
//
//		}
//    	  
//    	  
//	});
//      myFontButton.addMouseListener(new MouseAdapter() {
//    	  
//    	  @Override
//    	  public void mouseClicked(MouseEvent e) {
//    		  
//    		  card.show(bottomBottomPanel, "font");
//    	  }
//    	  
//    	  
//      });
//      
//      
//      
////      JButton inventory7 = new JButton();
////      inventory7.setBounds(35, 30, 120, 120);
////      JButton inventory8 = new JButton();
////      inventory8.setBounds(185, 30, 120, 120);
////      JButton inventory9 = new JButton();
////      inventory9.setBounds(35, 180, 120, 120);
////      JButton inventory10 = new JButton();
////      inventory10.setBounds(185, 180, 120, 120);
////      JButton inventory11 = new JButton();
////      inventory11.setBounds(35, 330, 120, 120);
////      JButton inventory12 = new JButton();
////      inventory12.setBounds(185, 330, 120, 120);
//      
//      
//      bottomPanel2.add(bottomTopPanel);
//      bottomPanel2.add(bottomBottomPanel);
//      frame.add(topPanel);
//      frame.add(bottomPanel1);
//      frame.add(bottomPanel2);
//
//      
//      frame.setVisible(true);
//      
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      
//   }
//   
//}