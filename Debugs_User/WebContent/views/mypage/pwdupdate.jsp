<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.debugs.member.model.vo.Member"%>
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
/* base - 브라우저 별로 다를 수도 있는 것을 초기화 */
*{ padding: 0; margin: 0; } /* 태그 여백 없앰 */
li{ list-style: none; } /* 기호나 번호를 제거 */
a{ text-decoration: none; } /* 링크텍스트에 밑줄없앰 */
button{ cursor: pointer; } /* 모든 버튼에 마우스손모양 처리 */
/* body설정 */
body {
    margin: 0;
    font-family: 'Noto Sans KR', sans-serif;
}
a {
    text-decoration: none;
    color: black;
}
button{
    background-color: transparent;
    border:none;
}


body  .MainIcon{
    width: 120px; height: 100px;
    padding: 10px 35px;
    color : #666;  
}
/* sidebar */
.sidebar {
    /* position: relative; */
    /* width:100%; */
    /* margin-top: 60px; */
    /* clear: both; */

    /* border-top: 1px solid #e0e1e5; */
    /* padding-top: 32px;
    bottom: 70px; */
}
.sidebar  table {
    margin-top: 1px;
    background-color: #faecec80;
}
.sidebar ul {
		/* list-style-type: none; */
		/* background-color: #ccc; */
		/* width: 13%; */
		padding: 0;
		/* margin:  0; */
		/* position: fixed;  사이드 바 세로 설정 기능 */
		/* height: 100%; 사이드 바 세로 길이 설정 기능 */
		/* overflow: auto;    스크롤바 생기게 해주는 설정 기능*/ 
}
.sidebar li a { /*사이드바 글씨 크기 위치 설정 기능*/
		text-decoration: none;
		display: block;
		color: #000;
		padding: 8px 1px 8px 40px;
		font-weight: bold;
        font-size: 18px;
}
.sidebar li a.job {
	background-color: #333;
	color: #fff;
}
.sidebar li a:hover:not(.job) {/*사이드 바 글씨 마우스 갖다대면 효과일어나게 해주는 기능*/
	background-color: #333;
	color: #fff;
}
pre {
    font-size: 15px;
}
.loginbox{
    width: 600px; height: 550px;
    /* margin: 0 auto; 블록요소를 부모영역에서 가운데 처리 */
    margin-left: 40px;
    /* border-top: 1px solid #e0e1e5; */
   
}
.loginbox h2{
    width: 100%; /* 부모영역을 상속 */
    /* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
    height: 100px; line-height: 100px;
    font-size: 30px;
    font-weight: normal;
    margin-left: 52px;
}
.loginbox form{
    width: 110%; height: 950px;
    background-color: #fff;
    /* 패딩수치를 인사이드 처리 */
    padding: 0px; box-sizing: border-box;
    margin-left: 50%;  
    
}
.loginbox fieldset{
    border: none; /* 테두리 제거 */ 
    margin-left: 20px;
}
.loginbox legend{
    /* 요소를 화면 밖으로 처리 */
    position: absolute; left: -999em;

    /* 웹접근성으로 스크린리더기가 읽어줘야 하므로 display: none;을 사용하지 말것 */
}
.loginbox label{
    font-size: 12px; color: #333;
    margin-bottom: 5px; /* 동위선택자와의 간격 조정 */
}

.loginbox h3{  
    font-size: 12px; color: #333;
    margin-bottom: 2px; /* 동위선택자와의 간격 조정 */
} 

