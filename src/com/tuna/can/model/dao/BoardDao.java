package com.tuna.can.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tuna.can.model.dto.BoardDTO;

public class BoardDao {
	//파일에서 리스트 읽어오기용 메소드
	public ArrayList<BoardDTO> readBoardList() {
		ObjectInputStream ois = null;
		ArrayList<BoardDTO> list = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("boardList.txt"));
			
			list = (ArrayList<BoardDTO>) ois.readObject();
			
		} catch(FileNotFoundException e) {
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
	
	//파일에 리스트 기록하기용 메소드 
	public int writeBoardList(ArrayList<BoardDTO> list) {
		ObjectOutputStream oos = null;
		int result = 0;
		
		try {	
			oos = new ObjectOutputStream(new FileOutputStream("boardList.txt"));
			
			oos.writeObject(list);
			
			result++;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	

}
