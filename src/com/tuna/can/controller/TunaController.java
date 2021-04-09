package com.tuna.can.controller;


import java.util.ArrayList;
import java.util.List;

import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;
import com.tuna.can.service.TunaService;

public class TunaController {
	
	private String loginMemberId; 
	
	private TunaService service = new TunaService();
	
//	로그인한 USER의 개인정보를 담고있을 객체
	private UserDTO loginMember = null;
	
//	MyPage에 로그인한 회원정보 조회
	public UserDTO selectMemberInfo(String id){
		
		loginMemberId = id;
		
		loginMember = new UserDTO();
		
		loginMember = service.selectMemberInfo(loginMemberId);
		
		return loginMember;
	}

//	MyPage에 로그인한 회원의 아이템 정보 조회
	public void selectUserInventory() {
		
		UserInventoryDTO userInventory = new UserInventoryDTO();
		
		userInventory = service.selectUserInventory(loginMember.getUserNo());
		
		
		
	}
	
	

}
