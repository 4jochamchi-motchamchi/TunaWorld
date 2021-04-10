package com.tuna.can.controller;

import java.util.ArrayList;

import com.tuna.can.model.dto.BoardDTO;

public class ResultPrinter {
	public void printAllList(ArrayList<BoardDTO> list) {
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		} else {
		
		}
		
	}

}
