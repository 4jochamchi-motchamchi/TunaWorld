package com.tuna.can.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.tuna.can.model.dto.StoreItemDTO;

public class StoreItemButtonController extends JButton{

	
	private int itemPrice;
	private String itemImg;
	private int itemCategory;
	private TunaController controller = new TunaController();

	public StoreItemButtonController(StoreItemDTO item) {

		this.setText(item.getItemImg());
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = controller.storeItemBuy(item);
				
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "템 구매 성공", "구매성공", 0);
				} else if(result == 2){
					JOptionPane.showMessageDialog(null, "이미 소유한 아이템 입니다..", "구매성공", 0);
				} else {
					JOptionPane.showMessageDialog(null, "보유 코인 부족", "구매성공", 0);
				}
				
			}
		});
	}
	
}


