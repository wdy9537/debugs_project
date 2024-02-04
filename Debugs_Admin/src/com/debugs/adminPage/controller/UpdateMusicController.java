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
import com.debugs.adminPage.model.vo.Music;
import com.debugs.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateMusicController
 */
@WebServlet("/updateMusic.ad")
public class UpdateMusicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateMusicController() {
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

//			------------------------앨범업-----------------------------------------------
			String saveAlbumPath = request.getSession().getServletContext().getRealPath("/resources/img/album_pic/");
			MultipartRequest multi1 = new MultipartRequest(request, saveAlbumPath, maxSize, "UTF-8",
					new MyFileRenamePolicy());
			int albumNo = Integer.parseInt(multi1.getParameter("albumNo"));
			String albumTitle = multi1.getParameter("albumTitle");
			String albumType = multi1.getParameter("albumType");
			String albumDate = (multi1.getParameter("albumDate")).replaceAll("-", "");

//			-------------아티스트 번호 검색후 없으면----------아티스트업하고 아래 새로 부여------------------
			String artistName = multi1.getParameter("artistName");
			int artistNo = new AdminService().getArtistNoByName(artistName);

			if (artistNo == 0) {
				int insertResult = new AdminService().insertArtist(artistName);
				if (insertResult > 0) {
					artistNo = new AdminService().getArtistNoByName(artistName);
				}
			}
			Album album = new Album();

			album.setAlbumNo(albumNo);
			album.setAlbumTitle(albumTitle);
			album.setAlbumPic(multi1.getOriginalFileName("albumPic"));
			album.setAlbumType(albumType);
			album.setAlbumDate(albumDate);
			album.setArtistNo(artistNo);

			album.setAlbumPic(multi1.getParameter("albumPic"));
			album.setAlbumChangeName(multi1.getParameter("albumChangeName"));

			if (multi1.getOriginalFileName("upAlbumPic") != null) {
				album.setAlbumPic(multi1.getOriginalFileName("upAlbumPic"));
				album.setAlbumChangeName(multi1.getFilesystemName("upAlbumPic"));
			}

//			album.setAlbumChangeName(multi1.getFilesystemName("albumPic"));
			album.setAlbumPicPath("/resources/img/album_pic/");

			int result1 = new AdminService().updateAlbum(album);

//			------------------------음원업-----------------------------------------------
			String saveMusicPath = request.getSession().getServletContext().getRealPath("/resources/songs/");
			// MultipartRequest multi1 = new MultipartRequest(request, saveMusicPath,
			// maxSize, "UTF-8", new MyFileRenamePolicy());

			int musicNo = Integer.parseInt(multi1.getParameter("musicNo"));
			int albumNo2 = Integer.parseInt(multi1.getParameter("albumNo"));
			String musicDetail = multi1.getParameter("musicDetail");
			String musicGenre = multi1.getParameter("musicGenre");
			String musicTimeM = multi1.getParameter("musicTimeM");
			String musicTimeS = multi1.getParameter("musicTimeS");
			String musicTime = musicTimeM + ":" + musicTimeS;
			String musicLyrics = multi1.getParameter("musicLyrics");
			String musicTitle = multi1.getParameter("musicTitle");

//			-------------키워드 검색후 없으면----키워드/키워드뮤직 인설트--------------------
			String keywordName = multi1.getParameter("keywordName");

			Music music = new Music();
			music.setAlbumNo(albumNo2);
			music.setMusicNo(musicNo);
			music.setMusicDetail(musicDetail);
			music.setMusicGenre(musicGenre);
			music.setMusicTime(musicTime);
			music.setMusicLyrics(musicLyrics);
			music.setMusicFile(multi1.getParameter("musicFile"));
			music.setMusicChangeName(multi1.getParameter("musicChangeName"));

			if (multi1.getOriginalFileName("upMusicFile") != null) {
				music.setMusicFile(multi1.getOriginalFileName("upMusicFile"));
				music.setMusicChangeName(multi1.getFilesystemName("upMusicFile"));
			}

			music.setMusicTitle(musicTitle);
			music.setMusicPath("/resources/songs/");

			int result2 = new AdminService().updateMusic(music, keywordName);

			if (result1 * result2 > 0) { // 성공
				request.getSession().setAttribute("alertMsg", "수정 성공");
				response.sendRedirect(request.getContextPath() + "/manageMusic.ad");

				File wrongPath = new File(saveAlbumPath + music.getMusicChangeName());
				File rightPath = new File(saveMusicPath + music.getMusicChangeName());
				wrongPath.renameTo(rightPath);
				// new File(saveMusicPath+album.getAlbumChangeName()).delete();
			} else { // 실패
				new File(saveAlbumPath + album.getAlbumChangeName()).delete();
				new File(saveAlbumPath + music.getMusicChangeName()).delete();
				request.getSession().setAttribute("alertMsg", "수정 실패");
				response.sendRedirect(request.getContextPath() + "/manageMusic.ad");
			}

		} else {
			request.getSession().setAttribute("alertMsg", "전송 방식이 잘못되었습니다.");
			response.sendRedirect(request.getContextPath() + "/manageMusic.ad");
		}
	}

}
