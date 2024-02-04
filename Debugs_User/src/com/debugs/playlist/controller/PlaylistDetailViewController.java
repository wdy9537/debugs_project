package com.debugs.playlist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.playlist.model.vo.Playlist;
import com.debugs.playlist.model.vo.PlaylistTrack;
import com.debugs.member.model.vo.Member;
import com.debugs.musiclist.model.service.MusiclistService;
import com.debugs.musiclist.model.vo.Like;
import com.debugs.playlist.model.service.PlaylistService;

/**
 * Servlet implementation class PlaylistDetailViewController
 */
@WebServlet("/detail.pl")
public class PlaylistDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	      Member user = (Member)session.getAttribute("loginUser");
	      int userNo = 0;
	      
	      if ( user != null ) {
	         userNo = user.getUserNo();
	      }

		
		int playlistNo = Integer.parseInt(request.getParameter("plno"));
		
		Playlist pl = null;
		ArrayList<PlaylistTrack> trackList = new ArrayList();
		ArrayList<Like> like = new ArrayList();
		
		pl = new PlaylistService().playlistDetailPageView(playlistNo);
		trackList = new PlaylistService().playlistTrackSelect(playlistNo);
		like = new MusiclistService().checkMusicLikeList(userNo);
		
		request.setAttribute("pl", pl);
		request.setAttribute("trackList", trackList);
		request.setAttribute("like", like);
		request.getRequestDispatcher("views/playlist/playlist_detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
