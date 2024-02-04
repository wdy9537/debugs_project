package com.debugs.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.member.model.service.MemberService;
import com.debugs.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/pwdupdate.me")
public class MemberPwdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 마이페이지로 이동
		request.getRequestDispatcher("views/mypage/pwdupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내정보변경
		request.setCharacterEncoding("UTF-8");
		
		int result = 0;
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
	
		System.out.println("userPwd : " + userPwd);
		
		result = new MemberService().pwdupdateMember(userId,userPwd);
		
		if(result == 0) {// 실 패
			request.setAttribute("errorMsg", "비밀번호 수정에 실패했습니다.");
			request.getRequestDispatcher(request.getContextPath()+"views/common/errorPage.jsp").forward(request, response);
		}else { // 성 공
			//session영역안에 업데이트된 사용자정보 담아주기
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 비밀번호를 변경했습니다.");
			
			// 응답페이지 url 재요청
			//response.sendRedirect(request.getContextPath()+"/views/mypage/modify2.jsp");  // 페이지 이동은 
			response.sendRedirect(request.getContextPath());  // 페이지 이동은 
		}
	}
	
	
	
	
	
	
	
	

}
