package com.debugs.adminPage.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debugs.adminPage.model.dao.AdminDao;
import com.debugs.adminPage.model.service.AdminService;
import com.debugs.adminPage.model.vo.Album;
import com.debugs.adminPage.model.vo.Artist;
import com.debugs.adminPage.model.vo.Keyword;
import com.debugs.adminPage.model.vo.Music;
import com.debugs.adminPage.model.vo.MusicKeyword;
import com.google.gson.Gson;

/**
 * Servlet implementation class LoadMusicInfoController
 */
@WebServlet("/loadMusicInfo.ad")
public class LoadMusicInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadMusicInfoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int musicNo = Integer.parseInt(request.getParameter("musicNo"));

		Music music = new AdminService().selectAllMusic(musicNo);

		Album album = new AdminService().selectAllAlbum(music.getAlbumNo());

		Artist artist = new AdminService().selectArtistByNo(album.getArtistNo());

		MusicKeyword musicKeyword = new AdminService().selectAllMusicKeyword(musicNo);

		Keyword keyword = new AdminService().selectAllKeyword(musicKeyword.getKeywordNo());

		HashMap<String, Object> loadMusic = new HashMap<String, Object>();

		loadMusic.put("Album", album);
		loadMusic.put("Music", music);
		loadMusic.put("Artist", artist);
		loadMusic.put("MusicKeyword", musicKeyword);
		loadMusic.put("Keyword", keyword);

		response.setContentType("application/json; charset=UTF-8");

		new Gson().toJson(loadMusic, response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
