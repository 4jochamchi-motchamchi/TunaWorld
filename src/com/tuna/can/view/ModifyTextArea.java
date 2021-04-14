package com.tuna.can.view;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;    // gjr
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.tuna.can.controller.TunaController;
import com.tuna.can.model.dto.BoardDTO;




	/**
	 * <pre>
	 * 글 수정 페이지
	 * </pre>
	 * @author Hyelim Jeon
	 *
	 */
	public class ModifyTextArea extends JFrame{

		TunaController tunaController = new TunaController();
		public ModifyTextArea() {}
		public ModifyTextArea(int boardNo) {
			super("수정하기");
			
			int boardNum = boardNo;
			int userNo = 2;
			
            //게시글 DTO
			BoardDTO board = new BoardDTO();
			board = tunaController.modifySecretBoard(boardNum);
	

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
			JLabel lbl = new JLabel("  수정하기 ");
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

			backB.setBackground(Color.pink);
			backB.setBorder(pinkborder);
			backB.setBounds(30, 30, 55, 55);
			topPanel.add(backB);
			
			Scanner sc = new Scanner(System.in);
			
		    //제목
			JLabel titleT = new JLabel("제목");
	        titleT.setBounds(50,10,90,25);
	        JTextField subject = new JTextField(board.getTitle());
	        subject.setBounds(140,10, 500 ,25);
	        String sub = subject.getText();
	      
	        
	 
	        subP.add(titleT);
	        subP.add(subject);
	    
	        
	        //게시글
	        TextArea txt = new TextArea(board.getBoardContent());
	        txt.setBounds(40,0,600,550);
	        textareaP.add(txt);
	        String content  = txt.getText();
	   
	    

	        
	        
	        
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
		    JLabel jListNo = new JLabel();
		    jListNo.setVisible(false);
		    all.setBounds(40, 0, 100,50);
		    all.addActionListener(new ActionListener() {
		    	
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
		    		Integer listno = 1;
		    	    jListNo.setText(listno.toString());
		    		
		    	}
		    });
		    	
		    
		    myself.setBounds(140, 0, 100, 50);
		    myself.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Integer listno = 2;
		    	    jListNo.setText(listno.toString());				
				}
			});
		    friend.setBounds(240, 0, 100, 50);
		    friend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					Integer listno = 3;
		    	    jListNo.setText(listno.toString());
				}
			});

		    range.add(all);
		    int listno =0;
		    all.setBounds(50, 0, 100, 50);
		    myself.setBounds(150, 0, 100,50);
		    friend.setBounds(250, 0, 100, 50);

		    

		    bottonP.add(myself);
		    bottonP.add(friend);
		    bottonP.add(all);

		    myself.setBackground(Color.pink);
		    friend.setBackground(Color.pink);
		    all.setBackground(Color.pink);
		    
		 
		
	        //저장버튼
		    ImageIcon save = new ImageIcon("image/save.PNG");
	        JButton saveButton = new JButton(save);
	        saveButton.setBackground(Color.pink);
	        saveButton.setBorder(pinkborder);
			saveButton.setBounds(580, 50 , 80, 50);
		    saveButton.addActionListener(new ActionListener() {
				
		    	
				public void actionPerformed(ActionEvent e) {
				
					BoardDTO board = new BoardDTO();
					
					
					if(e.getSource() == saveButton) {
						
					
						int result = 0;
						Map<String, Object> newInputContent = new HashMap<String, Object>();

						newInputContent.put("listNo", Integer.parseInt(jListNo.getText()));
						newInputContent.put("title", subject.getText());
						newInputContent.put("content", txt.getText());
						newInputContent.put("userNo", tunaController.checkUserNo(tunaController.loginMemberId));
						result = tunaController.insertBoard(newInputContent);

						
//						int result =controller.insertBoard(board);

						if(result > 0) {
							JOptionPane.showConfirmDialog(null,"저장되었습니다","성공!!",-1);
//							txt.requestFocus();

						    new BoardList();
						     dispose();
						}else {
							JOptionPane.showMessageDialog(null,"게시글 저장에 실패했습니다", "실패",-1);
							  }
						}
						
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
			
			new ModifyTextArea();
		}
		
		
}