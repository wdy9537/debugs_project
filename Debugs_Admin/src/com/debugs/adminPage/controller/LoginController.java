package com.debugs.adminPage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Admin;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.ad")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		Admin loginAdmin = new AdminService().loginAdmin(adminId, adminPwd);

		if (loginAdmin == null) { // 로그인 실패 => 에러페이지 응답

			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "로그인에 실패하였습니다.");
			response.sendRedirect(request.getContextPath());

		} else { // 로그인 성공 => index페이지(메인페이지) 응답

			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", loginAdmin);
			session.setAttribute("alertMsg", "성공적으로 로그인이 되었습니다.");
			response.sendRedirect(request.getContextPath() + "/main.ad");

		}

	}

}
