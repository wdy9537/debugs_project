<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.Album" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Album> list = (ArrayList<Album>)request.getAttribute("list");
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
				<h1>음원 추가</h1>
			</div>
			<div class="main-btn"></div>
			<div class="main-content">
				<form action="<%= contextPath %>/insertMusic.ad" method="post" enctype="multipart/form-data">
					<table class="main-content-insertTable" id="insertMusic">
						<tr>
							<th>앨범 제목*</th>
							<td><input type="text" placeholder="내용을 입력하세요." name="albumTitle" list="albumList" required>
									<datalist id="albumList">
										<% for(Album a : list){ %>
											<option label="앨범번호 : <%= a.getAlbumNo() %>"><%= a.getAlbumTitle() %></option>
										<% } %>
									</datalist>
							</td>
							<td rowspan="6" style="width: 50px;"></td>
							<th>음원 키워드*</th>
							<td><input type="text" placeholder="내용을 입력하세요." name="keywordName" required></td>
						</tr>
						<tr>
							<th>음원 제목*</th>
							<td><input type="text" placeholder="내용을 입력하세요." name="musicTitle" required></td>
							<th>재생 시간*</th>
							<td><input type="text" placeholder="00(분)"style="width: 197px;" name="musicTimeM" required> : <input type="text" placeholder="00(초)" style="width: 197px;"name="musicTimeS" required></td>
						</tr>
						<tr>
							<th>음원 장르*</th>
							<td><input type="text" placeholder="내용을 입력하세요." name="musicGenre" required></td>
							<th>음원 파일*</th>
							<td><input type="file" name="musicFile" required></td>
						</tr>
						<tr>
							<th>음원 상세정보</th>
							<td><textarea placeholder="내용을 입력하세요." name="musicDetail"></textarea></td>
							<th>음원 가사</th>
							<td><textarea placeholder="내용을 입력하세요." name="musicLyrics"></textarea></td>
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

			categorys.forEach(function(item) {
				item.checked = checked;
			});
		}
	</script>

</body>
</html>