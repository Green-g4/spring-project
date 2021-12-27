<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/admin/adminEnroll.css">

	<script
			src="https://code.jquery.com/jquery-3.4.1.js"
			integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
			crossorigin="anonymous"></script>
</head>
</head>
<body>

<%@ include file="/resources/header/Adminheader.jsp"%>

<div class="admin_content_wrap">
	<div class="admin_content_subject"><span>관리자 등록</span></div>
	<div class="admin_content_main">
		<form action="/admin/adminEnroll.do" method="post" id="enrollForm">
			<div class="form_section">
				<div class="form_section_title">
					<label>관리자 이름</label>
				</div>
				<div class="form_section_content">
					<input name="authorName">
					<span id="warn_authorName">관리자 이름을 입력 해주세요.</span>
				</div>
			</div>
		</form>
		<div class="btn_section">
			<button id="cancelBtn" class="btn">취 소</button>
			<button id="enrollBtn" class="btn enroll_btn">등 록</button>
		</div>
	</div>
</div>

<%@ include file="/resources/footer/footer.jsp"%>

<script>

	/* 등록 버튼 */
	$("#enrollBtn").click(function(){
		/* 검사 통과 유무 변수 */
		let nameCheck = false;			// 작가 이름

		/* 입력값 변수 */
		let authorName = $('input[name=authorName]').val();		// 작가 이름
		/* 공란 경고 span태그 */
		let wAuthorName = $('#warn_authorName');

		/* 작기 이름 공란 체크 */
		if(authorName ===''){
			wAuthorName.css('display', 'block');
			nameCheck = false;
		} else{
			wAuthorName.css('display', 'none');
			nameCheck = true;
		}

		/* 최종 검사 */
		if(nameCheck){
			$("#enrollForm").submit();
		} else{
			return;
		}

	});

	/* 취소 버튼 */
	$("#cancelBtn").click(function(){
		location.href="/admin/adminManage"
	});

</script>

</body>
</html>