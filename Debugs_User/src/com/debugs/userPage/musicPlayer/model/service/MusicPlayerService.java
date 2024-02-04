package com.debugs.userPage.musicPlayer.model.service;

import static com.debugs.userPage.common.JDBCTemplate.close;
import static com.debugs.userPage.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum;
import com.debugs.userPage.mainPage.model.vo.Playlist;
import com.debugs.userPage.musicPlayer.model.dao.MusicPlayerDao;

public class MusicPlayerService {
	public ArrayList<Playlist> selectUserPlaylist(int userNo) {

		Connection conn = getConnection();
		ArrayList<Playlist> list = new MusicPlayerDao().selectUserPlaylist(conn, userNo);
		close(conn);
		return list;
	}

	public ArrayList<MusicArtistAlbum> selectPlayList(String pno) {
		Connection conn = getConnection();
		ArrayList<MusicArtistAlbum> list = new MusicPlayerDao().selectPlayList(conn, pno);
		close(conn);
		return list;
	}

	public MusicArtistAlbum selectMusicArtistAlbum(String mno) {
		Connection conn = getConnection();
		MusicArtistAlbum mma = new MusicPlayerDao().selectMusicArtistAlbum(conn, mno);
		close(conn);
		return mma;
	}

	public String changeMusicLike(String mno, int userNo) {
		Connection conn = getConnection();
		String result = new MusicPlayerDao().changeMusicLike(conn, mno, userNo);
		close(conn);
		return result;
	}
	
}
