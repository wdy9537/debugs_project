<%@ page import="com.debugs.member.model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<style>

#mypage{
	text-align: center;
	padding: lpx;
}
table{ cursor: pointer; } 
#table2{ /*마이페이지 사이드 바 옆 화면 배열(크기) 설쟁해주는 기능*/
	padding: 50px 0px;
	font-size: 20px;
}
pre { /*바로가기> 글씨 위치 설정해주는 기능*/
	display: flex;
	align-items: center;
}
.body_hr { /* 푸터위에 hr선 설정 기능*/
	width: 80%; 
	margin: 0 auto;  /*hr선 센터 설정 기능*/
	text-align: center;
}
.logout { /*로그아웃 버튼 설정 스타일*/
	float: right;
	margin-top: 1%; /*로그아웃 버튼 위에서 아래로 옮겨주는 기능*/
	margin-right: 75px;  /*로그아웃 버튼 왼쪽으로 위치 끌어주는 기능*/
	border-radius: 5px;
	border: none;
	width: 100px; height: 45px;
	background-color: #E391A4;
	color: #fff; font-size: 14px; font-weight: bold;
}
</style>
</head>

<body>
<%@ include file="/views/common/headerView.jsp" %>

<div>
	<h2 id="mypage">마이페이지</h2>

	<table id="table2">
		<tr>
			<td width="100px"></td>
			<td style="text-align:center;">
				<img width="100px" height="100px" src="<%= contextPath %>/resources/img/user_logo.png">
				<label><strong><%= loginUser.getUserId() %> 환영합니다.</strong></label>
			</td>
			<td width="150px"></td>
			<td></td>
			<td width="150px"></td>
			<td><strong>내 플리 목록</strong>
				<br><br>
				<span style="color: #666">회원님에 플레이리스트 목록을 확인 할수 있습니다. </span>
				<br><br>
				<span style="color:#666">
					<pre> 바로가기>
						<img width="60px" height="60px" src="<%= contextPath %>/resources/img/mypage_logo4.png">
					</pre>
				</span>
			</td>
		</tr>
		<tr>
			<td colspan="6" height="80px"></td>
		</tr>
		<tr>
			<td width="100px"></td>
			<td><strong>비밀번호 수정</strong>
				<br><br>
				<span style="color: #666">회원님의 비밀번호 수정이 가능합니다.</span>
				<br><br>
				<a href="pwdupdate.me">
					<span style="color:#666">
						<pre> 바로가기>
							<img width="80px" height="80px" src="<%= contextPath %>/resources/img/mypage_logo1.png">
						</pre>
					</span>
				</a>
			</td>
			<td width="150px"></td>
			<td><strong>회원탈퇴</strong>
				<br><br>
				<span style="color: #666">회원탈퇴 절차를 도와드리겠습니다. </span>
				<br><br>
				<a href="delete.me">
					<span style="color:#666">
						<pre> 바로가기>                
							<img width="60px" height="60px" src="<%= contextPath %>/resources/img/mypage_logo2.png">
						</pre>
					</span>
				</a>
			</td>
			<td width="150px"></td>
			<td><strong>이용권 조회</strong>
				<br><br>
				<span style="color: #666">이용권 조회 및 해지 도 가능합니다. </span>
				<br><br>
				<a href="ticket_Select.me">
					<span style="color:#666">
						<pre> 바로가기>                
							<img width="60px" height="60px" src="<%= contextPath %>/resources/img/mypage_logo3.png">
						</pre>
					</span>
				</a>
			</td>
		</tr>

	</table>
	</div>
			
<%@ include file="/views/common/footerView.jsp" %>
<%@ include file="/views/musicPlayer/playerView.jsp" %>
			
</body>
</html>