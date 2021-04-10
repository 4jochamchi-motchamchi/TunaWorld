package com.tuna.can.model.dto;

public class FriendDTO {

	private String friends;
	private String image;
	
	
	public FriendDTO() {
		super();
	}


	public FriendDTO(String friends, String image) {
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


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "FriendDTO [friends=" + friends + ", image=" + image + "]";
	}
	
	
	
	
	
}
