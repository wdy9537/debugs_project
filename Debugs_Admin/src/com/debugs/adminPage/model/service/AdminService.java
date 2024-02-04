package com.debugs.adminPage.model.service;

import static com.debugs.common.JDBCTemplate.close;
import static com.debugs.common.JDBCTemplate.commit;
import static com.debugs.common.JDBCTemplate.getConnection;
import static com.debugs.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.adminPage.model.dao.AdminDao;
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
import com.debugs.adminPage.model.vo.ReplyList;
import com.debugs.adminPage.model.vo.Ticket;
import com.debugs.common.model.vo.PageInfo;

public class AdminService {

	public Admin loginAdmin(String adminId, String adminPwd) {

		Connection conn = getConnection();

		Admin m = new AdminDao().loginAdmin(conn, adminId, adminPwd);

		close(conn);

		return m;

	}
//--------------------------동연 시작--------------------------------
	public int updateMemo(int adminNo, String adminMemo) {

		Connection conn = getConnection();

		int result = new AdminDao().updateMemo(conn, adminNo, adminMemo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int selectNoAnswerQnaCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectNoAnswerQnaCount(conn);

		close(conn);

		return listCount;
	}

	public ArrayList<Qna> selectNoAnswerQnaList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Qna> list = new AdminDao().selectNoAnswerQnaList(conn, pi);

		close(conn);

		return list;
	}

	public int selectAllQnaCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectAllQnaCount(conn);

		close(conn);

