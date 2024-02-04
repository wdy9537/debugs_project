package com.debugs.member.model.vo;

import java.sql.Date;

public class Ticket {
	
	private int ticketNo;//	TICKET_NO
	private String ticketPer;//	TICKET_PER
	private String ticketName;//	TICKET_NAME
	private int ticketPrice;//	TICKET_PRICE
	private String ticketLoopPlay;//	TICKET_LOOP_PLAY
	private String ticketOfflinePlay;//	TICKET_OFFLINE_PLAY
	
	private String ticketDate;
	private String userName;
	

	
	public Ticket() {
		super();
	}
     
	/*회원가입 맴버 메소드*/
	public Ticket(int ticketNo, String ticketPer, String ticketName, int ticketPrice, String ticketLoopPlay, String ticketOfflinePlay) {
		super();
		this.ticketNo = ticketNo;
		this.ticketPer = ticketPer;
		this.ticketName = ticketName;
		this.ticketPrice = ticketPrice;
		this.ticketLoopPlay = ticketLoopPlay;
		this.ticketOfflinePlay= ticketOfflinePlay;

	}
	
	

	public Ticket(String ticketName, String ticketLoopPlay, String ticketOfflinePlay, String ticketDate,
			String userName) {
		super();
		this.ticketName = ticketName;
		this.ticketLoopPlay = ticketLoopPlay;
		this.ticketOfflinePlay = ticketOfflinePlay;
		this.ticketDate = ticketDate;
		this.userName = userName;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getTicketPer() {
		return ticketPer;
	}

	public void setTicketPer(String ticketPer) {
		this.ticketPer = ticketPer;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketPwd(String ticketName) {
		this.ticketName = ticketName;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getTicketLoopPlay() {
		return ticketLoopPlay;
	}

	public void setTicketLoopPlay(String ticketLoopPlay) {
		this.ticketLoopPlay = ticketLoopPlay;
	}

	public String getTicketOfflinePlay() {
		return ticketOfflinePlay;
	}

	public void setTicketEmail(String ticketOfflinePlay) {
		this.ticketOfflinePlay= ticketOfflinePlay;
	}


	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", ticketPer=" + ticketPer + ", ticketName=" + ticketName + ", ticketPrice=" + ticketPrice
				+ ", ticketLoopPlay=" + ticketLoopPlay + ", ticketOfflinePlay=" + ticketOfflinePlay+  "]";
	}

	public String getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public void setTicketOfflinePlay(String ticketOfflinePlay) {
		this.ticketOfflinePlay = ticketOfflinePlay;
	}
	
	
	
	
}






