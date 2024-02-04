<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/css/debugsAdminDashboard.css">
</head>
<body>

	<script>
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";
		
		if(msg != "null") {
			alert(msg);
			// 알림창을 띄워준 후 session에 담긴 해당 메세지는 지워줘야한다.
			// 안그러면 menubar.jsp가 로딩될때마다 항상 메세지가 뜰 것이다.
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>

	<div class="loginheader">
		<img src="resources/img/디버그로고.png">
	</div>

	<div class="login-outer">
		<form class="login-form" id="login-form" action="<%= request.getContextPath() %>/login.ad" method="POST">
			<table class="login-table">
				<thead>
					<tr>
						<th style="border-radius: 10px 10px 0px 0px;">관리자 로그인</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
					</tr>
					<tr>
						<td><input type="text" name="adminId" placeholder="아이디를 입력하세요" required></td>
					</tr>
					<tr>
						<td>비밀번호</td>
					</tr>
					<tr>
						<td><input type="password" name="adminPwd" placeholder="비밀번호를 입력하세요" required></td>
					</tr>
					<tr>
						<td><button type="submit">로그인</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
</body>
</html>