package com.tuna.can.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.tuna.can.model.dto.UserInventoryDTO;
import com.tuna.can.service.TunaService;

public class InventoryButtonController extends JButton{
	
	private int itemNo;
	private String equipItemYN;
	private String itemName;
	private String itemImg;
	private int categoryNumber;
	
	private Map<String, Integer> resultMap = new HashMap<String, Integer>();
	
	private UserInventoryDTO inventory = null;
	private TunaController controller = new TunaController();
	
	
	public InventoryButtonController(UserInventoryDTO inventory) {
		this.inventory = inventory;
		this.setText(inventory.getItemImg());
		
		bottonAction();
		
	}
	
	public void bottonAction() {
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = 0;
				if(inventory.getEquipItemYN().equals("Y")) {
					
					inventory.setEquipItemYN("N");
					
				} else {
					inventory.setEquipItemYN("Y");
				}
				
				resultMap = controller.updateItemEquipYn(inventory);
				result = resultMap.get("result");
				if(result > 0) {
					if(inventory.getEquipItemYN().equals("Y")) {
						JOptionPane.showMessageDialog(null, resultMap.get("itemNO") + "번 아이템이 장착 되었습니다.", "장착", 0);
						
					} else {
						JOptionPane.showMessageDialog(null, resultMap.get("itemNO") + "번 아이템이 장착 해제 되었습니다.", "장착 해제", 0);
						
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "아이템은 하나만 장착 가능 합니다 ", "장착 실패", 0);
				}
			}
		});
	}

}
