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
import com.debugs.member.model.vo.Ticket;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/ticket_Select.me")
public class MemberTicketSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberTicketSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.getRequestDispatcher("views/mypage/ticket.jsp").forward(request, response);
        
        HttpSession session = request.getSession();
        Member user = (Member)session.getAttribute("loginUser");
        
        String userId = user.getUserId();
        
        Ticket UserTicket = new MemberService().Member_ticketSelect(userId);
        
        System.out.println("user"+UserTicket);
        
        request.setAttribute("UserTicket", UserTicket);
        request.getRequestDispatcher("views/mypage/ticket.jsp").forward(request, response);
           
     }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* request.setCharacterEncoding("UTF-8");
		
		// 삭제처리시 delete문이 아닌 update문 이용.
		
		String userId = request.getParameter("userId");
		
		Ticket UserTicket = new MemberService().searchMemberTicket(userId);
		
		if(UserTicket == null) { // 티켓정보 없음 
			//request.setAttribute("errorMsg", "이용권 조회에 실패했습니다");
			HttpSession session = request.getSession();
			session.removeAttribute("UserTicket");   // 세션정보를 삭제하는 코드이다.
			
			request.getRequestDispatcher("views/mypage/ticket.jsp").forward(request, response);
			// response.sendRedirect("views/mypage/ticket.jsp");

		}else { // 티켓정보 있음 
			HttpSession session = request.getSession();
			
			session.setAttribute("UserTicket", UserTicket);
			
			session.setAttribute("alertMsg", "이용권이 정상 조회 되었습니다 ^^");
			request.getRequestDispatcher("views/mypage/ticket.jsp").forward(request, response);
			//response.sendRedirect("views/mypage/ticket.jsp");
		}
		 */
	}

}
