package com.tuna.can.controller;


import java.util.ArrayList;
import java.util.List;

import com.tuna.can.model.dto.MemberDTO;
import com.tuna.can.service.TunaService;

public class TunaController {
	
	private MemberDTO loginMember = null;
	private TunaService service = new TunaService();

	public void loginMember(String id) {

		loginMember = new MemberDTO();
		
		loginMember.setUserID(id);
		
		
	}
	
	
	public MemberDTO selectMemberInfo(){
		
		MemberDTO memberInfo = new MemberDTO();
		String id = loginMember.getUserID();
		
		memberInfo = service.selectMemberInfo(loginMember.getUserID());
		
		
		return memberInfo;
	}
	
	

}
