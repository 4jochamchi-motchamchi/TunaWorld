package com.tuna.can.model.dto;

public class UserDTO {

	private int userNo;
	private String nickName;
	private String userID;
	private String userPwd;
	private String phone;
	private String email;
	private int coin;
	

	public UserDTO() {

	}
	
	public UserDTO(int userNo, String nickName, String userID, String userPwd, String phone, String meail,
			int tunaCan) {
		super();
		this.userNo = userNo;
		this.nickName = nickName;
		this.userID = userID;
		this.userPwd = userPwd;
		this.phone = phone;
		this.email = meail;
		this.coin = tunaCan;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String meail) {
		this.email = meail;
	}

	@Override
	public String toString() {
		return "MemberDTO [userNo=" + userNo + ", nickName=" + nickName + ", userID=" + userID + ", userPwd=" + userPwd
				+ ", phone=" + phone + ", meail=" + email + ", tunaCan=" + coin + "]";
	}
	
}
