package com.debugs.cs.model.dao;

import static com.debugs.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.cs.model.vo.Category;
import com.debugs.cs.model.vo.Notice;
import com.debugs.cs.model.vo.Qna;

public class QnaDao {
	private Properties prop = new Properties();
	
	public QnaDao() {
		String fileName = NoticeDao.class.getResource("/sql/cs/Qna-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertQna(Connection conn, Qna q) {
		
		// Insert문 => 처리된 행의 갯수를 반환
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getQnaContent());
			pstmt.setString(2, q.getQnaImage());
			pstmt.setString(3, q.getQnaCategory());
			pstmt.setString(4, q.getFilePath());
			pstmt.setString(5, q.getQnaImageChange());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public ArrayList<Category> selectCategoryList(Connection conn){
		
		ArrayList<Category> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
				while(rset.next()) {
				
				list.add(new Category(rset.getInt("CATEGORY_NO"), rset.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
}
