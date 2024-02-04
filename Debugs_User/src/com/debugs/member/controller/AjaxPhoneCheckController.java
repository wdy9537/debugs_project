package com.debugs.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.debugs.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxPhoneCheckController
 */
@WebServlet("/phoneCheck.me")
public class AjaxPhoneCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxPhoneCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String checkPhone = request.getParameter("checkPhone");
		
		System.out.println("AjaxPhoneCheckController.java  checkPhone :  " + checkPhone);

		
		int count = new MemberService().phoneCheck(checkPhone);
		
		System.out.println("AjaxPhoneCheckController.java  count :  " + count);

		if(count > 0) { // 중복된 휴대폰번호. => 사용불가
			response.getWriter().print("0");
		}else {// 중복된 휴대폰번호가 존재하지 않음 ==> 사용가능.
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
