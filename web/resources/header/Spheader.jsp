<html>
<head>
    <meta charset="utf-8">
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
            integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
            crossorigin="anonymous"
    />
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
    <link href="/resources/header/main.css?after" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>메인 페이지 입니다</title>
</head>
<body>



<div class="v42_255">
    <div class="v42_239"></div>
    <div class="v42_240"></div>
    <form id="digital_homeapp" action="/product/category_list" method="get" name="digital_homeapp">
        <span class="v42_250">디지털/가전</span>
        <input type="hidden" name="digital/homeapp" value="digital/homeapp">
    </form>
    <form id="life_health" action="/product/category_list2" method="get" name="life_health">
        <span class="v42_251">생활/건강</span>
        <input type="hidden" name="life/health" value="life/health">
    </form>
    <form id="sports_leisure" action="/product/category_list3" method="get">
        <span class="v42_252">스포츠/레저</span>
        <input type="hidden" name="sports/leisure" value="sports/leisure" name="sports_leisure">
    </form>
    <form id="product_event" action="/event/eventList" method="get">
        <span class="v42_253">이벤트</span>
        <input type="hidden" name="product/event" value="product/event" name="product_event">
    </form>
    <form id="notice" action="/notice/notice" method="get">
        <span class="v42_254">공지사항</span>
        <input type="hidden"  name="notice">
    </form>


    <span class="v42_241"> <a href="/main/main" class="logo_button_underlineNone">NEOTREE</a></span>
    <div class="v42_242">
        <form id="searchForm" action="/search/search" method="get" name="searchForm">
            <input type="text" name="keyword" class="search" placeholder="검색어를 입력해주세요" />
            <button class="img-button" type="submit" name="click">
                <i class="fas fa-search"></i>
            </button>
        </form>
    </div>


    <span class="loginId"> <%= session.getAttribute("signedUser")  %>님 <br>반갑습니다.</span>

    <%--    <span class="v42_243" id="login"><a href="/login/login" class="login_button_underlineNone">로그인</a></span>--%>
    <%--    <span class="v42_243" id="logout"><a href="/login/logout" class="login_button_underlineNone">로그아웃</a></span>--%>
    <span class="v42_243"><a href="/login/login" class="login_button_underlineNone"></a></span>
    <span class="v42_244"><a href="/login/join" class="register_button_underlineNone">회원가입</a></span>
    <span class="v42_245"><a href="/cart/list" class="cart_button_underlineNone">장바구니</a></span>

</div>
<script>
    function enterPress(f){
        if(f.keyCode == 13){
            searchForm.submit();
        }
    }
    var loginId = $(".loginId").text();
    var idx = loginId.indexOf("님");
    loginId = String(loginId.substring(0, idx));

    $(document).ready(function (){
        $(".v42_245 a").click(function (){
            if(loginId.includes("null")){
                alert("로그인 후 장바구니를 이용해주세요.")
                $(".v42_245 a").attr("href", "/main/main");
            }

            $(".v42_245 a").attr("href", "/cart/cart");
        })

        $("#logout a").css("top","2000px").hide();

        $(".v42_250").click(function (e){
            digital_homeapp.submit();
        })
        $(".v42_251").click(function (e){
            life_health.submit();
        })
        $(".v42_252").click(function (e){
            sports_leisure.submit();
        })
        $(".v42_253").click(function (e){
            product_event.submit();
        })
        $(".v42_254").click(function (e){
            notice.submit();
        })

        if(!loginId.includes("null")){
            $(".v42_243 a").text("로그아웃")
            $(".v42_243 a").attr("href", "/login/logout")


        }else{
            $(".v42_243 a").text("로그인")
            $(".loginId").css("top","2000px")
            $(".loginId").hide()
        }
        // if(!loginId.includes("null")){
        //     $("#login a").css("top","2000px")
        //     $("#login a").hide();
        //     $("#logout a").show();
        // }else{
        //     $(".loginId").css("top","2000px")
        //     $(".loginId").hide()
        // }
    })
</script>
</body>
</html>