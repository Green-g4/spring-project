<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/admin/adminModify.css">

	<script
			src="https://code.jquery.com/jquery-3.4.1.js"
			integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
			crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/resources/header/Adminheader.jsp"%>
<div class="admin_content_wrap">
	<div class="admin_content_subject"><span>관리자 상세</span></div>
	<div class="admin_content_main">
		<form id="modifyForm" action="/admin/adminModify" method="post">
			<div class="form_section">
				<div class="form_section_title">
					<label>관리자 번호</label>
				</div>
				<div class="form_section_content">
					<input class="input_block" name="authorId" readonly="readonly" value="<c:out value='${authorInfo.authorId }'></c:out>">
				</div>
			</div>
			<div class="form_section">
				<div class="form_section_title">
					<label>관리자 이름</label>
				</div>
				<div class="form_section_content">
					<input name="authorName" value="<c:out value='${authorInfo.authorName }'></c:out>" >
					<span id="warn_authorName">관리자 이름을 입력 해주세요.</span>
				</div>
			</div>
			<div class="btn_section">
				<button id="cancelBtn" class="btn">취소</button>
				<button id="modifyBtn" class="btn modify_btn">수 정</button>
				<button id="deleteBtn" class="btn delete_btn">삭 제</button>
			</div>
		</form>
	</div>
</div>

<form id="moveForm" method="get">
	<input type="hidden" name="authorId" value='<c:out value="${authorInfo.authorId }"/>'>
	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
	<input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>' >
	<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
</form>
<%@ include file="/resources/footer/footer.jsp"%>

<script>

	let moveForm = $("#moveForm");
	let modifyForm = $("#modifyForm");




	/* 작가 상세 페이지 이동 버튼 */
	$("#cancelBtn").on("click", function(e){

		e.preventDefault();

		moveForm.attr("action", "/admin/adminDetail")
		moveForm.submit();

	});

	/* 삭제 버튼 */
	$("#deleteBtn").on("click", function(e){
		e.preventDefault();
		moveForm.find("input").remove();
		moveForm.append('<input type="hidden" name="authorId" value="${authorInfo.authorId}">');
		moveForm.attr("action", "/admin/adminDelete");
		moveForm.attr("method", "post");
		moveForm.submit();
	});

	/* 작가 수정 버튼 작동 및 유효성 검사 */
	$("#modifyBtn").on("click", function(e){

		let authorName = $(".form_section_content input[name='authorName']").val();

		let	nameCk = false;

		e.preventDefault();

		if(!authorName){
			$("#warn_authorName").css("display", "block");
		} else {
			$("#warn_authorName").css("display", "none");
			nameCk = true;
		}

		if(nameCk){
			modifyForm.submit();
		} else {
			return false;
		}


	});




</script>

</body>
</html>