package com.tuna.can.model.dao;

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
	Properties prop = null;
	
	public TunaDAO() {
		
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/tuna-query.xml"));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public MemberDTO selectMemberInfo(Connection con, String userId) {
		String query = prop.getProperty("selectMemberInfo");
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		MemberDTO member = new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member.setMeail(rset.getString("EMAIL"));
				member.setNickName(rset.getString("USER_NICKNAME"));
				member.setPhone(rset.getString("PHONE"));
				member.setUserID(rset.getString("USER_ID"));
				member.setUserNo(rset.getInt("USER_NO"));
				member.setUserPwd(rset.getString("USER_PWD"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return member;
		
	}

}



















