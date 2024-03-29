package com.debugs.userPage.musicPlayer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.member.model.vo.Member;
import com.debugs.userPage.mainPage.model.vo.Playlist;
import com.debugs.userPage.mainPage.model.vo.User;
import com.debugs.userPage.musicPlayer.model.service.MusicPlayerService;
import com.google.gson.Gson;

/**
 * Servlet implementation class SelectUserPlaylistController
 */
@WebServlet(urlPatterns = "/selectUserPlaylist", name="selectUserPlaylistController")
public class SelectUserPlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserPlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		
		ArrayList<Playlist> myPlist = new MusicPlayerService().selectUserPlaylist(loginUser.getUserNo());
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(myPlist, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
