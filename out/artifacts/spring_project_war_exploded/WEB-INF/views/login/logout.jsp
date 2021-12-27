
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <%@ include file="/resources/header/Spheader.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
    <link href="/resources/css/login/logout.css" rel="stylesheet" />
    <title>로그인아웃 페이지 입니다.</title>
</head>

<body>
<div class="v1_1583">
    <span class="v1_1597">로그아웃 되었습니다. </span>
    <button type="button" class="login" onClick="location.href='/login/login'">로그인</button>
    <button type="button" class="main" onClick="location.href='/main/main'">메인페이지</button>
</div>
<%@ include file="/resources/footer/footer.jsp"%>
</body>

</html>