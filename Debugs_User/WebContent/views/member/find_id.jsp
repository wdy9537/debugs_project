<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
@charset "utf-8";

/* base - 브라우저 별로 다를 수도 있는 것을 초기화 */
*{ padding: 0; margin: 0; } /* 태그 여백 없앰 */
li{ list-style: none; } /* 기호나 번호를 제거 */
a{ text-decoration: none; } /* 링크텍스트에 밑줄없앰 */
button{ cursor: pointer; } /* 모든 버튼에 마우스손모양 처리 */

/* body설정 */
body{ 
   background-color: #fff; 
   /* width: 1000px;  */
}




.loginbox{
    width: 600px; height: 590px;
    margin: 0 auto; /* 블록요소를 부모영역에서 가운데 처리 */
    
     
}
.loginbox h2{
    width: 100%; /* 부모영역을 상속 */

    /* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
    height: 100px; line-height: 100px;
    text-align: center; font-size: 20px;
    font-weight: normal;
    font-size: 25px;
}
.loginbox form{
    width: 100%; height: 450px;
    background-color: #fff;
    /* 패딩수치를 인사이드 처리 */
    padding: 60px; box-sizing: border-box;
    border: 1px solid gray;
}
.loginbox fieldset{
    border: none; /* 테두리 제거 */ 
}
.loginbox legend{
    /* 요소를 화면 밖으로 처리 */
    position: absolute; left: -999em;

    /* 웹접근성으로 스크린리더기가 읽어줘야 하므로 display: none;을 사용하지 말것 */
}
.loginbox label{
    display: block;
    font-size: 12px; color: #333;
    margin-bottom: 10px; /* 동위선택자와의 간격 조정 */
}
.loginbox input{
    display: block;
    width: 100%; height: 50px;
    margin-bottom: 25px; /* 동위선택자와의 간격 조정 */
    border: none; background-color: #ededed;
    padding: 0 20px; /* 앞상하 뒷좌우 */
    box-sizing: border-box; /* 패딩수치를 인사이드 처리 */
}

.loginbox ul{
    width: 100%;
    text-align: right; /* 글자를 오른쪽으로 처리 */
    margin-bottom: 60px;
}
.loginbox li{
    display: inline-block;
    height: 12px; line-height: 12px;
}
.loginbox li:last-child{
    border-left: 1px solid #333;
    padding-left: 10px; /* 테두리 안쪽 여백 */
    margin-left: 4px; /* 테두리 바깥쪽 여백 */
}
.loginbox a{
    /* 글자관련은 보통 최종태그에 줘야 적용 */
    color: #333; font-size: 12px;

    /* 현재 위치에서 상대적 이동 */
    position: relative; top: -2px;
}
.loginbox button{
    display: block;
    width: 350px; height: 50px;
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    border: none;
    background-color: #E391A4;
    color: #fff; font-size: 14px; font-weight: bold;
}


</style>

</head>
<body>

 <%@ include file="/views/common/headerView.jsp" %>

<div class="loginbox" >
	
	
   <h2>아이디 찾기</h2>
    <form id="enroll-form"  action="<%=contextPath %>/find_id.me" method="post">
   
    <!--작성하지 않아도 문제는 없음-->
    <fieldset>
      <legend>아이디찾기 구역</legend>
      <label for="loginname">이름</label>
      <input type="text" id="loginname"  name="userName"placeholder="이름을 입력해 주세요">
      <label for="loginemail">이메일</label>
      <input type="text" id="loginemail" name="userEmail" placeholder="이메일을 입력해 주세요">
      <br>
      <!--데이터를 서버로 전송-->
      <button type="button" onclick="findId_Proc()"  >아이디 찾기</button>
      <br>
      
    </fieldset>
  </form>
 </div>	
 
  <%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>
    
    
	<script>
	function findId_Proc(){ 
	   	
	      /*  alert("findId_Proc  1");  */
	           
	          const $userName = $("#enroll-form input[name=userName]");
	          const $userEmail = $("#enroll-form input[name=userEmail]");
	       
	         
	          $.ajax(
	          {
	        	 type : "post",
	        	 url : "findId_Proc.me",    
	        	 data : {checkName : $userName.val(),  
	        		     checkEmail : $userEmail.val()},
	        	 success : function(result)  
	        	 {
	        /* 		 alert("findId_Proc  success   result "  +  result);   */
	        		  
	        		 if(result == "0")
	        		 {
	        			 alert("회원정보에 없는 아이디 입니다.");
	        			   $userName.focus();  
	        	     } 
	        		 else
	        	     {
	        			 alert("회원님에 아이디는 " + result + " 입니다.");
	        			 $userName.focus();
	        		
	        	     }
	        	  }
	        	 
	     
	          });
	    

	          
	       }

	</script>
     



</body>
</html>