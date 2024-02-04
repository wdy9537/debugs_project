package com.debugs.album.model.dao;

import static com.debugs.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.debugs.album.model.vo.Album;
import com.debugs.album.model.vo.Reply;
import com.debugs.member.model.vo.Artist;
import com.debugs.song.model.vo.Music;

public class AlbumDao {
	private Properties prop = new Properties();

	public AlbumDao() {
		String fileName = AlbumDao.class.getResource("/sql/album/album-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertComment(Connection conn, Reply r, int albumNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertComment");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, albumNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Music> selectMusicList(Connection conn, int albumNo) {
		ArrayList<Music> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectMusicList");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, albumNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Music m = new Music(rset.getInt("MUSIC_NO"), rset.getInt("ALBUM_NO"), rset.getString("MUSIC_DETAIL"),
						rset.getString("MUSIC_GENRE"), rset.getString("MUSIC_TIME"), rset.getString("MUSIC_LYRICS"),
						rset.getString("MUSIC_FILE"), rset.getString("MUSIC_TITLE"), rset.getString("MUSIC_CHANGENAME"),
						rset.getString("MUSIC_PATH"));
				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public ArrayList<Reply> selectReplyList(Connection conn, int albumNo) {

		ArrayList<Reply> list2 = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectReplyList");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, albumNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Reply r = new Reply(rset.getString("USER_NAME"), rset.getInt("REPLY_NO"),
						rset.getString("REPLY_CONTENT"), rset.getInt("ALBUM_NO"), rset.getInt("USER_NO"));
				list2.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list2;

	}

	public Album selectAlbumList(Connection conn, int albumNo) {

		Album a = null;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectAlbumList");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, albumNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				a = new Album(rset.getInt("ALBUM_NO"), rset.getString("ALBUM_TITLE"), rset.getString("ALBUM_PIC"),
						rset.getString("ALBUM_TYPE"), rset.getDate("ALBUM_DATE"), rset.getInt("ARTIST_NO"),
						rset.getString("ALBUM_CHANGENAME"), rset.getString("ALBUM_PIC_PATH")

				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return a;

	}

	public Artist selectArtistList(Connection conn, int albumNo) {

		Artist ar = null;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectArtistList");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, albumNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				ar = new Artist(rset.getInt("ARTIST_NO"), rset.getString("ARTIST_NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return ar;

	}

	public ArrayList<Music> selectMusicCount(Connection conn, int albumNo) {

		ArrayList<Music> mlist = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectMusicCount");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, albumNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				mlist.add(new Music(rset.getInt("MUSIC_NO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return mlist;

	}
	
	public ArrayList<Reply> selectCommentList(Connection conn, int albumNo){
		ArrayList<Reply> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCommentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumNo);
			
			rset = pstmt.executeQuery();
			
			while ( rset.next() ) {
				
				Reply r = new Reply();
				
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setUserName(rset.getString("USER_NAME"));
				
				list.add(r);
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
