package com.debugs.userPage.musicPlayer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum;
import com.google.gson.Gson;

/**
 * Servlet implementation class SelectCurrentPlayList
 */
@WebServlet(urlPatterns = "/selectCurrentPlayList" , name="selectCurrentPlayList")
public class SelectCurrentPlayList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCurrentPlayList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<MusicArtistAlbum> cList = request.getSession().getAttribute("currentPlayList") == null ? new ArrayList<MusicArtistAlbum>() : (ArrayList<MusicArtistAlbum>)request.getSession().getAttribute("currentPlayList"); 
		System.out.println(cList);
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(cList, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
