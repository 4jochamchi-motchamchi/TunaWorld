package com.tuna.can.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.tuna.can.controller.InventoryButtonController;
import com.tuna.can.controller.StoreItemButtonController;
import com.tuna.can.controller.TunaController;
import com.tuna.can.model.dto.StoreItemDTO;
import com.tuna.can.model.dto.UserInventoryDTO;

public class Store{

	private TunaController controller = new TunaController();
	
	public static void main(String[] args) {
		
		new Store();
	}
	
	public Store() {
		JFrame frame = new JFrame("Store");
		
	      try {
	    	  frame.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
	       } catch (IOException e1) {
	          e1.printStackTrace();
	       }
		
//		public static void main(String[] args) {
			Font font = new Font("상점폰트", Font.BOLD, 50);

//			JFrame frame = new JFrame("Store");
			frame.setLayout(null);
			frame.setSize(700, 900);
			frame.setLocation(600, 50);
			JPanel colorPanel = new JPanel();
			colorPanel.setBackground(new Color(255, 240, 245));
			colorPanel.setSize(700, 900);
			colorPanel.setLayout(null);

			// 최상단 패널
			JPanel topPanel = new JPanel();
			topPanel.setLayout(null);
			topPanel.setBounds(0, 0, 700, 125);
			topPanel.setBackground(Color.pink);

			// 상점 글씨
			JLabel storeLabel = new JLabel("Store");
			storeLabel.setBounds(270, 40, 170, 50);
			storeLabel.setFont(font);
			topPanel.add(storeLabel);

			// 뒤로가기 버튼
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
			
			//////////////////////////////////////////
			
//			코인 넣자
			int coin = 0;
//			coin = controller.selectUSerCoin(controller.loginMember.getUserNo());
			coin = controller.selectUSerCoin(controller.loginMember.getUserNo());
			JLabel coinLabel = new JLabel();
			coinLabel.setBounds(565, 55, 100, 30);
			coinLabel.setText("보유 코인 " + coin);
			topPanel.add(coinLabel);
			
//			새로고침 넣자
//			JButton refreshButton = new JButton("코인 확인");
//			refreshButton.setBounds(550, 90, 100, 30);
//			
//			refreshButton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new Store();
//					frame.dispose();
//					
//				}
//			});
//			
//			topPanel.add(refreshButton);

			//////////////////////////////////////////

			// 중간 패널
			JPanel midPanel = new JPanel();
			midPanel.setLayout(new GridLayout(1, 3));
			midPanel.setBounds(45, 170, 600, 130);
			
			midPanel.setBackground(new Color(255, 240, 245));
			
			JButton characterButton = new JButton("캐릭터");

			JButton backgroundButton = new JButton("배경");

			JButton fontButton = new JButton("폰트");

			midPanel.add(characterButton);
			midPanel.add(backgroundButton);
			midPanel.add(fontButton);
			
			////////////////////////////////////////

			// 하단 패널
//			하단 패널에 버튼 9개씩 추가하여 
//			중간 패널 버튼 클릭시 하단패널 버튼 변경
//			중간에 ~선택 ~ 구매 하시겠습니까 ~ 현재 금액 생성
			JPanel botPanel = new JPanel();
			CardLayout card = new CardLayout();
			botPanel.setLayout(card);
			botPanel.setBounds(45, 350, 600, 500);

			JPanel characterPanel = new JPanel();
			characterPanel.setLayout(new GridLayout(3,3));
			characterPanel.setBounds(45, 350, 600, 500);
			characterPanel.setBackground(Color.pink);

			JPanel backgroundPanel = new JPanel();
			backgroundPanel.setLayout(new GridLayout(3,3));
			backgroundPanel.setBounds(45, 350, 600, 500);
			backgroundPanel.setBackground(Color.orange);

			JPanel fontPanel = new JPanel();
			fontPanel.setLayout(new GridLayout(3,3));
			fontPanel.setBounds(45, 350, 600, 500);
			fontPanel.setBackground(Color.gray);
			TunaController controller = new TunaController();
			
			Map<Integer, ArrayList<StoreItemDTO>> storeItemMap = new HashMap<Integer, ArrayList<StoreItemDTO>>();
			
			List<StoreItemDTO> storeItem = new ArrayList<StoreItemDTO>();
			
			storeItemMap = controller.selectStoreItem();
			
			
			for(int i = 0; i < 9; i++) {
				if(i < storeItemMap.get(1).size()) {
					
					characterPanel.add(new StoreItemButtonController(storeItemMap.get(1).get(i),frame));
				} else {
					
					characterPanel.add(new JButton("아이템 없음"));
				}
			}
			
			for(int i = 0; i < 9; i++) {
				if(i < storeItemMap.get(2).size()) {
					backgroundPanel.add(new StoreItemButtonController(storeItemMap.get(2).get(i),frame));
				} else {
					
					backgroundPanel.add(new JButton("아이템 없음"));
				}
			}
			
			for(int i = 0; i < 9; i++) {
				if(i < storeItemMap.get(3).size()) {
					fontPanel.add(new StoreItemButtonController(storeItemMap.get(3).get(i),frame));
				} else {
					
					fontPanel.add(new JButton("아이템 없음"));
				}
			}
			
			botPanel.add("character", characterPanel);
			botPanel.add("background", backgroundPanel);
			botPanel.add("font", fontPanel);

			// 실행하자 마자 보이게
			card.show(botPanel, "character");

			characterButton.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					card.show(botPanel, "character");

				}
			});

			backgroundButton.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					card.show(botPanel, "background");

				}
			});

			fontButton.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					card.show(botPanel, "font");

				}
			});
			colorPanel.add(topPanel);
			colorPanel.add(midPanel);
			colorPanel.add(botPanel);
			frame.add(colorPanel);
