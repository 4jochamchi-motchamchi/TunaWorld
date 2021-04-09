package com.tuna.can.model.dto;

public class BoardDTO {

	private String title;
	private String boardContents;
	private String userNickname;
	
	
	public BoardDTO() {
		super();
	}


	public BoardDTO(String title, String boardContents, String userNickname) {
		super();
		this.title = title;
		this.boardContents = boardContents;
		this.userNickname = userNickname;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBoardContents() {
		return boardContents;
	}


	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}


	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	@Override
	public String toString() {
		return "BoardDTO [title=" + title + ", boardContents=" + boardContents + ", userNickname=" + userNickname + "]";
	}
	
}
