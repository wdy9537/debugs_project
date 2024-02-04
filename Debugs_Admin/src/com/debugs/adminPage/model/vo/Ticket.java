package com.debugs.adminPage.model.vo;

public class Ticket {

	private int ticketNo;
	private String ticketPer;
	private String ticketName;
	private int ticketPrice;
	private String ticketLoopPlay;
	private String ticketOfflinePlay;

	public Ticket() {

	}

	public Ticket(int ticketNo, String ticketPer, String ticketName, int ticketPrice, String ticketLoopPlay,
			String ticketOfflinePlay) {
		super();
		this.ticketNo = ticketNo;
		this.ticketPer = ticketPer;
		this.ticketName = ticketName;
		this.ticketPrice = ticketPrice;
		this.ticketLoopPlay = ticketLoopPlay;
		this.ticketOfflinePlay = ticketOfflinePlay;
	}

	public Ticket(String ticketName, int ticketPrice, String ticketPer, String ticketLoopPlay, String ticketOfflinePlay) {
		super();
		this.ticketName = ticketName;
		this.ticketPrice = ticketPrice;
		this.ticketPer = ticketPer;
		this.ticketLoopPlay = ticketLoopPlay;
		this.ticketOfflinePlay = ticketOfflinePlay;
	}

	public Ticket(int ticketNo, String ticketName) {
		super();
		this.ticketNo = ticketNo;
		this.ticketName = ticketName;
	}

	public Ticket(int ticketNo, String ticketName, int ticketPrice, String ticketPer) {
		super();
		this.ticketNo = ticketNo;
		this.ticketName = ticketName;
		this.ticketPrice = ticketPrice;
		this.ticketPer = ticketPer;
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

	public void setTicketName(String ticketName) {
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

	public void setTicketOfflinePlay(String ticketOfflinePlay) {
		this.ticketOfflinePlay = ticketOfflinePlay;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", ticketPer=" + ticketPer + ", ticketName=" + ticketName
				+ ", ticketPrice=" + ticketPrice + ", ticketLoopPlay=" + ticketLoopPlay + ", ticketOfflinePlay="
				+ ticketOfflinePlay + "]";
	}

}
