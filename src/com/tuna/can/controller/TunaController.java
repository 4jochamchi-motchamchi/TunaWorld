package com.tuna.can.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tuna.can.model.dto.AddFriendDTO;
import com.tuna.can.model.dto.BulletinDTO;
import com.tuna.can.model.dto.CommentDTO;
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

//	아이템
	private ArrayList<UserInventoryDTO> category1Item = new ArrayList<UserInventoryDTO>();
	private ArrayList<UserInventoryDTO> category2Item = new ArrayList<UserInventoryDTO>();
	private ArrayList<UserInventoryDTO> category3Item = new ArrayList<UserInventoryDTO>();

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
	public Map<Integer, ArrayList<UserInventoryDTO>> selectUserInventory(int userNo) {
		
		Map<Integer, ArrayList<UserInventoryDTO>> itemMap = new HashMap<Integer, ArrayList<UserInventoryDTO>>();
		
		ArrayList<UserInventoryDTO> equipItemList = new ArrayList<UserInventoryDTO>();
		
		ArrayList<UserInventoryDTO> invenButtonInfo = new ArrayList<UserInventoryDTO>();
		
		invenButtonInfo = service.selectUserInventory(userNo);
		
		for(int i = 0; i < invenButtonInfo.size(); i++) {
			UserInventoryDTO inventory = new UserInventoryDTO();
			inventory = invenButtonInfo.get(i);
			int category = inventory.getItemCategory();
			switch (category) {
			case 1:
				category1Item.add(inventory);
				break;
			case 2:
				category2Item.add(inventory);
				break;
			case 3:
				category3Item.add(inventory);
				break;
			}
		}
		
//		장착 아이템 분별
		UserInventoryDTO equItem1 = null;
		for(int i = 0; i < category1Item.size(); i++) {
			if(category1Item.get(i).getEquipItemYN().equals("Y")) {
				equItem1 = new UserInventoryDTO();
				equItem1 = category1Item.get(i);
				break;
			}
		}
		
		UserInventoryDTO equItem2 = null;
		for(int i = 0; i < category2Item.size(); i++) {
			if(category2Item.get(i).getEquipItemYN().equals("Y")) {
				equItem2 = new UserInventoryDTO();
				equItem2 = category2Item.get(i);
				break;
			}
		}
		
		UserInventoryDTO equItem3 = null;
		for(int i = 0; i < category3Item.size(); i++) {
			if(category3Item.get(i).getEquipItemYN().equals("Y")) {
				equItem3 = new UserInventoryDTO();
				equItem3 = category3Item.get(i);
				break;
			}
		}
		
		equipItemList.add(equItem1);
		equipItemList.add(equItem2);
		equipItemList.add(equItem3);
		System.out.println(equipItemList);
		
		itemMap.put(1, category1Item);
		itemMap.put(2, category2Item);
		itemMap.put(3, category3Item);
		itemMap.put(4, equipItemList);

		
		return itemMap;	
		
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
	
//	유저 개인정보 변경
	public int updateUserInformation(UserDTO updateUserInfo) {
		
		int result = 0;
		
		result = service.updateUserInformation(updateUserInfo);
		
//		System.out.println("업데이트 됨?"+ result);
		
		return result;
		
	}
	
//	아이템장착 여부 변경
	public Map<String, Integer> updateItemEquipYn(UserInventoryDTO inventory) {
		
		int category = inventory.getItemCategory();
		int result = 0;
		boolean check = true;
		List<String> equipYNList = new ArrayList<String>();
		
		equipYNList = service.selectCategoryInvenYN(inventory);
		
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < equipYNList.size(); i++) {
			if(equipYNList.get(i).equals("Y")) {
				check = false;
			}
		}
		
		if(check || inventory.getEquipItemYN().equals("N")) {
			result = service.updateItemEquipYn(inventory);
		}
		
		resultMap.put("result", result);
		resultMap.put("itemNo", inventory.getItemNo());
		
		return resultMap;
	}
	
	// 로그인 유저의 정보가 있는 지 확인하기 위한 select
	public AddFriendDTO selectPlusFriend(UserDTO userInfo) {
		AddFriendDTO list = new AddFriendDTO();
		
		list = service.selectAddFriend(userInfo.getUserNo());
		return list;
	}
	
	// PlUS_FRIEND 테이블에서 받아돈 값을 AddFriendDTO에 담아서 값을 받아온다.
//	public int RequestFriends(AddFriendDTO friend) {
//		int result = 0;
//		result = service.insertAndDeleteRequestFriend(friend);
//		
//		return result;
//		
//	}
		
}
//		switch (category) {
//		case 1:
//			for(int i = 0; i< category1Item.size(); i++) {
//				UserInventoryDTO inven = new UserInventoryDTO();
//				inven = category1Item.get(i);
//				if(inven.getEquipItemYN().equals("Y")) {
//					JOptionPane.showMessageDialog(null, "아이템을 해제 후 장착 부탁 드립니다.", "장착", 0);
//					check = false;
//				}
//			}
//			break;
//			
//		case 2:
//			for(int i = 0; i< category2Item.size(); i++) {
//				UserInventoryDTO inven = new UserInventoryDTO();
//				inven = category2Item.get(i);
//				if(inven.getEquipItemYN().equals("Y")) {
//					JOptionPane.showMessageDialog(null, "아이템을 해제 후 장착 부탁 드립니다.", "장착", 0);
//					check = false;
//				}
//			}
//			break;
//			
//		case 3:
//			for(int i = 0; i< category3Item.size(); i++) {
//				UserInventoryDTO inven = new UserInventoryDTO();
//				inven = category3Item.get(i);
//				if(inven.getEquipItemYN().equals("Y")) {
//					JOptionPane.showMessageDialog(null, "아이템을 해제 후 장착 부탁 드립니다.", "장착", 0);
//					check = false;
//				}
//			}
//			break;
//			
//		}


	
	
	// 친구 삭제
//	public int deleteFriend (UserDTO  UserInfo) {
//		
//		int friend = 0;
//		
//		friend = service.deleteFriend(UserInfo.getUserNo());
//		 return friend;
//	}

