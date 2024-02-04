package com.debugs.playlist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.playlist.model.service.PlaylistService;
import com.debugs.playlist.model.vo.Playlist;
import com.debugs.playlist.model.vo.PlaylistTrack;

/**
 * Servlet implementation class RecommendPlaylistListController
 */
@WebServlet("/recommend.pl")
public class RecommendPlaylistListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendPlaylistListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Playlist> plList = new ArrayList();
		ArrayList<PlaylistTrack> trackList = new ArrayList();
		
		plList = new PlaylistService().selectRecommnedPlaylist();
		
		request.setAttribute("plList", plList);
		request.setAttribute("trackList", trackList);
		
		request.getRequestDispatcher("views/playlist/playlist_list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
