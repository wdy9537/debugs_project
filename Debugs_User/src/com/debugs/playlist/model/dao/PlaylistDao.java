package com.debugs.playlist.model.dao;

import static com.debugs.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.musiclist.model.dao.MusiclistDao;
import com.debugs.playlist.model.vo.Playlist;
import com.debugs.playlist.model.vo.PlaylistTrack;

public class PlaylistDao {
	
	private Properties prop = new Properties();
	
	public PlaylistDao() {
		String fileName = PlaylistDao.class.getResource("/sql/playlist/playlist-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 플레이리스트 번호를 받아와 해당 플레이리스트 정보를 플레이리스트 객체에 담아줌 
	public Playlist playlistDetailPageView(Connection conn, int playlistNo) {
		Playlist pl = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("playlistDetailPageView");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistNo);

			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				
				String th1 = PlaylistTh(conn, playlistNo, 1);
				String th2 = PlaylistTh(conn, playlistNo, 2);
				String th3 = PlaylistTh(conn, playlistNo, 3);
				String th4 = PlaylistTh(conn, playlistNo, 4);
				
				pl = new Playlist(
								rset.getInt("PLAYLIST_NO"),
								rset.getString("PLAYLIST_TH"),
								rset.getString("PLAYLIST_SUBJECT"),
								rset.getString("USER_ID"),
								th1, th2, th3, th4
								);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return pl;
	}
	
	// 플레이리스트 썸네일을 위해 트랙 번호에 해당하는 앨범 이미지 불러오기
	public String PlaylistTh(Connection conn, int plNo, int num) {
		
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("playlistTh");
		int count = 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, plNo);

			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				if ( count == num ) { 
					result = rset.getString("ALBUM_CHANGENAME");
					break; 
				}
				++count;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	
	// 플레이리스트 번호를 받아와 해당 플레이리스트 트랙 정보을 어레이리스트에 담아줌
	public ArrayList<PlaylistTrack> playlistTrackSelect(Connection conn, int playlistNo){
		ArrayList<PlaylistTrack> trackList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("playlistTrackSelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistNo);

			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				
				PlaylistTrack pt = new PlaylistTrack(
							rset.getInt("TRACK_NO"),
							rset.getString("ALBUM_CHANGENAME"),
							rset.getString("MUSIC_TITLE"),
							rset.getString("ALBUM_TITLE"),
							rset.getString("ARTIST_NAME"),
							rset.getInt("MUSIC_NO")
						);
				
				trackList.add(pt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return trackList;
	}
	
	
	public int insertAllPlaylist(Connection conn, int userNo, int playlistNo, String type) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "";
		
		if ( type.equals("all") ) {
			sql = prop.getProperty("insertAllPlaylist");
		} else if ( type.equals("shuffle") ) {
			sql = prop.getProperty("insertAllPlaylistShuffle");
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, playlistNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Playlist> selectRecommnedPlaylist(Connection conn){
		
		ArrayList<Playlist> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRecommnedPlaylist");
		
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				
				int count = new MusiclistDao().countPlaylist(conn, rset.getInt("PLAYLIST_NO"));
				
				String th1 = PlaylistTh(conn, rset.getInt("PLAYLIST_NO"), 1);
				String th2 = PlaylistTh(conn, rset.getInt("PLAYLIST_NO"), 2);
				String th3 = PlaylistTh(conn, rset.getInt("PLAYLIST_NO"), 3);
				String th4 = PlaylistTh(conn, rset.getInt("PLAYLIST_NO"), 4);
				
				Playlist pl = new Playlist(
							rset.getInt("PLAYLIST_NO"),
							rset.getString("PLAYLIST_TH"),
							rset.getString("PLAYLIST_SUBJECT"),
							rset.getString("USER_ID"),
							count,
							th1, th2, th3, th4
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
	
	public int copyPlaylist(Connection conn, int plNo, int copyPlNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		String sql = "";
		
		try {
			
			// track 넘버 가져오기
			String sql2 = prop.getProperty("playlistTrackCount");
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, plNo);
			
			rset = pstmt2.executeQuery();
			
			int track = 0;
			
			if ( rset.next() ) {
				track = rset.getInt("TRACK"); 
			}
			
			// copy 플레이리스트에 있는 음원들 가져오기
			sql = prop.getProperty("selectPlaylistTrackMusicNo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, copyPlNo);

			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				++track;
				int musicNo = rset.getInt("MUSIC_NO");
				insertCopyPlaylist(conn, track, plNo, musicNo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int playlistTrackCount(Connection conn, int playlistNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("playlistTrackCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, playlistNo);

			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				result = rset.getInt("TRACK");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertCopyPlaylist(Connection conn, int track, int plNo, int musicNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCopyPlaylist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, track);
			pstmt.setInt(2, plNo);
			pstmt.setInt(3, musicNo);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	};
	
}
















