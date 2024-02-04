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
import com.debugs.search.model.service.SearchService;

/**
 * Servlet implementation class ChartPageController
 */
@WebServlet("/chart.page")
public class ChartPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartPageController() {
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

	      
		String chart = request.getParameter("chart");
		
		ArrayList<Music> searchMusic = new ChartService().searchMusic(chart);
		ArrayList<Like> like = new MusiclistService().checkMusicLikeList(userNo);

		request.setAttribute("music", searchMusic);
		request.setAttribute("like", like);
		request.setAttribute("chart", chart);
		
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
