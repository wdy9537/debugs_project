<%@ page import="java.util.ArrayList, 
				com.debugs.member.model.vo.*" %>
				
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   	String contextPath = request.getContextPath();
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
	<link rel="stylesheet" href="resources/css/header.css"/>
	<link rel="stylesheet" href="resources/css/playlist.css" />
    <link rel="stylesheet" href="resources/css/musiclist.css" />
    <link rel="stylesheet" href="resources/css/search.css" />
    <link rel="stylesheet" href="resources/css/common2.css" />
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>    
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
    
    <link rel="icon" href="2023071910201761118.png" type="image/x-icon" sizes="16x16">
    <link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
</head>
<body>
	<script>
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";
		
		if(msg != "null"){
			alert(msg);
			// 알림창을 띄워준 후 session에 담긴 해당 메세지는 지워줘야한다.
			// 안그럼, menubar.jsp가 로딩될때마다 항상 메세지가 뜰것..
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>

      <header>
        <div class="header-top-wrap">
            <div class="header-right">
                <a href=""><img src="resources/img/common/마이페이지로고.png"></a>
                <% if ( loginUser == null ) { %>
	                <a href="login.me">로그인</a>
    	            <a href="enrollForm.me">회원가입</a>
                <% } else { %>
                	<a href="page.me">마이페이지</a>
                	<a href="logout.me">로그아웃</a>
                <% } %>
                <a href="go.cs">고객센터</a>
                <a href="list.me">이용권</a>
            </div>

            <nav class="navbar">
                <div class="navbar_logo">
                    <a href="<%= contextPath %>">
                        <img src="resources/img/common/디벅스_로고_2-removebg-preview.png">
                    </a>
                </div>

                <ul class="navbar_menu">
                    <li><a href="chart.page?chart=최신노래">DEBUGS 차트</a></li>
                    <li><a href="recommend.pl">추천 플레이리스트</a></li>
                </ul>

                <div class="box" />
                    <div class="container-1">
                        <span class="icon"><i class="fa fa-search"></i></span>
                        <form method="get" action="search.li">
							<input type="search" name="keyword" id="search" placeholder="검색어를 입력하세요."/> <button type="submit"></button>
						</form> <br>
                    </div>
                    <div class = "container-2">
                     
                    </div>
                  </div>
                </nav>
        </div>
        
    </header>
   
   <script>
   $(function(){
	      $.ajax({
	         url : "<%= request.getContextPath()%>/keyword",
	         success : function(list){
	            let result = "";
	            for(let key of list){
	               result += "<a href='keyword.page?keyword="+key.keywordName+"'>#"+key.keywordName+"</a>";
	            }
	            $(".container-2").html(result);
	         }
	      })
	   })
   	var contextPath = "<%= contextPath %>";
   	var loginUser = "<%= loginUser %>";
   </script>

</body>
</html>