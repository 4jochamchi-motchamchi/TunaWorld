package com.tuna.can.view;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 * <pre>
 * 게시판 목록 페이지
 * </pre>
 * @author Hyelim Jeon
 *
 */
public class BoardList_hyelim {

	public static void main(String[] args) {

		//메인프레임생성
		JFrame frame = new JFrame("BoardList");
		frame.setLayout(null);
		frame.setSize(700, 900);
		
		//아이콘
		try {
			frame.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//각위치 패널 생성
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 700, 125);
		topPanel.setBackground(Color.pink);
		
	    JPanel midlePanel = new JPanel();
	    midlePanel.setLayout(null);
	    midlePanel.setBounds(0,125,700,650);
	    midlePanel.setBackground(Color.pink);
	    
	    JPanel bottonPanel = new JPanel();
	    bottonPanel.setLayout(null);
	    bottonPanel.setBounds(0, 775, 700, 125);
	    bottonPanel.setBackground(Color.pink);
	    
	   
		
		// 뒤로가기 버튼
	    ImageIcon home = new ImageIcon("image/home.PNG");
		JButton backButton = new JButton(home);
		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
		backButton.setBounds(30, 30, 55, 55);
		backButton.setBackground(Color.pink);
		backButton.setBorder(pinkborder);
		topPanel.add(backButton);
		
		//전체게시글 글씨
		JLabel lbl = new JLabel(" 전체게시글 ");
		lbl.setBounds(350, 40, 150, 50);
		topPanel.add(lbl);
		
	    
		//전체글 리스트 
        JList list = new JList();
        midlePanel.add(list);

        
		//스크롤
		
//		JScrollPane scroll = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//			    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		
//        midlePanel.add(scroll);
        JScrollPane a = new JScrollPane();
        midlePanel.add(a);
		

		//삭제버튼(확인팝업)
		JButton deleteButton  = new JButton("delete");
		deleteButton.addActionListener(null);
		
		
		
		//수정버튼
	   
	    

		
	    //내게시글보기 버튼
		JButton myboard  = new JButton("myboard");
		myboard.setBounds(30, 20, 90, 30);
		bottonPanel.add(myboard);
		
		
		//글쓰러 가기 버튼
		JButton write  = new JButton("write");
	    write.setBounds(560, 20, 90, 30);
	    bottonPanel.add(write);
		
		
		frame.add(topPanel);
		frame.add(midlePanel);
		frame.add(bottonPanel);
		

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

}
