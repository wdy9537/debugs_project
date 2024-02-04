package com.debugs.adminPage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Music;
import com.debugs.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertMusicController
 */
@WebServlet("/insertMusic.ad")
public class InsertMusicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertMusicController() {
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
			String savePath = request.getSession().getServletContext().getRealPath("/resources/songs/");
//			String savePath = "Z:/songs/";
			// 일단은 현재 아래의 리소스에 넣어놓고 마운트 해보자

			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());

			String albumTitle = multi.getParameter("albumTitle");
			String keywordName = multi.getParameter("keywordName"); // 키워드테이블
			String musicTitle = multi.getParameter("musicTitle");
			String musicTimeM = multi.getParameter("musicTimeM");
			String musicTimeS = multi.getParameter("musicTimeS");
			String musicGenre = multi.getParameter("musicGenre");
			String musicDetail = multi.getParameter("musicDetail"); // null
			String musicLyrics = multi.getParameter("musicLyrics"); // null
			String musicTime = musicTimeM + ":" + musicTimeS;

			int albumNo = new AdminService().selectAlbumNo(albumTitle);

			if (albumNo == 0) {
				request.getSession().setAttribute("alertMsg", "앨범을 먼저 추가해주세요.");
				response.sendRedirect(request.getContextPath() + "/addAlbum.ad");
			} else {

				Music m = new Music();
				m.setAlbumNo(albumNo);
				m.setMusicTitle(musicTitle);
				m.setMusicTime(musicTime);
				m.setMusicGenre(musicGenre);
				m.setMusicDetail(musicDetail);
				m.setMusicLyrics(musicLyrics);
				m.setMusicFile(multi.getOriginalFileName("musicFile")); // 원본명
				m.setMusicChangeName(multi.getFilesystemName("musicFile")); // 수정명
				m.setMusicPath("/resources/songs/"); // 경로

				int result = new AdminService().insertMusicKeyword(m, keywordName);

				if (result > 0) {
					request.getSession().setAttribute("alertMsg", "음원 추가 성공");
					response.sendRedirect(request.getContextPath() + "/addMusic.ad");
				} else {
					new File(savePath + m.getMusicChangeName()).delete();
					request.getSession().setAttribute("alertMsg", "음원 추가 실패");
					response.sendRedirect(request.getContextPath() + "/addMusic.ad");
				}
			}
		} else {
			request.getSession().setAttribute("alertMsg", "전송 방식이 잘못되었습니다.");
			response.sendRedirect(request.getContextPath() + "/addMusic.ad");
		}

	}

}
