<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="stylesheet" type="text/css" href="resources/css/mainCss.css">
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>
<%@include file="/views/common/headerView.jsp" %>

<div id="wholemain">
    <br>
    <div class="maindiv"><a href="<%=contextPath %>/noticelist.bo" class="mainbtn">공지사항<br><br> <span class="goingcs">바로가기 >></span></a></div>
    <div class="maindiv"><a href="<%=contextPath %>/goFaq.me" class="mainbtn">자주 하는 질문 <br><br> <span class="goingcs">바로가기 >></span></a></div>

    <br clear="both">

    <div class="maindiv"><a href="<%=contextPath %>/goQna.me" class="mainbtn">1:1 문의 <br><br> <span class="goingcs">바로가기 >></span></a></div>
    <div class="maindiv"><a href="<%=contextPath %>/goQnaResult.me" class="mainbtn">나의 문의 내역 <br><br> <span class="goingcs">바로가기 >></span></a></div>
    <br clear="both">
   </div>
<br><br><br><br><br>
<%@include file="/views/common/footerView.jsp" %>
<%@include file="/views/musicPlayer/playerView.jsp" %>
</body>
</html>