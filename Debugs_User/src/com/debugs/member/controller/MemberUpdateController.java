package com.debugs.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.member.model.service.MemberService;
import com.debugs.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 마이페이지로 이동
		request.getRequestDispatcher("views/mypage/modify2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내정보변경
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userSsn = request.getParameter("userSsn");
		String userPhone = request.getParameter("userPhone");
		String userId = request.getParameter("userId");
		
		
		System.out.println("userName : " + userName);
		System.out.println("userPwd : " + userPwd);
		System.out.println("userSsn : " + userSsn);
		System.out.println("userPhone : " + userPhone);
		System.out.println("userId : " + userId);
		
		
		Member m = new Member(userName, userPwd, userSsn, userPhone, userId);
		
		Member updateMember = new MemberService().updateMember(m);
		
		if(updateMember == null) {// 실 패
			System.out.println("MemberUpdateController updateMember  null " );
			request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}else { // 성 공
			System.out.println("MemberUpdateController updateMember not null " );
			
			//session영역안에 업데이트된 사용자정보 담아주기
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원정보를 수정했습니다.");
			session.setAttribute("loginUser", updateMember);// 같은 키값으로 존재할수 없음 => 즉 덮어쓰기 가능
			
			// 응답페이지 url 재요청
			response.sendRedirect(request.getContextPath());  // 페이지 이동은 
		}
	}
	
	
	
	
	
	
	
	

}
