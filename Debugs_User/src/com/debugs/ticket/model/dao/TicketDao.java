package com.debugs.ticket.model.dao;

import static com.debugs.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.cs.model.vo.Notice;
import com.debugs.member.model.vo.User;
import com.debugs.ticket.model.vo.Ticket;

public class TicketDao {
	private Properties prop = new Properties();
	
	public TicketDao() {
		String fileName = TicketDao.class.getResource("/sql/ticket/ticket-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Ticket> selectTicketList(Connection conn){
		
		// SELECT문 => 여러행 => ResultSet => ArrayList
		ArrayList<Ticket> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTicketList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Ticket t = new Ticket(
									  rset.getInt("TICKET_NO"),
									  rset.getString("TICKET_NAME"),
									  rset.getInt("TICKET_PRICE")
									  );
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	public int updateBuyTicket(Connection conn, int ticketNo, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBuyTicket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ticketNo);
			pstmt.setInt(2, userNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int updateBuyTicketNo(Connection conn, int ticketNo, int userNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateTicketNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ticketNo);
			pstmt.setInt(2, userNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}

