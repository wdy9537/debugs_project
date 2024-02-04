package com.debugs.adminPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Ticket;

/**
 * Servlet implementation class InsertTicketController
 */
@WebServlet("/insertticket.ad")
public class InsertTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertTicketController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ticketName = request.getParameter("ticket-name");
		int ticketPrice = Integer.parseInt(request.getParameter("ticket-price"));
		String ticketPer = request.getParameter("ticket-per");
		String ticketLoopPlay = request.getParameter("music-listen");
		String ticketOfflinePlay = request.getParameter("music-start");

		Ticket t = new Ticket(ticketName, ticketPrice, ticketPer, ticketLoopPlay, ticketOfflinePlay);

		int result = new AdminService().insertTicket(t);

		if (result > 0) {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "성공적으로 이용권이 등록되었습니다.");

			response.sendRedirect(request.getContextPath() + "/ticket.ad");
		} else {
			HttpSession session = request.getSession();

			session.setAttribute("alertMsg", "이용권 등록에 실패했습니다.");

			response.sendRedirect(request.getContextPath() + "/ticket.ad");
		}

	}

}