		return listCount;
	}

	public ArrayList<Qna> selectAllQnaList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Qna> list = new AdminDao().selectAllQnaList(conn, pi);

		close(conn);

		return list;
	}

	public int selectAllFaqCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectAllFaqCount(conn);

		close(conn);

		return listCount;
	}

	public ArrayList<Faq> selectAllFaqList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Faq> list = new AdminDao().selectAllFaqList(conn, pi);

		close(conn);

		return list;
	}

	public int insertFaq(String faqCategory, String faqTitle, String faqContent) {

		Connection conn = getConnection();

		int result = new AdminDao().insertFaq(conn, faqCategory, faqTitle, faqContent);

		close(conn);

		return result;
	}

	public int deleteFaq(String faqNo) {

		Connection conn = getConnection();

		int result = new AdminDao().deleteFaq(conn, faqNo);

		close(conn);

		return result;
	}

	public int getArtistNoByName(String artistName) {

		Connection conn = getConnection();

		int artistNo = new AdminDao().getArtistNoByName(conn, artistName);

		if (artistNo > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return artistNo;
	}

	public int insertAlbum(Album noPicAlbum) {

		Connection conn = getConnection();

		int result = new AdminDao().insertAlbum(conn, noPicAlbum);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int insertPicAlbum(Album picAlbum) {

		Connection conn = getConnection();

		int result = new AdminDao().insertPicAlbum(conn, picAlbum);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int insertArtist(String artistName) {

		Connection conn = getConnection();

		int insertResult = new AdminDao().insertArtist(conn, artistName);

		if (insertResult > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return insertResult;
	}

	public ArrayList<Artist> selectAllArtist() {

		Connection conn = getConnection();

		ArrayList<Artist> list = new AdminDao().selectAllArtist(conn);

		close(conn);

		return list;
	}

	public int selectAlbumNo(String albumTitle) {

		Connection conn = getConnection();

		int albumNo = new AdminDao().selectAlbumNo(conn, albumTitle);

		close(conn);

		return albumNo;
	}

	public int insertMusicKeyword(Music m, String keywordName) {

		Connection conn = getConnection();

		int keywordNo = new AdminDao().selectKeywordNo(conn, keywordName);

		int musicResult = new AdminDao().insertMusic(conn, m);
		int musicKeywordResult = 0;
		if (keywordNo > 0 && musicResult > 0) {

			musicKeywordResult = new AdminDao().insertMusicKeywordTable(conn, keywordNo);

			if (musicKeywordResult > 0) {
				commit(conn);
			} else {
				musicKeywordResult = 0;
				rollback(conn);
			}

		} else {
			rollback(conn);
		}

		return keywordNo * musicResult * musicKeywordResult;
	}

	public int selectAllMusicCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectAllMusicCount(conn);

		close(conn);

		return listCount;

	}

	public ArrayList<MusicList> selectAllMusicList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<MusicList> list = new AdminDao().selectAllMusicList(conn, pi);

		close(conn);

		return list;
	}

	public Music selectAllMusic(int musicNo) {

		Connection conn = getConnection();

		Music music = new AdminDao().selectAllMusic(conn, musicNo);

		close(conn);

		return music;
	}

	public Album selectAllAlbum(int albumNo) {

		Connection conn = getConnection();

		Album album = new AdminDao().selectAllAlbum(conn, albumNo);

		close(conn);

		return album;
	}

	public Artist selectArtistByNo(int artistNo) {

		Connection conn = getConnection();

		Artist artist = new AdminDao().selectArtistByNo(conn, artistNo);

		close(conn);

		return artist;
	}

	public MusicKeyword selectAllMusicKeyword(int musicNo) {

		Connection conn = getConnection();

		MusicKeyword musicKeyword = new AdminDao().selectAllMusicKeyword(conn, musicNo);

		close(conn);

		return musicKeyword;
	}

	public Keyword selectAllKeyword(int keywordNo) {

		Connection conn = getConnection();

		Keyword keyword = new AdminDao().selectAllKeyword(conn, keywordNo);

		close(conn);

		return keyword;
	}

	public int updateAlbum(Album album) {

		Connection conn = getConnection();

		int result = new AdminDao().updateAlbum(conn, album);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int updateMusic(Music music, String keywordName) {

		Connection conn = getConnection();
		if (keywordName == null || keywordName.isEmpty()) {

			int result = new AdminDao().updateMusic(conn, music);

			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			return result;

		} else {

			int keywordNo = new AdminDao().selectKeywordNo(conn, keywordName);

			int musicResult = new AdminDao().updateMusic(conn, music);
			if (keywordNo > 0 && musicResult > 0) {

				new AdminDao().insertNewMusicKeywordTable(conn, keywordNo, music.getMusicNo());

				commit(conn);
			} else {

				rollback(conn);
			}

			close(conn);
			return keywordNo * musicResult;
		}

	}

	public int selectAllReplyCount() {
		Connection conn = getConnection();

		int listCount = new AdminDao().selectAllReplyCount(conn);

		close(conn);

		return listCount;
	}

	public ArrayList<ReplyList> selectAllReplyList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<ReplyList> list = new AdminDao().selectAllReplyList(conn, pi);

		close(conn);

		return list;
	}

	public int deleteReply(String[] replyNoList) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int eachResult = 0;
		int result = 0;
		for (int i = 0; i < replyNoList.length; i++) {
			eachResult = adminDao.deleteReply(conn, replyNoList[i]);
			if (eachResult > 0) {
				result++;
			}
		}
		if (result == replyNoList.length) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
			result = 0;
		}
		close(conn);

		return result;
	}

	public int deleteMusic(String[] musicNoList) {

		// 뮤직 + 키워드 먼저 지우
		// 아니면 그냥 롤백 0
		// 성공하면 뮤직 지우기 이거도 성공하면 커밋 1

		Connection conn = getConnection();
		AdminDao adminDao = new AdminDao();

		int eachMusicKeywordResult = 0;
		int musicKeywordResult = 0;
		int eachMusicResult = 0;
		int musicResult = 0;
		int result = 0;

		for (int i = 0; i < musicNoList.length; i++) {
			eachMusicKeywordResult = adminDao.deleteMusicKeyword(conn, musicNoList[i]);
			if (eachMusicKeywordResult > 0) {
				musicKeywordResult++;
			}
		}

		if (musicKeywordResult == musicNoList.length) {

			for (int i = 0; i < musicNoList.length; i++) {
				eachMusicResult = adminDao.deleteMusic(conn, musicNoList[i]);
				if (eachMusicResult > 0) {
					musicResult++;
				}
			}
			if (musicResult == musicNoList.length) {
				commit(conn);
				result = 1;
			} else {
				rollback(conn);
				result = 0;
			}

		} else {
			rollback(conn);
			result = 0;
		}

		close(conn);

		return result;
	}

	public Qna selectQnaInfo(int qnaNo) {

		Connection conn = getConnection();

		Qna qna = new AdminDao().selectQnaInfo(conn, qnaNo);

		close(conn);

		return qna;
	}

	public int updateQna(int qnaNo, String qnaAnswer) {

		Connection conn = getConnection();

		int result = new AdminDao().updateQna(conn, qnaNo, qnaAnswer);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int deleteQna(String[] qnaNoList) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int eachResult = 0;
		int result = 0;
		for (int i = 0; i < qnaNoList.length; i++) {
			eachResult = adminDao.deleteQna(conn, qnaNoList[i]);
			if (eachResult > 0) {
				result++;
			}
		}
		if (result == qnaNoList.length) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
			result = 0;
		}
		close(conn);

		return result;
	}

	public int searchMusicCount(String searchMusicName) {

		Connection conn = getConnection();

		int listCount = new AdminDao().searchMusicCount(conn, searchMusicName);

		close(conn);

		return listCount;
	}

	public ArrayList<MusicList> searchMusicList(PageInfo pi, String searchMusicName) {

		Connection conn = getConnection();

		ArrayList<MusicList> list = new AdminDao().searchMusicList(conn, pi, searchMusicName);

		close(conn);

		return list;
	}

	public ArrayList<Album> selectAlbum() {

		Connection conn = getConnection();

		ArrayList<Album> list = new AdminDao().selectAlbum(conn);

		close(conn);

		return list;
	}

	public String selectQnaImg(int qnaNo) {

		Connection conn = getConnection();

		String qnaImg = new AdminDao().selectQnaImg(conn, qnaNo);

		close(conn);

		return qnaImg;
	}
