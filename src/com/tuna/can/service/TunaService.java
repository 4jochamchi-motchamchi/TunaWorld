package com.tuna.can.service;

import static com.tuna.can.common.JDBCTemplate.commit;
import static com.tuna.can.common.JDBCTemplate.getConnection;
import static com.tuna.can.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.tuna.can.model.dao.TunaDAO;
import com.tuna.can.model.dto.BoardDTO;
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
