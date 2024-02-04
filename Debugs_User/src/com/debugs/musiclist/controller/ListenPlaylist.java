package com.debugs.musiclist.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.member.model.vo.Member;
import com.debugs.musiclist.model.service.MusiclistService;
import com.google.gson.Gson;

/**
 * Servlet implementation class ListenPlaylist
 */
@WebServlet("/listen.pl")
public class ListenPlaylist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenPlaylist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member user = (Member)session.getAttribute("loginUser");
		int userNo = user.getUserNo();
		
		int musicNo = Integer.parseInt(request.getParameter("musicNo"));
		int result = new MusiclistService().listenPlaylist(userNo, musicNo);

		response.setContentType("application/json; charset=UTF	-8");
		new Gson().toJson(result, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
