package com.debugs.cs.model.service;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


import com.debugs.cs.model.dao.QnaResultDao;
import com.debugs.cs.model.vo.Qna;

public class QnaResultService {
	
		
		public ArrayList<Qna> selectQnaList(){
			
			Connection conn = getConnection();
			
			ArrayList<Qna> list = new QnaResultDao().selectQnaList(conn);
			
			close(conn);
			
			return list;
		}
}