//			frame.add(topPanel);
//			frame.add(midPanel);
//			frame.add(botPanel);

			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	
}
	
	

//	public static void main(String[] args) {
//		Font font = new Font("상점폰트", Font.BOLD, 50);
//
//		JFrame frame = new JFrame("Store");
//		frame.setLayout(null);
//		frame.setSize(700, 900);
//
//		// 최상단 패널
//		JPanel topPanel = new JPanel();
//		topPanel.setLayout(null);
//		topPanel.setBounds(0, 0, 700, 125);
//		topPanel.setBackground(Color.pink);
//
//		// 상점 글씨
//		JLabel storeLabel = new JLabel("상점~~~");
//		storeLabel.setBounds(270, 40, 150, 50);
//		storeLabel.setFont(font);
//		topPanel.add(storeLabel);
//
//		// 뒤로가기 버튼
//		JButton backButton = new JButton("back");
//		backButton.setBounds(10, 10, 90, 25);
//		topPanel.add(backButton);
//
//		//////////////////////////////////////////
//
//		// 중간 패널
//		JPanel midPanel = new JPanel();
//		midPanel.setLayout(new GridLayout(1, 3));
//		midPanel.setBounds(45, 170, 600, 130);
//		midPanel.setBackground(Color.blue);
//
//		JButton characterButton = new JButton("캐릭터");
//
//		JButton backgroundButton = new JButton("배경");
//
//		JButton fontButton = new JButton("폰트");
//
//		midPanel.add(characterButton);
//		midPanel.add(backgroundButton);
//		midPanel.add(fontButton);
//		
//		JLabel buyLabel = new JLabel("gdgdgddd");
//		buyLabel.setBounds(300, 300, 300, 50);
//		buyLabel.setFont(new Font("구매폰트", Font.BOLD, 20));
//		frame.add(buyLabel);
//		
//
//		////////////////////////////////////////
//
//		// 하단 패널
////		하단 패널에 버튼 9개씩 추가하여 
////		중간 패널 버튼 클릭시 하단패널 버튼 변경
////		중간에 ~선택 ~ 구매 하시겠습니까 ~ 현재 금액 생성
//		JPanel botPanel = new JPanel();
//		CardLayout card = new CardLayout();
//		botPanel.setLayout(card);
//		botPanel.setBounds(45, 350, 600, 500);
//
//		JPanel characterPanel = new JPanel();
//		characterPanel.setLayout(new GridLayout(3,3));
//		characterPanel.setBounds(45, 350, 600, 500);
//		characterPanel.setBackground(Color.pink);
//
//		JPanel backgroundPanel = new JPanel();
//		backgroundPanel.setLayout(new GridLayout(3,3));
//		backgroundPanel.setBounds(45, 350, 600, 500);
//		backgroundPanel.setBackground(Color.orange);
//
//		JPanel fontPanel = new JPanel();
//		fontPanel.setLayout(new GridLayout(3,3));
//		fontPanel.setBounds(45, 350, 600, 500);
//		fontPanel.setBackground(Color.gray);
//		
//		JButton storeButton1 = new JButton("캐릭터 1");
//		JButton storeButton2 = new JButton();
//		JButton storeButton3 = new JButton();
//		JButton storeButton4 = new JButton();
//		JButton storeButton5 = new JButton();
//		JButton storeButton6 = new JButton();
//		JButton storeButton7 = new JButton();
//		JButton storeButton8 = new JButton();
//		JButton storeButton9 = new JButton();
//		
//		JButton storeButton10 = new JButton("배경 1");
//		JButton storeButton11 = new JButton();
//		JButton storeButton12 = new JButton();
//		JButton storeButton13 = new JButton();
//		JButton storeButton14 = new JButton();
//		JButton storeButton15 = new JButton();
//		JButton storeButton16 = new JButton();
//		JButton storeButton17 = new JButton();
//		JButton storeButton18 = new JButton();
//		
//		JButton storeButton19 = new JButton("폰트 1");
//		JButton storeButton20 = new JButton();
//		JButton storeButton21 = new JButton();
//		JButton storeButton22 = new JButton();
//		JButton storeButton23 = new JButton();
//		JButton storeButton24 = new JButton();
//		JButton storeButton25 = new JButton();
//		JButton storeButton26 = new JButton();
//		JButton storeButton27 = new JButton();
//		
////		상점 1버튼 클릭시 텍스트 입력
//		storeButton1.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				buyLabel.setText(" 캐릭터 구매? ");
//			}
//			
//			
//		});
//		
//		storeButton10.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				buyLabel.setText(" 배경 구매?");
//			}
//			
//			
//		});
//		
//		storeButton19.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				buyLabel.setText(" 폰트 구매?");
//			}
//			
//			
//		});
//		
//		characterPanel.add(storeButton1);
//		characterPanel.add(storeButton2);
//		characterPanel.add(storeButton3);
//		characterPanel.add(storeButton4);
//		characterPanel.add(storeButton5);
//		characterPanel.add(storeButton6);
//		characterPanel.add(storeButton7);
//		characterPanel.add(storeButton8);
//		characterPanel.add(storeButton9);
//		
//		backgroundPanel.add(storeButton10);
//		backgroundPanel.add(storeButton11);
//		backgroundPanel.add(storeButton12);
//		backgroundPanel.add(storeButton13);
//		backgroundPanel.add(storeButton14);
//		backgroundPanel.add(storeButton15);
//		backgroundPanel.add(storeButton16);
//		backgroundPanel.add(storeButton17);
//		backgroundPanel.add(storeButton18);
//		
//		fontPanel.add(storeButton19);
//		fontPanel.add(storeButton20);
//		fontPanel.add(storeButton21);
//		fontPanel.add(storeButton22);
//		fontPanel.add(storeButton23);
//		fontPanel.add(storeButton24);
//		fontPanel.add(storeButton25);
//		fontPanel.add(storeButton26);
//		fontPanel.add(storeButton27);
//
//		botPanel.add("character", characterPanel);
//		botPanel.add("background", backgroundPanel);
//		botPanel.add("font", fontPanel);
//
//		// 실행하자 마자 보이게
//		card.show(botPanel, "character");
//
//		characterButton.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				card.show(botPanel, "character");
//
//			}
//		});
//
//		backgroundButton.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				card.show(botPanel, "background");
//
//			}
//		});
//
//		fontButton.addMouseListener(new MouseAdapter() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				card.show(botPanel, "font");
//
//			}
//		});
//
//		frame.add(topPanel);
//		frame.add(midPanel);
//		frame.add(botPanel);
//
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	}
//}
