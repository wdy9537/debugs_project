package com.debugs.userPage.musicPlayer.model.dao;

import static com.debugs.userPage.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.userPage.mainPage.model.dao.MainPageDao;
import com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum;
import com.debugs.userPage.mainPage.model.vo.Playlist;

public class MusicPlayerDao {
	private Properties prop = new Properties();

	public MusicPlayerDao() {

		try {
			prop.loadFromXML(
					new FileInputStream(MainPageDao.class.getResource("/sql/musicPlayer/musicPlayer.xml").getPath()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Playlist> selectUserPlaylist(Connection conn, int userNo) {
		ArrayList<Playlist> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectUserPlaylist");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Playlist p = new Playlist();
				p.setPlaylistNo(rset.getInt("PLAYLIST_NO"));
				p.setPlaylistTh(rset.getString("PLAYLIST_TH"));
				p.setPlaylistSubject(rset.getString("PLAYLIST_SUBJECT"));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<MusicArtistAlbum> selectPlayList(Connection conn, String pno) {
		ArrayList<MusicArtistAlbum> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectPlayList");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pno);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				MusicArtistAlbum maa = new MusicArtistAlbum();
				
				maa.setMusicTitle(rset.getString("MUSIC_TITLE"));
				maa.setArtistName(rset.getString("ARTIST_NAME"));
				maa.setAlbumImg(rset.getString("ALBUM_IMG"));
				maa.setMusicChangeName(rset.getString("MUSIC_CHANGENAME"));
				maa.setMusicPath(rset.getString("MUSIC_PATH"));
				maa.setMusicNo(rset.getInt("MUSIC_NO"));
				maa.setMusicLike(rset.getInt("MLIKE"));
				list.add(maa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public MusicArtistAlbum selectMusicArtistAlbum(Connection conn, String mno) {
		MusicArtistAlbum maa = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectMusicArtistAlbum");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				maa = new MusicArtistAlbum();
				
				maa.setMusicTitle(rset.getString("MUSIC_TITLE"));
				maa.setArtistName(rset.getString("ARTIST_NAME"));
				maa.setAlbumImg(rset.getString("ALBUM_IMG"));
				maa.setMusicChangeName(rset.getString("MUSIC_CHANGENAME"));
				maa.setMusicPath(rset.getString("MUSIC_PATH"));
				maa.setMusicNo(rset.getInt("MUSIC_NO"));
				maa.setMusicLike(rset.getInt("MLIKE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return maa;
	}

	public String changeMusicLike(Connection conn, String mno, int userNo) {
		String result = "error";
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMusicLike");
		int result2 = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, mno);
			result = "like";
			result2 = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("에러발생");
			try {
				close(pstmt);
				pstmt = conn.prepareStatement(prop.getProperty("deleteMusicLike"));
				pstmt.setInt(1, userNo);
				pstmt.setString(2, mno);
				result= "cancel";
				result2 = pstmt.executeUpdate();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				close(pstmt);
			}
			
		} finally {
			close(pstmt);
		}
		
		return result2 == 0? "error" : result;
	}
}
