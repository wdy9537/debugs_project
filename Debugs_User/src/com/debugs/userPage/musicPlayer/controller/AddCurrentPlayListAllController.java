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
 * Servlet implementation class AddCurrentPlayListAllController
 */
@WebServlet(urlPatterns = "/addCurrentPlayListAll", name="addCurrentPlayListAllController")
public class AddCurrentPlayListAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCurrentPlayListAllController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //플레이리스트 곡 전체 추가
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//곡정보 얻어옴
		String pno = request.getParameter("pno");
		ArrayList<MusicArtistAlbum> cList = request.getSession().getAttribute("currentPlayList") == null ? new ArrayList<MusicArtistAlbum>() : (ArrayList<MusicArtistAlbum>)request.getSession().getAttribute("currentPlayList"); 
		
		ArrayList<MusicArtistAlbum> pList = new MusicPlayerService().selectPlayList(pno);
		
		// 중복된 곡이 있나 체크
		for(MusicArtistAlbum maa : pList) {
			for(int i =0; i<cList.size(); i++) {
				if(cList.get(i).getMusicNo() == maa.getMusicNo()) {
					cList.remove(i);
					break;
				}
			}
			cList.add(maa);
		}
		
		request.getSession().setAttribute("currentPlayList", cList);
		
		response.getWriter().print(pList.size() != 0 ? pList.get(0).getMusicNo() : "-1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
