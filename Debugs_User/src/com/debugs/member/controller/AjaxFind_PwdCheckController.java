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
 * Servlet implementation class AjaxPhoneCheckController
 */
@WebServlet("/findPwd_Proc.me")
public class AjaxFind_PwdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxFind_PwdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("views/member/find_pwd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkId = request.getParameter("checkId");
		String checkEmail = request.getParameter("checkEmail");
		
		System.out.println("AjaxFind_IdCheckController.java  checkId :  " + checkId);
		System.out.println("AjaxPhoneCheckController.java  checkEmail :  " + checkEmail);
		
		Member listMember = new MemberService().findUserPwdMember(checkId,checkEmail);

		if(listMember == null) {// 실 패
			response.getWriter().print("0");
		}else { // 성 공
			response.getWriter().print(listMember.getUserPwd());
		}
	}

}
