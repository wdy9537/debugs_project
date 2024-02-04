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
 * Servlet implementation class CreateaAdminController
 */
@WebServlet("/insertadmin.ad")
public class InsertAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertAdminController() {
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

		int adminNo = Integer.parseInt(request.getParameter("admin-no"));
		String adminName = request.getParameter("admin-name");
		String adminId = request.getParameter("admin-id");
		String adminPwd = request.getParameter("admin-password");
		String adminPhone = request.getParameter("admin-phone");

		if (adminNo == 1234) { // 관리자 회원가입 번호
			Admin a = new Admin(adminName, adminId, adminPwd, adminPhone);

			int result = new AdminService().insertAdmin(a);

			if (result > 0) {
				HttpSession session = request.getSession();

				session.setAttribute("alertMsg", "성공적으로 회원가입 되었습니다.");

				response.sendRedirect(request.getContextPath() + "/admin.ad");
			} else {
				HttpSession session = request.getSession();

				session.setAttribute("alertMsg", "회원가입에 실패했습니다.");

				response.sendRedirect(request.getContextPath() + "/admin.ad");
			}
		} else {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "회원가입에 실패했습니다.");

			response.sendRedirect(request.getContextPath() + "/admin.ad");
		}
	}

}
