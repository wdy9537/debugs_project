package com.debugs.search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.common.model.vo.Album;
import com.debugs.common.model.vo.Artist;
import com.debugs.common.model.vo.Music;
import com.debugs.member.model.vo.Member;
import com.debugs.musiclist.model.service.MusiclistService;
import com.debugs.musiclist.model.vo.Like;
import com.debugs.playlist.model.service.PlaylistService;
import com.debugs.playlist.model.vo.Playlist;
import com.debugs.search.model.service.SearchService;

/**
 * Servlet implementation class serachViewController
 */
@WebServlet("/search.li")
public class serachViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serachViewController() {
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

		
		String keyword = request.getParameter("keyword");
		
		ArrayList<Artist> searchArtist = new SearchService().searchArtist(keyword);
		ArrayList<Album> searchAlbum = new SearchService().searchAlbum(keyword);
		ArrayList<Music> searchMusic = new SearchService().searchMusic(keyword);
		ArrayList<Like> like = new MusiclistService().checkMusicLikeList(userNo);
		ArrayList<Playlist> pl = new PlaylistService().selectRecommnedPlaylist();
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("artist", searchArtist);
		request.setAttribute("album", searchAlbum);
		request.setAttribute("music", searchMusic);
		request.setAttribute("like", like);
		request.setAttribute("pl", pl);
		request.getRequestDispatcher("views/search/searchView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
