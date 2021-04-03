package com.tuna.can.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.naming.NameAlreadyBoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyPage_sunwoong {

   public static void main(String[] args) {
      
      JFrame frame = new JFrame("MyPage");
      
      frame.setLayout(null);
      
      frame.setSize(700,900);
      
//      위쪽 패널
      Panel topPanel = new Panel();
      
//      좌측 하단 패널
      Panel bottomPanel1 = new Panel();
      
//      우측 하단 패널
      Panel bottomPanel2 = new Panel();
      
//      우측 하단 내 위쪽 패널
      Panel bottomTopPanel = new Panel();
      
//      우측 하단 내 하단 패널
      Panel bottomBottomPanel = new Panel();
      
//      위쪽 패널
      topPanel.setLayout(null);
      topPanel.setLocation(0, 0);
      topPanel.setSize(700, 250);
      topPanel.setBackground(Color.pink);
      
      JButton backButton = new JButton("back");
      backButton.setBounds(10, 10, 90, 25);
      
      topPanel.add(backButton);
      
//      좌측 하단 패널
      bottomPanel1.setLayout(null);
      bottomPanel1.setLocation(0, 250);
      bottomPanel1.setSize(350, 650);
      bottomPanel1.setBackground(Color.white);
      
      Label infoLabel = new Label("information");
      infoLabel.setBounds(20, 20, 200, 50);
      infoLabel.setFont(new Font("test", Font.BOLD, 30));
      
      Font font = new Font("woongFont",Font.BOLD, 18);
      
      Label nameLabel = new Label("username");
      nameLabel.setBounds(20, 100, 90, 30);
      nameLabel.setFont(font);
      Label phoneLabel = new Label("phone");
      phoneLabel.setBounds(30, 190, 80, 30);
      phoneLabel.setFont(font);
      Label emailLabel = new Label("email");
      emailLabel.setBounds(30, 280, 80, 30);
      emailLabel.setFont(font);
      Label genderLabel = new Label("gender");
      genderLabel.setBounds(30, 370, 80, 30);
      genderLabel.setFont(font);
      Label ageLabel = new Label("age");
      ageLabel.setBounds(30, 460, 80, 30);
      ageLabel.setFont(font);
      
      JTextField nameText = new JTextField(10);
      nameText.setBounds(130, 100, 186, 35);
      JTextField phoneText = new JTextField(10);
      phoneText.setBounds(130, 190, 186, 35);
      JTextField emailText = new JTextField(10);
      emailText.setBounds(130, 280, 186, 35);
      JTextField genderText = new JTextField(10);
      genderText.setBounds(130, 370, 186, 35);
      JTextField ageText = new JTextField(10);
      ageText.setBounds(130, 460, 186, 35);
      
      JButton userCommit = new JButton("commit");
      userCommit.setBounds(240, 530, 80, 40);
     
      bottomPanel1.add(infoLabel);
      bottomPanel1.add(nameLabel);
      bottomPanel1.add(phoneLabel);
      bottomPanel1.add(emailLabel);
      bottomPanel1.add(genderLabel);
      bottomPanel1.add(ageLabel);
      
      bottomPanel1.add(nameText);
      bottomPanel1.add(phoneText);
      bottomPanel1.add(emailText);
      bottomPanel1.add(genderText);
      bottomPanel1.add(ageText);
      
      bottomPanel1.add(userCommit);
      
      
//      우측 하단 패널   
      bottomPanel2.setLayout(null);
      bottomPanel2.setLocation(350, 250);
      bottomPanel2.setSize(350, 650);
      bottomPanel2.setBackground(Color.gray);
      
//      우측 하단 상단 패널
      bottomTopPanel.setLayout(new GridLayout(0,3));
      bottomTopPanel.setSize(350,100);
      bottomTopPanel.setLocation(0, 0);
//      bottomTopPanel.setBackground(Color.green);

//      bottomTopPanel.add(comp);
//      bottomTopPanel.add(comp);
//      bottomTopPanel.add(comp);
      
//    좌측 하단 my캐릭터, 배경색, 폰트  변경
//      버튼or라벨
      Font myfont = new Font("내캐릭터 폰트", Font.BOLD, 18);
      
      JButton myCharacterButton = new JButton();
      JLabel myCharacterLabel = new JLabel("내 캐릭터");
      myCharacterButton.add(myCharacterLabel);
      myCharacterLabel.setFont(myfont);
      
      JButton myBackgroundButton = new JButton();
      JLabel myBackgroundLabel = new JLabel("내 배경색");
      myBackgroundButton.add(myBackgroundLabel);
      myBackgroundLabel.setFont(myfont);
      
      JButton myFontButton = new JButton();
      JLabel myFontLabel = new JLabel("내 폰트");
      myFontButton.add(myFontLabel);
      myFontLabel.setFont(myfont);
      
      
//      Panel bottomTopPanel1 = new Panel();
//      bottomTopPanel1.setBackground(Color.CYAN);
//      Panel bottomTopPanel2 = new Panel();
//      bottomTopPanel2.setBackground(Color.PINK);
//      Panel bottomTopPanel3 = new Panel();
//      bottomTopPanel3.setBackground(Color.RED);
      
      bottomTopPanel.add(myCharacterButton);
      bottomTopPanel.add(myBackgroundButton);
      bottomTopPanel.add(myFontButton);
      
      
//      우측 하단 하단 패널
//      new GridLayout(3, 2, 20, 20)
      bottomBottomPanel.setLayout(null);
      bottomBottomPanel.setLocation(0, 100);
      bottomBottomPanel.setSize(350, 550);
      bottomBottomPanel.setBackground(Color.pink);
      
      JButton inventory1 = new JButton();
      inventory1.setBounds(35, 30, 120, 120);
      JButton inventory2 = new JButton();
      inventory2.setBounds(185, 30, 120, 120);
      JButton inventory3 = new JButton();
      inventory3.setBounds(35, 180, 120, 120);
      JButton inventory4 = new JButton();
      inventory4.setBounds(185, 180, 120, 120);
      JButton inventory5 = new JButton();
      inventory5.setBounds(35, 330, 120, 120);
      JButton inventory6 = new JButton();
      inventory6.setBounds(185, 330, 120, 120);

      bottomBottomPanel.add(inventory1);
      bottomBottomPanel.add(inventory2);
      bottomBottomPanel.add(inventory3);
      bottomBottomPanel.add(inventory4);
      bottomBottomPanel.add(inventory5);
      bottomBottomPanel.add(inventory6);
      
      
      bottomPanel2.add(bottomTopPanel);
      bottomPanel2.add(bottomBottomPanel);
      frame.add(topPanel);
      frame.add(bottomPanel1);
      frame.add(bottomPanel2);

      
      frame.setVisible(true);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
   
}


















