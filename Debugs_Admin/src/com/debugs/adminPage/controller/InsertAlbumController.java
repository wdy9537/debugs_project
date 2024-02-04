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
import com.debugs.adminPage.model.vo.Album;
import com.debugs.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertAlbumController
 */
@WebServlet("/insertAlbum.ad")
public class InsertAlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertAlbumController() {
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
			String savePath = request.getSession().getServletContext().getRealPath("/resources/img/album_pic");

			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());

			String albumTitle = multi.getParameter("albumTitle");
			String albumType = multi.getParameter("albumType");
			String albumDate = (multi.getParameter("albumDate")).replaceAll("-", "");
			String artistName = multi.getParameter("artistName");
			int artistNo = new AdminService().getArtistNoByName(artistName);

			if (artistNo == 0) {
				int insertResult = new AdminService().insertArtist(artistName);
				if (insertResult > 0) {
					artistNo = new AdminService().getArtistNoByName(artistName);
				}
			}

			Album noPicAlbum = new Album();
			noPicAlbum.setAlbumTitle(albumTitle);
			noPicAlbum.setAlbumType(albumType);
			noPicAlbum.setAlbumDate(albumDate);
			noPicAlbum.setArtistNo(artistNo);

			Album PicAlbum = null;
			int result = 0;

			if (multi.getOriginalFileName("albumPic") != null) {
				PicAlbum = new Album();
				PicAlbum.setAlbumTitle(albumTitle);
				PicAlbum.setAlbumType(albumType);
				PicAlbum.setAlbumDate(albumDate);
				PicAlbum.setArtistNo(artistNo);
				PicAlbum.setAlbumPic(multi.getOriginalFileName("albumPic"));// 원본명
				PicAlbum.setAlbumChangeName(multi.getFilesystemName("albumPic")); // 수정명
				PicAlbum.setAlbumPicPath("/resources/img/");
				result = new AdminService().insertPicAlbum(PicAlbum);
			} else {
				result = new AdminService().insertAlbum(noPicAlbum);
			}

			if (result > 0) { // 성공
				request.getSession().setAttribute("alertMsg", "앨범 추가 성공");
				response.sendRedirect(request.getContextPath() + "/addAlbum.ad");
			} else { // 실패
				if (PicAlbum != null) {
					new File(savePath + PicAlbum.getAlbumChangeName()).delete();
				}
				request.getSession().setAttribute("alertMsg", "앨범 추가 실패");
				response.sendRedirect(request.getContextPath() + "/addAlbum.ad");
			}

		} else {
			request.getSession().setAttribute("alertMsg", "전송 방식이 잘못되었습니다.");
			response.sendRedirect(request.getContextPath() + "/addAlbum.ad");
		}

	}

}
