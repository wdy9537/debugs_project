package com.debugs.userPage.musicPlayer.model.vo;

public class User {

	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String userSsn;
	private String userEmail;
	private String userPhone;
	private String ticketDate;
	private int ticketNo;

	public User() {

	}

	public User(int userNo, String userId, String userPwd, String userName, String userSsn, String userEmail,
			String userPhone, String ticketDate, int ticketNo) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userSsn = userSsn;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.ticketDate = ticketDate;
		this.ticketNo = ticketNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSsn() {
		return userSsn;
	}

	public void setUserSsn(String userSsn) {
		this.userSsn = userSsn;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userSsn=" + userSsn + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", ticketDate="
				+ ticketDate + ", ticketNo=" + ticketNo + "]";
	}

}
