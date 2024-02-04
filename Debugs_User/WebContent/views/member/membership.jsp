<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DEBUGS</title>
<link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<!-- jQuery library -->
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
    width: 600px; height: 570px;
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
.loginbox form{ /*회원가입 박스 설정 기능*/
    width: 110%; height: 930px;
    background-color: #fff;
    /* 패딩수치를 인사이드 처리 */
    padding: 0px; box-sizing: border-box;
    border: 1px solid gray;
    position: relative;
    top:5%;
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
.loginbox button{ /*아이디 중복확인 버튼 설정 기능*/
    display: block;
    width: 350px; height: 50px;
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    border: none;
    background-color: #E391A4;
    color: #fff; font-size: 14px; font-weight: bold;
   

}
#button2{ /*아이디 중복확인 버튼 설정 기능*/
    display: block;
    /* display: flex; */
    width: 100px; height: 50px;
    margin: 0 auto;
    padding-left: 5px; /* 중복확인 버튼 배열조절*/
    margin-left: 460px; /*중복확인 버튼 오른쪽으로 옮길때 사용*/
    /* margin: 0 auto; */
    border: none;
    background-color: #E391A4;
    color: #fff; font-size: 13px; font-weight: bold;
    position: absolute; /*중복확 버튼 위쪽으로 옮길때 사용 */
    top: 167px; 
    text-align: center;
    justify-content: center; /*박스안에 테스트 가로 정렬*/ 
    align-items: center;/*박스안에 테스트 세로 정렬*/
    
}
#button3{ /*휴대폰 번호확인 버튼설정 기능*/
    display: block;;
    width: 100px; height: 50px;
    padding-left: 5px; /* 중복확인 버튼 배열조절*/
    margin-left: 460px; /*중복확인 버튼 오른쪽으로 옮길때 사용*/
    border: none;
    background-color: #E391A4;
    color: #fff; font-size: 13px; font-weight: bold;
    position: absolute; /*중복확 버튼 위쪽으로 옮길때 사용*/
    justify-content: center;
    top: 735px;
    text-align: center;
    align-items: center;

    
}


    

/* #membershow{
    font-family: "arial";
} */
/* font-family: Pretendard Variable,Pretendard,-apple-system,BlinkMacSystemFont,Roboto,Segoe UI,Helvetica,sans-serif; */
</style>

       
</head>
<body > <!-- onload="onload_proc()" -->
   <%@ include file="/views/common/headerView.jsp" %>
	
	

	<div class="loginbox" >
    <form id="insert-form" action="<%= contextPath %>/insert.me" method="post" onsubmit="return submit_check();">  

    <span style="padding: 5px;" id="membershow"><h2><strong>회원가입 입력</strong></h2></span>
    <!--작성하지 않아도 문제는 없음-->
    <fieldset>
     <legend>회원가입 구역</legend>
     <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>아이디</strong>  &nbsp;&nbsp;&nbsp;<label id="idLabel" > </label></h3>
     <input type="text" id="loginid" name="userId"  placeholder="아이디를 입력해 주세요" style="width: 400px;"  onblur="idCheck_1()" required>
     <button  type="button" id="button2" onclick="idCheck_2()" >중복확인</button>
      
     <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>비밀번호</strong>  &nbsp;&nbsp;&nbsp;<label id="pwdLabel" > </label></h3>
      <input type="password" id="loginpw"  name="userPwd" placeholder="비밀번호를 입력해 주세요" required>
     <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>비밀번호 확인</strong>  &nbsp;&nbsp;&nbsp;</h3>
      <input type="password" id="loginpw2"  placeholder="비밀번호를 확인해 주세요" onblur="idCheck_3()" required>
     
      <label for="loginname">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>이름</strong></label>
      <input type="text" id="loginname" name="userName" placeholder="이름을 입력해 주세요" required>
     
     <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>주민번호</strong>  &nbsp;&nbsp;&nbsp;<label id="ssnLabel" > </label></h3>
      <input type="text" id="loginssn" name="userSsn" placeholder="주민번호를 - 포함해서 입력해 주세요" onblur="ssnCheck()" oninput="userSsn_autoHyphen(this)" required>
     
     <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>이메일</strong>  &nbsp;&nbsp;&nbsp;<label id="emailLabel" > </label></h3>
      <input type="text" id="loginemail" name="userEmail" placeholder="이메일을 입력해 주세요" onblur="emailCheck()" required>
     
     <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>휴대폰 번호</strong>  &nbsp;&nbsp;&nbsp;<label id="phoneLabel" > </label></h3>
      
      <input type="text" id="loginphone" name="userPhone" placeholder="휴대폰 번호를 - 포함해서 입력해 주세요" style="width: 400px;" onblur="phoneCheck_1()" oninput="userPhone_autoHyphen(this)" required>
      <button  type="button" id="button3" onclick="phoneCheck()">번호확인</button>
      <br>
                
      <!--데이터를 서버로 전송-->
      <button type="submit">가입하기</button>
      <br>
     
    </fieldset>
  </form>
 </div>	
 <br><br><br> <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 <%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>
            
