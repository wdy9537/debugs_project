package com.debugs.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.DebugUser;

/**
 * Servlet implementation class UpdateUserController
 */
@WebServlet("/updateuser.ad")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserController() {
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

		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userId = request.getParameter("change-id");
		String userName = request.getParameter("change-name");
		String ssn = request.getParameter("change-ssn");
		String email = request.getParameter("change-email");
		String phone = request.getParameter("change-phone");
		int ticketNo = Integer.parseInt(request.getParameter("change-ticket-option"));

		DebugUser d = new DebugUser(userNo, userId, userName, ssn, email, phone, ticketNo);

		int result = new AdminService().updateUser(d);

		if (result > 0) {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "성공적으로 회원정보가 수정되었습니다.");

			response.sendRedirect(request.getContextPath() + "/user.ad");
		} else {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "회원정보 수정에 실패했습니다.");

			response.sendRedirect(request.getContextPath() + "/user.ad");
		}

	}

}
