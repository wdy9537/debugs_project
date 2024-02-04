<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DEBUGS</title>
    <link rel="shortcut icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
       <link rel="icon" href="resources/img/common/파비콘후보2.ico" type="image/x-icon" />
<style>

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

.checkbox_group{
     top: 40px;
}


.loginbox{
    width: 600px; height: 480px;
    margin: 0 auto; /* 블록요소를 부모영역에서 가운데 처리 */
    margin-bottom: 30px;
    
     
}
.loginbox h2{
    width: 100%; /* 부모영역을 상속 */

    /* 한줄텍스트인 경우만 height와 line-height가 같으면 세로 가운데 처리 */
    height: 100px; line-height: 100px;
    text-align: center; font-size: 20px;
    font-weight: normal;
}
.loginbox form{
    width: 100%; height: 700px;
    background-color: #fff;
    /* 패딩수치를 인사이드 처리 */
    padding: 0px; box-sizing: border-box;
    border: 1px solid gray;
    position: relative;
    top:5%;
}
.loginbox fieldset{
    border: none; /* 테두리 제거 */ 
}
.loginbox legend{
    /* 요소를 화면 밖으로 처리 */
    position: absolute; left: -999em;

    /* 웹접근성으로 스크린리더기가 읽어줘야 하므로 display: none;을 사용하지 말것 */
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

.loginbox table { /*회원가입 동의서 밑에 글씨부분 가운데로 설정 해주는 기능*/
    margin: 0 auto; /* 블록요소가 부모 영역에서 가운데 오기 */
    border: 0px solid black;
}


.checkbox-size { /*체크박스 랑 옆에 글씨 크기 설행주는 기능*/
    
    width: 20px;
    height : 20px;
    border : 2px;
}


</style>


</head>
<body>
      
      <%@ include file="/views/common/headerView.jsp" %>

      <div class="loginbox" >
     
 
        <form id="enroll-form" action="enrollForm2.me" method="post">
      <!--작성하지 않아도 문제는 없음-->
    <!-- <input type="checkbox" id="check_all">  
    <label for="check_all">체크해주세요</label> -->
    <div class="checkbox_group">

        <h2><strong>회원가입 동의서</strong></h2>
         <br>
        <table  align="center"  >
            <tr>
                <td><input type="checkbox" id="check_all"  class="checkbox-size" name = 'chk[]' onclick="isAllCheck(this.name, 'chkAll');"required></td>
                <td  width="300px"><label for="check_all"><strong style="color:#E391A4">(필수)</strong style="color:#181818">이용약관</label> </td>
                <td><a href ="">전문보기</a></td>
            </tr>
            <tr>
                <td  colspan="3"> <br></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="check_all" class="checkbox-size"  name = 'chk[]' onclick="isAllCheck(this.name, 'chkAll');"required></td>
                <td><label for="check_all"><strong style="color:#E391A4" >(필수)</strong style="color:#181818">개인정보 수집 및 이용 안내</label> </td>
                <td><a href ="">전문보기</a> </td>
            </tr>
            <tr>
                <td  colspan="3"> <br></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="check_all" class="checkbox-size" name = 'chk[]' onclick="isAllCheck(this.name, 'chkAll');"required></td>
                <td><label for="check_all"><strong style="color:#E391A4" >(필수)</strong style="color:#181818">제 3자 제공 동의</label> </td>
                <td><a href ="">전문보기</a> </td>
            </tr>
            <tr>
                <td  colspan="3"> <br></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="check_all" class="checkbox-size" name = 'chk[]' onclick="isAllCheck(this.name, 'chkAll');"required></td>
                <td><label for="check_all"><strong style="color:#E391A4" >(필수)</strong style="color:#181818">제 3자 제공 동의(선택)</label> </td>
                <td><a href ="">전문보기</a> </td>
            </tr>
            <tr>
                <td  colspan="3"> <br></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="check_all" class="checkbox-size" name = 'chk[]' onclick="isAllCheck(this.name, 'chkAll');"required></td>
                <td><label for="check_all"><strong style="color:#E391A4" >(필수)</strong style="color:#181818">이벤트/혜택 알림 수신 동의</label> </td>
                <td><a href ="">전문보기</a> </td>
            </tr>
            <tr>
                <td  colspan="3"> <br></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="check_all" class="checkbox-size" name = 'chk[]' onclick="isAllCheck(this.name, 'chkAll');" required></td>
                <td><label for="check_all"><strong style="color:#E391A4" >(필수)</strong style="color:#181818">이벤트/혜택 알림 제공을 위한 개인정보 수집 및 이용안내</label> </td>
                <td><a href ="">전문보기</a> </td>
            </tr>
            <tr>
                <td  colspan="3"> <br><hr></td>
            </tr>
           
            <tr>
                <td style="vertical-align: top;"><input type="checkbox" id="check_all" class="checkbox-size"  onclick="allCheckboxes('chk[]', this.checked)"></td>
                <td><label for="check_all" style="color:#929292"><strong style="color:#181818" >전체동의</strong ><br>(선택)이벤트/혜택 알림을 포함하여 모두 둥의합니다.</label> </td>
                <td><a href ="">전문보기</a> </td>
            </tr>
        </table>



        <br><br><br>  
      </div>
  
      <fieldset>
        <!--데이터를 서버로 전송-->
        <button type="submit">다음</button>
        <br>
        
      </fieldset>
    </form>
   </div>	
   <br><br><br><br><br><br><br><br><br><br><br><br>
    <%@ include file="/views/common/footerView.jsp" %>
    <%@ include file="/views/musicPlayer/playerView.jsp" %>

  <script>
//체크박스 전체 선택/해제
  function allCheckboxes(boxNames, chkMode){
	 
    const el = document.getElementsByName(boxNames);
    for(let i = 0; i < el.length; i++){          
     if(!el[i].disabled){
       el[i].checked = chkMode;	
     }
    }
  }

  //전체 체크 여부
  function isAllCheck(boxNames, allChkName){
	  
    const el = document.getElementsByName(boxNames);
    let checkboxCnt = 0;
    let checkedCnt = 0;
    for(let i = 0; i < el.length; i++){
      if(!el[i].disabled){
        checkboxCnt += 1;
        if(el[i].checked){
          checkedCnt += 1;
        }
      }
    }
    
    let chkMode = false;
    //체크박스 개수와 체크 된 체크박스 개수와 일치할 경우
    if(checkboxCnt == checkedCnt){
      chkMode = true;
    } else {  
      chkMode = false;
    }  
    //일치할 경우 천제 체크 박스는 체크, 일치하지 않을 경우 해제
    document.getElementById(allChkName).checked = chkMode;
  }
  
  </script>



</body>
</html>