<%@ page import="com.debugs.adminPage.model.vo.Admin" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();

	Admin loginAdmin = (Admin)session.getAttribute("loginAdmin");
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴바</title>
<!-- css -->
<link rel="stylesheet" href="resources/css/debugsAdminDashboard.css">
<link rel="stylesheet" href="resources/css/modal.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<script>
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";

		if (msg != "null") {
			alert(msg);
			// 알림창을 띄워준 후 session에 담긴 해당 메세지는 지워줘야한다.
			// 안그러면 menubar.jsp가 로딩될때마다 항상 메세지가 뜰 것이다.
			<%session.removeAttribute("alertMsg");%>
		}
	</script>

	<!-- 헤더 시작 -->
	<header>
		<div class="container">
			<a href="<%= contextPath %>/main.ad" style="height:145px;"><img src="resources/img/디버그로고.png" /></a>
			<a href="<%= contextPath %>/main.ad"><span>Admin Dashboard</span></a>
			<nav>
				<ul>
					<li><a href="<%= contextPath %>/main.ad">메인으로</a></li>
					<li><a href="http://localhost:8081/semi/main">홈페이지</a></li>
					<li><a href="<%= contextPath %>/logout.ad">로그아웃</a></li>
					<!-- <li><a href="#" ><img src="resources/홈로고.png"></a></li> -->
				</ul>
			</nav>
		</div>
	</header>
	<div id="test" style="width: 100%; height: 145px;">
		<!-- 헤더 끝 -->

		<!-- 사이드 시작 -->
	</div>
	<aside class="side-bar">
		<section class="side-bar__icon-box">
			<section class="side-bar__icon-1">
				<div></div>
				<div></div>
				<div></div>
			</section>
		</section>
		<ul>
			<li><a href="#"><i class="fa-solid fa-cat"></i>회원관리</a>
				<ul>
					<li><a href="<%= contextPath %>/user.ad">회원관리</a></li>
					<li><a href="<%= contextPath %>/blacklist.ad">블랙리스트</a></li>
				</ul>
			</li>
			<li><a href="#">앨범 및 음원관리</a>
				<ul>
					<li><a href="<%= contextPath %>/addAlbum.ad">앨범추가</a></li>
					<li><a href="<%= contextPath %>/addMusic.ad">음원추가</a></li>
					<li><a href="<%= contextPath %>/manageMusic.ad">음원관리</a></li>
					<li><a href="<%= contextPath %>/reply.ad">댓글관리</a></li>
				</ul>
			</li>
			<li><a href="<%= contextPath %>/ticket.ad">이용권관리</a></li>
			<li><a href="<%= contextPath %>/notice.ad">공지사항관리</a></li>
			<li><a href="#">고객센터관리</a>
				<ul>
					<li><a href="<%= contextPath %>/faq.ad">FAQ관리</a></li>
					<li><a href="<%= contextPath %>/qna.ad">문의관리</a></li>
				</ul>
			</li>
			<% if (loginAdmin != null && loginAdmin.getAdminGrade() == 1) { %>
			<li><a href="<%= contextPath %>/admin.ad">일반관리자 관리</a></li>
			<% } %>
		</ul>
	</aside>
	<!-- 사이드 끝 -->
</body>
</html>