.loginbox input{
    display: block;
    width: 85%; height: 50px;
    margin-bottom: 25px; /* 동위선택자와의 간격 조정 */
    border: none; background-color: #ededed;
    padding: 0 20px; /* 앞상하 뒷좌우 */
    box-sizing: border-box; /* 패딩수치를 인사이드 처리 */
    margin-left: 5%;
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
.loginbox button{ /*확인버튼 취소 버튼 크기 색깔 설징 기능*/
    width: 100px; height: 50px;
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    border: none;
    background-color: #E391A4;
    color: #fff; font-size: 14px; font-weight: bold;

}

.confirm_btn { /*확인 버튼이랑 취소 버튼 오른쪽으로 위치 옮겨주는 기능 */
    padding-left: 30%; /*중복확인 버튼 오른쪽으로 옮길때 사용*/
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    margin-left: 50px;
}
table{
  margin-bottom: 50px;
}
</style>
</head>
<body>
<%@ include file="/views/common/headerView.jsp" %>


     <table>
        <tr>
            <td>
                <div class="sidebar">
                    <ul id="ur1">
            
                        <li> <img class="MainIcon" src="<%= contextPath %>/resources/img/debugs_logo1.png" ></li>
                            
                        <br>
                        <li><a  href="#">정보수정</a></li>
                        <br>
                        <li><a href="delete.me">회원탈퇴</a></li>
                        <br>
                        <li><a href="ticket_Select.me">이용권 조회</a></li>
                        <br>
                        <li><a href="#">내 플리 목록</a></li>
                    </ul>
            
                </div>
            </td>
            <td>
                <div class="loginbox" >
                    <form id="enroll-form" action="pwdupdate.me" method="post">
                        <span><h2><strong>비밀번호 변경</strong></h2></span>
                        <pre style="color: #4c4c4c;" >        *디버스에 등록된 비밀번호를 변경 할 수 있습니다.</pre>
                        <br>
                        <!--작성하지 않아도 문제는 없음-->
                        <fieldset>
                         <legend>비밀번호 수정 구역</legend>                          
                           <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>현재 비밀번호</strong>  &nbsp;&nbsp;&nbsp;<label id="pwdLabelold" > </label></h3>
                          <input type="password" id="loginpw1" name="userPwdold"  placeholder="현재 비밀번호를 입력해 주세요"  onblur="pwd_Check()" required> 
                         
                          <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>변경할 비밀번호</strong>  &nbsp;&nbsp;&nbsp;<label id="pwdLabel" > </label></h3>
                          <input type="password" id="loginpw" name="userPwd"  placeholder="비밀번호를 입력해 주세요" required>
                         
                          <label for="loginpw">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>비밀번호 확인</strong></label>
                          <input type="password" id="loginpw2" placeholder="비밀번호를 확인해 주세요" onblur="idCheck_3()"  required>
                          <br>
                          <!-- userid  session 정보 임 -->
                          <input type="hidden" id="loginid" name="userId" value="<%=loginUser.getUserId() %>"  style="width: 400px;">
                          <!--데이터를 서버로 전송-->
                          <div class="confirm_btn">
                            <button type="submit">확인</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <!-- <button type="button" style="background-color: #ccc;  color:black;"   >취소</button> -->
                          </div>             

                          <br>
                        </fieldset>
                      </form>
            
                </div>

            </td>
        </tr>
    </table>  
    
    
<script>
function isValidPasswd(str) { /* 비밀번호 문자 길이 & 조건문 제한 설정 기능 */
	
    let cnt = 0;
    if (str == "") {
        return false;
    }

    let retVal = checkSpace(str);
    if (retVal) {
        return false;
    }

    if (str.length < 8) {
    	/* alert("isValidPasswd 3  str.length : " + str.length); */
        return false;
    }

    for (let i = 0; i < str.length; ++i) {
        if (str.charAt(0) == str.substring(i, i + 1))
            ++cnt;
    }

    if (cnt == str.length) {
        return false;
    }
   
    let isPW = /^[a-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{8,16}$/;
    if (!isPW.test(str)) {
        return false;
    }
    return true;
}
        
function checkSpace(str) {
    if (str.search(/\s/) != -1) {
        return true;
    } else {
        return false;
    }
}
function idCheck_3(){ /*변경할 비밀번호 중복확인 & 조건문 설정 기능 */
	 pwdLabel.innerHTML = " ";


	 
	 if (loginpw.value == loginpw2.value) {
         pwdLabel.innerHTML = "(비밀번호가 일치합니다.)";
         pwdLabel.style.color = "green";
         pwdLabel.style.fontSize = "12px";
     } else {
         pwdLabel.innerHTML = "(비밀번호가 일치하지 않습니다.)";
         pwdLabel.style.color = "red";
         pwdLabel.style.fontSize = "12px";
     }

     if (isValidPasswd(loginpw.value) != true) {
    	
         pwdLabel.innerHTML = "(비밀번호: 8~16자 영문 소문자, 숫자, 특수문자를 사용하세요.)";
         pwdLabel.style.color = "red";
         pwdLabel.style.fontSize = "12px";
         return false;
     }
}

function pwd_Check(){ // 현재 비밀번호 확인
	pwdLabelold.innerHTML = " ";
	const userPwd = "<%= loginUser.getUserPwd() %>";
	
	 
	 if ( loginpw1.value == userPwd) {
		 pwdLabelold.innerHTML = "(현재 비밀번호가 일치합니다.)";
		 pwdLabelold.style.color = "green";
		 pwdLabelold.style.fontSize = "12px";
	} else {
		 pwdLabelold.innerHTML = "(현재 비밀번호가 일치하지 않습니다.)";
		 pwdLabelold.style.color = "red";
		 pwdLabelold.style.fontSize = "12px";
	}
}
</script>
    
    <%@ include file="/views/common/footerView.jsp" %>
<%@ include file="/views/musicPlayer/playerView.jsp" %>      

</body>
</html>