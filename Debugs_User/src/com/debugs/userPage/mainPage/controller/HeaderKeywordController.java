package com.debugs.userPage.mainPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.userPage.mainPage.model.service.HeaderPageService;
import com.debugs.userPage.mainPage.model.vo.Keyword;
import com.google.gson.Gson;

/**
 * Servlet implementation class MainPageKeyword
 */
@WebServlet("/keyword")
//어노테이션 추가 필요 해당 키워드 검색창으로 이동
public class HeaderKeywordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderKeywordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		//키워드 세개 가져올거니까 리스트? 형? 태?
		ArrayList<Keyword> list = new HeaderPageService().selectKeyword();
		
//		request.getSession().setAttribute("list", list);
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());
//		request.getRequestDispatcher("views/common/header.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	
	}

}

