package com.debugs.userPage.mainPage.model.dao;
import static com.debugs.userPage.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.playlist.model.dao.PlaylistDao;
import com.debugs.userPage.mainPage.model.vo.Artist;
import com.debugs.userPage.mainPage.model.vo.Music;
import com.debugs.userPage.mainPage.model.vo.MusicArtistAlbum;
import com.debugs.userPage.mainPage.model.vo.Playlist;

public class MainPageDao {

	private Properties prop = new Properties();
	
	public MainPageDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(MainPageDao.class.getResource("/sql/mainPage/mainPage.xml").getPath())); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<MusicArtistAlbum>  selectLatestMusic(Connection conn) {
		ArrayList<MusicArtistAlbum> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectLatestMusic");
	
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MusicArtistAlbum maa= new MusicArtistAlbum();
				maa.setMusicTitle(rset.getString("MUSIC_TITLE"));
				maa.setArtistName(rset.getString("ARTIST_NAME"));
				maa.setAlbumImg(rset.getString("ALBUM_IMG"));
				maa.setMusicNo(rset.getInt("MUSIC_NO"));
				
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


	 public ArrayList<Playlist> selectRecommendPl(Connection conn) {
	      ArrayList<Playlist> list = new ArrayList();
	      ResultSet rset = null;
	      PreparedStatement pstmt = null;
	      String sql = prop.getProperty("selectRecommendPl");
	      
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	            Playlist p = new Playlist();
	            p.setPlaylistNo(rset.getInt("PLAYLIST_NO"));
	            p.setPlaylistTh(rset.getString("PLAYLIST_TH"));
	            p.setPlaylistSubject(rset.getString("PLAYLIST_SUBJECT"));
	            
	            String th = new PlaylistDao().PlaylistTh(conn, rset.getInt("PLAYLIST_NO"), 1);
	            
	            if (th != null ) {
	               p.setPlaylistTh(th);
	            }
	            
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



	public ArrayList<MusicArtistAlbum> selectRandomMusic(Connection conn) {
		ArrayList<MusicArtistAlbum> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectRandomMusic");
		
		try {
			
			
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MusicArtistAlbum maa= new MusicArtistAlbum();
				maa.setMusicTitle(rset.getString("MUSIC_TITLE"));
				maa.setArtistName(rset.getString("ARTIST_NAME"));
				maa.setAlbumImg(rset.getString("ALBUM_IMG"));
				maa.setMusicNo(rset.getInt("MUSIC_NO"));
				
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

}
