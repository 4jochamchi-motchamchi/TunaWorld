package com.tuna.can.controller;


import java.util.ArrayList;
import java.util.List;

import com.tuna.can.model.dto.MemberDTO;
import com.tuna.can.service.TunaService;

public class TunaController {
	
	private String loginMemberId; 
	private TunaService service = new TunaService();
	
//	MyPage 페이지 회원정보 select
	public MemberDTO selectMemberInfo(String id){
		
		loginMemberId = id;
		
		MemberDTO loginMember = new MemberDTO();
		
		loginMember = service.selectMemberInfo(loginMemberId);
		
		return loginMember;
	}
	
	

}
