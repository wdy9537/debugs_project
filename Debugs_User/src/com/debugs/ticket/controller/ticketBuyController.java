package com.debugs.ticket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.member.model.vo.Member;
import com.debugs.ticket.model.service.TicketService;

/**
 * Servlet implementation class ticketBuyController
 */
@WebServlet("/buyTicket.ti")
public class ticketBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ticketBuyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ticketNo = Integer.parseInt(request.getParameter("tno"));
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int userNo = loginUser.getUserNo();
		
//		System.out.println(ticketNo);
		int result = new TicketService().updateBuyTicket(ticketNo, userNo);
		int result2 = new TicketService().updateBuyTicketNo(ticketNo, userNo);
		if(result > 0 && result2 > 0) { // 유효한 게시글 => 게시글정보, 첨부파일 정보 조회
			session.setAttribute("alertMsg", "티켓구매에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/list.me");
		} else {
			request.setAttribute("errorMsg", "티켓구매에 실패했습니다.");
			response.sendRedirect(request.getContextPath()+"/list.me");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
