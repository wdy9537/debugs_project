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
 * Servlet implementation class AddCurrentPlayListController
 */
@WebServlet(urlPatterns = "/addCurrentPlayList", name="addCurrentPlayListController")
public class AddCurrentPlayListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCurrentPlayListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // 한곡 재생목록에 추가
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//곡정보 얻어옴
		String mno = request.getParameter("mno");
		ArrayList<MusicArtistAlbum> cList = request.getSession().getAttribute("currentPlayList") == null ? new ArrayList<MusicArtistAlbum>() : (ArrayList<MusicArtistAlbum>)request.getSession().getAttribute("currentPlayList"); 
		
		for(int i =0; i<cList.size(); i++) {
			if(cList.get(i).getMusicNo() == Integer.parseInt(mno)) {
				cList.remove(i);
				break;
			}
		}
		
		MusicArtistAlbum maa = new MusicPlayerService().selectMusicArtistAlbum(mno);
		
		cList.add(maa);
		
		request.getSession().setAttribute("currentPlayList", cList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
