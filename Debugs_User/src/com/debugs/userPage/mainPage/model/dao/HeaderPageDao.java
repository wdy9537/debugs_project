package com.debugs.userPage.mainPage.model.dao;

import static com.debugs.userPage.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.userPage.mainPage.model.vo.Keyword;

public class HeaderPageDao {
	
	
	private Properties prop = new Properties();
	
	public HeaderPageDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(HeaderPageDao.class.getResource("/sql/mainPage/mainPage.xml").getPath())); 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Keyword> selectKeyword(Connection conn) {
	
		ArrayList<Keyword> list = new ArrayList<Keyword>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectKeyword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Keyword k = new Keyword();
				
				k.setKeywordName(rset.getString("KEYWORD_NAME"));
				
				list.add(k);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

	
	
	
}
