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
@WebServlet("/findId_Proc.me")
public class AjaxFind_IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxFind_IdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("views/member/find_id.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkName = request.getParameter("checkName");
		String checkEmail = request.getParameter("checkEmail");
		
		System.out.println("AjaxFind_IdCheckController.java  checkName :  " + checkName);
		System.out.println("AjaxPhoneCheckController.java  checkEmail :  " + checkEmail);
		
		Member listMember = new MemberService().findUserIdMember(checkName, checkEmail);

		if(listMember == null) {// 실 패
			response.getWriter().print("0");
		}else { // 성 공
			response.getWriter().print(listMember.getUserId());
		}
	}

}
