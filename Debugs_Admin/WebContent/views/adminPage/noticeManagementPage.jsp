<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.*, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/debugsAdminDashboard.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<%@ include file="/views/common/menubar.jsp" %>
	
	<!-- 메인시작 -->
  <main id="main-container">
      <div class="side-section"></div>
      <div class="main-section">
        <div class="main-title"><h1>공지사항 관리</h1></div>
        <div class="main-btn">
            <button type="button" id="enrollnotice"><div>등록</div></button>
            <button type="button" id="deletenotice"><div>선택 삭제</div></button>
        </div>
        <div class="main-content">
          <table>
            <thead>
              <th width="50px" height="50px"><input type="checkbox" id="selectAll" onclick="selectAll();"></input></th>
              <th width="100px">번호</th>
              <th width="600px">제목</th>
              <th width="800px">내용</th>
              <th width="500px">카테고리</th>
            </thead>
            <tbody>
            <% if(list.isEmpty()) { %>
					<tr>
						<td colspan="5">조회된 리스트가 없습니다.</td>
					</tr>
			<% } else {%>
				<% for(Notice n : list) { %>
					<tr>
						<td id="noticecheckbox"><input type="checkbox" name="check-btn" value="<%= n.getNoticeNo() %>"></td>
						<td><%= n.getNoticeNo() %></td>
						<td><%= n.getNoticeTitle() %></td>
						<% if(n.getNoticeContent().length() > 20) { %>
							<td><%= n.getNoticeContent().substring(0, 20) %>...</td>
						<% } else { %>
							<td><%= n.getNoticeContent() %></td>		
						<% } %>
						<td><%= n.getCategoryName() %></td>
					</tr>
				<% } %>
			<% } %>
            </tbody>
          </table>
          <br><br>
          <!-- 페이징 바 -->
          <div class="main-pagingbar">
						<% if(currentPage != 1) { %>
							<button onclick="location.href='<%= contextPath%>/notice.ad?currentPage=<%= currentPage - 1 %>'">&lt;</button>
						<% } %>
			
						<% for(int p = startPage; p <= endPage; p++) { %>
							<% if(p != currentPage) { %>
								<button onclick="location.href='<%= contextPath%>/notice.ad?currentPage=<%= p %>'"><%= p %></button>
							<% } else { %>
								<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔 -->
								<button disabled><%= p %></button>
							<% } %>
						<% } %>
			
						<% if(currentPage != maxPage) { %>
							<button onclick="location.href='<%= contextPath %>/notice.ad?currentPage=<%= currentPage + 1 %>'">&gt;</button>
						<% } %>
         </div>  
        </div>
      </div>  
  </main>
  <!-- 메인 끝 -->
 
   <!-- 공지사항 등록 모달창 -->
   <div class="notice-enroll-modal">
    <div class="notice-enroll-modal-body">
      <button id="notice-out">X</button>
      <form action="<%= contextPath %>/insertnotice.ad" method="post">
        <h2>공지사항 등록</h2>
        <!-- 공지사항 등록 폼 -->
        <table id="motice-modal-table">
          <tr>
            <th><label for="notice-category" style="text-align:left;">분류</label></th>
            <td id="selectOption">
              <select id="notice-category-option" name="notice-category">
              </select>
            </td>
          </tr>
          <tr>
            <td colspan="2" style="text-align: left;"><label>제목</label></td>
          </tr>
          <tr>
            <td colspan="2" style="text-align: left;"><textarea name="notice-title" id="notice-title" cols="53" rows="15"></textarea></td>
          </tr>
          <tr>
            <td colspan="2" style="text-align: left;"><label>내용</label></td>
          </tr>
          <tr>
            <td colspan="2" style="text-align: left;"><textarea name="notice-content" id="notice-content" cols="53" rows="15"></textarea></td>
          </tr>
        </table>
        <br>
        <!-- 공지사항 등록 버튼 -->
        <button type="submit" id="motice-enroll">등록</button>
      </form>
    </div>
  </div>

  <!-- 공지사항 삭제 모달창 -->
  <div class="notice-delete-modal">
    <div class="notice-delete-modal-body">
      <button id="notice-delete-out">X</button>
      <form action="<%= contextPath %>/deletenotice.ad" method="post">
      <input type="hidden" name="noticeNo">
        <h2>정말 삭제하시겠습니까?</h2>
        <!-- 관리자 삭제 버튼 -->
        <button type="submit" id="motice-delete">삭제</button>
      </form>
    </div>
  </div>

  <script>
    function selectAll(){
            const checked = document.getElementById("selectAll").checked; // true : 체크, false : 미선택

            const categorys = document.getElementsByName("check-btn");

            categorys.forEach(function(item){
                item.checked = checked;
            });
        }
     // 전체선택버튼과 각각의 체크박스들 연동

     const categorys = document.getElementsByName("check-btn");
        const selectAllBtn = document.querySelector("#selectAll");
        
        categorys.forEach(function(item){
            item.onclick = onOff;
        });

        function onOff(){   
            // 전체선택이 체크되었을때는 '모든' 카테고리 체크박스가 체크된 상태일때만 가능하다.
            // 선택된 체크박스의 길이 == 전체 체크박스의 길이 ==> true일시 전체선택버튼에 불이 들어오게 작업
            const checkedLength = document.querySelectorAll("input[name=check-btn]:checked").length;

            if(checkedLength == categorys.length){
                selectAllBtn.checked = true;
            } else{
                selectAllBtn.checked = false;
            }
          }    

    // 관리자 생성 모달 관련 스트립트
    const enrollBodyModal = document.querySelector('.notice-enroll-modal-body');
    const enrollModal = document.querySelector('.notice-enroll-modal');
    const noticeDeleteModal = document.querySelector('.notice-delete-modal');
    const noticeDeletBody = document.querySelector('.notice-delete-modal-body');
    const enrollNotice = document.querySelector('#enrollnotice');
    const deleteNotice = document.querySelector('#deletenotice');
    const noticeOut = document.querySelector('#notice-out');
    const noticeDeleteOut = document.querySelector('#notice-delete-out');

    // 생성
    enrollNotice.addEventListener('click', () => {
    	
    	$.ajax({
			url : "<%= contextPath %>/selectcategorylist.ad",
			success : function(result){
				let str = "";
				
				for(let i = 0; i < result.length; i++) {
					str += 
						"<option value=" + result[i].categoryNo + ">" + result[i].categoryName + "</option>";
				}
				$("#notice-category-option").html(str);
			}
		});
    	
      enrollModal.classList.toggle('show');

        if (enrollModal.classList.contains('show')) {
          enrollBodyModal.style.overflow = 'hidden';
        }
      });

      enrollModal.addEventListener('click', (event) => {
        if (event.target === enrollModal) {
          enrollModal.classList.toggle('show');

          if (!enrollModal.classList.contains('show')) {
            enrollBodyModal.style.overflow = 'auto';
          }
        }
      });

      // 삭제
      deleteNotice.addEventListener('click', () => {
    	  
    	  var checkboxes = document.getElementsByName('check-btn');
    	  var vals = [];
    	  for (var i=0, n = checkboxes.length; i<n; i++) {
    	      if (checkboxes[i].checked) {
    	          vals.push(checkboxes[i].value);
    	      }
    	  }
    	  if (vals.length === 0) {
    		  alert("삭제할 공지사항을 체크해주세요");
    		  return;
    	  }
    	  document.getElementsByName('noticeNo')[0].value = vals.join(",");
    	  
        noticeDeleteModal.classList.toggle('show');

        if (noticeDeleteModal.classList.contains('show')) {
          noticeDeletBody.style.overflow = 'hidden';
        }
      });

      noticeDeleteModal.addEventListener('click', (event) => {
        if (event.target === noticeDeleteModal) {
          noticeDeleteModal.classList.toggle('show');

          if (!noticeDeleteModal.classList.contains('show')) {
            noticeDeletBody.style.overflow = 'auto';
          }
        }
      });

    // 모달창 바깥쪽 클릭시 없어짐
      noticeOut.addEventListener('click', () => {
        enrollModal.classList.remove('show');
        enrollBodyModal.style.overflow = 'auto';
      });

      noticeDeleteOut.addEventListener('click', () => {
        noticeDeleteModal.classList.remove('show');
        noticeDeletBody.style.overflow = 'auto';
      });
  </script>

</body>
</html>