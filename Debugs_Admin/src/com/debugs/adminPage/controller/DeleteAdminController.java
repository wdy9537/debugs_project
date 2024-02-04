package com.debugs.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.adminPage.model.service.AdminService;

/**
 * Servlet implementation class DeleteAdminController
 */
@WebServlet("/deleteadmin.ad")
public class DeleteAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAdminController() {
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

		String adminNo = request.getParameter("adminNo");

		String[] adminNos = adminNo.split(",");

		int result = new AdminService().deleteAdmin(adminNos);

		if (result > 0) {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "성공적으로 삭제 되었습니다.");

			response.sendRedirect(request.getContextPath() + "/admin.ad");

		} else {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "삭제에 실패했습니다.");

			response.sendRedirect(request.getContextPath() + "/admin.ad");
		}

	}

}
