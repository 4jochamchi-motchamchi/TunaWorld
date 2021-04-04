package com.tuna.can.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * 
 * <pre>
 *  게시글 보기 레이아웃
 * </pre> 
 * @author 위나라
 *
 */
public class BulletinLayout_nara {

	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
//		JScrollPane scroll = new JScrollPane();
//		scroll.setBounds(690, 100, 8, 700);
		
		mainFrame.setTitle("게시글보기");
		mainFrame.setSize(700,900);
		mainFrame.setBackground(Color.pink);
		
		JPanel topPanel = new JPanel();					// Back, 제목 들어갈 패널
		JPanel nickAndPlusPanel = new JPanel();			// 작성자닉넴, 친구추가 들어갈 패널
		JPanel bulletinPanel = new JPanel();			// 게시글 들어갈 패널
		JPanel commentsPanel = new JPanel();			// 댓글목록 패널
		JPanel writePanel = new JPanel();				// 댓글쓰는 패널
		
		JLabel topLabel = new JLabel("제목");				// 제목 들어갈 라벨(데이터 불러와야됨)
		JButton backButton = new JButton("Back");		// 메인으로가기 버튼
		JLabel nickName = new JLabel("작성자닉네임");		// 닉네임 들어갈 라벨(데이터 불러와야됨)
		JButton plusFriend = new JButton("친구추가");		// 친구추가 들어갈 라벨
		JLabel bulletin = new JLabel("게에에시시그으을");	// 게시글 들어갈 라벨(데이터 불러와야됨)
		JLabel comments = new JLabel("대대대대대대댓글");	// 댓글목록 보이는 라벨(데이터 불러와야됨)
		JTextField writeComment = new JTextField();		// 댓글 쓸 수있는 텍스트박스
		
		
		// topPanel 설정값
		topPanel.setLayout(null);
		topPanel.setLocation(0, 0);
		topPanel.setSize(700, 100);
		topPanel.setBackground(Color.pink);
		topPanel.setBorder(border);
		
		// 뒤로가기버튼 설정
		backButton.setBounds(25, 25, 90, 50);
		topPanel.add(backButton);
		
		// 제목 설정
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		topLabel.setBounds(115, 0, 470, 100);
		topPanel.add(topLabel);
		
		
		// nickAndPlusPanel 설정값
		nickAndPlusPanel.setLayout(null);
		nickAndPlusPanel.setLocation(0, 100);
		nickAndPlusPanel.setSize(700, 100);
		nickAndPlusPanel.setBackground(Color.pink);
		
		// 작성자 닉네임 설정
		nickName.setLocation(440, 60);
		nickName.setSize(100, 30);
		nickName.setBorder(border);
		nickName.setHorizontalAlignment(JLabel.CENTER);
		nickAndPlusPanel.add(nickName);
		
		// 친구추가 설정
		plusFriend.setLocation(550, 60);
		plusFriend.setSize(100, 30);
		nickAndPlusPanel.add(plusFriend);
		
		
		// bulletinPanel 설정값
		bulletinPanel.setLayout(null);
		bulletinPanel.setLocation(0, 200);
		bulletinPanel.setSize(700, 400);
		bulletinPanel.setBackground(Color.pink);
		
		// 게시글 설정
		bulletin.setLocation(50, 10);
		bulletin.setSize(600, 380);
		bulletin.setBorder(border);
		bulletinPanel.add(bulletin);
		
		
		// commentsPanel 설정값
		commentsPanel.setLayout(null);
		commentsPanel.setLocation(0, 600);
		commentsPanel.setSize(700, 230);
		commentsPanel.setBackground(Color.pink);
		
		// 댓글목록 설정
		comments.setLocation(50, 10);
		comments.setSize(600, 210);
		comments.setVerticalAlignment(JLabel.TOP);
		commentsPanel.add(comments);
		
		
		// writePanel 설정값
		writePanel.setLayout(null);
		writePanel.setLocation(0, 830);
		writePanel.setSize(700, 70);
		writePanel.setBackground(Color.pink);
		
		// 댓글입력창 설정
		writeComment.setLocation(50, 840);
		writeComment.setSize(600, 40);
		writeComment.setBorder(border);
		writePanel.add(writeComment);
		
		
		mainFrame.add(topPanel);
		mainFrame.add(nickAndPlusPanel);
		mainFrame.add(bulletinPanel);
		mainFrame.add(commentsPanel);
		mainFrame.add(writePanel);
		
		
		
		
		
		
		
		
		
//		// 글 제목 라벨, 메인으로 버튼
//		JPanel topPanel = new JPanel();
//		JLabel topLabel = new JLabel("제목");
//		topLabel.setHorizontalAlignment(JLabel.CENTER);
//		JButton backButton = new JButton("뒤로");
//		topPanel.setBackground(Color.PINK);
//		
//		// topPanel에 뒤로버튼, 제목 추가
//		topPanel.setLayout(new BorderLayout());
//		topPanel.add(backButton,"West");
//		topPanel.add(topLabel,"Center");
//		
//		
//		
//		
//		
//		// 게시글 라벨
//		JPanel centerPanel = new JPanel();
//		JLabel Bulletin = new JLabel("게에에에에시이이이이이그으으으으을");
//		Bulletin.setHorizontalAlignment(JLabel.CENTER);
//		centerPanel.setBackground(Color.PINK);
//		
//		// 친구추가 버튼, 작성자닉네임 라벨 
//		JPanel nickAndPlus = new JPanel();
//		JButton plusButton = new JButton("친구추가");
//		JLabel nickName = new JLabel("작성자닉네임   ");
//		nickName.setHorizontalAlignment(JLabel.RIGHT);
//		nickAndPlus.setBackground(Color.PINK);
//	
//		// centerPanel에 게시글
//		centerPanel.setLayout(new BorderLayout());
//		centerPanel.add(Bulletin, "Center");
//		
//		// nickAndPlus에 작성자닉네임, 친구차가 추가
//		nickAndPlus.setLayout(new BorderLayout());
//		nickAndPlus.add(nickName,"Center");
//		nickAndPlus.add(plusButton,"East");
//		centerPanel.add(nickAndPlus,"North");
//		
//		
//		
//		
//		
//	
//		
//		
//		mainFrame.add(topPanel, "North");
//		mainFrame.add(centerPanel, "Center");
	
		
		mainFrame.setVisible(true);			
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
//	public void bulletinMain() {
//
//	}
	
}
