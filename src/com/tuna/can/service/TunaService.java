package com.tuna.can.service;

import java.sql.Connection;
import java.util.List;

import com.tuna.can.model.dao.TunaDAO;
import com.tuna.can.model.dto.MemberDTO;

import static com.tuna.can.common.JDBCTemplate.getConnection;

public class TunaService {
	
	TunaDAO tunaDAO = new TunaDAO();

	public MemberDTO selectMemberInfo(String loginMemberId) {
		
		MemberDTO member = new MemberDTO();
		
		Connection con = getConnection();
		
		member = tunaDAO.selectMemberInfo(con, loginMemberId);
		
		return member;
	}

}
