package com.debugs.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxIdCheckController
 */
@WebServlet("/pwdCheck.me")
public class AjaxPwdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxPwdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String checkPwd = request.getParameter("checkPwd");

		System.out.println("AjaxIdCheckController.java  checkPwd :  " + checkPwd);

		int count = new MemberService().pwdCheck(checkPwd);

		System.out.println("AjaxPhoneCheckController.java  count :  " + count);

	
		if(count > 0) { // 중복된 아이디. => 사용불가
			response.getWriter().print("0");
		}else {// 중복된 아이디가 존재하지 않음 ==> 사용가능.
			response.getWriter().print("1");
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
