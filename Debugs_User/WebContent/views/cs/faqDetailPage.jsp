<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.debugs.cs.model.vo.Faq" %>
<%
	Faq f = (Faq) request.getAttribute("f");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="stylesheet" type="text/css" href="resources/css/faqDetailPageCss.css">
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<style>
 

		
		
</style>
</head>
<body>
<%@include file="/views/common/headerView.jsp" %>
<div class="outerbox">
 <h1 id="faqmaintext">고객센터</h1>

		<div class="wholefaqmenu">
			<div class="faqmenu" id="faqchoicemenu">
				<a href="<%=contextPath %>/noticelist.bo">공지사항</a>
			</div>
			<div class="faqmenu">
				<a href="<%=contextPath %>/faqlist.fa">FAQ</a>
			</div>
			<div class="faqmenu">
				<a href="<%=contextPath %>/goQna.me">1:1문의</a>
			</div>
			<div class="faqmenu">
				<a href="<%=contextPath %>/goQnaResult.me">나의 문의내역</a>
			</div>
		</div>

    <table id="faqtable">
		<thead>
			<tr>
				<th width="50"><%= f.getFaqNo() %></th>
				<th width="200"><%= f.getFaqCategory() %></th>
				<th width="650"><%= f.getFaqTitle() %></th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<td colspan="3"><%= f.getFaqContent() %></td>
		</tr>
		</tbody>
	</table>
	
	
		
		
</div>
<br><br><br><br><br>
<%@include file="/views/common/footerView.jsp" %>
<%@include file="/views/musicPlayer/playerView.jsp" %>

</body>
</html>