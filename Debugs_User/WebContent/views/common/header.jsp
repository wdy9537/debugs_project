<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더</title>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>    
 	<link rel="stylesheet" href="resources/css/header.css" />
    
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/playlist.css" />
    <link rel="stylesheet" href="resources/css/musiclist.css" />
    <link rel="stylesheet" href="resources/css/search.css" />
    <link rel="stylesheet" href="resources/css/common2.css" />
</head>
<body>
<header>
        <div class="header-top-wrap">
            <div class="header-right">
                <a href=""><img src="resources/img/common/마이페이지로고.png"></a>
                <!-- 에이씨 db에 넣는거 까묵 안되면 없애지 뭐 ㅗㅗ  -->
                <a href="">로그인</a>
                <a href="">회원가입</a>
                <a href="">고객센터</a>
            </div>

            <nav class="navbar">
                <div class="navbar_logo">
                    <a href="">
                        <img src="resources/img/common/디벅스_로고_2-removebg-preview.png">
                    </a>
                </div>

                <ul class="navbar_menu">
                    <li><a href="">음원페이지</a></li>
                    <li><a href="">추천 플레이리스트</a></li>
                </ul>

                <div class="box" >
                    <div class="container-1">
                        <span class="icon"><i class="fa fa-search"></i></span>
                        <input type="search" id="search" placeholder="검색어를 입력하세요." />
                    </div>
                    <div class="container-2">
                        <a href="#">#키워드1</a>
                        <a href="#">#키워드2</a>
                        <a href="#">#키워드3</a>
                    </div>
                  </div>
                </nav>
        </div>
        
    </header>
</body>
</html>