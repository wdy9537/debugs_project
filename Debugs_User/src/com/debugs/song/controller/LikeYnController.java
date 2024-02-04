package com.debugs.song.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.song.model.service.SongService;
import com.debugs.song.model.vo.LikeMusic;
import com.debugs.member.model.vo.User;
/**
 * Servlet implementation class LikeYnController
 */
@WebServlet("/LikeYn.li")
public class LikeYnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeYnController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mno = request.getParameter("mno");
		
	      int userNo = ((User) request.getSession().getAttribute("loginUser")).getUserNo();
	      
	      String result = new SongService().changeMusicLike(mno, userNo);
	      
	      ArrayList<LikeMusic> cList = request.getSession().getAttribute("currentPlayList") == null ? new ArrayList<LikeMusic>() : (ArrayList<LikeMusic>)request.getSession().getAttribute("currentPlayList"); 
	      
	      for(LikeMusic maa : cList) {
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
