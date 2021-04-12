package com.tuna.can.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.tuna.can.model.dto.BoardDTO;



public class BoardDao {
	
	private static Properties prop = new Properties();
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
	//글삽입하는 메소드
	public static int insertBoard(Connection con, BoardDTO board) {
		
		PreparedStatement pstmt = null;
		
		
		String query = prop.getProperty("insertBoard");
		
		int result = 0;
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setInt(2, board.getListNo());
			pstmt.setString(3,board.getTitle());
			pstmt.setString(4, board.getBoardContent());
			pstmt.setDate(5, (Date) board.getBoardDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
		   
		}
		
		return result;
	
		
	}

	
	

}
