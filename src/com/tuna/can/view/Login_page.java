package com.tuna.can.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.tuna.can.controller.TunaController;

import com.tuna.can.controller.Test;


/**
 * <pre>
 * 로그인 할 수 있는 페이지
 * </pre>
 * @author Juhee hwang
 *
 */
public class Login_page extends JFrame{
	TunaController tunaController = new TunaController();
	
	
	public void login(JTextField idText) {
		
		
		tunaController.loginMember(idText.toString());
				
	}



	public Login_page() {
		super("Login page");
//		public static void main(String[] args) {
			
//			JFrame mf = new JFrame("Login Page");
			this.setLayout(null);
			this.setSize(700,900);
			this.setLocation(600, 50);
			try {
				this.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			// image 패널
			JPanel imagePanel = new JPanel();
			imagePanel.setBackground(Color.PINK);
			imagePanel.setLayout(null);
			imagePanel.setLocation(0,0);
			imagePanel.setSize(700,420);
			
			// id/pw 패널
			JPanel loginPanel = new JPanel();
			loginPanel.setBackground(Color.pink);
			loginPanel.setLayout(null);
			loginPanel.setLocation(0, 420);
			loginPanel.setSize(700,450);
			
			// 4조참치 로고
			ImageIcon icon = new ImageIcon("image/logoBig_ver2.PNG");
			JLabel imageLable = new JLabel(icon);
			imageLable.setBounds(30, 30, 650, 380);
			imagePanel.add(imageLable);
			
			//로그인 ID
			
			JLabel idLabel = new JLabel("아 이 디 : ");
			idLabel.setBounds(200, 100, 100, 50);
			idLabel.setFont(new Font("아 이 디 : ", Font.BOLD, 22));
			loginPanel.add(idLabel);
			
		
			//ID 텍스트 상자 생성
			JTextField idText = new JTextField(20);
			idText.setBounds(320, 110, 150, 40);
			loginPanel.add(idText);
			
			
		
			//로그인 PW
			JLabel pwLabel = new JLabel("비밀번호 : ",JLabel.CENTER);
			pwLabel.setBounds(170, 160, 150, 60);
			pwLabel.setFont(new Font("비밀번호 : ", Font.BOLD, 22));
			loginPanel.add(pwLabel);
			
			//pw 텍스트 상자 생성
			JPasswordField pwText = new JPasswordField(40);
			pwText.setBounds(320, 170, 150, 40);
			loginPanel.add(pwText);
			
			//로그인 버튼 생성
			Border pinkborder = BorderFactory.createLineBorder(Color.pink, 1);
			ImageIcon login = new ImageIcon("image/login.png");
			ImageIcon rollover_login = new ImageIcon("image/rollover_login.PNG");
			JButton loginBtn = new JButton(login);
			loginBtn.setBackground(Color.PINK);
			loginBtn.setBorder(pinkborder);
			loginBtn.setBounds(150, 250, 190, 90);
			loginBtn.setRolloverIcon(rollover_login);
			
//			loginBtn.reshape(150, 230, 160, 90);
			
//			loginBtn.setPressedIcon(loginBtn);
			
			
			//회원가입 버튼 생성
			ImageIcon signUp = new ImageIcon("image/signUp.png");
			ImageIcon rollover_signUp = new ImageIcon("image/rollover_signUp.PNG");
			JButton createUserBtn = new JButton(signUp);
			createUserBtn.setBackground(Color.PINK);
			createUserBtn.setBorder(pinkborder);
			createUserBtn.setBounds(370, 250, 190, 90);
			createUserBtn.setRolloverIcon(rollover_signUp);
			createUserBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						new Signup_page();
						dispose();
				}
			});
			
			loginPanel.add(loginBtn);
