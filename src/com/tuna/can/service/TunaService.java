package com.tuna.can.service;

import static com.tuna.can.common.JDBCTemplate.close;
import static com.tuna.can.common.JDBCTemplate.commit;
import static com.tuna.can.common.JDBCTemplate.getConnection;
import static com.tuna.can.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


import com.tuna.can.model.dao.TunaDAO;
import com.tuna.can.model.dto.AddFriendDTO;
import com.tuna.can.model.dto.BoardDTO;
import com.tuna.can.model.dto.BulletinDTO;
import com.tuna.can.model.dto.CommentDTO;
import com.tuna.can.model.dto.FriendDTO;
import com.tuna.can.model.dto.StoreItemDTO;
import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;

public class TunaService {

	TunaDAO tunaDAO = new TunaDAO();

	/**
	 * <pre>
	 * 유저 정보 등록/생성용 메소드
	 * </pre>
	 * 
	 * @param user
	 * @return
	 */
	public int registUser(UserDTO user) {

		Connection con = getConnection();

		int result = 0;

		int createResult = tunaDAO.createUser(con, user);
		// 마지막 발생한 회원번호 시퀀스 조회
		int createdNo = tunaDAO.selectLastNo(con);
		UserDTO userDTO = new UserDTO();
		userDTO.setUserNo(createdNo);

		if (createResult > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}

		return result;

	}

//	MyPage 페이지 회원정보 select
	public UserDTO selectMemberInfo(String loginMemberId) {

		UserDTO member = new UserDTO();

		Connection con = getConnection();

		member = tunaDAO.selectMemberInfo(con, loginMemberId);

		
		close(con);
		

		return member;
	}

//	MyPage inventory load 
	public ArrayList<UserInventoryDTO> selectUserInventory(int userNo) {

		ArrayList<UserInventoryDTO> invenButtonInfo = new ArrayList<UserInventoryDTO>();

		Connection con = getConnection();

		invenButtonInfo = tunaDAO.selectUserInventory(con, userNo);

		
		close(con);
		

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

		if (result > 0) {
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

	/**
	 * @author 김현빈
	 * @param userInfor
	 * @return
	 */
	public int updateCoinHB(int userInfor, int coin) {

		int userCoin = 0;
		Connection con = getConnection();
		
		userCoin = tunaDAO.updateUserCoin(con, userInfor, coin);

		if (userCoin > 0) {
			commit(con);
			
		} else {
			rollback(con);
		}

		return userCoin;
	}

	// 친구 목록 조회
	/**
	 * @author 김현빈
	 * @param userNo
	 * @return
	 */
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

		if (result == 1) {
			commit(con);
			close(con);
		}

		return result;
	}

	public int updateItemEquipYn(UserInventoryDTO inventory) {

		int result = 0;

		Connection con = getConnection();

		result = tunaDAO.updateItemEquipYn(con, inventory);


		commit(con);


		
		if(result > 0) {
			commit(con);
			close(con);
		}
		

		return result;
	}

	public List<String> selectCategoryInvenYN(UserInventoryDTO inventory) {

		List<String> equipYNList = new ArrayList<String>();

		Connection con = getConnection();

		equipYNList = tunaDAO.selectCategoryInvenYN(con, inventory);

		close(con);
		

		return equipYNList;
	}


	/**
	 * <pre>
	 *  친구 등록 
	 * </pre>
	 * @author 김현빈
	 * @return
	 */
	public int insertRequestFriend(AddFriendDTO userInfo) {

		Connection con = getConnection();
		int result1 = 0;
		int result2 = 0;
		// 상태 값에 따라 addFriend y, n 조건으로 나누기.
		// 1. y 일 경우
		result1 = tunaDAO.acceptFriend(con, userInfo);
		result2 = tunaDAO.rejectFriend(con, userInfo);

		if (result1 + result2 > 0) {
			System.out.println("성공");
			commit(con);
		} else {
			System.out.println("실패");
			rollback(con);
		}
		return result1 + result2;
	}
	
	/**
	 * <pre>
	 *  친구 수락 거절 메소드
	 * </pre> 
	 * @author 김현빈
	 * @param userInfo
	 * @return 
	 */
	public int rejectRequestFriend(AddFriendDTO userInfo) {
		Connection con = getConnection();
		
		int result = 0;
		result = tunaDAO.rejectFriend(con, userInfo);
		
		if (result > 0) {
			System.out.println("성공");
			commit(con);
		} else {
			System.out.println("실패");
			rollback(con);
		}
		
		return result;
	}
	
	// 친구인지 아닌지 확인하기 위해 친구조회
	public List<FriendDTO> selectFriends(int userNo) {
		
		
		List<FriendDTO> friend = new ArrayList<>();
		
		Connection con = getConnection();
		
		friend = tunaDAO.selectFriends(con, userNo);
		
		return friend;
	}


	public int updateRequestFriend(AddFriendDTO userInfo) {

		
		Connection con = getConnection();
		int result = 0;
		result = tunaDAO.rejectFriend(con, userInfo);
		
		
		if (result > 0) {
			System.out.println("성공");
			commit(con);
		} else {
			System.out.println("실패");
			rollback(con);
		}
		return result;
	}

	// plus_friends 테이블에서 값 꺼내오기
	/**
	 * @author 김현빈
	 * @return
	 */
	public AddFriendDTO selectAddFriend(int userNo) {
		Connection con = getConnection();
		AddFriendDTO friendList = new AddFriendDTO();

		friendList = tunaDAO.selectAddFriend(con, userNo);

		return friendList;
	}

	public List<StoreItemDTO> selectStoreItem() {

		List<StoreItemDTO> sotreItem = new ArrayList<StoreItemDTO>();
		
		Connection con = getConnection();
		
		sotreItem = tunaDAO.selectStoreItem(con);
		
		close(con);
		
		return sotreItem;
	}

	// 친구요청 보내기 정보 INSERT
	public int insertRequest(AddFriendDTO addFriend) {
		

		int result = 0;
			
		Connection con = getConnection();
			
		result = tunaDAO.insertRequest(con, addFriend);
			
		if(result > 0){
			commit(con);
		} else {
			System.out.println();
			rollback(con);
		}
			
		return result;
		
	}


	/**
	 * <pre>
	 * 로그인 아이디/비번 체크용
	 * 닉네임까지 불러올때 사용가능
	 * </pre>
	 * @param idCheck
	 * @return
	 * @author Juhee Hwang
	 */
	public UserDTO checkLoginUser(String idCheck) {
		Connection con = getConnection();
		UserDTO userCheck = tunaDAO.checkLoginUser(con,idCheck);
		
		return userCheck;
	}


	/**
	 * <pre>
	 * 전체 게시글 db 입력하기
	 * </pre>
	 * @param board
	 * @return
	 */
	public int insertBoard(BoardDTO board) {
		Connection con = getConnection();
		
		int result = 0;
		int insertResult = tunaDAO.insertBoard(con, board);
		int insertContentNo = tunaDAO.selectLastContentNo(con);
		
		BoardDTO boardDTO =new BoardDTO();
		boardDTO.setBoardNo(insertContentNo);
		
		if(insertResult > 0){
			commit(con);
			result =1;
		} else {
//			System.out.println();
			rollback(con);
		}
		
		return result;
	}



	// 비밀게시글 목록 불러오기
	public List<BoardDTO> selectSecretBoard(int userNo) {

		Connection con = getConnection();
		
		List<BoardDTO> secretList = tunaDAO.selectSecretBoard(con, userNo);
		
		return secretList;
	}


	public int deleteSecretBoard(BoardDTO title) {
		
		int result = 0;
		
		Connection con = getConnection();
		
		result = tunaDAO.deleteSecretBoard(con, title);
			
		if(result > 0){
			commit(con);
		} else {
			System.out.println();
			rollback(con);
		}
		
		return result;
	}
		

	public int updateUserInventory(UserInventoryDTO userInven) {
		
		int result = 0;
		Connection con = getConnection();
		result = tunaDAO.updateUserInventory(con, userInven);
		
		commit(con);
		close(con);
		return result;
	}

	
//	업데이트코인
//	웅이꺼
	public int updateCoin(int userNo, int coin) {
		int result = 0;
		Connection con = getConnection();
		
		result = tunaDAO.updateCoin(con, userNo, coin);
		
		commit(con);
		close(con);
		
		return result;
	}

	

	public List<BoardDTO> selectAllBoard(int userNo) {
		Connection con =  getConnection();
		List<BoardDTO> allBoardlist  = tunaDAO.allBoardList(con,userNo);
		return allBoardlist;
		
	}


	public List<BoardDTO> selectMyBoard(int userNo) {
		Connection con =  getConnection();
		List<BoardDTO> myBoardList  = tunaDAO.selectMyBoard(con,userNo);
		return myBoardList;
	}

	public List<BoardDTO> selectFriendBoard(int userNo) {
		Connection con =  getConnection();
		List<BoardDTO> FriendBoard  = tunaDAO.SelectFriendBoard (con,userNo);
		return FriendBoard;
	}

	public BoardDTO modifySecretBoard(int boardNo) {
		
        BoardDTO boardDTO = new BoardDTO();
		
		Connection con = getConnection();
		
		boardDTO = tunaDAO.modifySecretBoard(con, boardNo);
			
		close(con);
		
		return boardDTO;
	}



	/**
	 * <pre>
	 *   친구 삭제용 메소드
	 * </pre>
	 * 
	 * @param userNo
	 * @return
	 */
	public int deleteFriend(int userNO, int fNo) {
		
		Connection con = getConnection();
		
		int friendNo = 0;
		
		friendNo = tunaDAO.deleteFriend(con, userNO, fNo);
		
		if(friendNo > 0){
				commit(con);

		} else {
			System.out.println();
				rollback(con);
		}
		
		return friendNo;
	}

	public int updatetBoard(BoardDTO board) {
		Connection con = getConnection();
		
		int result = 0;
		
		result = tunaDAO.updatetBoard(con, board);
//		int insertContentNo = tunaDAO.selectLastContentNo(con);
		
		
		if(result > 0){
			commit(con);
			close(con);
		} 
		
		return result;
		
	}

}
