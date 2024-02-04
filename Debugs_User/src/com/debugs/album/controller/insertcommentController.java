package com.debugs.album.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.album.model.service.AlbumService;
import com.debugs.album.model.vo.Reply;
import com.google.gson.Gson;

/**
 * Servlet implementation class insertcommentController
 */
@WebServlet("/insertcomment.al")
public class insertcommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertcommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replyContent = request.getParameter("replyContent");
		int albumNo = Integer.parseInt(request.getParameter("ano"));
		
		Reply r = new Reply();
		r.setReplyContent(replyContent);
		
		int result = new AlbumService().insertComment(r, albumNo);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(result, response.getWriter());
		
		
		/*
		if(result > 0) { // 성공 -> 메인페이지로 url재요청보내기
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "댓글등록에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/goAlbum.me");
		}else { // 에러페이지로 포워딩
			request.setAttribute("errorMsg", "댓글등록에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/goAlbum.me");
		}
		*/
	}

}
