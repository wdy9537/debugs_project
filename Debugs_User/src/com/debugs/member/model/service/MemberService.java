package com.debugs.member.model.service;

import static com.debugs.common.JDBCTemplate.close;
import static com.debugs.common.JDBCTemplate.commit;
import static com.debugs.common.JDBCTemplate.getConnection;
import static com.debugs.common.JDBCTemplate.rollback;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import  static com.debugs.common.JDBCTemplate.*;
import com.debugs.member.model.dao.MemberDao;
import com.debugs.member.model.vo.Member;
import com.debugs.member.model.vo.Ticket;

public class MemberService { // 로그인

	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		System.out.println("MemberService  loginMember  userId : "  + userId);
		System.out.println("MemberService  loginMember  userPwd : "  + userPwd);
		
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return m;
	}
	
	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		
		//1) 회원정보 변경요청 보내기(UPDATE)
		int result = new MemberDao().updateMember(conn, m);
		
		 Member updateMember = null;
		
		System.out.println("MemberService  updateMember  result : "  + result);
		
		//2) 트랜잭션 처리
		if(result > 0) {
			System.out.println("MemberService  updateMember  commit  " );
			commit(conn);
			
			// 3) 갱신된 회원정보 다시 조회해오기
//			updateMember = new MemberDao().selectMember(conn, m.getUserId());
		}else {
			System.out.println("MemberService  updateMember  rollback   ");

			rollback(conn);
		}
		
		// 수정 후 조회
		System.out.println("MemberService  loginMember  userId : "  + m.getUserId());
		System.out.println("MemberService  loginMember  userPwd : "  + m.getUserPwd());
		
		updateMember = new MemberDao().loginMember(conn, m.getUserId(), m.getUserPwd());

		
		//4) 자원반납
		close(conn);
		
		return updateMember;
	}
	
	public int updateMember_ticketCancel(String userId) {
		
		Connection conn = getConnection();
		
		
		int result = new MemberDao().updateMember_ticketCancel(conn, userId);
		
		System.out.println("MemberService  updateMember_ticketCancel  result : "  + result);
		
		
		if(result > 0) {
			System.out.println("MemberService  updateMember_ticketCancel  commit  " );
			commit(conn);
			
			
		}else {
			System.out.println("MemberService  updateMember_ticketCancel  rollback   ");

			rollback(conn);
		}
		
		
		close(conn);
		
		return 1;

	}
	
	
	public Ticket Member_ticketSelect(String userId) {
		
		Connection conn = getConnection();
		
		
		Ticket t = new MemberDao().Member_ticketSelect(conn, userId);
		
		System.out.println("MemberService  Member_ticketSelect   : "  );
		
		
		if(t == null ) {
			System.out.println("MemberService  Member_ticketSelect  Ticket Not Found  " );
		}else {
			System.out.println("MemberService  Member_ticketSelect  Ticket Exist    ");

		}
		
		close(conn);
		
		return t;

	}
	
	
	public Member findUserIdMember(String userName, String userEmail) {
		
		Connection conn = getConnection();
		
		Member selectMember = null;
		
		
		
		selectMember = new MemberDao().findUserIdMember(conn, userName, userEmail);
		  
			
		
		close(conn);
		
		return selectMember;
	}	
	
	
	public Member findUserPwdMember(String userId, String userEmail) {
		
		Connection conn = getConnection();
		
		Member selectMember = null;
		
		
		
		selectMember = new MemberDao().findUserPwdMember(conn, userId, userEmail);
		  
			
		
		close(conn);
		
		return selectMember;
	}	
	
	
	
	public int pwdCheck(String checkPwd) {
		Connection conn = getConnection();
		
		System.out.println("MemberService.java  checkPwd :  " + checkPwd);
		
		int count = new MemberDao().pwdCheck(conn, checkPwd);
		
		System.out.println("MemberService.java  pwdCheck  count :  " + count);
		
		close(conn);
		
		return count;
	}
	
	
	
	
	
	public int deleteMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		
		System.out.println("MemberService.java  checkId :  " + checkId);
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		System.out.println("MemberService.java  idCheck  count :  " + count);
		
		close(conn);
		
		return count;
	}
	
	public int phoneCheck(String checkPhone) {
		Connection conn = getConnection();
		
		System.out.println("MemberService.java  checkPhone :  " + checkPhone);
		
		int count = new MemberDao().phoneCheck(conn, checkPhone); 
		
		System.out.println("MemberService.java  phoneCheck  count :  " + count);

		close(conn);
		
		return count;
	}
	
	
	public int pwdupdateMember(String userId,String userPwd) {
		
		Connection conn = getConnection();
		
		//1) 회원정보 변경요청 보내기(UPDATE)
		int result = new MemberDao().pwdupdateMember(conn, userId,userPwd);
		
		 
		
		System.out.println("MemberService  updateMember  result : "  + result);
		
		//2) 트랜잭션 처리
		if(result > 0) {
			System.out.println("MemberService  pwdupdateMember  commit  " );
			commit(conn);
			
			// 3) 갱신된 회원정보 다시 조회해오기
//			updateMember = new MemberDao().selectMember(conn, m.getUserId());
		}else {
			System.out.println("MemberService  pwdupdateMember  rollback   ");

			rollback(conn);
		}
		
		// 수정 후 조회
		
		
		
		

		
		//4) 자원반납
		close(conn);
		
		return result;
	}

	public Ticket searchMemberTicket(String userId) {
		
		Connection conn = getConnection();
		
		Ticket ticket = new MemberDao().searchMemberTicket(conn, userId);
		
		close(conn);
		
		return ticket;
	}
	
	
	
	
	
	
	
	
	
	
}
