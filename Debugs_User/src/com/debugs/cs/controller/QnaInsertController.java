package com.debugs.cs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.debugs.common.MyFileRenamePolicy;
import com.debugs.cs.model.service.QnaService;
import com.debugs.cs.model.vo.Qna;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class QnaInsertController
 */
@WebServlet("/insertqna.qn")
public class QnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QnaInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/img/");
			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8" , new MyFileRenamePolicy());

			String qnaContent = multi.getParameter("qnaContent");
			String qnaCategory = multi.getParameter("qnaCategory");

			
			Qna q = new Qna();
			q.setQnaContent(qnaContent);
			q.setFilePath("/resources/img/");
			q.setQnaImage(multi.getOriginalFileName("upfile"));
			q.setQnaImageChange(multi.getFilesystemName("upfile"));
			q.setQnaCategory(qnaCategory);

			// 3) 요청처리(서비스 매서드 호출 및 결과 받기)
			int result = new QnaService().insertQna(q);

			// 4) 처리결과를 가지고 사용자가 보게될 응답 뷰 지정
			if (result > 0) { // 성공 -> 메인페이지로 url재요청보내기
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "문의등록에 성공했습니다.");
				response.sendRedirect(request.getContextPath() + "/goQna.me");
			} else { // 에러페이지로 포워딩
				request.setAttribute("errorMsg", "문의등록에 실패했습니다.");
				response.sendRedirect(request.getContextPath() + "/goQna.me");
			}
		}else { // 에러페이지로 포워딩
			request.setAttribute("errorMsg", "전송방식이 잘못됐습니다.");
			response.sendRedirect(request.getContextPath() + "/goQna.me");
		}

	}

}
