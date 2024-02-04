package com.debugs.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Blacklist;

/**
 * Servlet implementation class InsertBlacklistController
 */
@WebServlet("/insertblacklist.ad")
public class InsertBlacklistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertBlacklistController() {
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

		String blacklistUserNo = request.getParameter("userId");
		String blacklistReason = request.getParameter("blacklist-reason");
		String blacklistName = request.getParameter("blacklist-name");
		String blacklistDate = request.getParameter("date");

		Blacklist bl = new Blacklist(blacklistUserNo, blacklistName, blacklistReason, blacklistDate);

		int result1 = new AdminService().insertBlacklist(bl);

		int result2 = new AdminService().updateUserStatus(blacklistName);

		if (result1 > 0 && result2 > 0) {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "성공적으로 블랙리스트가 등록되었습니다.");

			response.sendRedirect(request.getContextPath() + "/blacklist.ad");
		} else {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "블랙리스트 등록에 실패했습니다.");

			response.sendRedirect(request.getContextPath() + "/blacklist.ad");
		}

	}

}
