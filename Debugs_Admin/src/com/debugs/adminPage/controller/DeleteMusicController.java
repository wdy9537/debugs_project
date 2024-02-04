package com.debugs.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.adminPage.model.service.AdminService;

/**
 * Servlet implementation class DeleteMusicController
 */
@WebServlet("/deleteMusic.ad")
public class DeleteMusicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteMusicController() {
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

		// 뮤직 + 키워드 먼저 지우고
		// 뮤직 지우기
		String musicNo = request.getParameter("musicNo");
		String[] musicNoList = musicNo.split(",");

		int result = new AdminService().deleteMusic(musicNoList);

		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "음원 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/manageMusic.ad");
		} else {
			request.getSession().setAttribute("alertMsg", "음원 삭제 실패");
			response.sendRedirect(request.getContextPath() + "/manageMusic.ad");
		}

	}

}
