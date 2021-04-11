package com.tuna.can.service;


import static com.tuna.can.common.JDBCTemplate.getConnection;

import static com.tuna.can.common.JDBCTemplate.commit;
import static com.tuna.can.common.JDBCTemplate.rollback;

import java.sql.Connection;
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

	
	/**
	 * <pre>
	 * 유저 정보 등록/생성용 메소드
	 * </pre>
	 * @param user
	 * @return
	 */
	public int registUser(UserDTO user) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		int createResult = tunaDAO.createUser(con, user);
		//마지막 발생한 회원번호 시퀀스 조회
		int createdNo = tunaDAO.selectLastNo(con);
		UserDTO userDTO = new UserDTO();
		userDTO.setUserNo(createdNo);
		
		
		if(createResult>0) {
			commit(con);
			result =1;
		}else {
			rollback(con);
		}	
		
		return result;
		
	}
	
	/**
	 * <pre>
	 * 로그인페이지 아이디/ 비밀번호 확인하는 메소드
	 * </pre>
	 * @param userList
	 * @return
	 */
	public int loginUser(UserDTO userList) {
		Connection con = getConnection();
		
		int result = 0;
		
		int loginResult = tunaDAO.loginUser(con,userList);
		
		return result;
	}
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
		
		if(result > 0){
			commit(con);
		} else {
			System.out.println();
			rollback(con);
		}
		
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
		
		userCoin = tunaDAO.updateUserCoin(con, userInfor);
		
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

	public int updateUserInformation(UserDTO updateUserInfo) {
		
		int result = 0;
		
		Connection con = getConnection();
		
		result = tunaDAO.updateUserInformation(con, updateUserInfo);
		
		if(result == 1) {
			commit(con);
		}
		
		return result;
	}

	public int updateItemEquipYn(UserInventoryDTO inventory) {
		
		int result = 0;
		
		Connection con = getConnection();
		
		result = tunaDAO.updateItemEquipYn(con, inventory);
		
		return result;
	}


	public List<String> selectCategoryInvenYN(UserInventoryDTO inventory) {

		List<String> equipYNList = new ArrayList<String>();
		
		Connection con = getConnection();
		
		equipYNList = tunaDAO.selectCategoryInvenYN(con, inventory);
		
		
		return equipYNList;
	}


	/**
	 * <pre>
	 *   친구 삭제용 메소드
	 * </pre>
	 * @param userNo
	 * @return
	 */
//	public int deleteFriend(int userNo, int friends) {
//		
//		Connection con = getConnection();
//		
//		int friendNo = 0;
//		
//		friendNo = tunaDAO.deleteFriend(con, userNo, friends);
//		
//		if(friendNo > 0){
//				commit(con);
//		} else {
//			System.out.println();
//				rollback(con);
//		}
//		
//		return friendNo;
//	}

}
