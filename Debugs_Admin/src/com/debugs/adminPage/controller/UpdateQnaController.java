package com.debugs.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.adminPage.model.service.AdminService;

/**
 * Servlet implementation class UpdateQnaController
 */
@WebServlet("/updateQna.ad")
public class UpdateQnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateQnaController() {
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
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String qnaAnswer = request.getParameter("qnaAnswer");

		int result = new AdminService().updateQna(qnaNo, qnaAnswer);

		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "문의 답변 성공");
			response.sendRedirect(request.getContextPath() + "/qna.ad");
		} else {
			request.getSession().setAttribute("alertMsg", "문의 답변 실패");
			response.sendRedirect(request.getContextPath() + "/qna.ad");
		}

	}

}
