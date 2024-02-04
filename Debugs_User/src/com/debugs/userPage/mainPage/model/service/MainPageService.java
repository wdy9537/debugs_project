package com.debugs.userPage.mainPage.model.service;
import static com.debugs.userPage.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.userPage.mainPage.model.dao.MainPageDao;
import com.debugs.userPage.mainPage.model.vo.*;
public class MainPageService {

	public ArrayList<MusicArtistAlbum> selectLatestMusic() {
		
		Connection conn = getConnection();
		ArrayList<MusicArtistAlbum>  list = new MainPageDao().selectLatestMusic(conn);
		close(conn);
		return list;
		
	}

	public ArrayList<Playlist> selectRecommendPl() {
		Connection conn = getConnection();
		ArrayList<Playlist> list = new MainPageDao().selectRecommendPl(conn);
		close(conn);
		return list;
	
	}

	public ArrayList<MusicArtistAlbum> selectRandomMusic() {

		Connection conn = getConnection();
		ArrayList<MusicArtistAlbum>  list = new MainPageDao().selectRandomMusic(conn);
		close(conn);
		return list;
		
	}


}
