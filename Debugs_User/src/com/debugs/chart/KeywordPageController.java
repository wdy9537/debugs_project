package com.debugs.chart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.common.model.vo.Music;
import com.debugs.member.model.vo.Member;
import com.debugs.musiclist.model.service.MusiclistService;
import com.debugs.musiclist.model.vo.Like;

/**
 * Servlet implementation class KeywordPageController
 */
@WebServlet("/keyword.page")
public class KeywordPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KeywordPageController() {
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

		
		String chart = null;
		String keyword = request.getParameter("keyword");
		
		ArrayList<Music> searchMusic = new ChartService().searchKeywordMusic(keyword);
		ArrayList<Like> like = new MusiclistService().checkMusicLikeList(userNo);

		request.setAttribute("music", searchMusic);
		request.setAttribute("like", like);
		request.setAttribute("chart", "#"+keyword);
		
		request.getRequestDispatcher("views/chart/chart.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
