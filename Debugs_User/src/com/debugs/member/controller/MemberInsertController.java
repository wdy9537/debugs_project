package com.debugs.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.member.model.service.MemberService;
import com.debugs.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")

public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
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
		
		//1) 인코딩작업
		request.setCharacterEncoding("UTF-8");
	
		//2) 요청시 전달값을 뽑아서 변수 및 객체에 기록
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userSsn = request.getParameter("userSsn");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		
		System.out.println("request.userId  : " + request.getParameter("userId"));
		System.out.println("userId  : " + userId);
		
		System.out.println("userPwd" + userPwd);
		
	
		
		// 매개변수있는 생성자를 이용해서 Member객체에 담기
		Member m = new Member(userId, userPwd, userName, userSsn, userEmail, userPhone);

		// 3) 요청처리(서비스 매서드 호출 및 결과 받기)
		int result = new MemberService().insertMember(m);
		
		
		// 4) 처리결과를 가지고 사용자가 보게될 응답 뷰 지정
		if(result > 0) { // 성공 -> 메인페이지로 url재요청보내기
			request.getSession().setAttribute("alertMsg", "디벅스 회원가입에 성공했습니다.");
			response.sendRedirect(request.getContextPath());
		}else { // 에러페이지로 포워딩
			request.setAttribute("errorMsg", "디벅스 회원가입에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

		
		

	

	}

}
