package com.tuna.can.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.tuna.can.model.dto.UserInventoryDTO;
import com.tuna.can.service.TunaService;

public class ButtonController extends JButton implements ActionListener{
	private int buttonNumber;
	private String itemName;
	private String equipItemYN;
	private int itemNo;
	private int categoryNumber;
	private UserInventoryDTO inventory = null;
	
	TunaService service = new TunaService();

	TunaController controller = null;
	
	public ButtonController(int buttonNumber) {
		this.buttonNumber = buttonNumber;
	}
	
	public int getCategoryNumber() {
		return this.categoryNumber;
	}
	
	public void selectButtonInfo() {
		List<UserInventoryDTO> invenButtonInfo = new ArrayList<UserInventoryDTO>();
		
		invenButtonInfo = controller.selectUserInventory();
		
		inventory = new UserInventoryDTO();
		
		inventory = invenButtonInfo.get(buttonNumber);
		
		this.categoryNumber = inventory.getItemCategory();

		this.equipItemYN = inventory.getEquipItemYN();
		
		if(this.equipItemYN.equals("Y")) {
			
		}
		
	}
	
	public String equipItem() {
		
		
		return "";
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String equipYn = "";
		if(inventory.getEquipItemYN().equals("Y")) {
			equipYn = "N";
			
		} else {
			equipYn = "Y";
		}
		
//		int result = service.updateEquipYn(itemNo, equipYn);
		
		JOptionPane.showMessageDialog(null, "모든칸이 채워지지 않았습니다. \n 입력해주세요!", "경고", 0);
	}
	
	

}
