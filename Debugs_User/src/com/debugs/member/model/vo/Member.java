package com.debugs.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int userNo;//	USER_NO
	private String userId;//	USER_ID
	private String userPwd;//	USER_PWD
	private String userName;//	USER_NAME
	private String userSsn;//	USERSSN
	private String userEmail;//	USERuserEmail
	private String userPhone;//	userPhone
	private String TicketName;//	TICKETNAME
	private String TicketDate;//	TICKETDATE
	private String userStatus;//	USER_STATUS
	private int ticketNo;
	
	public Member() {
		super();
	}
     
	/*회원가입 맴버 메소드*/
	public Member(int userNo, String userId, String userPwd, String userName, String userSsn, String userEmail,
			String userPhone, String TicketName, String TicketDate, String userStatus ) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userSsn = userSsn;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.TicketName = TicketName;
		this.TicketDate = TicketDate;
		this.userStatus = userStatus;
	}
	
	public Member(String userId, String userPwd, String userName, String userSsn, String userEmail, String userPhone,
			String TicketName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userSsn = userSsn;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.TicketName = TicketName;
	}
	
	public Member(int userNo, String userId, String userPwd, String userName, String userSsn, String userEmail, String userPhone,
			int ticketNo, String ticketDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userSsn = userSsn;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.ticketNo = ticketNo;
		this.TicketDate = ticketDate;
	}
	
	
	
	public Member(String userId, String userPwd,String userName, String userSsn, String userEmail, String userPhone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userSsn = userSsn;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	
	}
	
      /*개인 정보 수정안에 있는 휴대폰 번호 확인 메소드  4개 */
	public Member(String userPwd,String userName, String userSsn,String userPhone) {
		super();
		
		this.userPwd = userPwd;
		this.userName = userName;
		this.userSsn = userSsn;
		this.userPhone = userPhone;
	
	}
	
    /*개인 정보 수정안에 있는 휴대폰 번호 확인 메소드  5개 */
	public Member(String userName, String userPwd, String userSsn,String userPhone,String userId) {
		super();
		this.userPwd = userPwd;
		this.userName = userName;
		this.userSsn = userSsn;
		this.userPhone = userPhone;
		this.userId = userId;
	}	
	
	public Member(String userPwd) {
		super();
		
		this.userPwd = userPwd;
	
	
	}
	
	public Member(String userPwd,String userId) {
		super();
		
		this.userPwd = userPwd;
		this.userPwd = userId;
	
	
	}
	


	public Member(String ticketName, String ticketDate, int ticketNo) {
		super();
		TicketName = ticketName;
		TicketDate = ticketDate;
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

	public String getTicketName() {
		return TicketName;
	}

	public void setTicketName(String TicketName) {
		this.TicketName = TicketName;
	}

	public String getTicket_Date() {
		return TicketDate;
	}

	public void setTicket_Date(String TicketDate) {
		this.TicketDate = TicketDate;
	}

	public String getUserStatus() {  
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}  
	

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userSsn=" + userSsn + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", TicketName=" + TicketName
				+ ", TicketDate=" + TicketDate + ",userStatus=" + userStatus+ "]";
	}

	public String getTicketDate() {
		return TicketDate;
	}

	public void setTicketDate(String ticketDate) {
		TicketDate = ticketDate;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	
	
	
}






