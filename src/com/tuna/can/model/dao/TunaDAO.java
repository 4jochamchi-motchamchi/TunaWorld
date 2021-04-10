package com.tuna.can.model.dao;

import static com.tuna.can.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tuna.can.model.dto.BoardDTO;
import com.tuna.can.model.dto.BulletinDTO;
import com.tuna.can.model.dto.CommentDTO;
import com.tuna.can.model.dto.FriendDTO;
import com.tuna.can.model.dto.UserDTO;
import com.tuna.can.model.dto.UserInventoryDTO;

/**
 * @author doqnt
 *
 */
public class TunaDAO {
	private Properties prop = new Properties();
	
	public TunaDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/tuna-query.xml"));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	
	/**
	 * <pre>
	 * 새로운 유저 입력용 메소드
	 * </pre>
	 * @param con
	 * @param user
	 * @return
	 */
	public int createUser(Connection con, UserDTO user) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("create_User");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, user.getNickName());
			pstmt.setString(2, user.getUserID());
			pstmt.setString(3, user.getUserPwd());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getEmail());

			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
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

	public ArrayList<UserInventoryDTO> selectUserInventory(Connection con, int userNo) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String query = prop.getProperty("selectUserInventory");
		
		ArrayList<UserInventoryDTO> invenButtonInfo = null;
		
		try {
			invenButtonInfo = new ArrayList<UserInventoryDTO>();
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				UserInventoryDTO userInventory = new UserInventoryDTO();
				userInventory.setUserNo(rset.getInt("USER_NO"));
				userInventory.setItemNo(rset.getInt("ITEM_NO"));
				userInventory.setItemCategory(rset.getInt("ITEM_CATEGORY"));
				userInventory.setEquipItemYN(rset.getString("EQUIP_ITEM_YN"));
				userInventory.setItemName(rset.getString("ITEM_NAME"));
				userInventory.setItemImg(rset.getString("ITEM_IMG"));
				invenButtonInfo.add(userInventory);
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		return invenButtonInfo;
		
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






	// 게시글 내용 가져오기

	public BulletinDTO selectBulletinContent(Connection con, int boardNo) {

		
		String query = prop.getProperty("selectBulletin");
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		BulletinDTO bulletinDTO = new BulletinDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bulletinDTO.setTitle(rset.getString("TITLE"));
				bulletinDTO.setBoardContents(rset.getString("BOARD_CONTENTS"));
				bulletinDTO.setUserNickname(rset.getString("USER_NICKNAME"));
				bulletinDTO.setEnrollDate(rset.getString("ENROLLDATE"));
				bulletinDTO.setListNo(rset.getInt("LIST_NO"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return bulletinDTO;
	}

	// 댓글 내용 가져오기
	public List<CommentDTO> selectComment(Connection con, int commentNo) {

		String query = prop.getProperty("selectComment");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<CommentDTO> commentList = null;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, commentNo);

			rset = pstmt.executeQuery();

			
			commentList = new ArrayList<>();

			while(rset.next()) {
				
				CommentDTO comment = new CommentDTO();
				comment.setUserNickname(rset.getString("USER_NICKNAME"));
				comment.setCommentContent(rset.getString("COMMENT_CONTENT"));
				
				commentList.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return commentList;
	}

	
	// 댓글 넣어주기
	public int insertComment(Connection con, CommentDTO comment) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertComment");
		
		try {
			
			CommentDTO comments = new CommentDTO();
			
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, comment.getBoardNo());
			pstmt.setString(2, comment.getCommentContent());
			pstmt.setInt(3, comment.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;

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


	// 회원번호 시퀀스 조회용 메소드
	public int selectLastNo(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		int lastOrderNo = 0;
		
		String query = prop.getProperty("selectLastUserNo");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				lastOrderNo = rset.getInt("CURRVAL");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return lastOrderNo;
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

	public int updateEquipYn(Connection con, int userNo, int itemNo, String equipYn) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateEquipYn");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, equipYn);
			pstmt.setInt(2, itemNo);
			pstmt.setInt(3, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		return result;
	}
	//전체글 불러오기
	public List<BoardDTO> allBoardList(Connection con, int boardno ) {

		String query = prop.getProperty("allBoardList");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BoardDTO> bList = null;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardno);

			rset = pstmt.executeQuery();

			
			bList = new ArrayList<>();

			while(rset.next()) {
				
				BoardDTO board = new BoardDTO();
				board.setUserId(rset.getString("USER_NICKNAME"));
				board.setTitle(rset.getString("TITLE"));
				
				bList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return bList;
	}


}














