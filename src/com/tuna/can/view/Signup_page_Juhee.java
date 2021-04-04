package com.tuna.can.view;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Signup_page_Juhee {
	
	public static void main(String[] args) {
		
		JFrame mf = new JFrame("Sign up");
		mf.setLayout(null);
		mf.setSize(700,900);
		try {
			mf.setIconImage(ImageIO.read(new File("image/logoBig.PNG")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
