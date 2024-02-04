package com.debugs.cs.model.service;

import static com.debugs.common.JDBCTemplate.close;
import static com.debugs.common.JDBCTemplate.commit;
import static com.debugs.common.JDBCTemplate.getConnection;
import static com.debugs.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.cs.model.dao.QnaDao;
import com.debugs.cs.model.vo.Category;
import com.debugs.cs.model.vo.Qna;

public class QnaService {

	public int insertQna(Qna q) {
	
		Connection conn = getConnection();
		
		int result = new QnaDao().insertQna(conn, q);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public ArrayList<Category> selectCategoryList(){
		
		Connection conn = getConnection();
		
		ArrayList<Category> list = new QnaDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
	}
	
}
