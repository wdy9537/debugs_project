<%@ page import = "java.util.ArrayList, com.debugs.playlist.model.vo.Playlist" %>
<%
	ArrayList<Playlist> plList = (ArrayList<Playlist>)request.getAttribute("plList");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천 플레이리스트</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>
<%@ include file="/views/common/headerView.jsp" %>

	<div class="outer title_name">추천 플레이리스트</div>
	<% int index = 0; for ( int i = 0 ; i < 2 ; i ++ ) {  %>
    <div class="playlist_list_outer outer">
    	<%  for ( int j = 0 ; j < 2 ; j ++ ) {  %>
    		<div class="playlist_list">
    			<input type="hidden" type="hidden" id="playlist_no" value="<%= plList.get(index).getPlaylistNo() %>">
	            <div class="playlist_list_img">
	            <%	
		            int height1 = 0; int height2 = 0; int height3 = 0; int height4 = 0; 
		        	int width1 = 0; int width2 = 0; int width3 = 0; int width4 = 0;
		        	String th1 = "";
	
	            	if ( plList.get(index).getTh4() != null ) { height1=50; height2=50; height3=50; height4=50; width1=50; width2=50; width3=50; width4=50; } 
	            	else if ( plList.get(index).getTh3() != null ) { height1=50; height2=50; height3=50; height4=0; width1=50; width2=50; width3=100; width4=0; }
	            	else if ( plList.get(index).getTh2() != null ) { height1=100; height2=100; height3=0; height4=0; width1=50; width2=50; width3=0; width4=0; }
	            	else { height1=100; height2=0; height3=0; height4=0; width1=100; width2=0; width3=0; width4=0; }
	            %>
	            
	              <% if ( plList.get(index).getTh1() == null ) { th1 = "playlist_pic/"+plList.get(index).getPlaylistTh(); } else { th1 = "album_pic/"+plList.get(index).getTh1(); } %>
            
            	<div style="background-image: url(resources/img/<%= th1 %>);height: <%= height1 %>%;width: <%= width1 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= plList.get(index).getTh2() %>);height: <%= height2 %>%;width: <%= width2 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= plList.get(index).getTh3() %>);height: <%= height3 %>%;width: <%= width3 %>%;"></div>
            	<div style="background-image: url(resources/img/album_pic/<%= plList.get(index).getTh4() %>);height: <%= height4 %>%;width: <%= width4 %>%;"></div>
            	
	            	<%-- <img src="<%= contextPath %>/resources/img/playlist_pic/<%= plList.get(index).getPlaylistTh() %>.jpg"> --%>
            	</div>
	            <div class="playlist_list_comment">
	                <span class="middle_title_name"><%= plList.get(index).getPlaylistSubject() %></span> <br><br>
	                <span><%= plList.get(index).getUserId() %></span> | <span>총 <%= plList.get(index).getCount() %> 곡</span> <br><br>
	                <div>
	                    <button onclick="insertMyPlaylist(<%= plList.get(index).getPlaylistNo() %>);">내 플리 추가</button>
	                </div>
	            </div>
	        </div>
    	<% index++; } %>
    </div>
	<% } %>


    <%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>
    
</body>
</html>