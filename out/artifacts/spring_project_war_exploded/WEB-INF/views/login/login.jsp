<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <%@ include file="/resources/header/Spheader.jsp" %>
  <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
  <link href="/resources/login/login.css" rel="stylesheet"/>
  <title>로그인 페이지 입니다.</title>
</head>
<body>
<div class="v1_1583">
  <span class="v1_1597">로그인</span>
  <input class="v1_1599" value="아이디"></input>
  <input class="v1_1600" value="비밀번호"></input>
  <a href="#" class="myButton">로그인</a>
  <div class="v1_1601">
    <a href="#" class="v1_1602">아이디 찾기</a>
    <a href="#" class="v1_1603">비밀번호 찾기</a>
    <a href="#" class="v1_1604">회원가입</a>
  </div>
</div>
<%@ include file="/resources/footer/footer.jsp"%>
</body>
</html>