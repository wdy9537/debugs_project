package com.debugs.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.adminPage.model.service.AdminService;

/**
 * Servlet implementation class InsertFaqController
 */
@WebServlet("/insertFaq.ad")
public class InsertFaqController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertFaqController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String faqCategory = request.getParameter("faqCategory");
		String faqTitle = request.getParameter("faqTitle");
		String faqContent = request.getParameter("faqContent");

		int result = new AdminService().insertFaq(faqCategory, faqTitle, faqContent);

		if (result > 0) { // 성공
			request.getSession().setAttribute("alertMsg", "FAQ 등록 성공");
			response.sendRedirect(request.getContextPath() + "/faq.ad");
		} else {
			request.getSession().setAttribute("alertMsg", "FAQ 등록 실패");
			response.sendRedirect(request.getContextPath() + "/faq.ad");
		}

	}

}
