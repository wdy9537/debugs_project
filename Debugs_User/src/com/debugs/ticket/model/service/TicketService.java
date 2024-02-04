package com.debugs.ticket.model.service;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.ticket.model.dao.TicketDao;
import com.debugs.ticket.model.vo.Ticket;

public class TicketService {
	
	public ArrayList<Ticket> selectTicketList(){
		
		Connection conn = getConnection();
		
		ArrayList<Ticket> list = new TicketDao().selectTicketList(conn);
		
		close(conn);
		
		return list;
	}
	
	public int updateBuyTicket(int ticketNo, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new TicketDao().updateBuyTicket(conn, ticketNo, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	public int updateBuyTicketNo(int ticketNo, int userNo) {
		
		Connection conn = getConnection();
		
		int result = new TicketDao().updateBuyTicketNo(conn, ticketNo, userNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
}
