package com.debugs.cs.model.service;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.common.PageInfo;
import com.debugs.cs.model.dao.FaqDao;
import com.debugs.cs.model.dao.NoticeDao;
import com.debugs.cs.model.vo.Category;
import com.debugs.cs.model.vo.Faq;


public class FaqService {
		
		public Faq selectFaq(int faqNo) {
			Connection conn = getConnection();
			
			Faq f  = new FaqDao().selectFaq(conn, faqNo);
			
			close(conn);
			
			return f;
		}
		
		
		public int selectListCount() {
			
			Connection conn = getConnection();
			
			int listCount = new FaqDao().selectListCount(conn);
			
			close(conn);
			
			return listCount;
		}
		
		public ArrayList<Faq> selectList(PageInfo pi){
			
			Connection conn = getConnection();
			
			ArrayList<Faq> list = new FaqDao().selectList(conn, pi);
			
			close(conn);
			
			return list;
		}
		public ArrayList<Category> selectCategoryList(){
			
			Connection conn = getConnection();
			
			ArrayList<Category> list2 = new FaqDao().selectCategoryList(conn);
			
			close(conn);
			
			return list2;
		}
}
