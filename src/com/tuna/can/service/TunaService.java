package com.tuna.can.service;

import java.sql.Connection;
import java.util.List;

import com.tuna.can.model.dao.TunaDAO;
import com.tuna.can.model.dto.BoardDTO;
import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;

import static com.tuna.can.common.JDBCTemplate.getConnection;

public class TunaService {
	
	TunaDAO tunaDAO = new TunaDAO();

//	MyPage 페이지 회원정보 select
	public UserDTO selectMemberInfo(String loginMemberId) {
		
		UserDTO member = new UserDTO();
		
		Connection con = getConnection();
		
		member = tunaDAO.selectMemberInfo(con, loginMemberId);
		
		return member;
	}

	public UserInventoryDTO selectUserInventory(int userNo) {

		UserInventoryDTO userInventory = new UserInventoryDTO();
		
		Connection con = getConnection();
		
		userInventory = tunaDAO.selectUserInventory(con, userNo);
		
		return userInventory;


	}
	

	public BoardDTO selectBoardContent(int boardNo) {
		
		BoardDTO boardContent = new BoardDTO();
		
		Connection con = getConnection();
		
		boardContent = tunaDAO.selectBoardContent(con, boardNo);
		
		return boardContent;
		


	}

}
