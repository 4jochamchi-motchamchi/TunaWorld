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
import javax.swing.JPanel;

import com.tuna.can.model.dto.UserInventoryDTO;
import com.tuna.can.service.TunaService;
import com.tuna.can.view.MyPage;

public class InventoryButtonController extends JButton{
	
	private int itemNo;
	private String equipItemYN;
	private String itemName;
	private String itemImg;
	private int categoryNumber;
	
	private Map<String, Object> resultMap = new HashMap<String, Object>();
	
	private UserInventoryDTO inventory = null;
	
	public InventoryButtonController(UserInventoryDTO inventory) {
		
		this.inventory = inventory;
		
		this.setText(inventory.getItemImg());
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TunaController controller = new TunaController();
				
				String resultComent = "";
				if(inventory.getEquipItemYN().equals("Y")) {
					
					inventory.setEquipItemYN("N");
					
				} else {
					inventory.setEquipItemYN("Y");
				}
				
				resultMap = controller.updateItemEquipYn(inventory);
				
				resultComent = resultMap.get("result").toString();
				
				switch (resultComent) {
				case "장착성공":
					JOptionPane.showMessageDialog(null, resultMap.get("itemNo") + "번 아이템이 장착 되었습니다.", "장착성공", 0);					
					break;
					
					
//					장착 실패시 장착여부 다시 변경
				case "장착실패":
					JOptionPane.showMessageDialog(null, resultMap.get("itemNo") + "번 아이템 장착에 실패 하였습니다.", "장착실패", 0);
					if(inventory.getEquipItemYN().equals("Y")) {
						
						inventory.setEquipItemYN("N");
						
					} else {
						inventory.setEquipItemYN("Y");
					}
					
					break;
					
					
//					이미 장착시 장착여부 다시 변경
				case "이미장착":
					JOptionPane.showMessageDialog(null, resultMap.get("itemNo") + "번 아이템은 이미 장착 중입니다.", "이미장착", 0);
					if(inventory.getEquipItemYN().equals("Y")) {
						
						inventory.setEquipItemYN("N");
						
					} else {
						inventory.setEquipItemYN("Y");
					}
					
					break;
					
				case "한개만장착가능":
					JOptionPane.showMessageDialog(null, "아이템은 카테고리별로 한개만 장착 가능합니다", "한개만장착가능", 0);
					if(inventory.getEquipItemYN().equals("Y")) {
						
						inventory.setEquipItemYN("N");
						
					} else {
						inventory.setEquipItemYN("Y");
					}
					
					break;					
				case "장착해제":
					JOptionPane.showMessageDialog(null, resultMap.get("itemNo") + "번 아이템이 장착 해제 되었습니다.", "장착해제", 0);
					break;
				}
			}
		});
		
	}


	
}
