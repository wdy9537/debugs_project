package com.debugs.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Category;
import com.debugs.adminPage.model.vo.Faq;
import com.debugs.common.model.vo.PageInfo;

/**
 * Servlet implementation class FaqPageController
 */
@WebServlet("/faq.ad")
public class FaqPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FaqPageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ------------ 페이징처리 -------------
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;

		listCount = new AdminService().selectAllFaqCount();

		currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));

		// * pageLimit : 페이지 하단에 보여질 페이징바의 페이지 최대 갯수(페이지 목록들을 몇개 단위로 출력할것인지)
		pageLimit = 10;

		// * boardLimit : 한 페이지에 보여질 게시글의 최대 갯수(게시글을 몇개 단위로 출력할것인지)
		boardLimit = 10;

		maxPage = (int) Math.ceil((double) listCount / boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		request.setAttribute("pi", pi);

		ArrayList<Faq> list = new AdminService().selectAllFaqList(pi);

		ArrayList<Category> categoryList = new AdminService().selectCategoryList();

		request.setAttribute("list", list);
		request.setAttribute("categoryList", categoryList);

		request.getRequestDispatcher("views/adminPage/adminFaq.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
