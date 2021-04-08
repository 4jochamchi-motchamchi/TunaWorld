package com.tuna.can.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
public class BulletinLayout extends JFrame{

	public BulletinLayout() {
		super("게시글 보기");
//		public static void main(String[] args) {
			
//			JFrame mainFrame = new JFrame();
			Border border = BorderFactory.createEtchedBorder(1);
			Border border2 = BorderFactory.createDashedBorder(Color.darkGray);
			Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);	
			Border whiteborder = BorderFactory.createLineBorder(Color.white, 1);	
			Border lightgrayborder = BorderFactory.createLineBorder(Color.lightGray, 1);	
			
			ImageIcon home = new ImageIcon("image/home.PNG");
			
			this.setTitle("게시글보기");
			this.setLayout(null);
			this.setSize(700,900);
			try {
				this.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			this.setBackground(Color.pink);
			
			JPanel topPanel = new JPanel();					// Back, 제목 들어갈 패널
			JPanel bulletinPanel = new JPanel();			// 게시글, 작성자닉넴, 친구추가 들어갈 패널
			JPanel commentsPanel = new JPanel();			// 댓글목록 패널
			JPanel writePanel = new JPanel();				// 댓글쓰는 패널
			
			JLabel topLabel = new JLabel("제목");			// 제목 들어갈 라벨(데이터 불러와야됨)
			JButton backButton = new JButton(home);			// 메인으로가기 버튼
			JLabel nickName = new JLabel("작성자닉네임");		// 닉네임 들어갈 라벨(데이터 불러와야됨)
			JButton plusFriend = new JButton("친구추가");		// 친구추가 들어갈 라벨
			JTextArea bulletin = new JTextArea("게에에시시그으을\n\n\nㄳㄳㄳ\n\n\n아아아아\n\n\n오오오오\n\n\n\n하이하이\n\n\n\n\n스크롤\n\n\n\n안녕");	// 게시글 들어갈 라벨(데이터 불러와야됨)
//			JLabel bulletinLabel = new JLabel();
			JLabel date = new JLabel("작성날짜들어갈거야아아아");	// 게시글 작성된 날짜 들어갈 라벨(데이터 불러와야됨)
//			JLabel comments = new JLabel();					// 댓글목록 보이는 라벨(데이터 불러와야됨)
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
			topLabel.setFont(new Font("휴먼둥근헤드라인",Font.PLAIN, 30));
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
			
			
			// 게시글 설정
			JPanel bulletinLabel = new JPanel();
			bulletinLabel.setLocation(50, 60);
			bulletinLabel.setSize(600, 350);
			bulletinLabel.setBackground(Color.white);
			bulletinLabel.setBorder(border2);
			bulletinPanel.add(bulletinLabel);

		    bulletin.setLocation(60, 70);
		    bulletin.setSize(580, 330);
		    bulletin.setBackground(Color.white);
		    bulletinPanel.add(bulletin);
		    
	        JScrollPane scrollPane = new JScrollPane(bulletin);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane.setBounds(60, 165, 589, 340);
	        scrollPane.setBorder(whiteborder);
	        this.getContentPane().add(scrollPane);
		    
			bulletin.setEditable(false);
			
			
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
//			comments.setLocation(55, 10);
//			comments.setSize(590, 180);
//			comments.setVerticalAlignment(JLabel.TOP);
//			commentsPanel.add(comments);
			
			
			
			
			
			// 댓글목록 설정(내용 불러와야함)
			commentsPanel.setLayout(null);
			commentsPanel.setPreferredSize(new Dimension(650,500));	
			
			JPanel commentList = null;
			
			for(int i = 0; i <= 10; i++) {
				
				commentList = new JPanel();
				
				commentList.setLayout(null);
				
				commentList.setBounds(0,(i * 50),700,50);
				
				commentList.setBorder(lightgrayborder);
				
				JLabel commentNickName = new JLabel("댓글닉네임 : ");
				commentNickName.setLayout(null);
				commentNickName.setBounds(5, 3, 100, 50);
				commentNickName.setBackground(Color.pink);
				commentList.add(commentNickName);
				
				/* 닉네임 옆에 라벨 따로 만들어서 댓글 내용 불러들어와야 함*/


				commentsPanel.add(commentList);
				
			}

			JScrollPane scrollbar = new JScrollPane(commentsPanel);
			scrollbar.setPreferredSize(new Dimension(685,200));
			scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			int width = scrollbar.getPreferredSize().width;
			int height = scrollbar.getPreferredSize().height;
			scrollbar.setBounds(0,550,width,height);
			scrollbar.setBackground(Color.pink);
			
			this.getContentPane().add(scrollbar);
			
			
			
			
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
			
			
			
			// 친구추가 버튼 눌렀을 때
			plusFriend.addActionListener(new ActionListener() {
							
				@Override
				public void actionPerformed(ActionEvent e) {
								
					if(e.getSource() == plusFriend) {
						JOptionPane.showMessageDialog(null,"친구요청을 보냈습니다.", "친구추가",1);	
					}				
				}
			});
			
			
			// 뒤로가기 버튼 눌렀을 때
			backButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(e.getSource() == backButton) {
						new Main_page();
						dispose();		
					}				
				}
			});
			
			// 댓글입력 버튼 눌렀을 때
