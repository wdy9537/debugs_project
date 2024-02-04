package com.debugs.userPage.mainPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.chart.ChartService;
import com.debugs.common.model.vo.Music;
import com.debugs.member.model.vo.Member;
import com.debugs.musiclist.model.service.MusiclistService;
import com.debugs.musiclist.model.vo.Like;
import com.debugs.userPage.mainPage.model.service.MainPageService;
import com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum;
import com.debugs.userPage.mainPage.model.vo.Playlist;
import com.debugs.userPage.mainPage.model.vo.User;

/**
 * Servlet implementation class MainPagecontroller2
 */
@WebServlet("/main")
public class MainPageBannerController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageBannerController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MainPageService mpService = new MainPageService();
		HttpSession session = request.getSession();
		Member loginUser = (Member) session.getAttribute("loginUser"); // 수정해야할수도 잇음
		
		ArrayList<MusicArtistAlbum> list = mpService.selectLatestMusic();
		
		request.setAttribute("list", list);
		

		ArrayList<Playlist> pList = mpService.selectRecommendPl();
		
		request.setAttribute("pList", pList);
		
		ArrayList<MusicArtistAlbum> rList = mpService.selectRandomMusic();
		
		request.setAttribute("rList",rList);
		
		String chart = "TOP 100 차트";

		int userNo = 0;
		if ( loginUser != null ) {
			userNo = loginUser.getUserNo();
		} 
		
		ArrayList<Music> searchMusic = new ChartService().searchMusic(chart);
		ArrayList<Like> like = new MusiclistService().checkMusicLikeList(userNo);

		request.setAttribute("music", searchMusic);
		request.setAttribute("like", like);
		
		request.getRequestDispatcher("views/main/mainPageView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
