package com.tuna.can.controller;



import java.util.List;
import java.util.Map;

import com.tuna.can.model.dto.BulletinDTO;
import com.tuna.can.model.dto.CommentDTO;

import java.util.ArrayList;

import com.tuna.can.model.dto.FriendDTO;

import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;
import com.tuna.can.service.TunaService;

public class TunaController {
	
	private String loginMemberId; 
	
	private TunaService service = new TunaService();
	
//	로그인한 USER의 개인정보를 담고있을 객체
	private UserDTO loginMember = null;
	private int coin;

	/**
	 * <pre>
	 * 회원가입 창에서 정보가져오는 메소드
	 * </pre>
	 * @param newMemberInfo
	 * @return
	 */
	public int registUser(Map<String, Object> newMemberInfo) {
		UserDTO userList = new UserDTO();

		userList.setNickName(newMemberInfo.get("nickname").toString());
		userList.setUserID(newMemberInfo.get("id").toString());
		userList.setUserPwd(newMemberInfo.get("pw").toString());
		userList.setPhone(newMemberInfo.get("phone").toString());
		userList.setEmail(newMemberInfo.get("email").toString());

		
		int result = service.registUser(userList);
		
		return result;
		
	}
	/**
	 * <pre>
	 * 로그인 아이디/비밀번호 확인 조회
	 * </pre>
	 * @param loginInfo
	 * @return
	 */
	public int loginUser(Map<String, String> loginInfo) {
		
		UserDTO userList = new UserDTO();

		userList.setUserID(loginInfo.get("id").toString());
		userList.setUserPwd(loginInfo.get("pw").toString());
		
		int result = service.loginUser(userList);
		
		return result;
	}
	
//	MyPage에 로그인한 회원정보 조회
	public UserDTO selectMemberInfo(String id){
		
		loginMemberId = id;
		
		loginMember = new UserDTO();
		
		loginMember = service.selectMemberInfo(loginMemberId);
		
		return loginMember;
	}

//	MyPage에 로그인한 회원의 아이템 정보 조회
	public ArrayList<UserInventoryDTO> selectUserInventory() {
		
		ArrayList<UserInventoryDTO> invenButtonInfo = new ArrayList<UserInventoryDTO>();
		
		invenButtonInfo = service.selectUserInventory(loginMember.getUserNo());
		
		return invenButtonInfo;
		
		
		
	}

	// 유저 정보에서 코인 조회
	public int selectUSerCoin(UserDTO UserInfo) {
		
		coin = service.selectCoin(UserInfo.getUserNo());
		 
		return coin;
	}
	
	// 받아온 코인 정보값에 코인갯수 업데이트
	public int updateCoin(UserDTO userInfo) {
		
		int userCoin = 0;
		userCoin = service.updateCoin(userInfo);
		
		return userCoin;
		
	}
	
	   // 게시글 내용 조회
	   public BulletinDTO selectBulletinContent(int boardNo) {
	      
	      BulletinDTO bulletinDTO = new BulletinDTO();
	      bulletinDTO = service.selectBulletinContent(boardNo);
	      return bulletinDTO;
	      
	   }
	   
	   // 댓글 내용 조회
	   public List<CommentDTO> selectComment(int commentNo) {

	      List<CommentDTO> comment = service.selectComment(commentNo);
	      return comment;
	      
	   }

	// 댓글 집어넣기
	public int insertComment(CommentDTO comment) {

		CommentDTO insertComment = new CommentDTO();
		
		int result = 0;
		
		result = service.insertComment(comment);
		
		return result;

		
	}
	
	// 친구목록에 친구닉네임, 이미지 받아오기
	public List<FriendDTO> selectFriendsList(int userInfo) {
			
		List<FriendDTO> friendsList = new ArrayList<>();
		friendsList = service.selectFriendsList(userInfo);
		
		return friendsList;
	}
	public void insertBoard() {
		
	}


	
	
	// 친구 삭제
//	public int deleteFriend (UserDTO  UserInfo) {
//		
//		int friend = 0;
//		
//		friend = service.deleteFriend(UserInfo.getUserNo());
//		 return friend;
//	}
	
	
}
