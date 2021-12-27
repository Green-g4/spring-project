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

            //공지사항 신규 등록
            $("#event_regist").on("click",function(){
                var formData = $("#event_form").serialize();
                $.ajax({
                    type : "post",
                    url : "/event/eventInsert",
                    data : formData,
                    success : function(data){
                        if(data==1) alert("등록 완료");
                        else alert('등록 실패');

                    },
                    error : function(error){
                        alert("등록 실패");
                        console.log("event insert fail : "+error);
                    }
                });
            });

            //공지사항 수정
            $("#event_edit").on("click",function(){
                var formData = $("#event_form").serialize();
                $.ajax({
                    type : "post",
                    url : "/event/eventUpdate",
                    data : formData,
                    success : function(data){
                        if(data==1) alert("수정 완료");
                        else alert('수정 실패');
                    },
                    error : function(error){
                        alert("수정 실패");
                        console.log("event update fail : "+error);
                    }
                });
            });

            //공지사항 삭제
            $("#event_delete").on("click",function(){
                var formData = $("#event_form").serialize();
                alert(formData);
                $.ajax({
                    type : "post",
                    url : "/event/eventDelete",
                    data : formData,
                    success : function(data){
                        if(data==1){
                            alert("삭제 완료");
                            location.href="/event/eventList";
                        }else alert('삭제 실패');
                    },
                    error : function(error){
                        alert("삭제 실패");
                        console.log("event delete fail : "+error);
                    }
                });
            });

            $("#event_backPage").on("click",function(){
                location.href="/event/eventList";
            });
        })
    </script>
</head>
<body>
<div class="main">
<div class="big_title">공지사항 수정/삭제/추가</div>
<div class="big_contents">
    <form id="event_form">
        <input type="hidden" id="event_id" name="event_id" value="${event.event_id }">
        <div class="title">
            <div>
                제목
            </div>
            <div>
                <input type="text" id="event_title" name="event_title" value="${event.event_title}">
            </div>
        </div>

        <div class="contents">
            <div>
                내용
            </div>
            <div>
                <textarea id="event_coments" name="event_coments">${event.event_coments}</textarea>
            </div>
        </div>
    </form>

    <div class="footer">

        <c:if test="${null eq event }">
            <input type="button" id="event_regist" value="등록">
        </c:if>
        <c:if test="${null ne event }">
            <input type="button" id="event_edit" value="수정">
        </c:if>
        <input type="button" id="event_backPage" value="뒤로">
        <input type="button" id="event_delete" value="삭제">
    </div>

</div>
</div>
<%@ include file="/resources/footer/footer.jsp"%>
</body>
</html>