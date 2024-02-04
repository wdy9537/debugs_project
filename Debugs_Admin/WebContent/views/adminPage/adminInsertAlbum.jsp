<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.Artist" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Artist> list = (ArrayList<Artist>)request.getAttribute("list");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음원추가</title>
</head>
<body>
	<%@ include file="/views/adminPage/adminMenubar.jsp" %>

	<!-- 메인시작 -->
	<main id="main-container">
		<div class="side-section"></div>
		<div class="main-section">
			<div class="main-title">
				<h1>앨범 추가</h1>
			</div>
			<div class="main-btn"></div>
			<div class="main-content">
				<form action="<%= contextPath %>/insertAlbum.ad" method="post" enctype="multipart/form-data">
					<table class="main-content-insertTable" id="insertMusic">
						<tr>
							<th>앨범 제목*</th>
							<td><input type="text" placeholder="내용을 입력하세요." name="albumTitle" required></td>
							<td rowspan="6" style="width: 50px;"></td>
							<th>앨범사진</th>
							<td><input type="file" name="albumPic"></td>
						</tr>
						<tr>
							<th>앨범유형*</th>
							<td><input type="text" placeholder="내용을 입력하세요." name="albumType" required></td>
							<th>발매일*</th>
							<td><input type="date" name="albumDate" required></td>
						</tr>
						<tr>
							<th>아티스트*</th>
							<td>
								<input type="text" placeholder="내용을 입력하세요." name="artistName" list="artistList" required>
									<datalist id="artistList">
										<% for(Artist a : list){ %>
											<option label="아티스트번호 : <%= a.getArtistNo() %>"><%= a.getArtistName() %></option>
										<% } %>
									</datalist>
							</td>
							<th></th>
							<td></td>
						</tr>

					</table>
					<br>
					<br>
					<div class="music-insert-btn">
						<button type="submit">
							<div>추가 등록</div>
						</button>
					</div>
				</form>
			</div>
		</div>
	</main>
	<!-- 메인 끝 -->

	<script>
    function selectAll() {
      const checked = document.getElementById("selectAll").checked; // true : 체크, false : 미선택

      const categorys = document.getElementsByName("check-btn");

      categorys.forEach(function (item) {
        item.checked = checked;
      });
    }
  </script>

</body>
</html>