//--------------------------동연 끝--------------------------------
//--------------------------동현 시작--------------------------------

	public int insertAdmin(Admin a) {

		Connection conn = getConnection();

		int result = new AdminDao().insertAdmin(conn, a);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int selectListCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectListCount(conn);

		close(conn);

		return listCount;

	}

	public ArrayList<Admin> selectList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Admin> list = new AdminDao().selectList(conn, pi);

		close(conn);

		return list;

	}

	public int deleteAdmin(String[] adminNos) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int result = 0;

		for (int i = 0; i < adminNos.length; i++) {
			result = adminDao.deleteAdmin(conn, adminNos[i]);
		}

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int insertNotice(Notice n) {

		Connection conn = getConnection();

		int result = new AdminDao().insertNotice(conn, n);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int selectNoticeListCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectNoticeListCount(conn);

		close(conn);

		return listCount;

	}

	public ArrayList<Notice> selectNoticeList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Notice> list = new AdminDao().selectNoticeList(conn, pi);

		close(conn);

		return list;

	}

	public int deleteNotice(String[] noticeNos) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int eachResult = 0;
		int result = 0;
		for (int i = 0; i < noticeNos.length; i++) {
			eachResult = adminDao.deleteNotice(conn, noticeNos[i]);
			if (eachResult > 0) {
				result++;
			}
		}

		if (result == noticeNos.length) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
			result = 0;
		}

		close(conn);

		return result;

	}

	public ArrayList<Ticket> selectTicketList() {

		Connection conn = getConnection();

		ArrayList<Ticket> list = new AdminDao().selectTicketList(conn);

		close(conn);

		return list;

	}

	public int insertTicket(Ticket t) {

		Connection conn = getConnection();

		int result = new AdminDao().insertTicket(conn, t);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int deleteTicket(String[] ticketNos) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int result = 0;

		for (int i = 0; i < ticketNos.length; i++) {
			result = adminDao.deleteTicket(conn, ticketNos[i]);
		}

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int selectDebugUserListCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectDebugUserListCount(conn);

		close(conn);

		return listCount;

	}
	
	public int selectSearchDebugUserListCount(String userName) {
		
		Connection conn = getConnection();

		int listCount = new AdminDao().selectSearchDebugUserListCount(conn, userName);

		close(conn);

		return listCount;
		
	}

	public ArrayList<DebugUser> selectDebugUserList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<DebugUser> list = new AdminDao().selectDebugUserList(conn, pi);

		close(conn);

		return list;

	}

	public int deleteUser(String[] userNos) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int result = 0;

		for (int i = 0; i < userNos.length; i++) {
			result = adminDao.deleteUser(conn, userNos[i]);
		}

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public DebugUser selectUser(String[] userNos) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		DebugUser d = new DebugUser();

		for (int i = 0; i < userNos.length; i++) {
			d = adminDao.selectUser(conn, userNos[i]);
		}

		close(conn);

		return d;

	}

	public int updateUser(DebugUser d) {

		Connection conn = getConnection();

		int result = new AdminDao().updateUser(conn, d);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int selectBlacklistListCount() {

		Connection conn = getConnection();

		int listCount = new AdminDao().selectBlacklistListCount(conn);

		close(conn);

		return listCount;

	}

	public ArrayList<Blacklist> selectBlacklistList(PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Blacklist> list = new AdminDao().selectBlacklistList(conn, pi);

		close(conn);

		return list;

	}

	public int insertBlacklist(Blacklist bl) {

		Connection conn = getConnection();

		int result = new AdminDao().insertBlacklist(conn, bl);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int updateUserStatus(String blacklistName) {

		Connection conn = getConnection();

		int result = new AdminDao().updateUserStatus(conn, blacklistName);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int deleteBlacklist(String[] blacklistNos) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int result = 0;

		for (int i = 0; i < blacklistNos.length; i++) {
			result = adminDao.deleteBlacklist(conn, blacklistNos[i]);
		}

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int updateBlacklist(String[] blacklistNos) {

		Connection conn = getConnection();

		AdminDao adminDao = new AdminDao();

		int result = 0;

		for (int i = 0; i < blacklistNos.length; i++) {
			result = adminDao.updateBlacklist(conn, blacklistNos[i]);
		}

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public ArrayList<Category> selectCategoryList() {

		Connection conn = getConnection();

		ArrayList<Category> list = new AdminDao().selectCategoryList(conn);

		close(conn);

		return list;

	}

	public ArrayList<Ticket> selectTicket() {

		Connection conn = getConnection();

		ArrayList<Ticket> tlist = new AdminDao().selectTicket(conn);

		close(conn);

		return tlist;

	}

	/*
	 * public ArrayList<DebugUser> selectDebugUser(PageInfo pi, String userName) {
	 * 
	 * Connection conn = getConnection();
	 * 
	 * ArrayList<DebugUser> dlist = new AdminDao().selectDebugUser(pi, conn,
	 * userName);
	 * 
	 * close(conn);
	 * 
	 * return dlist;
	 * 
	 * }
	 */

	public ArrayList<DebugUser> searchUser(PageInfo pi, String userName) {

		Connection conn = getConnection();

		ArrayList<DebugUser> list = new AdminDao().searchUser(pi, conn, userName);

		close(conn);

		return list;

	}

	public ArrayList<Blacklist> searchBlacklist(PageInfo pi, String blacklistName) {

		Connection conn = getConnection();

		ArrayList<Blacklist> list = new AdminDao().searchBlacklist(pi, conn, blacklistName);

		close(conn);

		return list;

	}
//--------------------------동현 끝--------------------------------
}
