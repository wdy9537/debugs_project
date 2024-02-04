package com.debugs.cs.model.service;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.common.PageInfo;
import com.debugs.cs.model.dao.NoticeDao;
import com.debugs.cs.model.vo.Category;
import com.debugs.cs.model.vo.Notice;

public class NoticeService {
		
		public Notice selectNotice(int noticeNo) {
			Connection conn = getConnection();
			
			Notice n  = new NoticeDao().selectNotice(conn, noticeNo);
			
			close(conn);
			
			return n;
		}
		
		
		public int selectListCount() {
			
			Connection conn = getConnection();
			
			int listCount = new NoticeDao().selectListCount(conn);
			
			close(conn);
			
			return listCount;
		}
		
		public ArrayList<Notice> selectList(PageInfo pi){
			
			Connection conn = getConnection();
			
			ArrayList<Notice> list = new NoticeDao().selectList(conn, pi);
			
			close(conn);
			
			return list;
		}
		public ArrayList<Category> selectCategoryList(){
			
			Connection conn = getConnection();
			
			ArrayList<Category> list2 = new NoticeDao().selectCategoryList(conn);
			
			close(conn);
			
			return list2;
		}
}
