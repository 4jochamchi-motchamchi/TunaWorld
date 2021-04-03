package com.tuna.can.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;

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
      topPanel.setBackground(Color.black);
      
//      좌측 하단 패널
      bottomPanel1.setLayout(null);
      bottomPanel1.setLocation(0, 250);
      bottomPanel1.setSize(350, 650);
      bottomPanel1.setBackground(Color.blue);
      
//      우측 하단 패널   
      bottomPanel2.setLayout(null);
      bottomPanel2.setLocation(350, 250);
      bottomPanel2.setSize(350, 650);
      bottomPanel2.setBackground(Color.gray);
      
//      우측 하단 상단 패널
      bottomTopPanel.setLayout(new GridLayout(0,3));
      bottomTopPanel.setSize(350,100);
      bottomTopPanel.setLocation(0, 0);
      bottomTopPanel.setBackground(Color.green);
      
      Panel bottomTopPanel1 = new Panel();
      bottomTopPanel1.setBackground(Color.CYAN);
      Panel bottomTopPanel2 = new Panel();
      bottomTopPanel2.setBackground(Color.PINK);
      Panel bottomTopPanel3 = new Panel();
      bottomTopPanel3.setBackground(Color.RED);
      
      
//      우측 하단 하단 패널
      bottomBottomPanel.setLayout(new GridLayout(3, 2, 20, 20));
      bottomBottomPanel.setLocation(0, 100);
      bottomBottomPanel.setSize(350, 550);
      bottomBottomPanel.setBackground(Color.orange);
      
      for(int i = 1; i < 7; i++) {
         bottomBottomPanel.add(new JButton());
      }

      
      
      bottomTopPanel.add(bottomTopPanel1);
      bottomTopPanel.add(bottomTopPanel2);
      bottomTopPanel.add(bottomTopPanel3);
      
      bottomPanel2.add(bottomTopPanel);
      bottomPanel2.add(bottomBottomPanel);
      frame.add(topPanel);
      frame.add(bottomPanel1);
      frame.add(bottomPanel2);

      
      frame.setVisible(true);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
   
   
   
}