//			inputButton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// getText() : JTextField에서 입력한 값을 가져오는 메소드
//					String text = "댓글닉네임 : " + writeComment.getText();
//
//					comments.
//					
//				}
//			});
//			
			
			
			
			this.add(topPanel);
			this.add(bulletinPanel);
//			this.add(commentsPanel);
			this.add(writePanel);
			
			this.setResizable(false);		
			this.setVisible(true);			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
		
	public static void main(String[] args) {
		
		new BulletinLayout();
	}

	
	
	
}

//	public static void main(String[] args) {
//		
//		JFrame mainFrame = new JFrame();
//		Border border = BorderFactory.createEtchedBorder(1);
//		Border border2 = BorderFactory.createDashedBorder(Color.darkGray);
//		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);	
//		Border whiteborder = BorderFactory.createLineBorder(Color.white, 1);	
//		
//		ImageIcon home = new ImageIcon("image/home.PNG");
//		
//		mainFrame.setTitle("게시글보기");
//		mainFrame.setLayout(null);
//		mainFrame.setSize(700,900);
//		try {
//			mainFrame.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//		mainFrame.setBackground(Color.pink);
//		
//		JPanel topPanel = new JPanel();					// Back, 제목 들어갈 패널
//		JPanel bulletinPanel = new JPanel();			// 게시글, 작성자닉넴, 친구추가 들어갈 패널
//		JPanel commentsPanel = new JPanel();			// 댓글목록 패널
//		JPanel writePanel = new JPanel();				// 댓글쓰는 패널
//		
//		JLabel topLabel = new JLabel("제목");				// 제목 들어갈 라벨(데이터 불러와야됨)
//		JButton backButton = new JButton(home);			// 메인으로가기 버튼
//		JLabel nickName = new JLabel("작성자닉네임");		// 닉네임 들어갈 라벨(데이터 불러와야됨)
//		JButton plusFriend = new JButton("친구추가");		// 친구추가 들어갈 라벨
//		JTextArea bulletin = new JTextArea("게에에시시그으을\n\n\nㄳㄳㄳ\n\n\n아아아아\n\n\n오오오오\n\n\n\n하이하이\n\n\n\n\n스크롤\n\n\n\n안녕");	// 게시글 들어갈 라벨(데이터 불러와야됨)
////		JLabel bulletinLabel = new JLabel();
//		JLabel date = new JLabel("작성날짜들어갈거야아아아");	// 게시글 작성된 날짜 들어갈 라벨(데이터 불러와야됨)
//		JLabel comments = new JLabel("대대대대대대댓글");	// 댓글목록 보이는 라벨(데이터 불러와야됨)
//		JLabel cm = new JLabel("댓글 : ");				// 댓글
//		JTextField writeComment = new JTextField();		// 댓글 쓸 수있는 텍스트박스
//		JButton inputButton = new JButton("입력");		// 댓글 입력 버튼
//		
//		
//		// topPanel 설정값
//		topPanel.setLayout(null);
//		topPanel.setLocation(0, 0);
//		topPanel.setSize(700, 100);
//		topPanel.setBackground(Color.pink);
//		topPanel.setBorder(border);
//		
//		// 뒤로가기버튼 설정
//		backButton.setBounds(30, 25, 55, 55);
//		backButton.setBackground(Color.pink);
//		backButton.setBorder(pinkborder);
//		topPanel.add(backButton);
//		
//		// 제목 설정
//		topLabel.setHorizontalAlignment(JLabel.CENTER);
//		topLabel.setBounds(115, 0, 470, 100);
//		topLabel.setFont(new Font("휴먼둥근헤드라인",Font.PLAIN, 30));
//		topPanel.add(topLabel);
//		
//		
//		// bulletinPanel 설정값		
//		bulletinPanel.setLayout(null);
//		bulletinPanel.setLocation(0, 100);
//		bulletinPanel.setSize(700, 450);
//		bulletinPanel.setBackground(Color.pink);
//		
//		// 작성자 닉네임 설정
//		nickName.setLocation(440, 25);
//		nickName.setSize(100, 25);
//		nickName.setHorizontalAlignment(JLabel.CENTER);
//		bulletinPanel.add(nickName);
//		
//		// 친구추가 설정
//		plusFriend.setLocation(550, 25);
//		plusFriend.setSize(100, 25);
//		bulletinPanel.add(plusFriend);
//		
////		JScrollPane scroll = new JScrollPane();
////		scroll.setBounds(690, 100, 8, 180);
//		
//		// 게시글 설정
//		JPanel bulletinLabel = new JPanel();
//		bulletinLabel.setLocation(50, 60);
//		bulletinLabel.setSize(600, 350);
//		bulletinLabel.setBackground(Color.white);
//		bulletinLabel.setBorder(border2);
//		bulletinPanel.add(bulletinLabel);
//
//	    bulletin.setLocation(60, 70);
//	    bulletin.setSize(580, 330);
//	    bulletin.setBackground(Color.white);
//	    bulletinPanel.add(bulletin);
//	    
//        JScrollPane scrollPane = new JScrollPane(bulletin);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setBounds(60, 170, 580, 330);
//        scrollPane.setBorder(whiteborder);
//        mainFrame.getContentPane().add(scrollPane);
//	    
//	    
//		
//		bulletin.setEditable(false);
//		
//		// 날짜라벨 설정
//		date.setLocation(50, 410);
//		date.setSize(600, 35);
//		date.setHorizontalAlignment(JLabel.RIGHT);
//		bulletinPanel.add(date);
//		
//		
//		// commentsPanel 설정값
//		commentsPanel.setLayout(null);
//		commentsPanel.setLocation(0, 550);
//		commentsPanel.setSize(700, 200);
//		commentsPanel.setBackground(Color.pink);
//		
//		// 댓글목록 설정
//		comments.setLocation(55, 10);
//		comments.setSize(590, 180);
//		comments.setVerticalAlignment(JLabel.TOP);
//		commentsPanel.add(comments);
//		
//		
//		// writePanel 설정값
//		writePanel.setLayout(null);
//		writePanel.setLocation(0, 750);
//		writePanel.setSize(700, 200);
//		writePanel.setBackground(Color.pink);
//		
//		// 댓글라벨
//		cm.setLocation(50, 10);
//		cm.setSize(50, 40);
//		cm.setFont(new Font("댓글 : ",Font.BOLD, 14));
//		writePanel.add(cm);
//		
//		// 댓글입력창 설정
//		writeComment.setLocation(100, 10);
//		writeComment.setSize(475, 40);
//		writeComment.setBorder(border);
//		writePanel.add(writeComment);
//		
//		// 댓글입력 버튼 설정
//		inputButton.setLocation(580,10);
//		inputButton.setSize(70, 40);
//		writePanel.add(inputButton);
//		
//		
//		
//		
//		
//		// 뒤로가기 버튼 눌렀을 때
//		backButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				if(e.getSource() == backButton) {
//
//
//					
//				}
//				
//			}
//		});
//		
//		
//		
//		
//		
//		mainFrame.add(topPanel);
//		mainFrame.add(bulletinPanel);
//		mainFrame.add(commentsPanel);
//		mainFrame.add(writePanel);
//		
//		mainFrame.setResizable(false);		
//		mainFrame.setVisible(true);			
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	}
//	
////	public void bulletinMain() {
////
////	}
//	
//}
