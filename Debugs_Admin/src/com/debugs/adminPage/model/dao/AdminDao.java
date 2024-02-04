package com.debugs.adminPage.model.dao;

import static com.debugs.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.debugs.adminPage.model.vo.Admin;
import com.debugs.adminPage.model.vo.Album;
import com.debugs.adminPage.model.vo.Artist;
import com.debugs.adminPage.model.vo.Blacklist;
import com.debugs.adminPage.model.vo.Category;
import com.debugs.adminPage.model.vo.DebugUser;
import com.debugs.adminPage.model.vo.Faq;
import com.debugs.adminPage.model.vo.Keyword;
import com.debugs.adminPage.model.vo.Music;
import com.debugs.adminPage.model.vo.MusicKeyword;
import com.debugs.adminPage.model.vo.MusicList;
import com.debugs.adminPage.model.vo.Notice;
import com.debugs.adminPage.model.vo.Qna;
import com.debugs.adminPage.model.vo.Reply;
import com.debugs.adminPage.model.vo.ReplyList;
import com.debugs.adminPage.model.vo.Ticket;
import com.debugs.common.model.vo.PageInfo;

public class AdminDao {

	private Properties prop = new Properties();

	public AdminDao() {
		try {
			prop.loadFromXML(
					new FileInputStream(AdminDao.class.getResource("/sql/adminPage/admin-mapper.xml").getPath()));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//--------------------------동연 시작--------------------------------
	public Admin loginAdmin(Connection conn, String adminId, String adminPwd) {

		// Select문 실행예정 => ResultSet객체에 담아줘야 한다.
		Admin a = null;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("loginAdmin");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				a = new Admin(rset.getInt("ADMIN_NO"), rset.getInt("ADMIN_GRADE"), rset.getString("ADMIN_NAME"),
						rset.getString("ADMIN_ID"), rset.getString("ADMIN_PWD"), rset.getString("ADMIN_PHONE"),
						rset.getString("ADMIN_MEMO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return a;
	}

	public int updateMemo(Connection conn, int adminNo, String adminMemo) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMemo");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, adminMemo);
			pstmt.setInt(2, adminNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectNoAnswerQnaCount(Connection conn) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoAnswerQnaCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<Qna> selectNoAnswerQnaList(Connection conn, PageInfo pi) {

		ArrayList<Qna> list = new ArrayList<Qna>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoAnswerQnaList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Qna(rset.getInt("QNA_NO"), rset.getString("USER_ID"), rset.getString("QNA_CONTENT"),
						rset.getString("CATEGORY_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int selectAllQnaCount(Connection conn) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllQnaCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<Qna> selectAllQnaList(Connection conn, PageInfo pi) {

		ArrayList<Qna> list = new ArrayList<Qna>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllQnaList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Qna(rset.getInt("QNA_NO"), rset.getString("USER_ID"), rset.getString("QNA_CONTENT"),
						rset.getString("CATEGORY_NAME"), rset.getString("QNA_RESULT")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int selectAllFaqCount(Connection conn) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllFaqCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<Faq> selectAllFaqList(Connection conn, PageInfo pi) {

		ArrayList<Faq> list = new ArrayList<Faq>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllFaqList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Faq(rset.getInt("FAQ_NO"), rset.getString("FAQ_TITLE"),
						rset.getString("SUBSTR(FAQ_CONTENT,1,25)"), rset.getString("CATEGORY_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertFaq(Connection conn, String faqCategory, String faqTitle, String faqContent) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFaq");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, faqTitle);
			pstmt.setString(2, faqContent);
			pstmt.setInt(3, Integer.parseInt(faqCategory));

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteFaq(Connection conn, String faqNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteFaq");
		sql = sql.replace("%", faqNo);

		try {
			pstmt = conn.prepareStatement(sql);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getArtistNoByName(Connection conn, String artistName) {

		int artistNo = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("getArtistNoByName");
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, artistName);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				artistNo = rset.getInt(1);
			} // 중복은 나중에 생각해보자
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return artistNo;
	}

	public int insertAlbum(Connection conn, Album noPicAlbum) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAlbum");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, noPicAlbum.getAlbumTitle());
			pstmt.setString(2, noPicAlbum.getAlbumType());
			pstmt.setString(3, noPicAlbum.getAlbumDate());
			pstmt.setInt(4, noPicAlbum.getArtistNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertPicAlbum(Connection conn, Album picAlbum) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertPicAlbum");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, picAlbum.getAlbumTitle());
			pstmt.setString(2, picAlbum.getAlbumPic());
			pstmt.setString(3, picAlbum.getAlbumType());
			pstmt.setString(4, picAlbum.getAlbumDate());
			pstmt.setInt(5, picAlbum.getArtistNo());
			pstmt.setString(6, picAlbum.getAlbumChangeName());
			pstmt.setString(7, picAlbum.getAlbumPicPath());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertArtist(Connection conn, String artistName) {

		int insertResult = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertArtist");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, artistName);

			insertResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return insertResult;
	}

	public ArrayList<Artist> selectAllArtist(Connection conn) {

		ArrayList<Artist> list = new ArrayList<Artist>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllArtist");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Artist a = new Artist(rset.getInt("ARTIST_NO"), rset.getString("ARTIST_NAME"));
				list.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int selectAlbumNo(Connection conn, String albumTitle) {

		int albumNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAlbumNo");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, albumTitle);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				albumNo = rset.getInt(1);
			} else {
				albumNo = 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return albumNo;
	}

	public int insertMusic(Connection conn, Music m) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMusic");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, m.getAlbumNo());
			pstmt.setString(2, m.getMusicDetail());
			pstmt.setString(3, m.getMusicGenre());
			pstmt.setString(4, m.getMusicTime());
			pstmt.setString(5, m.getMusicLyrics());
			pstmt.setString(6, m.getMusicFile());
			pstmt.setString(7, m.getMusicTitle());
			pstmt.setString(8, m.getMusicChangeName());
			pstmt.setString(9, m.getMusicPath());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertKeyword(Connection conn, String keywordName) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertKeyword");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keywordName);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectKeywordNo(Connection conn, String keywordName) {

		int keywordNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectKeywordNo");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keywordName);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				keywordNo = rset.getInt(1);
			} else {
				int result = insertKeyword(conn, keywordName);
				if (result > 0) {
					keywordNo = selectKeywordNo(conn, keywordName);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return keywordNo;
	}

	public int insertMusicKeywordTable(Connection conn, int keywordNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMusicKeywordTable");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, keywordNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectAllMusicCount(Connection conn) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllMusicCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<MusicList> selectAllMusicList(Connection conn, PageInfo pi) {

		ArrayList<MusicList> list = new ArrayList<MusicList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllMusicList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new MusicList(rset.getInt("MUSIC_NO"), rset.getString("ALBUM_TITLE"),
						rset.getString("MUSIC_TITLE"), rset.getString("ARTIST_NAME"), rset.getString("MUSIC_GENRE"),
						rset.getString("KEYWORD_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public Music selectAllMusic(Connection conn, int musicNo) {

		Music music = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllMusic");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, musicNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				music = new Music(rset.getInt("MUSIC_NO"), rset.getInt("ALBUM_NO"), rset.getString("MUSIC_DETAIL"),
						rset.getString("MUSIC_GENRE"), rset.getString("MUSIC_TIME"), rset.getString("MUSIC_LYRICS"),
						rset.getString("MUSIC_FILE"), rset.getString("MUSIC_TITLE"), rset.getString("MUSIC_CHANGENAME"),
						rset.getString("MUSIC_PATH"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return music;
	}

	public Album selectAllAlbum(Connection conn, int albumNo) {

		Album album = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllAlbum");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				album = new Album(rset.getInt("ALBUM_NO"), rset.getString("ALBUM_TITLE"), rset.getString("ALBUM_PIC"),
						rset.getString("ALBUM_TYPE"), rset.getString("ALBUM_DATE"), rset.getInt("ARTIST_NO"),
						rset.getString("ALBUM_CHANGENAME"), rset.getString("ALBUM_PIC_PATH"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return album;
	}

	public Artist selectArtistByNo(Connection conn, int artistNo) {

		Artist artist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectArtistByNo");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, artistNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				artist = new Artist(rset.getInt("ARTIST_NO"), rset.getString("ARTIST_NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return artist;
	}

	public MusicKeyword selectAllMusicKeyword(Connection conn, int musicNo) {

		MusicKeyword musicKeyword = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllMusicKeyword");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, musicNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				musicKeyword = new MusicKeyword(rset.getInt("MUSIC_NO"), rset.getInt("KEYWORD_NO"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return musicKeyword;
	}

	public Keyword selectAllKeyword(Connection conn, int keywordNo) {

		Keyword keyword = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllKeyword");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, keywordNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				keyword = new Keyword(rset.getInt("KEYWORD_NO"), rset.getString("KEYWORD_NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return keyword;
	}

	public int updateAlbum(Connection conn, Album album) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAlbum");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, album.getAlbumTitle());
			pstmt.setString(2, album.getAlbumPic());
			pstmt.setString(3, album.getAlbumType());
			pstmt.setString(4, album.getAlbumDate());
			pstmt.setInt(5, album.getArtistNo());
			pstmt.setString(6, album.getAlbumChangeName());
			pstmt.setString(7, album.getAlbumPicPath());
			pstmt.setInt(8, album.getAlbumNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateMusic(Connection conn, Music music) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMusic");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, music.getMusicDetail());
			pstmt.setString(2, music.getMusicGenre());
			pstmt.setString(3, music.getMusicTime());
			pstmt.setString(4, music.getMusicLyrics());
			pstmt.setString(5, music.getMusicFile());
			pstmt.setString(6, music.getMusicTitle());
			pstmt.setString(7, music.getMusicChangeName());
			pstmt.setString(8, music.getMusicPath());
			pstmt.setInt(9, music.getAlbumNo());
			pstmt.setInt(10, music.getMusicNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public void insertNewMusicKeywordTable(Connection conn, int keywordNo, int musicNo) {

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNewMusicKeywordTable");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, musicNo);
			pstmt.setInt(2, keywordNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

	}

	public int selectAllReplyCount(Connection conn) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllReplyCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<ReplyList> selectAllReplyList(Connection conn, PageInfo pi) {
		ArrayList<ReplyList> list = new ArrayList<ReplyList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllReplyList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new ReplyList(rset.getInt("REPLY_NO"), rset.getString("ALBUM_TITLE"),
						rset.getString("ARTIST_NAME"), rset.getString("SUBSTR(REPLY_CONTENT,1,33)")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int deleteReply(Connection conn, String replyNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteReply");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, replyNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMusicKeyword(Connection conn, String musicNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteMusicKeyword");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, musicNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMusic(Connection conn, String musicNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteMusic");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, musicNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Qna selectQnaInfo(Connection conn, int qnaNo) {

		Qna qna = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnaInfo");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				qna = new Qna(rset.getInt("QNA_NO"), rset.getString("QNA_CONTENT"), rset.getString("CATEGORY_NAME")

				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return qna;
	}

	public int updateQna(Connection conn, int qnaNo, String qnaAnswer) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateQna");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, qnaAnswer);
			pstmt.setInt(2, qnaNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteQna(Connection conn, String qnaNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteQna");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, qnaNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int searchMusicCount(Connection conn, String searchMusicName) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchMusicCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchMusicName);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<MusicList> searchMusicList(Connection conn, PageInfo pi, String searchMusicName) {

		ArrayList<MusicList> list = new ArrayList<MusicList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchMusicList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setString(1, searchMusicName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new MusicList(rset.getInt("MUSIC_NO"), rset.getString("ALBUM_TITLE"),
						rset.getString("MUSIC_TITLE"), rset.getString("ARTIST_NAME"), rset.getString("MUSIC_GENRE"),
						rset.getString("KEYWORD_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Album> selectAlbum(Connection conn) {

		ArrayList<Album> list = new ArrayList<Album>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAlbum");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Album a = new Album(rset.getInt("ALBUM_NO"), rset.getString("ALBUM_TITLE"));
				list.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public String selectQnaImg(Connection conn, int qnaNo) {

		String qnaImg = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectQnaImg");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				qnaImg = rset.getString("QNA_IMAGE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return qnaImg;
	}
//--------------------------동연 끝--------------------------------
//--------------------------동현 시작------------------------------

	public int insertAdmin(Connection conn, Admin a) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertAdmin");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, a.getAdminName());
			pstmt.setString(2, a.getAdminId());
			pstmt.setString(3, a.getAdminPwd());
			pstmt.setString(4, a.getAdminPhone());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public int selectListCount(Connection conn) {

		// SELECT문 => ResultSet객체 (한 행)
		int listCount = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;

	}

	public ArrayList<Admin> selectList(Connection conn, PageInfo pi) {

		ArrayList<Admin> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Admin(rset.getInt("ADMIN_NO"), rset.getString("ADMIN_NAME"), rset.getString("ADMIN_ID"),
						rset.getString("ADMIN_PWD"), rset.getString("ADMIN_PHONE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public int deleteAdmin(Connection conn, String adminNos) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteAdmin");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, adminNos);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertNotice(Connection conn, Notice n) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertNotice");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeCategory());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectNoticeListCount(Connection conn) {

		// SELECT문 => ResultSet객체 (한 행)
		int listCount = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectNoticeListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;

	}

	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {

		ArrayList<Notice> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectNoticeList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Notice(
						rset.getInt("NOTICE_NO"), 
						rset.getString("NOTICE_TITLE"),
						rset.getString("NOTICE_CONTENT"),
						rset.getString("CATEGORY_NAME")
						));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public int deleteNotice(Connection conn, String noticeNos) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteNotice");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, noticeNos);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Ticket> selectTicketList(Connection conn) {

		ArrayList<Ticket> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectTicketList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Ticket(
						rset.getInt("TICKET_NO"), 
						rset.getString("TICKET_NAME"),
						rset.getInt("TICKET_PRICE"),
						rset.getString("TICKET_PER")
						));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public int insertTicket(Connection conn, Ticket t) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertTicket");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, t.getTicketPer());
			pstmt.setString(2, t.getTicketName());
			pstmt.setInt(3, t.getTicketPrice());
			pstmt.setString(4, t.getTicketLoopPlay());
			pstmt.setString(5, t.getTicketOfflinePlay());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteTicket(Connection conn, String ticketNos) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteTicket");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ticketNos);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public int selectDebugUserListCount(Connection conn) {

		// SELECT문 => ResultSet객체 (한 행)
		int listCount = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectDebugUserListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;

	}
	
	public int selectSearchDebugUserListCount(Connection conn, String userName) {
		
		int listCount = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectSearchDebugUserListCount");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
		
	}

	public ArrayList<DebugUser> selectDebugUserList(Connection conn, PageInfo pi) {

		ArrayList<DebugUser> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectDebugUserList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new DebugUser(rset.getInt("USER_NO"), 
						rset.getString("USER_NAME"), 
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"), 
						rset.getString("USER_PHONE"), 
						rset.getString("USER_EMAIL"),
						rset.getString("USER_SSN"), 
						rset.getString("TICKET_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public int deleteUser(Connection conn, String userNos) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteUser");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userNos);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public DebugUser selectUser(Connection conn, String userNos) {

		DebugUser d = null;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectUser");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userNos);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				d = new DebugUser(rset.getString("USER_NAME"), rset.getString("USER_ID"), rset.getString("USER_PWD"),
						rset.getString("USER_PHONE"), rset.getString("USER_SSN"), rset.getString("USER_EMAIL"),
						rset.getString("TICKET_NAME"), rset.getString("TICKET_DATE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return d;

	}

	public int updateUser(Connection conn, DebugUser d) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateUser");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, d.getUserName());
			pstmt.setString(2, d.getUserId());
			pstmt.setString(3, d.getphone());
			pstmt.setString(4, d.getemail());
			pstmt.setString(5, d.getssn());
			pstmt.setInt(6, d.getTicketNo());
			pstmt.setInt(7, d.getUserNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectBlacklistListCount(Connection conn) {

		// SELECT문 => ResultSet객체 (한 행)
		int listCount = 0;

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectBlacklistListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;

	}

	public ArrayList<Blacklist> selectBlacklistList(Connection conn, PageInfo pi) {

		ArrayList<Blacklist> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectBlacklistList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Blacklist(rset.getInt("BLACKLIST_NO"), rset.getString("BLACKLIST_NAME"),
						rset.getString("BLACKLIST_USER_NO"), rset.getString("BLACKLIST_REASON"),
						rset.getString("BLACKLIST_STATUS"), rset.getString("BLACKLIST_DATE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public int insertBlacklist(Connection conn, Blacklist bl) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertBlacklist");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bl.getBlacklistReason());
			pstmt.setString(2, bl.getBlacklistDate());
			pstmt.setString(3, bl.getBlacklistName());
			pstmt.setString(4, bl.getBlacklistUserNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateUserStatus(Connection conn, String blacklistName) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateUserStatus");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, blacklistName);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public int deleteBlacklist(Connection conn, String blacklistNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteBlacklist");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, blacklistNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public int updateBlacklist(Connection conn, String blacklistNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateBlacklist");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, blacklistNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	public ArrayList<Category> selectCategoryList(Connection conn) {

		ArrayList<Category> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectCategoryList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Category(rset.getInt("CATEGORY_NO"), rset.getString("CATEGORY_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public ArrayList<Ticket> selectTicket(Connection conn) {

		ArrayList<Ticket> tlist = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("selectTicket");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				tlist.add(new Ticket(rset.getInt("TICKET_NO"), rset.getString("TICKET_NAME")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return tlist;
	}

	/*
	 * public ArrayList<DebugUser> selectDebugUser(PageInfo pi, Connection conn,
	 * String userName) {
	 * 
	 * ArrayList<DebugUser> dlist = null;
	 * 
	 * PreparedStatement pstmt = null;
	 * 
	 * ResultSet rset = null;
	 * 
	 * String sql = prop.getProperty("selectDebugUser");
	 * 
	 * try { pstmt = conn.prepareStatement(sql);
	 * 
	 * int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; int endRow
	 * = startRow + pi.getBoardLimit() - 1;
	 * 
	 * pstmt.setString(1, userName); pstmt.setInt(2, startRow); pstmt.setInt(3,
	 * endRow);
	 * 
	 * rset = pstmt.executeQuery();
	 * 
	 * while (rset.next()) { dlist.add(new DebugUser( rset.getInt("USER_NO"),
	 * rset.getString("USER_NAME"), rset.getString("USER_ID"),
	 * rset.getString("USER_PWD"), rset.getString("USER_PHONE"),
	 * rset.getString("USER_EMAIL"), rset.getString("USER_SSN"),
	 * rset.getInt("TICKET_NO") )); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally { close(rset);
	 * close(pstmt); } return dlist; }
	 */

	public ArrayList<DebugUser> searchUser(PageInfo pi, Connection conn, String userName) {

		ArrayList<DebugUser> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("searchUser");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setString(1, userName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new DebugUser(
						rset.getInt("USER_NO"), 
						rset.getString("USER_NAME"), 
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"), 
						rset.getString("USER_PHONE"), 
						rset.getString("USER_EMAIL"),
						rset.getString("USER_SSN"), 
						rset.getInt("TICKET_NO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}

	public ArrayList<Blacklist> searchBlacklist(PageInfo pi, Connection conn, String blacklistName) {

		ArrayList<Blacklist> list = new ArrayList();

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		String sql = prop.getProperty("searchBlacklist");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setString(1, blacklistName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Blacklist(rset.getInt("BLACKLIST_NO"), rset.getString("BLACKLIST_NAME"),
						rset.getString("BLACKLIST_USER_NO"), rset.getString("BLACKLIST_REASON"),
						rset.getString("BLACKLIST_STATUS"), rset.getString("BLACKLIST_DATE")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

	}
//--------------------------동현 끝--------------------------------
}
