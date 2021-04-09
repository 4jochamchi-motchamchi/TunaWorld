package com.tuna.can.controller;


import com.tuna.can.model.dto.BoardDTO;
import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;
import com.tuna.can.service.TunaService;

public class TunaController {
	
	private String loginMemberId; 
	
	private TunaService service = new TunaService();
	
//	로그인한 USER의 개인정보를 담고있을 객체
	private UserDTO loginMember = null;
	private int coin;
	
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
	

	// 유저 정보에서 코인 조회
	public int selectUSerCoin(int UserInfo) {
		
		coin = service.selectCoin(UserInfo);
		 
		return coin;
	}
	
	// 받아온 코인 정보값에 코인갯수 업데이트
	public int updateCoin(UserDTO userInfo) {
		
		int userCoin = 0;
		userCoin = service.updateCoin(userInfo);
		
		return userCoin;
		
	}
	public BoardDTO selectBoardContent(int boardNo) {
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO = service.selectBoardContent(boardNo);
		return boardDTO;
		
	}
	
	

}
