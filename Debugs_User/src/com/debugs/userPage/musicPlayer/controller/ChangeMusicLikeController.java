package com.debugs.userPage.musicPlayer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.member.model.vo.Member;
import com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum;
import com.debugs.userPage.mainPage.model.vo.User;
import com.debugs.userPage.musicPlayer.model.service.MusicPlayerService;

/**
 * Servlet implementation class ChangeMusicLikeController
 */
@WebServlet(urlPatterns = "/changeMusicLike", name = "changeMusicLikeController" )
public class ChangeMusicLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMusicLikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mno = request.getParameter("mno");
		
		int userNo = ((Member) request.getSession().getAttribute("loginUser")).getUserNo();
		
		String result = new MusicPlayerService().changeMusicLike(mno, userNo);
		
		ArrayList<MusicArtistAlbum> cList = request.getSession().getAttribute("currentPlayList") == null ? new ArrayList<MusicArtistAlbum>() : (ArrayList<MusicArtistAlbum>)request.getSession().getAttribute("currentPlayList"); 
		
		for(MusicArtistAlbum maa : cList) {
			if(maa.getMusicNo() == Integer.parseInt(mno)) {
				maa.setMusicLike(maa.getMusicLike() == 1 ? 0 : 1);
				break;
			}
		}
		request.getSession().setAttribute("currentPlayList", cList);
		//1. cancel => 좋아요 취소
		//2. like => 좋아요
		//3. error => 실패
		
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
