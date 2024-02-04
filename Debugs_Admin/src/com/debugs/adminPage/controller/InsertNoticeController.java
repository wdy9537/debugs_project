package com.debugs.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Category;
import com.debugs.adminPage.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeController
 */
@WebServlet("/insertnotice.ad")
public class InsertNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertNoticeController() {
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

		int noticeCategory = Integer.parseInt(request.getParameter("notice-category"));
		String noticeTitle = request.getParameter("notice-title");
		String noticeContent = request.getParameter("notice-content");

		Notice n = new Notice();
		n.setNoticeCategory(noticeCategory);
		n.setNoticeContent(noticeContent);
		n.setNoticeTitle(noticeTitle);

		int result = new AdminService().insertNotice(n);

		if (result > 0) {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "성공적으로 공지사항이 등록되었습니다.");

			response.sendRedirect(request.getContextPath() + "/notice.ad");
		} else {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "공지사항 등록에 실패했습니다.");

			response.sendRedirect(request.getContextPath() + "/notice.ad");
		}

	}

}
