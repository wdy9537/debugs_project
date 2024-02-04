<%@ page import="java.util.ArrayList, com.debugs.adminPage.model.vo.Admin, com.debugs.common.model.vo.PageInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Admin> list = (ArrayList<Admin>)request.getAttribute("list");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>일반관리자 관리</title>
<link rel="stylesheet" href="resources/css/debugsAdminDashboard.css">
</head>
<body>

	<script>
		const msg = "<%= (String)session.getAttribute("alertMsg") %>";
		
		if(msg != "null") {
			alert(msg);
			<% session.removeAttribute("alertMsg"); %>
		}
	</script>
	
	<%@ include file="/views/common/menubar.jsp" %>

		<!-- 메인시작 -->
		<main id="main-container">
			<div class="side-section"></div>
			<div class="main-section">
				<div class="main-title">
					<h1>일반관리자 관리</h1>
				</div>
				<div class="main-btn">
					<button type="button" id="create-admin">
						<div>관리자 생성</div>
					</button>
					<button type="button" id="remove-admin">
						<div>관리자 삭제</div>
					</button>
				</div>
				<div class="main-content">
					<table id="main-table">
						<thead>
							<th width="50px" height="50px"><input type="checkbox"
								id="selectAll" onclick="selectAll();"></input></th>
							<th width="200px">관리자 번호</th>
							<th width="200px">이름</th>
							<th width="300px">아이디</th>
							<th width="350px">비밀번호</th>
							<th width="350px">전화번호</th>
						</thead>
						<tbody>
						<% if(list.isEmpty()) { %>
					<tr>
						<td colspan="6">조회된 리스트가 없습니다.</td>
					</tr>
					<% } else {%>
						<% for(Admin a : list) { %>
							<tr>
								<td id="admincheckbox"><input type="checkbox" name="check-btn" value="<%= a.getAdminNo() %>"></td>
								<td><%= a.getAdminNo() %></td>
								<td><%= a.getAdminName() %></td>
								<td><%= a.getAdminId() %></td>
								<td><%= a.getAdminPwd() %></td>
								<td><%= a.getAdminPhone() %></td>
							</tr>
						<% } %>
					<% } %>
						</tbody>
					</table>
					<br>
					<br>
					<!-- 페이징 바 -->
					<div class="main-pagingbar">
						<% if(currentPage != 1) { %>
							<button onclick="location.href='<%= contextPath%>/admin.ad?currentPage=<%= currentPage - 1 %>'">&lt;</button>
						<% } %>
			
						<% for(int p = startPage; p <= endPage; p++) { %>
							<% if(p != currentPage) { %>
								<button onclick="location.href='<%= contextPath%>/admin.ad?currentPage=<%= p %>'"><%= p %></button>
							<% } else { %>
								<!-- 현재 내가 보고있는 페이지일 경우 클릭이 안되게끔 -->
								<button disabled><%= p %></button>
							<% } %>
						<% } %>
			
						<% if(currentPage != maxPage) { %>
							<button onclick="location.href='<%= contextPath %>/admin.ad?currentPage=<%= currentPage + 1 %>'">&gt;</button>
						<% } %>
					</div>
				</div>
			</div>
		</main>
		<!-- 메인 끝 -->


		<!-- 관리자 생성 모달창 -->
		<div class="admin-modal">
			<div class="admin-modal-body">
				<button id="admin-out">X</button>
			<form action="<%=contextPath%>/insertadmin.ad" method="post">
				<h2>새로운 관리자 생성</h2>
				<!-- 관리자 생성 폼 -->
				<table id="modal-table">
					<tr>
						<td><label for="admin-name">관리자 번호 :</label></td>
						<td><input type="text" id="admin-no" name="admin-no"
							placeholder="내용을 입력하세요" required></td>
					</tr>
					<tr>
						<td><label for="admin-name">이름 :</label></td>
						<td><input type="text" id="admin-name" name="admin-name"
							placeholder="내용을 입력하세요" required></td>
					</tr>
					<tr>
						<td><label for="admin-id">아이디 :</label></td>
						<td><input type="text" id="admin-id" name="admin-id"
							placeholder="내용을 입력하세요" required></td>
					</tr>
					<tr>
						<td><label for="admin-password">비밀번호 :</label></td>
						<td><input type="password" id="admin-password"
							name="admin-password" placeholder="내용을 입력하세요" required></td>
					</tr>
					<tr>
						<td><label for="admin-name">전화번호 :</label></td>
						<td><input type="text" id="admin-phone" name="admin-phone"
							placeholder="내용을 입력하세요" required></td>
					</tr>
				</table>
				<br>
				<!-- 관리자 생성 버튼 -->
				<button type="submit" id="admin-submit">생성</button>
			</form>
		</div>
		</div>
		<!-- 관리자 삭제 모달창 -->
		<div class="delete-modal">
			<div class="delete-modal-body">
				<button id="delete-admin-out">X</button>
				<form name="frmAdmin" action="<%= contextPath %>/deleteadmin.ad" method="post">
				   	<input type="hidden" name="adminNo">
					<h2>정말 삭제하시겠습니까?</h2>
					<!-- 관리자 삭제 버튼 -->
					<button type="submit" id="admin-remove">삭제</button>
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
            // 전체선택이 체크되었을때는 '모든' 카테고리 체크박스가 체크된 상태일때만 가능
            // 선택된 체크박스의 길이 == 전체 체크박스의 길이 ==> true일시 전체선택버튼에 불이 들어오게 작업
            const checkedLength = document.querySelectorAll("input[name=check-btn]:checked").length;

            if(checkedLength == categorys.length){
                selectAllBtn.checked = true;
            } else{
                selectAllBtn.checked = false;
            }
          }
    // 관리자 생성 모달 관련 스트립트
      const adminModalBody = document.querySelector('.admin-modal-body');
      const adminModal = document.querySelector('.admin-modal');
      const deleteModal = document.querySelector('.delete-modal');
      const deleteModalBody = document.querySelector('.delete-modal-body');
      const createAdminBtn = document.querySelector('#create-admin');
      const removceAdminBtn = document.querySelector('#remove-admin');
      const adminOut = document.querySelector('#admin-out');
      const deleteAdminOut = document.querySelector('#delete-admin-out');

    // 생성
      createAdminBtn.addEventListener('click', () => {
        adminModal.classList.toggle('show');

        if (adminModal.classList.contains('show')) {
          adminModalBody.style.overflow = 'hidden';
        }
      });

      adminModal.addEventListener('click', (event) => {
        if (event.target === adminModal) {
          adminModal.classList.toggle('show');

          if (!adminModal.classList.contains('show')) {
            adminModalBody.style.overflow = 'auto';
          }
        }
      });

      // 삭제
      removceAdminBtn.addEventListener('click', () => {
    	  var checkboxes = document.getElementsByName('check-btn');
    	  var vals = [];
    	  for (var i=0, n = checkboxes.length; i<n; i++) {
    	      if (checkboxes[i].checked) {
    	          vals.push(checkboxes[i].value);
    	      }
    	  }
    	  if (vals.length === 0) {
    		  alert("삭제할 관리자를 체크해주세요");
    		  return;
    	  }
    	  document.getElementsByName('adminNo')[0].value = vals.join(",");
    	  
        deleteModal.classList.toggle('show');

        if (deleteModal.classList.contains('show')) {
          deleteModalBody.style.overflow = 'hidden';
        }
      });

      deleteModal.addEventListener('click', (event) => {
        if (event.target === moddeleteModalal) {
          deleteModal.classList.toggle('show');

          if (!deleteModal.classList.contains('show')) {
            deleteModalBody.style.overflow = 'auto';
          }
        }
      });

    // 모달창 바깥쪽 클릭시 없어짐
      adminOut.addEventListener('click', () => {
        adminModal.classList.remove('show');
        adminModalBody.style.overflow = 'auto';
      });

      deleteAdminOut.addEventListener('click', () => {
        deleteModal.classList.remove('show');
        deleteModalBody.style.overflow = 'auto';
      });
  </script>

</body>
</html>
