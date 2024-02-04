package com.debugs.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.debugs.common.JDBCTemplate.*;

import com.debugs.common.model.vo.Album;
import com.debugs.common.model.vo.Artist;
import com.debugs.common.model.vo.Music;
import com.debugs.playlist.model.vo.Playlist;
import com.debugs.search.model.dao.SearchDao;

public class SearchService {
	
	// 검색결과 화면 : 노래 (키워드)
	public ArrayList<Music> searchMusic(String keyword) {
		Connection conn = getConnection();
		ArrayList<Music> musicList = new SearchDao().searchMusic(conn, keyword);
		close(conn);
		return musicList;
	}
	
	// 검색결과 화면 : 앨범 (키워드)
	public ArrayList<Album> searchAlbum(String keyword){
		Connection conn = getConnection();
		ArrayList<Album> searchAlbum = new SearchDao().searchAlbum(conn, keyword);
		close(conn);
		return searchAlbum;
	}
	
	// 검색결과 화면 : 가수 (키워드)
	public ArrayList<Artist> searchArtist(String keyword){
		Connection conn = getConnection();
		ArrayList<Artist> searchArtist = new SearchDao().searchArtist(conn, keyword);
		close(conn);
		return searchArtist;
		
	}

}
