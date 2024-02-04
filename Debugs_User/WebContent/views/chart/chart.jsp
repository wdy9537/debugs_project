<%@ page import="java.util.ArrayList, 
				com.debugs.common.model.vo.Music,
				com.debugs.musiclist.model.vo.Like" %>
				
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Music> music = (ArrayList<Music>)request.getAttribute("music");
	ArrayList<Like> like = (ArrayList<Like>)request.getAttribute("like");
	String chart = (String)request.getAttribute("chart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차트 페이지</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>
<%@ include file="/views/common/headerView.jsp" %>

<div class="music_list outer">
        <div class="title_name"><%= chart %> </div>
        <a href="chart.page?chart=TOP 100 차트"><span class="chartIndex">TOP 100</span></a>
        <a href="chart.page?chart=최신노래"><span class="chartIndex">최신노래</span></a>
        <a href="chart.page?chart=댄스/팝"><span class="chartIndex">댄스/팝</span></a>
        
        <br><br>
        <table>
            <thead>
                <tr>
                    <th width="10"><input type="checkbox" name="music_list" id="all_check"></th>
                    <th width="80" class="rank">순위</th>
                    <th colspan="2" class="table_left">곡 앨범</th>
                    <th width="180" class="table_left">아티스트</th>
                    <th width="60">재생</th>
                    <th width="60">담기</th>
                    <th width="60">좋아요</th>
                </tr>
            </thead>
            	<% if ( !music.isEmpty() ) { %>
	            	<% for ( int i = 0 ; i < music.size(); i ++ ) { %>
	    	       		<tr>
		                <td><input type="checkbox" name="music_list" id="music_list" value="<%= music.get(i).getMusicNo() %>"></td>
		                <td class="rank"><%= i+1 %></td>
	                	<td width="60">
	                		<a href="goAlbum.me?ano=<%= music.get(i).getAlbumNo() %>">
		                		<img src="<%= contextPath %>/resources/img/album_pic/<%= music.get(i).getAlbumChangename() %>" width="60" height="60" style="border-radius: 10px;">
		                	</a>
	                	</td>
		                
		                <td class="table_left">
		                	<a href="goSong.me?mno=<%= music.get(i).getMusicNo() %>"><span class="music_title"><%= music.get(i).getMusicTitle() %></span></a><br>
		                	<a href="goAlbum.me?ano=<%= music.get(i).getAlbumNo() %>"><span class="album_title"><%= music.get(i).getAlbumTitle() %></span></a>
	                	</td>
		                <td class="table_left"><span class="artist_name"><%= music.get(i).getArtistName() %></span></td>
		                <td class="music_list_icon"><img src="resources/img/musiclist/play_button.svg" onclick="addCurrentPlayList(<%= music.get(i).getMusicNo() %>)"></td>
		                <td class="music_list_icon"><img src="resources/img/musiclist/folder_button.png" onclick="myListAdd(<%= music.get(i).getMusicNo() %>);"></td>
			                <% if ( like.toString().contains("musicNo="+music.get(i).getMusicNo() ) ) { %>
			              		<td class="music_list_icon music_like"><img src="resources/img/musiclist/like_button_on.png"></td> 
		               		<% } else { %>
			               		<td class="music_list_icon music_like"><img src="resources/img/musiclist/like_button.svg"></td>
		               		<% } %>
		            </tr>
	            	<% } %>
            	<% } %>
        </table>
    </div>



<br><br>
	<%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>
</body>
</html>