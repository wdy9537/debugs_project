package com.debugs.musiclist.model.dao;

import static com.debugs.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.musiclist.model.vo.Like;
import com.debugs.playlist.model.dao.PlaylistDao;
import com.debugs.playlist.model.vo.Playlist;

public class MusiclistDao {
	private Properties prop = new Properties();
		
	public MusiclistDao() {
		String fileName = MusiclistDao.class.getResource("/sql/musiclist/musiclist-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public int listenPlaylist(Connection conn, int userNo, int musicNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("listenPlaylist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, musicNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Playlist> showPlayList(Connection conn, int userNo) {
		
		ArrayList<Playlist> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("showPlayList");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);

			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				
				int count = countPlaylist(conn, rset.getInt("PLAYLIST_NO"));
				
				String th1 = new PlaylistDao().PlaylistTh(conn, rset.getInt("PLAYLIST_NO"), 1);
				
				Playlist pl = new Playlist(
							rset.getInt("PLAYLIST_NO"),
							rset.getInt("USER_NO"),
							rset.getString("PLAYLIST_TH"),
							rset.getString("PLAYLIST_SUBJECT"),
							count, th1 
						);
				
				list.add(pl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return list;
	}
	
	// 플레이리스트의 트랙수를 세는 쿼리문
	public int countPlaylist(Connection conn, int playlistNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countPlaylist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistNo);

			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				result = rset.getInt("C");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int addPlaylist(Connection conn, int userNo, String plSubject) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("addPlaylist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, plSubject);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertMyPlaylist(Connection conn, int musicNo, int plNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMyPlaylist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, plNo);
			pstmt.setInt(2, plNo);
			pstmt.setInt(3, musicNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deletePlaylist(Connection conn, int musicNo, int plNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deletePlaylist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, plNo);
			pstmt.setInt(2, musicNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
		
	}
	
	public int musicLike(Connection conn, int musicNo, int userNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMusicLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, musicNo);

			rset = pstmt.executeQuery();
			
			if ( rset.next() ) { // DB에 들어있는 경우 
				result = 1;
				sql = prop.getProperty("deleteMusicLike");
			} else {
				sql = prop.getProperty("insertMusicLike");
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, musicNo);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
		
		
	}
	
	public ArrayList<Like> checkMusicLikeList(Connection conn, int userNo){
		
		ArrayList<Like> like = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkMusicLikeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				
				Like l = new Like();
				l.setMusicNo(rset.getInt("MUSIC_NO"));
				like.add(l);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return like;
	};
	
	
	
	
	
	
	
	
}
