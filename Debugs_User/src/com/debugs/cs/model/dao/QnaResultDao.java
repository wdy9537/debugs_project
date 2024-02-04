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

import com.debugs.cs.model.vo.Notice;
import com.debugs.cs.model.vo.Qna;

public class QnaResultDao {
	private Properties prop = new Properties();
	
	public QnaResultDao() {
		String fileName = NoticeDao.class.getResource("/sql/cs/QnaResult-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public ArrayList<Qna> selectQnaList(Connection conn){
		
		// SELECT문 => 여러행 => ResultSet => ArrayList
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Qna q = new Qna(rset.getInt("QNA_NO"),
									  rset.getString("QNA_CONTENT"),
									  rset.getString("QNA_RESULT"),
									  rset.getString("QNA_ANSWER")
				);
				
				q.setFilePath(rset.getString("QNA_FILE_PATH"));
				q.setQnaImage(rset.getString("QNA_IMAGE"));
				q.setQnaImageChange(rset.getString("QNA_IMAGE_CHANGE"));
				
				list.add(q);
				
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
