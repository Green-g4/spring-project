<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@ include file="/resources/header/Spheader.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link href="/resources/main/main.css?after" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>NEOTREE</title>
</head>
<body>
검색해서 나오는 product 리스트입니다
<div>
    ${list}
</div>
<div>
    ${pageMaker}
</div>
<%@ include file="/resources/footer/footer.jsp"%>
</body>
</html>
