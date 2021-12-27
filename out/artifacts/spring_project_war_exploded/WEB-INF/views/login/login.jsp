<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <%@ include file="/resources/header/Spheader.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
    <link href="/resources/css/login/login.css" rel="stylesheet" />
    <title>로그인 페이지 입니다.</title>
    <script src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
</head>

<body>
<div class="v1_1583">
    <span class="v1_1597">로그인</span>
    <form id="login_form" method="post">
        <input class="v1_1599" name="member_id" placeholder="아이디"></input>
        <input type="password" class="v1_1600" name="member_password" placeholder="비밀번호"></input>
        <c:if test="${result == 0 }">
            <div class="login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
        </c:if>
        <c:if test="${result == 1 }">
            <div class="login_warn">사용자 ID 또는 비밀번호를 누락하였습니다.</div>
        </c:if>
        <button class="myButton">로그인</button>
    </form>

    <div class="v1_1601">
        <a href="/login/findId" class="v1_1602">아이디 찾기</a>
        <a href="/login/findPw" class="v1_1603">비밀번호 찾기</a>
        <a href="/login/join" class="v1_1604">회원가입</a>
    </div>
</div>
<script>
    /* 로그인 버튼 클릭 메서드 */
    $(".myButton").click(function () {
        // alert("로그인 버튼 작동");
        /* 로그인 메서드 서버 요청 */

        $("#login_form").attr("action", "/login/login");
        $("#login_form").submit();


    });
</script>
<%@ include file="/resources/footer/footer.jsp"%>
</body>

</html>