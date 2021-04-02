package com.tuna.can.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * <pre>
 * 로그인 할 수 있는 페이지
 * </pre>
 * @author Juhee hwang
 *
 */
public class Login_page_Juhee {
	
	public static void main(String[] args) {
		
		JFrame mf = new JFrame();
	
		mf.setSize(900,700);
		
		//로그인 ID
		JPanel panel = new JPanel();
		panel.add(new JLabel("아이디: "));
		
		//ID 텍스트 상자 생성
		JTextField idText = new JTextField(20);
		panel.add(idText);
		
		//로그인 PW
	
		panel.add(new JLabel("비밀번호: "));
		
		//pw 텍스트 상자 생성
		JPasswordField pwText = new JPasswordField(40);
		panel.add(pwText);
		
		//로그인 버튼 생성
		JButton loginBtn = new JButton("로그인");
		panel.add(loginBtn);
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		mf.add(panel);
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}

}
