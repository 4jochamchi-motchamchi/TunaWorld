package com.tuna.can.service;


import static com.tuna.can.common.JDBCTemplate.getConnection;

import static com.tuna.can.common.JDBCTemplate.commit;
import static com.tuna.can.common.JDBCTemplate.getConnection;
import static com.tuna.can.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tuna.can.model.dao.TunaDAO;
import com.tuna.can.model.dto.BulletinDTO;
import com.tuna.can.model.dto.CommentDTO;
import com.tuna.can.model.dto.FriendDTO;
import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;


public class TunaService {
	
	TunaDAO tunaDAO = new TunaDAO();

//	MyPage 페이지 회원정보 select
	public UserDTO selectMemberInfo(String loginMemberId) {
		
		UserDTO member = new UserDTO();
		
		Connection con = getConnection();
		
		member = tunaDAO.selectMemberInfo(con, loginMemberId);
		
		return member;
	}

//	MyPage inventory load 
	public ArrayList<UserInventoryDTO> selectUserInventory(int userNo) {

		
		ArrayList<UserInventoryDTO> invenButtonInfo = new ArrayList<UserInventoryDTO>();
		
		Connection con = getConnection();
		
		invenButtonInfo = tunaDAO.selectUserInventory(con, userNo);
		
		return invenButtonInfo;

	}
	
////	장비 장착시 장착여부 DB변경
//	public int updateEquipYn(int itemNo, String equipYn) {
//		
//		Connection con = getConnection();
		
//		int result = tunaDAO.updateEquipYn(con, itemNo, equipYn);
		
//		return result;
		
//	}
	

	// boardNO 정보로 게시글 내용 SELECT
	public BulletinDTO selectBulletinContent(int boardNo) {
		
		BulletinDTO bulletinContent = new BulletinDTO();
		
		Connection con = getConnection();
		
		bulletinContent = tunaDAO.selectBulletinContent(con, boardNo);
		
		return bulletinContent;

	}


	// commentNo 정보로 게시글 댓글 SELECT
	public List<CommentDTO> selectComment(int commentNo) {
		 
		Connection con = getConnection();
		
		List<CommentDTO> comment = tunaDAO.selectComment(con, commentNo);
		
		return comment;
	}
	

	// 댓글 INSERT 해쥬기이
	public int insertComment(CommentDTO comment) {

		int result = 0;
		
		Connection con = getConnection();
		
		result = tunaDAO.insertComment(con, comment);
		
		return result;
	}



	// 유저 코인 현환
	public int selectCoin(int userNo) {
		
		
		int userCoin = 0;
		Connection con = getConnection();
		
		userCoin = tunaDAO.selectMenberCoin(con, userNo);
		
		return userCoin;
		
		
	}

	public int updateCoin(UserDTO userInfor) {
		
		int userCoin = 0;
		Connection con = getConnection();
		
		userCoin = tunaDAO.upateUserCoin(con, userInfor);
		
		if(userCoin > 0){
				commit(con);
		} else {
			System.out.println();
				rollback(con);
		}
		
		return userCoin;
	}

	// 친구 목록 조회
	public List<FriendDTO> selectFriendsList(int userNo) {
		Connection con = getConnection();
		
		List<FriendDTO> friendsList = new ArrayList<>();
		friendsList = tunaDAO.selectFriendsList(con, userNo);
		return friendsList;
	}

}
