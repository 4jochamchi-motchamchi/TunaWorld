package com.tuna.can.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.border.Border;

import com.tuna.can.controller.MiniGame;

/**
 * @author doqnt
 * <PRE>
 *   4조참치 못참지 김현빈 미니게임 클래스
 * </pre>
 *
 */
public class Game_view extends JFrame{

	public Game_view() {
		
		super("MINI GAME!!");
		JPanel topPanel = new JPanel();
		JLabel topLab = new JLabel("참치캔 찾기 못참지!!");
		try {
			this.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		this.setSize(700,900);

	/*--------------------------------------------------------------------------*/	
		
		
		// 상단 게임 이름 판넬
		topPanel.setLayout(null);
		// topLab 글씨 크기 설정
		topLab.setFont(new Font("휴먼둥근헤드라인" ,Font.PLAIN, 30));
		// 상단 페널 크기 위치 지정
		topPanel.setBounds(0,0,700,100);
		// 라벨 위치
		topLab.setBounds(210, 27, 700, 50);
		// 라벨 추가
		topPanel.add(topLab);
		// 배경색 설정
		topPanel.setBackground(Color.PINK);
		
		
	/*--------------------------------------------------------------------------*/	
		
		
		// 센터 중간 버튼 페널
		JPanel buttonPanel = new JPanel();
		// 센터 중간 버튼 배경 색
		buttonPanel.setBackground(Color.PINK);
		// 버튼 페널 위치 설정
		buttonPanel.setBounds(100, 100, 500, 650);
		// 그리드레이아웃 버튼
		buttonPanel.setLayout(new GridLayout(4,4,5,5));
		// 버튼 생성
		
//		JButton[] jb = new JButton[25];
		
		// 하단 페널에 게임 남은 횟수 표시
		MiniGame hg = new MiniGame();
		JLabel countNum = new JLabel("남은 횟수  X  " + hg.getCountNum());
		countNum.setFont(new Font("휴먼둥근헤드라인" ,Font.PLAIN, 17));
		countNum.setBounds(400, 40, 150, 30);
		
		for(int i = 1; i < 17; i++) {
			ImageIcon cardBack = new ImageIcon("image/catcard2.PNG");
			JButton button = new JButton(cardBack);
			button.setBackground(Color.WHITE);
			button.addActionListener(new MiniGame(i, button, countNum));
			
			buttonPanel.add(button);
//			if(MiniGame_hyunbin.getCheck() == 1) {
//				break;
//			}
//		나라 작품	break;
//			buttonPanel.add(new JButton(i+ ""));
			
		}
		
	/*--------------------------------------------------------------------------*/	
		
		
		
		// 홈 가기 버튼
		ImageIcon home = new ImageIcon("image/home.PNG");
		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
		JButton backB = new JButton(home);
		backB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//		backB.setBounds(10,10,90,25);
//		topPanel.add(backB);
		backB.setBounds(30, 25, 55, 55);
		backB.setBackground(Color.pink);
		backB.setBorder(pinkborder);
		topPanel.add(backB);
		
	
	/*--------------------------------------------------------------------------*/	
		// 하단 판넬 살정
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(100,750,600,300);
		bottomPanel.setBackground(Color.PINK);
		
		// 재화 박스 설정
//		JTextField textBox = new JTextField(100);
//		textBox.setBackground(Color.PINK);
//		textBox.setBounds(400, 40, 150, 30);
//		textBox.setText("참치캔 이미지 " +" X ");
//		ImageIcon  can = new ImageIcon("image/logoBig.PNG");
//		JLabel jaehwa = new JLabel("참치캔    X   갯수");
//		jaehwa.setBounds(400, 70, 150, 30);
		//-----------------------------------------------------
		
		
		
		// 읽기 전용으로 만들기
//		textBox.setEditable(false);
//		bottomPanel.add(textBox);
		bottomPanel.add(countNum);
//		bottomPanel.add(jaehwa);
		
		
	/*--------------------------------------------------------------------------*/	
		
		// 좌우 판넬 설정
//		ImageIcon cwtree = new ImageIcon("image/catwithtree.PNG");
//		JButton ctree = new JButton(cwtree);
		JPanel sidePanel1 = new JPanel();
		sidePanel1.setLayout(null);
		sidePanel1.setBounds(0,0,100,900);
		sidePanel1.setBackground(Color.PINK);
//		sidePanel1.add(ctree);
		JPanel sidePanel2 = new JPanel();
		sidePanel2.setLayout(null);
		sidePanel2.setBounds(600,0,100,750);
		sidePanel2.setBackground(Color.PINK);
		
	/*--------------------------------------------------------------------------*/	
		
		// 프레임에 페널 추가
		this.add(topPanel);
		this.add(buttonPanel);
		this.add(sidePanel1);
		this.add(sidePanel2);
		this.add(bottomPanel);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
//		Game_view gb = new Game_view();
		new Game_view();
	}
		
	}

//	
//	public static void main(String[] args) {
//		
//		JFrame mf = new JFrame("MINI GAME!");
//		JPanel topPanel = new JPanel();
//		JLabel topLab = new JLabel("참치캔 찾기 못참지!!");
//		try {
//			mf.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		mf.setLayout(null);
//		mf.setSize(700,900);
//
//	/*--------------------------------------------------------------------------*/	
//		
//		
//		// 상단 게임 이름 판넬
//		topPanel.setLayout(null);
//		// topLab 글씨 크기 설정
//		topLab.setFont(new Font("휴먼둥근헤드라인" ,Font.PLAIN, 30));
//		// 상단 페널 크기 위치 지정
//		topPanel.setBounds(0,0,700,100);
//		// 라벨 위치
//		topLab.setBounds(210, 27, 700, 50);
//		// 라벨 추가
//		topPanel.add(topLab);
//		// 배경색 설정
//		topPanel.setBackground(Color.PINK);
//		
//		
//	/*--------------------------------------------------------------------------*/	
//		
//		
//		// 센터 중간 버튼 페널
//		JPanel buttonPanel = new JPanel();
//		// 센터 중간 버튼 배경 색
//		buttonPanel.setBackground(Color.PINK);
//		// 버튼 페널 위치 설정
//		buttonPanel.setBounds(100, 100, 500, 650);
//		// 그리드레이아웃 버튼
//		buttonPanel.setLayout(new GridLayout(4,4,5,5));
//		// 버튼 생성
//		
////		JButton[] jb = new JButton[25];
//		
//		// 하단 페널에 게임 남은 횟수 표시
//		MiniGame hg = new MiniGame();
//		JLabel countNum = new JLabel("남은 횟수  X  " + hg.getCountNum());
//		countNum.setFont(new Font("휴먼둥근헤드라인" ,Font.PLAIN, 17));
//		countNum.setBounds(400, 40, 150, 30);
//		
//		for(int i = 1; i < 17; i++) {
//			ImageIcon cardBack = new ImageIcon("image/catcard2.PNG");
//			JButton button = new JButton(cardBack);
//			button.setBackground(Color.WHITE);
//			button.addActionListener(new MiniGame(i, button, countNum));
//			
//			buttonPanel.add(button);
////			if(MiniGame_hyunbin.getCheck() == 1) {
////				break;
////			}
////		나라 작품	break;
////			buttonPanel.add(new JButton(i+ ""));
//			
//		}
//		
//	/*--------------------------------------------------------------------------*/	
//		
//		
//		
//		// 홈 가기 버튼
//		ImageIcon home = new ImageIcon("image/home.PNG");
//		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
//		JButton backB = new JButton(home);
//		backB.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
////		backB.setBounds(10,10,90,25);
////		topPanel.add(backB);
//		backB.setBounds(30, 25, 55, 55);
//		backB.setBackground(Color.pink);
//		backB.setBorder(pinkborder);
//		topPanel.add(backB);
//		
//	
//	/*--------------------------------------------------------------------------*/	
//		// 하단 판넬 살정
//		
//		JPanel bottomPanel = new JPanel();
//		bottomPanel.setLayout(null);
//		bottomPanel.setBounds(100,750,600,300);
//		bottomPanel.setBackground(Color.PINK);
//		
//		// 재화 박스 설정
////		JTextField textBox = new JTextField(100);
////		textBox.setBackground(Color.PINK);
////		textBox.setBounds(400, 40, 150, 30);
////		textBox.setText("참치캔 이미지 " +" X ");
////		ImageIcon  can = new ImageIcon("image/logoBig.PNG");
////		JLabel jaehwa = new JLabel("참치캔    X   갯수");
////		jaehwa.setBounds(400, 70, 150, 30);
//		//-----------------------------------------------------
//		
//		
//		
//		// 읽기 전용으로 만들기
////		textBox.setEditable(false);
////		bottomPanel.add(textBox);
//		bottomPanel.add(countNum);
////		bottomPanel.add(jaehwa);
//		
//		
//	/*--------------------------------------------------------------------------*/	
//		
//		// 좌우 판넬 설정
////		ImageIcon cwtree = new ImageIcon("image/catwithtree.PNG");
////		JButton ctree = new JButton(cwtree);
//		JPanel sidePanel1 = new JPanel();
//		sidePanel1.setLayout(null);
//		sidePanel1.setBounds(0,0,100,900);
//		sidePanel1.setBackground(Color.PINK);
////		sidePanel1.add(ctree);
//		JPanel sidePanel2 = new JPanel();
//		sidePanel2.setLayout(null);
//		sidePanel2.setBounds(600,0,100,750);
//		sidePanel2.setBackground(Color.PINK);
//		
//	/*--------------------------------------------------------------------------*/	
//		
//		// 프레임에 페널 추가
//		mf.add(topPanel);
//		mf.add(buttonPanel);
//		mf.add(sidePanel1);
//		mf.add(sidePanel2);
//		mf.add(bottomPanel);
//		mf.setResizable(false);
//		mf.setVisible(true);
//		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//	}
	
	
//}
