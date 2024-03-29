package com.debugs.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Admin;

/**
 * Servlet implementation class UpdateMemoController
 */
@WebServlet("/updateMemo.ad")
public class UpdateMemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMemoController() {
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

		HttpSession session = request.getSession();
		Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");

		int adminNo = loginAdmin.getAdminNo();

		String adminMemo = request.getParameter("adminMemo");

		int result = new AdminService().updateMemo(adminNo, adminMemo);

		if (result > 0) {
			loginAdmin.setAdminMemo(adminMemo);
			session.setAttribute("loginAdmin", loginAdmin);
			session.setAttribute("alertMsg", "메모 저장 성공");
			response.sendRedirect(request.getContextPath() + "/main.ad");
		} else {
			session.setAttribute("alertMsg", "메모 저장 실패");
			response.sendRedirect(request.getContextPath() + "/main.ad");
		}

	}

}
