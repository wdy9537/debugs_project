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

/**
 * Servlet implementation class AddPlayRecommendController
 */
@WebServlet(urlPatterns = "/playRecommend" , name="addPlayRecommendController")
public class AddPlayRecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPlayRecommendController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	//추천음악 전체 추가
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 곡정보 얻어옴
		String[] musicNos = request.getParameter("musicNos").split(",");
		System.out.println(musicNos);
		
		ArrayList<MusicArtistAlbum> cList = request.getSession().getAttribute("currentPlayList") == null
				? new ArrayList<MusicArtistAlbum>()
				: (ArrayList<MusicArtistAlbum>) request.getSession().getAttribute("currentPlayList");

		for (String mno : musicNos) {

			for (int i = 0; i < cList.size(); i++) {
				if (cList.get(i).getMusicNo() == Integer.parseInt(mno)) {
					cList.remove(i);
					i--;
				}
			}
			MusicArtistAlbum maa = new MusicPlayerService().selectMusicArtistAlbum(mno);

			cList.add(maa);
		}
		System.out.println(cList);
		
		request.getSession().setAttribute("currentPlayList", cList);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
