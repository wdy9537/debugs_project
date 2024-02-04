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

import com.debugs.common.PageInfo;
import com.debugs.cs.model.vo.Category;
import com.debugs.cs.model.vo.Faq;

public class FaqDao {
	private Properties prop = new Properties();

	public FaqDao() {
		String fileName = FaqDao.class.getResource("/sql/cs/Faq-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Faq selectFaq(Connection conn, int faqNo) {

		Faq f = null;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectFaq");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, faqNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				f = new Faq(rset.getInt("FAQ_NO"), 
						rset.getString("CATEGORY_NAME"),
						rset.getString("FAQ_TITLE"), 
						rset.getString("FAQ_CONTENT"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return f;

	}

	public int selectListCount(Connection conn) {

		// SELECT문 => ResultSet객체 (한행)
		int listCount = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Faq> selectList(Connection conn, PageInfo pi) {

		ArrayList<Faq> list = new ArrayList<>();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectList");

		try {
			pstmt = conn.prepareStatement(sql);

			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Faq(
						rset.getInt("FAQ_NO"), 
						rset.getString("CATEGORY_NAME"),
						rset.getString("FAQ_TITLE")
						));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	public ArrayList<Category> selectCategoryList(Connection conn){
		
		ArrayList<Category> list2 = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list2.add(new Category(rset.getInt("CATEGORY_NO"), rset.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list2;
	}

}
