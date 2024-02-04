package com.debugs.userPage.mainPage.model.service;

import static com.debugs.userPage.common.JDBCTemplate.getConnection;
import static com.debugs.userPage.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.userPage.mainPage.model.dao.HeaderPageDao;
import com.debugs.userPage.mainPage.model.vo.Keyword;

public class HeaderPageService {

	public ArrayList<Keyword> selectKeyword() {

	
	Connection conn = getConnection();
	
	ArrayList<Keyword> list = new HeaderPageDao().selectKeyword(conn);
	
	close(conn);
	
	return list;
	
	}
	
	
	
	

}
