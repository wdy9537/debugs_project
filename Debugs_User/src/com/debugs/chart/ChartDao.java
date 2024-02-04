package com.debugs.chart;

import static com.debugs.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.common.model.vo.Music;

public class ChartDao {
	
	private Properties prop = new Properties();
	
	public ChartDao() {
		String fileName = ChartDao.class.getResource("/sql/chart/chart-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Music> searchMusic(Connection conn, String chart){
		
		ArrayList<Music> musicList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "";
			
		switch ( chart ) {
		
		case "TOP 100 차트" : sql = prop.getProperty("top100chart"); break;
		case "최신노래" : sql = prop.getProperty("recentMusic"); break;
		case "댄스/팝" : sql = prop.getProperty("dacnepopMusic"); break;
		
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				
				Music m = new Music();
				
				m.setRank(rset.getInt("ROWNUM"));
				m.setAlbumChangename(rset.getString("ALBUM_CHANGENAME"));
				m.setMusicTitle(rset.getString("MUSIC_TITLE"));
				m.setAlbumTitle(rset.getString("ALBUM_TITLE"));
				m.setArtistName(rset.getString("ARTIST_NAME"));
				m.setAlbumNo(rset.getInt("ALBUM_NO"));
				m.setMusicNo(rset.getInt("MUSIC_NO"));
				
				musicList.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return musicList;
	}
	
	
	
	
	public ArrayList<Music> searchKeywordMusic(Connection conn, String keyword){
		
		ArrayList<Music> musicList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("keywordSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				
				Music m = new Music();
				
				m.setRank(rset.getInt("ROWNUM"));
				m.setAlbumChangename(rset.getString("ALBUM_CHANGENAME"));
				m.setMusicTitle(rset.getString("MUSIC_TITLE"));
				m.setAlbumTitle(rset.getString("ALBUM_TITLE"));
				m.setArtistName(rset.getString("ARTIST_NAME"));
				m.setAlbumNo(rset.getInt("ALBUM_NO"));
				m.setMusicNo(rset.getInt("MUSIC_NO"));
				
				musicList.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return musicList;
	}
	
	
	
}
