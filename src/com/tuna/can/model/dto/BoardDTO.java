package com.tuna.can.model.dto;

import java.io.Serializable;
import java.util.Date;

public class BoardDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6741550132732687627L;
	
	private int boardNo;
	private String userId;
	private Date boardDate;
	private String title;
	private String boardContent;
	private int listNo;
	
	public BoardDTO() {
	super();
		
	}
	
	
	public BoardDTO(int boardNo, String title, String userId, Date boardDate, String boardContent, int listNo) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.userId = userId;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.listNo = listNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", title=" + title + ", userId=" + userId + ", boardDate=" + boardDate
				+ ", boardContent=" + boardContent + "]";
	}


	public int getListNo() {
		return listNo;
	}


	public void setListNo(int listNo) {
		this.listNo = listNo;
	}


}
