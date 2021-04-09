package com.tuna.can.model.dto;

public class FriendDTO {

	private String friends;
	private int image;
	
	
	public FriendDTO() {
		super();
	}


	public FriendDTO(String friends, int image) {
		super();
		this.friends = friends;
		this.image = image;
	}


	public String getFriends() {
		return friends;
	}


	public void setFriends(String friends) {
		this.friends = friends;
	}


	public int getImage() {
		return image;
	}


	public void setImage(int image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "FriendDTO [friends=" + friends + ", image=" + image + "]";
	}
	
	
	
	
	
}
