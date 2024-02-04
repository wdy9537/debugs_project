package com.debugs.member.model.dao;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.debugs.common.JDBCTemplate.*;

import com.debugs.member.model.vo.Member;
import com.debugs.member.model.vo.Ticket;
import com.debugs.musiclist.model.dao.MusiclistDao;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() { 
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 로그인
	public Member loginMember(Connection conn, String userId, String userPwd) {
		
		// Select문 실행예정 => ResultSet객체에 담아줘야함
		Member m = null;
		
		System.out.println("MemberDao  loginMember  userId : "  + userId);
		System.out.println("MemberDao  loginMember  userPwd : "  + userPwd);

		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginDebugs_User");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			System.out.println("MemberDao  1  sql  : " + sql);			
			System.out.println("MemberDao  1  rset.getRow()  : " + rset.getRow() );	

			if(rset.next()) {
				System.out.println("MemberDao  2 ");			
				
				m = new Member(
						rset.getInt("USER_NO"),
						rset.getString("USER_ID"), 
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("USER_SSN"),
						rset.getString("USER_EMAIL"),
						rset.getString("USER_PHONE"),
						rset.getInt("TICKET_NO"),
						rset.getString("TICKET_DATE")
						);
				 System.out.println("MemberDao  rset.getInt( USER_NO ) : "  + rset.getInt("USER_NO"));

			}
			System.out.println("MemberDao  3 ");			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		
		// Insert문 => 처리된 행의 갯수를 반환
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertDebugs_User");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserSsn());
			pstmt.setString(5, m.getUserEmail());
			pstmt.setString(6, m.getUserPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	
	public int updateMember(Connection conn, Member m) {
		
		//UPDATE => 처리된 행의 갯수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateDebugs_User");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserSsn());
			pstmt.setString(4, m.getUserPhone());
			pstmt.setString(5, m.getUserId());

			System.out.println( "MemberDao updateMember  sql : " +  sql );

			System.out.println( "MemberDao updateMember  m.getUserName() : " +  m.getUserName() );
			System.out.println( "MemberDao updateMember  m.getUserPwd() : " +  m.getUserPwd() );
			System.out.println( "MemberDao updateMember  m.getUserSsn() : " +  m.getUserSsn() );
			System.out.println( "MemberDao updateMember  m.getUserPhone() : " +  m.getUserPhone() );
			System.out.println( "MemberDao updateMember  m.getUserId() : " +  m.getUserId() );
 
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 티켓정보 조회 
	public Ticket Member_ticketSelect(Connection conn, String userId ) {
	      
	      // Select문 실행예정 => ResultSet객체에 담아줘야함
	      Ticket t  = null;
	      System.out.println("MemberDao  Member_ticketSelect  userId : "  + userId);
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String sql = prop.getProperty("searchMemberTicket");
	      
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, userId);
	         
	         rset = pstmt.executeQuery();
	         
	         System.out.println("MemberDao  1  sql  : " + sql);         
	         System.out.println("MemberDao  1  rset.getRow()  : " + rset.getRow() );   

	         if(rset.next()) {
	            
	            t = new Ticket ();

	            t.setTicketName(rset.getString("TICKET_NAME"));
	            t.setTicketLoopPlay(rset.getString("TICKET_LOOP_PLAY"));
	            t.setTicketOfflinePlay(rset.getString("TICKET_OFFLINE_PLAY"));
	            t.setTicketDate(rset.getString("TICKET_DATE"));
	            t.setUserName(rset.getString("USER_NAME"));
	                  
	         }
	         System.out.println("MemberDao  3 ");         

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return t;
	   }
	
	// 티켓정보해지 
	public int updateMember_ticketCancel(Connection conn, String userId) {
		
		//UPDATE => 처리된 행의 갯수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateDebugs_User_ticket_cancel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, userId);

			System.out.println( "MemberDao updateMember_ticketCancel  sql : " +  sql );
			System.out.println( "MemberDao updateMember_ticketCancel  userId : " +  userId);
 
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	public Member findUserIdMember(Connection conn, String UserName, String UserEmail) {

		//		 SELECT문 => ResultSet객체 => 조회된 행의 결과가 1행 OR 0행
		Member m = null;		
		PreparedStatement pstmt = null;		
		ResultSet rset =null;		
		String sql = prop.getProperty("findUserIDDebugs_User");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, UserName);
			pstmt.setString(2, UserEmail);
			
			System.out.println( "MemberDao findUserIdMember  sql : " +  sql );

			System.out.println( "MemberDao findUserIdMember  UserName : " +  UserName );
			System.out.println( "MemberDao findUserIdMember  UserEmail : " +  UserEmail );
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(
						rset.getString("USER_ID"), 
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("USER_SSN"),
						rset.getString("USER_EMAIL"),
						rset.getString("USER_PHONE")
						);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	
	
	public Member findUserPwdMember(Connection conn, String UserId, String UserEmail) {
		
//		 SELECT문 => ResultSet객체 => 조회된 행의 결과가 1행 OR 0행
		Member m = null;		
		PreparedStatement pstmt = null;		
		ResultSet rset =null;		
		String sql = prop.getProperty("findUserPWDDebugs_User");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, UserId);
			pstmt.setString(2, UserEmail);
			
			System.out.println( "MemberDao findUserPwdMember  sql : " +  sql );

			System.out.println( "MemberDao findUserPwdMember  UserId : " +  UserId );
			System.out.println( "MemberDao findUserPwdMember  UserEmail : " +  UserEmail );
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(
						rset.getString("USER_ID"), 
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("USER_SSN"),
						rset.getString("USER_EMAIL"),
						rset.getString("USER_PHONE")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	

	
	public int deleteMember(Connection conn, String userId, String userPwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteDebugs_User");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	public int idCheck(Connection conn, String checkId) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		System.out.println("MemberDao.java  idCheck  checkId :  " + checkId);
		
		try {
			pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, checkId);
		    
		    rset = pstmt.executeQuery();
		    //rset.last();  
		    
		    System.out.println("MemberDao.java  rset.getRow :  " + rset.getRow());
		    
		    if(rset.next()) {
		    	System.out.println("MemberDao.java  rset.Count :  " + rset.getInt(1));
			    if ( rset.getInt(1) > 0) {
		    	    count=1;
			    }
		    }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("MemberDao.java  idCheck  count :  " + count);
		  return count;
	}
	
	
	public int phoneCheck(Connection conn, String checkPhone) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("phoneCheck");
		
		System.out.println("MemberDao.java  phoneCheck  checkPhone :  " + checkPhone);
		
		try {
			pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, checkPhone);
		    
		    rset = pstmt.executeQuery();
		    //rset.last();  
		    
		    System.out.println("MemberDao.java  rset.getRow :  " + rset.getRow());
		    
		    if(rset.next()) {
		    	System.out.println("MemberDao.java  rset.Count :  " + rset.getInt(1));
			    if ( rset.getInt(1) > 0) {
		    	    count=1;
			    }
		    }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("MemberDao.java  phoneCheck  count :  " + count);
		  return count;
	}
	
	
	
public int pwdCheck(Connection conn, String checkpwd) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("pwdCheck");
		
		System.out.println("MemberDao.java  pwdCheck  checkPwd :  " + checkpwd);
		
		try {
			pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, checkpwd);
		    
		    rset = pstmt.executeQuery();
		    //rset.last();  
		    
		    System.out.println("MemberDao.java  rset.getRow :  " + rset.getRow());
		    
		    if(rset.next()) {
		    	System.out.println("MemberDao.java  rset.Count :  " + rset.getInt(1));
			    if ( rset.getInt(1) > 0) {
		    	    count=1;
			    }
		    }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("MemberDao.java  pwdCheck  count :  " + count);
		  return count;
	}
	
	public int pwdupdateMember(Connection conn,String userId,String userPwd) {
		
		//UPDATE => 처리된 행의 갯수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("pwdupdateDebugs_User");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);
			
	
			System.out.println( "MemberDao updateMember  sql : " +  sql );
	
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Ticket searchMemberTicket(Connection conn, String userId) {

		Ticket ticket = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchMemberTicket");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				ticket= new Ticket(
								rset.getString("TICKET_NAME"),
								rset.getString("TICKET_LOOP_PLAY"),
								rset.getString("TICKET_OFFLINE_PLAY"),
								rset.getString("TICKET_DATE"),
								rset.getString("USER_NAME")
							);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
				 
		
		System.out.println(ticket);
		
		return ticket;
	}
		
		
		
		
	
	

}
