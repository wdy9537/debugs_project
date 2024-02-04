package com.debugs.chart;

import static com.debugs.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.debugs.common.model.vo.Music;

public class ChartService {
	
	// 차트화면
	public ArrayList<Music> searchMusic(String chart) {
		Connection conn = getConnection();
		ArrayList<Music> musicList = new ChartDao().searchMusic(conn, chart);
		close(conn);
		return musicList;
	}
	
	public ArrayList<Music> searchKeywordMusic(String keword) {
		Connection conn = getConnection();
		ArrayList<Music> musicList = new ChartDao().searchKeywordMusic(conn, keword);
		close(conn);
		return musicList;
	}
}
