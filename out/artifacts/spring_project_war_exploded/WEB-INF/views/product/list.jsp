<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <%@ include file="/resources/header/Spheader.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link href="/resources/product/product.css?after" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>NEOTREE</title>
</head>
<body>
<c:forEach items="${list}" var="list">
        <td>${list.id}번 상품 정보</td>
        <td>${list.product_name}</td>
        <td>${list.product_price}</td>
        <td>${list.product_discount}</td>
        <td>${list.product_totalprice}</td>
        <td>${list.product_stock}</td>
        <td>${list.product_img}</td>
        <td>${list.product_date}</td>
        </br>
    </tr>
</c:forEach>
<%@ include file="/resources/footer/footer.jsp"%>
</body>
</html>
