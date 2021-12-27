<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="../resources/css/admin/adminDetail.css">

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
        <input class="input_block" name="authorName" readonly="readonly" value="<c:out value='${authorInfo.authorName }'></c:out>" >
      </div>
    </div>
    <div class="btn_section">
      <button id="cancelBtn" class="btn">관리자 목록</button>
      <button id="modifyBtn" class="btn modify_btn">수 정</button>
    </div>
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

  /* 작가 관리 페이지 이동 버튼 */
  $("#cancelBtn").on("click", function(e){

    e.preventDefault();

    $("input[name=authorId]").remove();
    moveForm.attr("action", "/admin/adminManage")
    moveForm.submit();

  });

  /* 작가 수정 페이지 이동 버튼 */
  $("#modifyBtn").on("click", function(e){

    e.preventDefault();

    moveForm.attr("action", "/admin/adminModify");
    moveForm.submit();

  });

</script>

</body>
</html>