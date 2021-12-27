<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <%@ include file="/resources/header/Spheader.jsp" %>
  <title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="/resources/css/event/eventList.css">

</head>
<body>
<div class="main">
  <div class="title">이벤트</div>
  <div class="contents">
    <div class="divTable greenTable">
      <div class="divTableHeading">
        <div class="divTableRow">
          <div class="divTableHead">NO</div>
          <div class="divTableHead">제목</div>
          <div class="divTableHead">등록일자</div>
        </div>
      </div>
      <c:forEach var="v" items="${eventList}" varStatus="status">
        <div class="divTableBody">
          <div class="divTableRow">
            <div class="divTableCell">${status.index+1+(paging.curPage-1)*10}</div>
            <div class="divTableCell">
              <a href="/event/userEventDetail/${v.event_id}">${v.event_title}</a>
            </div>
            <div class="divTableCell">${v.mod_date}</div>
          </div>
        </div>
      </c:forEach>
    </div>

    <div class="greenTable outerTableFooter">
      <div class="tableFootStyle">
        <div class="links">
          <a href="#" onClick="fn_paging(1)">[처음]</a>
          <c:if test="${paging.curPage ne 1}">
            <a href="#" onClick="fn_paging(${paging.prevPage })">[이전]</a>
          </c:if>
          <c:forEach var="pageNum" begin="${paging.startPage }" end="${paging.endPage }">
            <c:choose>
              <c:when test="${pageNum eq  paging.curPage}">
                                <span style="font-weight: bold;">
                                    <a href="#" onClick="fn_paging(${pageNum })" style="font-weight: bold; color:red;">
                                        ${pageNum }
                                    </a>
                                </span>
              </c:when>
              <c:otherwise>
                <a href="#" onClick="fn_paging(${pageNum })">${pageNum }</a>
              </c:otherwise>
            </c:choose>
          </c:forEach>
          <c:if test="${paging.curPage ne paging.pageCnt && paging.pageCnt > 0}">
            <a href="#" onClick="fn_paging(${paging.nextPage })">[다음]</a>
          </c:if>
          <c:if test="${paging.curRange ne paging.rangeCnt && paging.rangeCnt > 0}">
            <a href="#" onClick="fn_paging(${paging.pageCnt })">[끝]</a>
          </c:if>
        </div>
      </div>
    </div>

    <div class="bottomtext">
      총 게시글 수 : ${paging.listCnt } /    총 페이지 수 : ${paging.pageCnt } / 현재 페이지 : ${paging.curPage } / 현재 블럭 : ${paging.curRange } / 총 블럭 수 : ${paging.rangeCnt }
    </div>

  </div>
</div>

<%@ include file="/resources/footer/footer.jsp"%>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
  function fn_paging(curPage){
    location.href="/event/eventList?curPage="+curPage;
  }
  function eventpush(event_id){
    alert(event_id);
  }
</script>
</html>

