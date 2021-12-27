<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/resources/header/Spheader.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/event/eventDetail.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script>
        $(document).ready(function(){
            $("#event_backPage").on("click",function(){
                location.href="/event/eventList";
            });
        })
    </script>
</head>
<body>
<div class="main">
<div class="big_title">공지사항</div>
<div class="big_contents">
    <form id="event_form">
        <input type="hidden" id="event_id" name="event_id" value="${event.event_id }">
        <div class="title">
            <div>
                제목
            </div>
            <div>
                <input type="text" id="event_title" name="event_title" value="${event.event_title}" readonly="readonly">
            </div>
        </div>

        <div class="contents">
            <div>
                내용
            </div>
            <div>
                <textarea id="event_coments" name="event_coments" readonly="readonly">${event.event_coments}</textarea>
            </div>
        </div>
    </form>

    <div class="footer">
        <input type="button" id="event_backPage" value="뒤로">

    </div>

</div>
</div>
<%@ include file="/resources/footer/footer.jsp"%>
</body>
</html>