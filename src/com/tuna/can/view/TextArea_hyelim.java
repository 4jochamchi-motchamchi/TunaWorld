package com.tuna.can.view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TextArea_hyelim {
	
	public static void main(String[] args) {
	
        //메인프레임 생
		JFrame frame = new JFrame("TextArea");
		frame.setLayout(null);
		frame.setSize(700, 900);
		
		//각위치의 패널생
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
		JButton backButton = new JButton(" back ");
		backButton.setBounds(30, 30, 90, 25);
		topPanel.add(backButton);
		
		
	    //제목
		JLabel subname = new JLabel("제목");
        subname.setBounds(50,10,90,25);
        TextField subject = new TextField(80);
        subject.setBounds(150,10, 500 ,25);
        
        subP.add(subname);
        subP.add(subject);
    
        
        //게시글
        TextArea txt = new TextArea(30,70);
        txt.setBounds(50,0,600,500);
        textareaP.add(txt);
        
        
		//날짜
       
      
        Date day = new Date();
        String today = day.toGMTString();
        JLabel oneul = new JLabel(today);
        oneul.setBounds(490, 0, 200, 30);
        bottonP.add(oneul);
        
        
     
        
        
        
        //공개범위 라디오 버튼
        JRadioButton myself = new JRadioButton("나만");
		JRadioButton friend= new JRadioButton("친구들");
		JRadioButton all = new JRadioButton("전체공개");
		
	    ButtonGroup range =new ButtonGroup();
	    range.add(myself);
	    range.add(friend);
	    range.add(all);
	    
	    myself.setBounds(40, 80, 80,50);
	    friend.setBounds(100, 80, 80, 50);
	    all.setBounds(170, 80, 80, 50);
	    
	    bottonP.add(myself);
	    bottonP.add(friend);
	    bottonP.add(all);
	    
        
	    

        //저장버튼
        JButton saveButton = new JButton(" save ");
		saveButton.setBounds(580, 80 , 80, 25);
		bottonP.add(saveButton);
		

		frame.add(topPanel);
	    frame.add(subP);
		frame.add(textareaP);
		frame.add(bottonP);
		

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