<script   type="text/javascript">

var IdMultiCheckFlag = "N";    // 아이디 중복확인용 변수
var HandPhoneCheckFlag = "N";  // 휴대폰번호 번호확인용 변수  
var UserInsertBtnFlag = "N";   // 가입하기 버튼 클릭 확인용 변수 

     function idCheck_1(){ /* 아이디 문자 길이 제한 설정 기능 */
    	 
    	 /* alert ("idCheck_1");  */
         
         idLabel.innerHTML = " ";
     	 let isID = /^[a-z0-9][a-z0-9_\-]{5,19}$/;
   	 
          if (!isID.test(loginid.value)) {
              idLabel.innerHTML = "(6~20자의 영문 소문자, 숫자만 사용 가능합니다.)";
              idLabel.style.color = "red";
              idLabel.style.fontSize = "12px";
              return false;
          } 
     }
     
     function idCheck_2(){ /* 아이디 중복확인 버튼 설정 기능 */
         /* alert ("idCheck_2-1"); */
       
         const $userId = $("#insert-form input[name=userId]");
         
         IdMultiCheckFlag = "N";
                          
         $.ajax(
         {
	       	 url : "<%= contextPath%>/idCheck.me",     
	       	 data : {checkId : $userId.val()},
	       	 success : function(result)
	       	 {
	       	
	       		 /*  alert("idCheck_2  success   result "  +  result);  */ 
	       		 if(result == "0")
	       		 {
	       			 alert("이미 존재하거나, 회원탈퇴한 아이디입니다.");
	       			/* alert ("idCheck_2-2"); */
	       			   $userId.focus(); 
	       	     } 
	       		 else
	       	     {
       	    		 IdMultiCheckFlag = "Y";

       	    		 if ( UserInsertBtnFlag != "Y") {   // 가입하기 버튼 클릭이 아니면 
		       			 if(confirm("사용가능한 아이디 입니다. 사용하시겠습니까??"))
		       	    	 {
		       	    		/* alert ("idCheck_2-3"); */
		       	    		 $userId.attr("readonly",true);
		       	    	 }
		       	    	 else
		       	    	 {
		       	    		 $userId.focus();
		       	    	 }	       				 
	       			 }
	       	     }
	       	 }
	    
	      }); 
     }

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

     function idCheck_3(){ /* 비밀번호 중복확인 & 조건문 설정 기능 */
     	
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
    
     function ssnCheck(){ /* 주민번호 조건문 설정 기능 */
     	
     	ssnLabel.innerHTML = " ";
         var str_ssn =  loginssn.value;
          
         if (str_ssn.length < 14) {
         	ssnLabel.innerHTML = "(주민등록번호는 - 포함 14자리 입니다.)";
         	ssnLabel.style.color = "red";
         	ssnLabel.style.fontSize = "12px";
         	return false;              	
         }
     }
     
     /*  function onload_proc(){
        	loginid.value = "nato01000";
     	loginpw.value = "nato01000";
     	loginpw2.value = "nato01000";
     	loginname.value = "김민재";
     	loginssn.value = "123456-1234567";
     	loginemail.value = "a@a.a";
     	loginphone.value = "010-1234-1234";
     } */
       
     
     function emailCheck(){
     	
     	emailLabel.innerHTML = " ";
         
         var str_email =  loginemail.value;
         var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
         
         if(exptext.test(str_email)==false){
         

 			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
         	emailLabel.innerHTML = "(이메일형식이 올바르지 않습니다.)";
         	emailLabel.style.color = "red";
         	emailLabel.style.fontSize = "12px";

         	return false; 
         }
     }

     function phoneCheck(){ 
        const $userPhone = $("#insert-form input[name=userPhone]");
        HandPhoneCheckFlag = "N";
        
        $.ajax(
        {
	      	 url : "<%= contextPath%>/phoneCheck.me",    
	      	 data : {checkPhone : $userPhone.val()},
	      	 success : function(result)
	      	 {
	      		 if(result == "0")
	      		 {
	      			 alert("가입하신 핸드폰 번호 입니다.");
	      			   $userPhone.focus();  
	      	     } 
	      		 else
	      	     {
      	    		 HandPhoneCheckFlag = "Y";

      	    		 if ( UserInsertBtnFlag != "Y") {   // 가입하기 버튼 클릭이 아니면 
		      	    	 if(confirm("인증되었습니다."))
		      	    	 {
		      	    		 $userPhone.attr("readonly",true);
		      	    		 
		      	    	 }
		      	    	 else
		      	    	 {
		      	    		 $userPhone.focus();
		      	    	 }
	       			 }
	      	     }
	      	  }
   
        });
        
     }

     function phoneCheck_1(){ /* 휴대폰번호 조건문 설정 기능 */
     	phoneLabel.innerHTML = " ";
     
          var str_phone =  loginphone.value;
          
         if (str_phone.length < 13) {
         	phoneLabel.innerHTML = "(휴대폰번호는 - 포함 13자리 입니다.)";
         	phoneLabel.style.color = "red";
         	phoneLabel.style.fontSize = "12px";
         	return false;              	
         } else {
        	 
         }
     } 
     
     
     function submit_check(){   
    	 
//        alert ("IdMultiCheckFlag : " + IdMultiCheckFlag);	
//        alert ("HandPhoneCheckFlag : " + HandPhoneCheckFlag);	

        UserInsertBtnFlag = "Y";   // 가입하기 버튼 클릭시 셋팅 
     	
        if(IdMultiCheckFlag != "Y") {
        	alert ("아이디 중복확인을 하시기 바랍니다.");
        	document.getElementById("button2").focus();
            UserInsertBtnFlag = "N";    // 가입하기 버튼 클릭 상태 초기화 
        	return false;
        }
        
        if(HandPhoneCheckFlag != "Y") {
        	alert ("핸드폰 번호확인을 하시기 바랍니다.");
        	document.getElementById("button3").focus();
            UserInsertBtnFlag = "N";    // 가입하기 버튼 클릭 상태 초기화 
        	return false;
        } 
        
        if( idCheck_2() == false) {  // 아이디 중복확인
            UserInsertBtnFlag = "N";    // 가입하기 버튼 클릭 상태 초기화 
        	return false;
        }
        
        if( phoneCheck() == false) {   // 휴대폰번호 번호확인 
            UserInsertBtnFlag = "N";     // 가입하기 버튼 클릭 상태 초기화 
        	return false;
        }
     } 

     // 주민번호 : 6-7 패턴 및 마스킹 
     const userSsn_autoHyphen = (target) => {
    	 target.value = target.value
    	   .replace(/[^0-9]/g, '')
    	   .replace(/^(\d{6})(\d{1})(\d{6})$/, `$1-$2******`);
    	}
     
     // 휴대폰번호  : 3-4-4 패턴 
     const userPhone_autoHyphen = (target) => {
    	 target.value = target.value
    	   .replace(/[^0-9]/g, '')
    	   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
    	}
</script>
     
</body>
</html>