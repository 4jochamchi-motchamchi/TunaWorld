package com.tuna.can.view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * 
 * <pre>
 *  게시글 보기 레이아웃
 * </pre> 
 * @author NaraWee
 *
 */
public class BulletinLayout_nara {

	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);	
		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);	
		
		ImageIcon home = new ImageIcon("image/home.PNG");
		
		mainFrame.setTitle("게시글보기");
		mainFrame.setLayout(null);
		mainFrame.setSize(700,900);
		try {
			mainFrame.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		mainFrame.setBackground(Color.pink);
		
		JPanel topPanel = new JPanel();					// Back, 제목 들어갈 패널
		JPanel bulletinPanel = new JPanel();			// 게시글, 작성자닉넴, 친구추가 들어갈 패널
		JPanel commentsPanel = new JPanel();			// 댓글목록 패널
		JPanel writePanel = new JPanel();				// 댓글쓰는 패널
		
		JLabel topLabel = new JLabel("제목");				// 제목 들어갈 라벨(데이터 불러와야됨)
		JButton backButton = new JButton(home);		// 메인으로가기 버튼
		JLabel nickName = new JLabel("작성자닉네임");		// 닉네임 들어갈 라벨(데이터 불러와야됨)
		JButton plusFriend = new JButton("친구추가");		// 친구추가 들어갈 라벨
		JLabel bulletin = new JLabel("게에에시시그으을");	// 게시글 들어갈 라벨(데이터 불러와야됨)
		JLabel date = new JLabel("작성날짜들어갈거야아아아");	// 게시글 작성된 날짜 들어갈 라벨(데이터 불러와야됨)				
;		JLabel comments = new JLabel("대대대대대대댓글");	// 댓글목록 보이는 라벨(데이터 불러와야됨)
		JLabel cm = new JLabel("댓글 : ");				// 댓글
		JTextField writeComment = new JTextField();		// 댓글 쓸 수있는 텍스트박스
		JButton inputButton = new JButton("입력");		// 댓글 입력 버튼
		
		
		// topPanel 설정값
		topPanel.setLayout(null);
		topPanel.setLocation(0, 0);
		topPanel.setSize(700, 100);
		topPanel.setBackground(Color.pink);
		topPanel.setBorder(border);
		
		// 뒤로가기버튼 설정
		backButton.setBounds(30, 25, 55, 55);
		backButton.setBackground(Color.pink);
		backButton.setBorder(pinkborder);
		topPanel.add(backButton);
		
		// 제목 설정
		topLabel.setHorizontalAlignment(JLabel.CENTER);
		topLabel.setBounds(115, 0, 470, 100);
		topLabel.setFont(new Font("제목",Font.BOLD, 22));
		topPanel.add(topLabel);
		
		
		// bulletinPanel 설정값
		bulletinPanel.setLayout(null);
		bulletinPanel.setLocation(0, 100);
		bulletinPanel.setSize(700, 450);
		bulletinPanel.setBackground(Color.pink);
		
		// 작성자 닉네임 설정
		nickName.setLocation(440, 25);
		nickName.setSize(100, 25);
		nickName.setHorizontalAlignment(JLabel.CENTER);
		bulletinPanel.add(nickName);
		
		// 친구추가 설정
		plusFriend.setLocation(550, 25);
		plusFriend.setSize(100, 25);
		bulletinPanel.add(plusFriend);
		
//		JScrollPane scroll = new JScrollPane();
//		scroll.setBounds(690, 100, 8, 180);
		
		// 게시글 설정
		bulletin.setLocation(50, 60);
		bulletin.setSize(600, 350);
		bulletin.setBorder(border);
		bulletinPanel.add(bulletin);
		
		// 날짜라벨 설정
		date.setLocation(50, 410);
		date.setSize(600, 35);
		date.setHorizontalAlignment(JLabel.RIGHT);
		bulletinPanel.add(date);
		
		
		// commentsPanel 설정값
		commentsPanel.setLayout(null);
		commentsPanel.setLocation(0, 550);
		commentsPanel.setSize(700, 200);
		commentsPanel.setBackground(Color.pink);
		
		// 댓글목록 설정
		comments.setLocation(50, 10);
		comments.setSize(600, 180);
		comments.setVerticalAlignment(JLabel.TOP);
		commentsPanel.add(comments);
		
		
		// writePanel 설정값
		writePanel.setLayout(null);
		writePanel.setLocation(0, 750);
		writePanel.setSize(700, 200);
		writePanel.setBackground(Color.pink);
		
		// 댓글라벨
		cm.setLocation(50, 10);
		cm.setSize(50, 40);
		cm.setFont(new Font("댓글 : ",Font.BOLD, 14));
		writePanel.add(cm);
		
		// 댓글입력창 설정
		writeComment.setLocation(100, 10);
		writeComment.setSize(475, 40);
		writeComment.setBorder(border);
		writePanel.add(writeComment);
		
		// 댓글입력 버튼 설정
		inputButton.setLocation(580,10);
		inputButton.setSize(70, 40);
		writePanel.add(inputButton);
		
		
		mainFrame.add(topPanel);
		mainFrame.add(bulletinPanel);
		mainFrame.add(commentsPanel);
		mainFrame.add(writePanel);
		mainFrame.setResizable(false);

		
		
		
		
		
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
