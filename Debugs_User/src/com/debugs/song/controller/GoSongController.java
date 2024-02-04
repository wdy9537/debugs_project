package com.debugs.song.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.album.model.vo.Album;
import com.debugs.cs.model.service.NoticeService;
import com.debugs.cs.model.vo.Notice;
import com.debugs.member.model.vo.Artist;
import com.debugs.song.model.service.SongService;
import com.debugs.song.model.vo.Keyword;
import com.debugs.song.model.vo.Music;

/**
 * Servlet implementation class GoFaqController
 */
@WebServlet("/goSong.me")
public class GoSongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoSongController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int musicNo = Integer.parseInt(request.getParameter("mno"));
		
		Music m = new SongService().selectMusicList(musicNo);
		request.setAttribute("m", m);
		ArrayList<Keyword> list = new SongService().selectKeywordList(musicNo);
		request.setAttribute("list", list);
		Artist ar = new SongService().selectArtistList(musicNo);
		request.setAttribute("ar", ar);
		Album a = new SongService().selectAlbumList(musicNo);
		request.setAttribute("a", a);
		
		request.getRequestDispatcher("views/song/songPage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
