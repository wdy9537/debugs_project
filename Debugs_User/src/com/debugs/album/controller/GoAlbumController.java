package com.debugs.album.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.album.model.service.AlbumService;
import com.debugs.album.model.vo.Album;
import com.debugs.album.model.vo.Reply;
import com.debugs.cs.model.service.NoticeService;
import com.debugs.cs.model.vo.Notice;
import com.debugs.member.model.vo.Artist;
import com.debugs.member.model.vo.User;
import com.debugs.song.model.service.SongService;
import com.debugs.song.model.vo.Keyword;
import com.debugs.song.model.vo.Music;

/**
 * Servlet implementation class GoFaqController
 */
@WebServlet("/goAlbum.me")
public class GoAlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoAlbumController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int albumNo = Integer.parseInt(request.getParameter("ano"));
		
		Album a = new AlbumService().selectAlbumList(albumNo);
		request.setAttribute("a", a);
		
		Artist ar = new AlbumService().selectArtistList(albumNo);
		request.setAttribute("ar", ar);
		
		ArrayList<Music> list = new AlbumService().selectMusicList(albumNo);
		request.setAttribute("list", list);
		
		ArrayList<Reply> list2 = new AlbumService().selectReplyList(albumNo);
		request.setAttribute("list2", list2);
		
		request.getRequestDispatcher("views/album/albumPage.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
