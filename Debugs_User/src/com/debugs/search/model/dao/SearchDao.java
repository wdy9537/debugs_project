package com.debugs.search.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.debugs.common.JDBCTemplate.*;

import com.debugs.common.model.vo.Album;
import com.debugs.common.model.vo.Artist;
import com.debugs.common.model.vo.Music;

public class SearchDao {
	
	private Properties prop = new Properties();
	
	public SearchDao() {
		String fileName = SearchDao.class.getResource("/sql/search/search-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Music> searchMusic(Connection conn, String keyword){
		
		ArrayList<Music> musicList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String sql = prop.getProperty("searchMusic");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword.toUpperCase()+"%");
			pstmt.setString(2, "%"+keyword.toUpperCase()+"%");
			rset = pstmt.executeQuery();
			
			while ( rset.next() && count < 10 ) {
				Music m = new Music();
				
				m.setAlbumChangename(rset.getString("ALBUM_CHANGENAME"));
				m.setMusicTitle(rset.getString("MUSIC_TITLE"));
				m.setAlbumTitle(rset.getString("ALBUM_TITLE"));
				m.setArtistName(rset.getString("ARTIST_NAME"));
				m.setMusicNo(rset.getInt("MUSIC_NO"));
				
				musicList.add(m);
				count++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return musicList;
	}
	
	
	
	public ArrayList<Album> searchAlbum(Connection conn, String keyword){
		
		ArrayList<Album> searchAlbum = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchAlbum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword.toUpperCase()+"%");
			pstmt.setString(2, "%"+keyword.toUpperCase()+"%");
			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				Album al = new Album();
				al.setAlbumNo(rset.getInt("ALBUM_NO"));
				al.setAlbumTitle(rset.getString("ALBUM_TITLE"));
				al.setArtistName(rset.getString("ARTIST_NAME"));
				al.setAlbumDate(rset.getDate("ALBUM_DATE"));
				al.setAlbumGenre(rset.getString("MUSIC_GENRE"));
				al.setAlbumPic(rset.getString("ALBUM_CHANGENAME"));
				
				int count = albumCount(conn, al.getAlbumNo());
				al.setCount(count);
				
				searchAlbum.add(al);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return searchAlbum;
	}
	
	public int albumCount(Connection conn, int albumNo) {
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("albumCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, albumNo);
			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				count = rset.getInt("C");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	};
	
	public ArrayList<Artist> searchArtist(Connection conn, String keyword){
		
		ArrayList<Artist> searchArtist = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchArtist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword.toUpperCase()+"%");
			rset = pstmt.executeQuery();
			
			
			while ( rset.next() ) {
				
				Artist a = new Artist();
				String artistName = rset.getString("ARTIST_NAME");
				
				String albumPic = recentAlbumPic(conn, artistName);

				a.setAlbumChangename(albumPic);
				a.setArtistName(artistName);
				a.setArtistNo(rset.getInt("ARTIST_NO"));
				
				searchArtist.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return searchArtist;
		
	}
	
	public String recentAlbumPic (Connection conn, String artist){
		
		String result = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("recentAlbumPic");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, artist);
			pstmt.setString(2, artist);
			rset = pstmt.executeQuery();
			
			if ( rset.next() ) {
				result = rset.getString("ALBUM_CHANGENAME");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
		
	}
	
	
	
}


