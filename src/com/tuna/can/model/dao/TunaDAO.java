package com.tuna.can.model.dao;

import static com.tuna.can.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tuna.can.model.dto.BoardDTO;
import com.tuna.can.model.dto.FriendDTO;
import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;

/**
 * @author doqnt
 *
 */
public class TunaDAO {
	Properties prop = new Properties();
	
	public TunaDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/tuna-query.xml"));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public UserDTO selectMemberInfo(Connection con, String loginMemberId) {
		
		String query = prop.getProperty("selectMemberInfo");
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		UserDTO member = new UserDTO();
		
		System.out.println(loginMemberId);
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, loginMemberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member.setUserNo(rset.getInt("USER_NO"));
				member.setNickName(rset.getString("USER_NICKNAME"));
				member.setUserID(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setPhone(rset.getString("PHONE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setCoin(rset.getInt("COIN"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return member;
		
	}

	public UserInventoryDTO selectUserInventory(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String query = prop.getProperty("selectUserInventory");
		
		UserInventoryDTO userInventory = new UserInventoryDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				userInventory.setUserNo(rset.getInt("USER_NO"));
				userInventory.setItemNo(rset.getInt("ITEM_NO"));
				userInventory.setItemName(rset.getString("ITEM_NAME"));
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		return null;
		
	}

	// 김현빈씨 파트 친구닉네임, 이미지 select하는 메소드
	// 김현빈씨 파트 코인 획득 
	public int selectMenberCoin(Connection con, int userNo) {
		
		String query = prop.getProperty("selectCoin");
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		int coin = 0;
		
		try {
			pstmt =  con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				coin = rset.getInt("COIN");
				String str = rset.getString("USER_NICKNAME");		
				System.out.println(str);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rset);
		}
		
		return coin;
		
	}

	
	// 코인 획득
	public int updateUserCoin(Connection con, UserDTO userInfor) {
		String query = prop.getProperty("updateCoin");
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userInfor.getCoin()+1);
			pstmt.setInt(2, userInfor.getUserNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public BoardDTO selectBoardContent(Connection con, int boardNo) {
		
		String query = prop.getProperty("selectBoard");
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		BoardDTO boardDTO = new BoardDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				boardDTO.setTitle(rset.getString("TITLE"));
				boardDTO.setBoardContents(rset.getString("BOARD_CONTENTS"));
				boardDTO.setUserNickname(rset.getString("USER_NICKNAME"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return boardDTO;
	}

	
	// 친구리스트에서 이미지, 친구 닉네임 불러오기
	public List<FriendDTO> selectFriendsList(Connection con,int userNo) {
		String query = prop.getProperty("slectFriendsLIst");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		System.out.println("userNo : " + userNo );
		List<FriendDTO> friendsInfo = null;
		
		try {
			
			friendsInfo = new ArrayList<>();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
//			System.out.println("rset : " +rset);
		
			while(rset.next()) {
				FriendDTO friends = new FriendDTO();
				
				friends.setFriendsNickname(rset.getString(2));
//				friends.setImage(rset.getString("ITEM_IMG"));
				
				
				friendsInfo.add(friends);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rset);
		}
		return friendsInfo;
	}

	
//	public int deleteFriend(Connection con, int userNo, int friendNo) {
//		String query = prop.getProperty("deleteFriend");
//		PreparedStatement pstmt = null;
//		
//		int result = 0;
//		
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, userNo);
//			pstmt.setInt(2, friendNo);
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		finally {
//			
//			close(pstmt);
//			
//		}
//		
//		
//		return result;
//	}

}














