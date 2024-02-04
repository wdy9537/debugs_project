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
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/ticket_Cancel.me")
public class MemberTicketCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTicketCancelController() {
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
		request.setCharacterEncoding("UTF-8");
		
		// 삭제처리시 delete문이 아닌 update문 이용.
		
		String userId = request.getParameter("userId");
		
		
		
		System.out.println("userId" + userId);
		
		
		
		
		HttpSession session = request.getSession();  
		
		int result = new MemberService().updateMember_ticketCancel(userId);
		
		if(result > 0) { // 회원탈퇴 성공시 => 로그아웃처리
			session.setAttribute("alertMsg", "성공적으로 해지 되었습니다. 그동안 이용해주셔서 감사합니다 ^^");
			
			
			session.removeAttribute("loginUser");
			response.sendRedirect(request.getContextPath());
		}else { //실패시 => 에러머세지+에러페이지로 포워딩
			request.setAttribute("errorMsg", "이용권 해지에 실패했습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
	
	
	
	
	
	
	
	}

}
