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
.loginbox {
	width: 600px;
	height: 550px;
	margin: 0 auto; /* 블록요소를 부모영역에서 가운데 처리 */
}

.loginbox h2 {
	width: 100%; /* 부모영역을 상속 */
	/* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
	height: 100px;
	line-height: 100px;
	text-align: center;
	font-size: 20px;
	font-weight: normal;
	font-size: 25px;
}

.loginbox form {
	width: 100%;
	height: 450px;
	background-color: #fff;
	/* 패딩수치를 인사이드 처리 */
	padding: 60px;
	box-sizing: border-box;
	border: 1px solid gray;
}

.loginbox fieldset {
	border: none; /* 테두리 제거 */
}

.loginbox legend {
	/* 요소를 화면 밖으로 처리 */
	position: absolute;
	left: -999em;

	/* 웹접근성으로 스크린리더기가 읽어줘야 하므로 display: none;을 사용하지 말것 */
}

.loginbox label {
	display: block;
	font-size: 12px;
	color: #333;
	margin-bottom: 10px; /* 동위선택자와의 간격 조정 */
}

.loginbox input {
	display: block;
	width: 100%;
	height: 50px;
	margin-bottom: 25px; /* 동위선택자와의 간격 조정 */
	border: none;
	background-color: #ededed;
	padding: 0 20px; /* 앞상하 뒷좌우 */
	box-sizing: border-box; /* 패딩수치를 인사이드 처리 */
}

.loginbox ul {
	width: 100%;
	text-align: right; /* 글자를 오른쪽으로 처리 */
	margin-bottom: 60px;
}

.loginbox li {
	display: inline-block;
	height: 12px;
	line-height: 12px;
}

.loginbox li:last-child {
	border-left: 1px solid #333;
	padding-left: 10px; /* 테두리 안쪽 여백 */
	margin-left: 4px; /* 테두리 바깥쪽 여백 */
}

.loginbox a {
	/* 글자관련은 보통 최종태그에 줘야 적용 */
	color: #333;
	font-size: 12px;
	/* 현재 위치에서 상대적 이동 */
	position: relative;
	top: -2px;
}

.loginbox button {
	display: block;
	width: 350px;
	height: 50px;
	margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
	border: none;
	background-color: #E391A4;
	color: #fff;
	font-size: 14px;
	font-weight: bold;
}

.loginbox table { /*네이버 카카오 페이스북 이미지 위치 가운대로 설정해주는 기능*/
	margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
	border: 0px solid black;
}
</style>

</head>
<body>

	  <%@ include file="/views/common/headerView.jsp" %>

	<script>
		
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";
		
		if(msg != "null"){
			alert(msg);
			// 알림창을 띄워준 후 session에 담긴 해당 메세지는 지워줘야한다.
			// 안그럼, menubar.jsp가 로딩될때마다 항상 메세지가 뜰것..
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>

	<div class="loginbox">
	
	<% if(loginUser == null) { %>

			<h2>
			<strong>로그인 화면</strong>
		</h2>
		<form id="login-from" action="<%= request.getContextPath()%>/login.me" method="POST">
			<!--작성하지 않아도 문제는 없음-->
			<fieldset>
				<legend>로그인 구역</legend>
				<label for="loginid">아이디</label> <input type="text" id="loginid" name="userId"
					placeholder="아이디를 입력해 주세요"> <label for="loginpw">비밀번호</label>
				<input type="password" id="loginpw"  name="userPwd" placeholder="비밀번호를 입력해 주세요">
				<table>
					<tr>
						<a
							href="findId_Proc.me">아이디
							찾기 |</a>
					</tr>
					<tr>
						<a
							href="findPwd_Proc.me">
							비밀번호 찾기</a>
					</tr>
				</table>
				<br>
				<!--데이터를 서버로 전송-->
				<button type="submit">로그인</button>
				<!-- 
					<table>
						<tr align=center>
							<td width=80px><img width=50px height=50px
								src="<%= contextPath %>/resources/img/naver-circle.png"></td>
							<td width=80px><img width=50px height=50px
								src="<%= contextPath %>/resources/img/kakao-circle.png"></td>
							<td width=80px><img width=50px height=50px
								src="<%= contextPath %>/resources/img/facebook-circle.png"></td>
						</tr>
					</table>
				 -->
			</fieldset>
		</form>
		
			<script>
			function enrollPage(){
				
				<%-- location.href = "<%= contextPath %>/views/member/memberEnrollForm.jsp"; --%>
				// 웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 취약하다.
				
				// 단순한 정적인 페이지 요청일지라도 반드시 servlet을 거쳐가도록 작성할것.
				// 즉, url에 서블릿 매핑값만 노출되도록 하기.
				location.href = "<%=contextPath%>/enrollForm.me";
			}
		</script>
		
		<% } else { %>
			<!-- 로그인 성공 후 -->
			<div id="user-info">
				 
				<div align="center">
					<a href="<%=contextPath %>/update.me">마이페이지</a>
					<a href="<%=contextPath %>/logout.me">로그아웃</a>
				</div>
			</div>			
		<% } %>
		
		
	</div>
	<br>
	<br>
	 <%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>
</body>
</html>