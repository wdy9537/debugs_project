package com.debugs.cs.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.common.PageInfo;
import com.debugs.cs.model.service.FaqService;
import com.debugs.cs.model.service.NoticeService;
import com.debugs.cs.model.vo.Category;
import com.debugs.cs.model.vo.Faq;

/**
 * Servlet implementation class NoticePagingController
 */
@WebServlet("/faqlist.fa")
public class FaqPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqPagingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount; // 현재 총 게시글 갯수(1000개)
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
		int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수(10개씩 할예정)
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수(10개씩 할예정)
	
		int maxPage; // 가장 마지막 페이지가 몇번째 페이지인지(총 페이지 개수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝수
	
		// * listCount : 총 게시글 갯수
		listCount = new FaqService().selectListCount();
		
		// * currentPage : 현재페이지(즉 , 사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage")); 
	
		// * pageLimit : 페이지 하단에 보여질 페이징바의 페이지 최대 갯수(페이지 목록들을 몇 개 단위로 출력할것인지)
		pageLimit = 10;
		
		// * boardLimit : 한 페이지에 보여질 게시글의 최대 갯수(게시글 몇개 단위로 출력할것인지)
		boardLimit = 10;
		
		maxPage =  (int) Math.ceil((double)listCount / boardLimit); 
		
		
		startPage = (currentPage -1 ) / pageLimit * pageLimit +1;
		
		
		endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 페이지 정보들을 하나로 모아서 vo클래스에 담기
		// 1. 페이징바를 만들때 필요한 객체
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		request.setAttribute("pi", pi);
		
		// 2. 현재 사용자가 요청한 페이지(currentPage)에 맞는 게시글 리스트 가져오기
		ArrayList<Faq> list = new FaqService().selectList(pi);
		
		request.setAttribute("list", list);
		
		ArrayList<Category> list2 = new FaqService().selectCategoryList();
		
		request.setAttribute("list2", list2);
		
		request.getRequestDispatcher("views/cs/faqPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
