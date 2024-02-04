<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>
<a href="detail.pl?plno=3">3번 플레이리스트 상세페이지</a> <br>
<a href="recommend.pl">추천 플레이리스트</a> <br>
<form method="get" action="search.li">
	<input type="text" name="keyword"> <button type="submit">검색</button>
</form> <br>
<a href="chart.page?chart=TOP 100 차트">차트페이지</a> <br>
<a href="chart.page?chart=최신노래">최신노래</a>
<a href="chart.page?chart=댄스/팝">댄스/팝</a> <br>

 <% response.sendRedirect(request.getContextPath()+"/main"); %> 
	<!-- url 재요청 방식으로 변경 -->
	
	<!-- <a href="login.me">로그인</a>
	<br>
	<a href="views/mypage/mypage.jsp">마이페이지</a> -->
 
</body>
</html>