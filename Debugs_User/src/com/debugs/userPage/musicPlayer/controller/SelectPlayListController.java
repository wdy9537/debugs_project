package com.debugs.userPage.musicPlayer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum;
import com.debugs.userPage.musicPlayer.model.service.MusicPlayerService;
import com.google.gson.Gson;

/**
 * Servlet implementation class SelectPlayListController
 */
@WebServlet(urlPatterns = "/selectPlayList" , name="selectPlayListController")
public class SelectPlayListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPlayListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pno = request.getParameter("pno");
		
		ArrayList<MusicArtistAlbum> list = new MusicPlayerService().selectPlayList(pno);
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
