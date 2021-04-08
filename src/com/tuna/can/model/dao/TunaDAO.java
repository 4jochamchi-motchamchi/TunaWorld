package com.tuna.can.model.dao;

import java.beans.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static com.tuna.can.common.JDBCTemplate.close;

import com.tuna.can.model.dto.MemberDTO;

public class TunaDAO {
	Properties prop = new Properties();
	
	public TunaDAO() {
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/tuna-query.xml"));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public MemberDTO selectMemberInfo(Connection con, String loginMemberId) {
		
		String query = prop.getProperty("selectMemberInfo");
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		MemberDTO member = new MemberDTO();
		
		System.out.println(loginMemberId);
		
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, loginMemberId);
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset);
			
			if(rset.next()) {
				member.setUserNo(rset.getInt("USER_NO"));
				member.setNickName(rset.getString("USER_NICKNAME"));
				member.setUserID(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setPhone(rset.getString("PHONE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setTunaCan(rset.getInt("TUNACAN"));
			}
			System.out.println(member);
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return member;
		
	}

}



















