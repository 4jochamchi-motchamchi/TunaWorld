package com.tuna.can.view;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;    // gjr

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 * <pre>
 * 게시판 글쓰기 페이지
 * </pre>
 * @author Hyelim Jeon
 *
 */
public class Text_Area extends JFrame{

	public Text_Area() {
		super("TextArea");
		
		this.setLayout(null);
		this.setSize(700, 900);
		this.setLocation(600, 50);
		//아이콘
		try {
			this.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//각위치의 패널 생성
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);
		topPanel.setBounds(0, 0, 700, 125);
		topPanel.setBackground(Color.pink);
		
		JPanel subP= new JPanel();
		subP.setLayout(null);
		subP.setBounds(0 ,125 ,700 ,50 );
		subP.setBackground(Color.pink);
	
		
		JPanel textareaP = new JPanel();
		textareaP.setLayout(null);
		textareaP.setBounds(0, 175, 700, 550);
	    textareaP.setBackground(Color.pink);
		
		
		JPanel bottonP = new JPanel();
		bottonP.setLayout(null);
		bottonP.setBounds(0, 725, 700, 175);
		bottonP.setBackground(Color.pink);
	
		
	

		//글쓰기 	글씨
		JLabel lbl = new JLabel(" 글쓰기 ");
		lbl.setBounds(350, 40, 150, 50);
		topPanel.add(lbl);

		// 뒤로가기 버튼
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
//		ImageIcon home = new ImageIcon("image/home.PNG");
//		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
//		JButton backButton = new JButton(home);
		backB.setBackground(Color.pink);
		backB.setBorder(pinkborder);
		backB.setBounds(30, 30, 55, 55);
		topPanel.add(backB);
		
		
	    //제목
		JLabel subname = new JLabel("제목");
        subname.setBounds(50,10,90,25);
        TextField subject = new TextField(80);
        subject.setBounds(140,10, 500 ,25);
        
        subP.add(subname);
        subP.add(subject);
    
        
        //게시글
        TextArea txt = new TextArea(30,70);
        txt.setBounds(40,0,600,550);
        textareaP.add(txt);
        
        
		//날짜
        Date day = new Date();
        String today = day.toLocaleString();
        JLabel oneul = new JLabel(today);
        oneul.setBounds(500, 10, 200, 30);
        bottonP.add(oneul);

        
        //공개범위 라디오 버튼
        JRadioButton myself = new JRadioButton("나만");
		JRadioButton friend= new JRadioButton("친구들");
		JRadioButton all = new JRadioButton("전체공개");
		
	    ButtonGroup range =new ButtonGroup();
	    range.add(myself);
	    range.add(friend);
	    range.add(all);
	   
	    myself.setBounds(50, 0, 60,50);
	    friend.setBounds(105, 0, 70, 50);
	    all.setBounds(170, 0, 80, 50);

	    bottonP.add(myself);
	    bottonP.add(friend);
	    bottonP.add(all);

	    myself.setBackground(Color.pink);
	    friend.setBackground(Color.pink);
	    all.setBackground(Color.pink);

        //저장버튼
        JButton saveButton = new JButton(" save ");
		saveButton.setBounds(550, 80 , 80, 25);
	    saveButton.addActionListener(new ActionListener() {
			
	    	
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource() == saveButton) {
						JOptionPane.showMessageDialog(null,"저장되었습니다");}
					
						new BoardList();
						dispose();
				}
			});
	    
	
		bottonP.add(saveButton);
		

		this.add(topPanel);
		this.add(subP);
		this.add(textareaP);
		this.add(bottonP);
		

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
		new Text_Area();
	}
}
	
	
	
	
	
//	public static void main"TextArea"(String[] args) {
	
        //메인프레임 생성
//		JFrame frame = new JFrame("TextArea");
//		frame.setLayout(null);
//		frame.setSize(700, 900);
//		//아이콘
//		try {
//			frame.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		//각위치의 패널 생성
//		JPanel topPanel = new JPanel();
//		topPanel.setLayout(null);
//		topPanel.setBounds(0, 0, 700, 125);
//		topPanel.setBackground(Color.pink);
//		
//		JPanel subP= new JPanel();
//		subP.setLayout(null);
//		subP.setBounds(0 ,125 ,700 ,50 );
//		subP.setBackground(Color.pink);
//	
//		
//		JPanel textareaP = new JPanel();
//		textareaP.setLayout(null);
//		textareaP.setBounds(0, 175, 700, 550);
//	    textareaP.setBackground(Color.pink);
//		
//		
//		JPanel bottonP = new JPanel();
//		bottonP.setLayout(null);
//		bottonP.setBounds(0, 725, 700, 175);
//		bottonP.setBackground(Color.pink);
//	
//		
//	
//
//		//글쓰기 	글씨
//		JLabel lbl = new JLabel(" 글쓰기 ");
//		lbl.setBounds(350, 40, 150, 50);
//		topPanel.add(lbl);
//
//		// 뒤로가기 버튼
//		ImageIcon home = new ImageIcon("image/home.PNG");
//		Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
//		JButton backButton = new JButton(home);
//		backButton.setBackground(Color.pink);
//		backButton.setBorder(pinkborder);
//		backButton.setBounds(30, 30, 55, 55);
//		topPanel.add(backButton);
//		
//		
//	    //제목
//		JLabel subname = new JLabel("제목");
//        subname.setBounds(50,10,90,25);
//        TextField subject = new TextField(80);
//        subject.setBounds(140,10, 500 ,25);
//        
//        subP.add(subname);
//        subP.add(subject);
//    
//        
//        //게시글
//        TextArea txt = new TextArea(30,70);
//        txt.setBounds(40,0,600,550);
//        textareaP.add(txt);
//        
//        
//		//날짜
//        Date day = new Date();
//        String today = day.toLocaleString();
//        JLabel oneul = new JLabel(today);
//        oneul.setBounds(500, 10, 200, 30);
//        bottonP.add(oneul);
//
//        
//        //공개범위 라디오 버튼
//        JRadioButton myself = new JRadioButton("나만");
//		JRadioButton friend= new JRadioButton("친구들");
//		JRadioButton all = new JRadioButton("전체공개");
//		
//	    ButtonGroup range =new ButtonGroup();
//	    range.add(myself);
//	    range.add(friend);
//	    range.add(all);
//	   
//	    myself.setBounds(50, 0, 60,50);
//	    friend.setBounds(105, 0, 70, 50);
//	    all.setBounds(170, 0, 80, 50);
//
//	    bottonP.add(myself);
//	    bottonP.add(friend);
//	    bottonP.add(all);
//
//	    myself.setBackground(Color.pink);
//	    friend.setBackground(Color.pink);
//	    all.setBackground(Color.pink);
//
//        //저장버튼
//        JButton saveButton = new JButton(" save ");
//		saveButton.setBounds(550, 80 , 80, 25);
//		bottonP.add(saveButton);
//		
//
//		frame.add(topPanel);
//	    frame.add(subP);
//		frame.add(textareaP);
//		frame.add(bottonP);
//		
//
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	}

//}
