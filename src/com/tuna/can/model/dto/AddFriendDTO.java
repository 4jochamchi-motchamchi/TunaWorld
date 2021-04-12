package com.tuna.can.model.dto;

public class AddFriendDTO {

	private int userNo;
	private int requsetFriendNo;
	
	
	public AddFriendDTO() {
		super();
	}


	public AddFriendDTO(int userNo, int requsetFriendNo) {
		super();
		this.userNo = userNo;
		this.requsetFriendNo = requsetFriendNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getRequsetFriendNo() {
		return requsetFriendNo;
	}


	public void setRequsetFriendNo(int requsetFriendNo) {
		this.requsetFriendNo = requsetFriendNo;
	}


	@Override
	public String toString() {
		return "AddFriendDTO [userNo=" + userNo + ", requsetFriendNo=" + requsetFriendNo + "]";
	}
	
	
	
	
}
