package com.tuna.can.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tuna.can.model.dto.StoreItemDTO;
import com.tuna.can.view.Store;

public class StoreItemButtonController extends JButton{

	
	private int itemPrice;
	private String itemImg;
	private int itemCategory;
	private TunaController controller = new TunaController();

	public StoreItemButtonController(StoreItemDTO item, JFrame frame) {
		
		ImageIcon itemImg = new ImageIcon("image/" + item.getItemImg());
		
		this.setIcon(itemImg);

//		this.setText(item.getItemImg());
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Map<String, Integer> resultMap = new HashMap<String, Integer>();
				
				int result = 0;
				int coinUpdateResult = 0;
				int coin = 0;
				resultMap = controller.storeItemBuy(item);
				
				result = resultMap.get("invenUpdateresult");
				coinUpdateResult = resultMap.get("coinUpdateResult");
				coin = resultMap.get("coin");
				
				if((result + coinUpdateResult) == 2) {
					JOptionPane.showMessageDialog(null, "아이템 구매 성공! 현재 보유 코인 " + coin , "구매성공", 0);
				} else if(result == 3){
					JOptionPane.showMessageDialog(null, "이미 소유한 아이템 입니다.", "보유중", 0);
				} else {
					JOptionPane.showMessageDialog(null, "보유 코인 부족", "코인 부족", 0);
				}
				new Store();
				frame.dispose();
				
			}
		});
	}
	
}


