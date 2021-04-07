package com.tuna.can.model.dto;

public class MemberDTO {

	private int userNo;
	private String nickName;
	private String userID;
	private String userPwd;
	private String phone;
	private String meail;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDTO(int userNo, String nickName, String userID, String userPwd, String phone, String meail) {

		this.userNo = userNo;
		this.nickName = nickName;
		this.userID = userID;
		this.userPwd = userPwd;
		this.phone = phone;
		this.meail = meail;
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
	public String getMeail() {
		return meail;
	}
	public void setMeail(String meail) {
		this.meail = meail;
	}

	@Override
	public String toString() {
		return "MemberDTO [userNo=" + userNo + ", nickName=" + nickName + ", userID=" + userID + ", userPwd=" + userPwd
				+ ", phone=" + phone + ", meail=" + meail + "]";
	}
	
	
}
