package com.debugs.cs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.cs.model.service.FaqService;
import com.debugs.cs.model.vo.Faq;



/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/detail.fa")
public class FaqDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클릭했던 공지사항의 글번호 얻어오기
		int faqNo = Integer.parseInt(request.getParameter("fno"));
		
		
			Faq f = new FaqService().selectFaq(faqNo);
			
			request.setAttribute("f", f);
			request.getRequestDispatcher("views/cs/faqDetailPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