//			loginPanel.add(rollover_loginBtn);
			loginPanel.add(createUserBtn);
			
			
			
			loginBtn.addActionListener(new ActionListener() {

						
				@Override
				public void actionPerformed(ActionEvent e) {
										
					if(idText.getText().isEmpty() && pwText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 입력되지않았습니다. \n 입력해주세요!", "경고", 0);
						idText.requestFocus();
						return;
					}
					if(idText.getText().isEmpty() || pwText.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "빈칸이 있습니다. \n 채워주세요!","경고",0);
						idText.requestFocus();
						return;
					}
				}
			});

			this.add(imagePanel);
			this.add(loginPanel);
			this.setResizable(false);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
		
		}

//	public void setRolloverIcon(Icon rolloverIcon) {
//		ImageIcon login = new ImageIcon("image/login.png");
//		rolloverIcon.paintIcon(login);
//	}

	public static void main(String[] args) {
		
		new Login_page();
	}	
	

}
	
//	public static void main(String[] args) {
//		
//		JFrame mf = new JFrame("Login Page");
//		mf.setLayout(null);
//		mf.setSize(700,900);
//		try {
//			mf.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//		// image 패널
//		JPanel imagePanel = new JPanel();
//		imagePanel.setBackground(Color.PINK);
//		imagePanel.setLayout(null);
//		imagePanel.setLocation(0,0);
//		imagePanel.setSize(700,420);
//		
//		// id/pw 패널
//		JPanel loginPanel = new JPanel();
//		loginPanel.setBackground(Color.pink);
//		loginPanel.setLayout(null);
//		loginPanel.setLocation(0, 420);
//		loginPanel.setSize(700,450);
//		
//		// 4조참치 로고
//		ImageIcon icon = new ImageIcon("image/logoBig_ver2.PNG");
//		JLabel imageLable = new JLabel(icon);
//		imageLable.setBounds(30, 30, 650, 380);
//		imagePanel.add(imageLable);
//		
//		//로그인 ID
//		
//		JLabel idLabel = new JLabel("아 이 디 : ");
//		idLabel.setBounds(200, 100, 100, 50);
//		idLabel.setFont(new Font("아 이 디 : ", Font.BOLD, 22));
//		loginPanel.add(idLabel);
//		
//	
//		//ID 텍스트 상자 생성
//		JTextField idText = new JTextField(20);
//		idText.setBounds(320, 110, 150, 40);
//		loginPanel.add(idText);
//		
//		
//	
//		//로그인 PW
//	
//		JLabel pwLabel = new JLabel("비밀번호 : ",JLabel.CENTER);
//		pwLabel.setBounds(170, 160, 150, 60);
//		pwLabel.setFont(new Font("비밀번호 : ", Font.BOLD, 22));
//		loginPanel.add(pwLabel);
//		
//		//pw 텍스트 상자 생성
//		JPasswordField pwText = new JPasswordField(40);
//		pwText.setBounds(320, 170, 150, 45);
//		loginPanel.add(pwText);
//		
//		//로그인 버튼 생성
//		JButton loginBtn = new JButton("로그인");
//		loginBtn.setBounds(180, 280, 150, 40);
//		loginBtn.setFont(new Font("로그인", Font.BOLD, 18));
//		
//		//회원가입 버튼 생성
//		JButton createUserBtn = new JButton("회원가입");
//		createUserBtn.setBounds(380, 280, 150, 40);
//		createUserBtn.setFont(new Font("회원가입", Font.BOLD, 18));
//		
//		loginPanel.add(loginBtn);
//		loginPanel.add(createUserBtn);
//		
//		loginBtn.addActionListener(new ActionListener() {
//					
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				if(idText.getText().isEmpty() && pwText.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 입력되지않았습니다. \n 입력해주세요!");
//					return;
//				}
//				if(idText.getText().isEmpty() || pwText.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "빈칸이 있습니다. \n 채워주세요!");
//					return;
//				}
//				
//				
//			}
//		});
//
//		mf.add(imagePanel);
//		mf.add(loginPanel);
//		mf.setResizable(false);
//		mf.setVisible(true);
//		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//	
//	}
//
//}
