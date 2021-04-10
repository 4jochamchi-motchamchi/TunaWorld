package com.tuna.can.controller;

import java.util.ArrayList;

import com.tuna.can.model.dao.BoardDao;
import com.tuna.can.model.dto.BoardDTO;


public class BoardManager {
	private BoardDao bd = new BoardDao();
	
	
	//새 게시물 등록용 메소드
	public void insertBoard(BoardDTO d) {
		int boardNo = 0;
		ArrayList<BoardDTO> list = bd.readBoardList();
		if(list == null) {
			list = new ArrayList<BoardDTO>();
			boardNo++;
		} else {
			boardNo = list.get(list.size() - 1).getBoardNo() + 1;
		}
		d.setBoardNo(boardNo);
		
		list.add(d);
	
		int result = bd.writeBoardList(list);
		

	}
	
	

}
