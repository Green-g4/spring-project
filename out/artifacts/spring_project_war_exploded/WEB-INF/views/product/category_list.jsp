<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <%@ include file="/resources/header/Spheader.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link href="/resources/css/product/product.css?after" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>NEOTREE</title>
</head>
<body>
    <div class="main">
        <a href="/product/category_list"><span class="all_item">ALL ITEMS</span></a>
        <span class="item_intro">전체 상품을 소개합니다</span>
        <div class="category_div">
            <form id="all_digital_homeapp" action="/product/category_list1" method="get" name="digital_homeapp">
            <span class="cate1">디지털/가전</span>
            </form>
            <form id="all_life_health" action="/product/category_list2" method="get" name="life_health">
            <span class="cate2">생활/건강</span>
            </form>
            <form id="all_sports_leisure" action="/product/category_list3" method="get" name="sports_leisure">
            <span class="cate3">스포츠/레저</span>
            </form>
        </div>
        <div class="category_down">
            <span class="downcate1">누적판매순</span>
            <form id="price_desc" action="" method="get" name="price_desc">
            <span class="downcate2">가격높은순</span>
            </form>
            <form id="price_asc" action="" method="get" name="price_asc">
            <span class="downcate3">가격낮은순</span>
            </form>
            <span class="downcate4">리뷰많은순</span>
        </div>
        <div class="productlist con">
            <ul class="row">
                <c:forEach items="${list}" var="list">
                    <li class="cell_01">
                        <div class="img-box" data-id="${list.imageList[0].id}" data-path="${list.imageList[0].uploadPath}" data-uuid="${list.imageList[0].uuid}" data-filename="${list.imageList[0].fileName}">
                            <a href="/product/goodsDetail/${list.id}">
                                <img>
                            </a>
                        </div>
                        <div class="product-name">${list.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list.product_price}" pattern="#,###" /></div>
                    </li>
                </c:forEach>
                <c:forEach items="${list1}" var="list1">
                    <li class="cell_02">
                        <div class="img-box" data-id="${list1.imageList[0].id}" data-path="${list1.imageList[0].uploadPath}" data-uuid="${list1.imageList[0].uuid}" data-filename="${list1.imageList[0].fileName}">
                            <a href="/product/goodsDetail/${list1.id}">
                                <img>
                            </a>
                        </div>
                        <div class="product-name">${list1.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list1.product_price}" pattern="#,###" /></div>
                    </li>
                </c:forEach>
                <c:forEach items="${list2}" var="list2">
                    <li class="cell_03">
                        <div class="img-box" data-id="${list2.imageList[0].id}" data-path="${list2.imageList[0].uploadPath}" data-uuid="${list2.imageList[0].uuid}" data-filename="${list2.imageList[0].fileName}">
                            <a href="/product/goodsDetail/${list2.id}">
                                <img>
                            </a>
                        </div>
                        <div class="product-name">${list2.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list2.product_price}" pattern="#,###" /></div>
                    </li>
                </c:forEach>
                <c:forEach items="${list3}" var="list3">
                    <li class="cell_04">
                        <div class="img-box" data-id="${list3.imageList[0].id}" data-path="${list3.imageList[0].uploadPath}" data-uuid="${list3.imageList[0].uuid}" data-filename="${list3.imageList[0].fileName}">
                            <a href="/product/goodsDetail/${list3.id}">
                                <img>
                            </a>
                        </div>
                        <div class="product-name">${list3.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list3.product_price}" pattern="#,###" /></div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="v1_1490">
            <div class="sidebar1">
                <button class="sidebar-button" onclick="">
                    <i class="fas fa-truck fa-5x"></i>
                </button>
                <span class="sidebarText1">운송장 조회</span>
            </div>
            <div class="sidebar2">
                <button class="sidebar-button2" onclick="clip()">
                    <i class="fas fa-share-alt fa-5x"></i>
                </button>
                <span class="sidebarText2">페이지 공유</span>
            </div>
            <div class="sidebar3">
                <button class="sidebar-button3" onclick="">
                    <i class="fas fa-file-alt fa-5x"></i>
                </button>
                <span class="sidebarText3">문의하기</span>
            </div>
        </div>
        <div class="forTheTop">
            <div class="forTheTopArrow" onclick="window.scrollTo(0,0);"><i class="fas fa-arrow-up"></i></div>
        </div>

        <div class="pageMaker_wrap">
            <ul class="pageMaker">
                <!-- 이전 버튼 -->
                <c:if test="${pageMaker.prev }">
                    <li class="pageMaker_btn prev">
                        <a href="${pageMaker.pageStart -1}">&#10094;</a>
                    </li>
                </c:if>
                <!-- 페이지 번호 -->
                <c:forEach begin="${pageMaker.pageStart }" end="${pageMaker.pageEnd }" var="num">
                    <li class="pageMaker_btn ${pageMaker.cri.pageNum == num ? 'active':''}">
                        <a href="${num}">${num}</a>
                    </li>
                </c:forEach>
                <!-- 다음 버튼 -->
                <c:if test="${pageMaker.next}">
                    <li class="pageMaker_btn next">
                        <a href="${pageMaker.pageEnd + 1 }">&#10095;</a>
                    </li>
                </c:if>
            </ul>
        </div>
        <form id="moveForm" action="/product/category_list" method="get" >
            <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
            <input type="hidden" name="amount" value="${pageMaker.cri.amount}">
            <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
        </form>
    </div>
    <%@ include file="/resources/footer/footer.jsp"%>
    <script type="text/javascript">
        $(document).ready(function (){
            /* 이미지 삽입 */
            $(".img-box").each(function(i, obj){

                const bobj = $(obj);

                const uploadPath = bobj.data("path");
                const uuid = bobj.data("uuid");
                const fileName = bobj.data("filename");

                const fileCallPath = encodeURIComponent(uploadPath + "/s_" + uuid + "_" + fileName);

                $(this).find("img").attr('src', '/product/display?fileName=' + fileCallPath);
            });

            let a = window.location.pathname
            $('#moveForm').attr("action",a)
            $('.cate1').mouseenter(function (){
                $('.cate1').css("color","black")
                $('.cate1').css("text-decoration","underline")
                $('.category_down').css("left","430")
                $('.category_down').css("display","flex")
                $('#price_desc').attr("action","/product/category_desc1")
                $('#price_asc').attr("action","/product/category_asc1")
                $('.hideValue2').val(a)
            })
            $('.cate1').mouseleave(function (){
                $('.cate1').css("color",'rgba(159, 157, 157, 1)')
                $('.cate1').css("text-decoration","none")
            })
            $('.cate1').click(function (e){
                $('.category_down').css("left","430")
                $('.category_down').css("display","flex")
                $('#all_digital_homeapp').submit()
            })
            $('.cate2').mouseenter(function (){
                $('.cate2').css("color","black")
                $('.cate2').css("text-decoration","underline")
                $('.category_down').css("left","731")
                $('.category_down').css("display","flex")
                $('#price_desc').attr("action","/product/category_desc2")
                $('#price_asc').attr("action","/product/category_asc2")
            })
            $('.cate2').mouseleave(function (){
                $('.cate2').css("color",'rgba(159, 157, 157, 1)')
                $('.cate2').css("text-decoration","none")
            })
            $('.cate2').click(function (e){
                $('.category_down').css("left","731")
                $('.category_down').css("display","flex")
                $('#all_life_health').submit()
                console.log($('.hideValue').val())
            })
            $('.cate3').mouseenter(function (){
                $('.cate3').css("color","black")
                $('.cate3').css("text-decoration","underline")
                $('.category_down').css("left","1040")
                $('.category_down').css("display","flex")
                $('#price_desc').attr("action","/product/category_desc3")
                $('#price_asc').attr("action","/product/category_asc3")
                console.log($('.hideValue2').val())
            })
            $('.cate3').mouseleave(function (){
                $('.cate3').css("color",'rgba(159, 157, 157, 1)')
                $('.cate3').css("text-decoration","none")
            })
            $('.cate3').click(function (e){
                $('.category_down').css("left","1040")
                $('.category_down').css("display","flex")
                $('#all_sports_leisure').submit()
                console.log($('.hideValue').val())
            })
            $('.category_down').mouseenter(function (){
                $('.category_down').css("display","flex")
            })
            $('.category_down').mouseleave(function (){
                $('.category_down').css("display","none")
            }) //카테고리 hover

            $("#price_desc").click(function (){
              $("#price_desc").submit()
            })
            $("#price_asc").click(function (){
                $("#price_asc").submit()
            })
        })
        let moveForm = $('#moveForm');
        $(".pageMaker_btn a").on("click", function(e){
            e.preventDefault();
            moveForm.find("input[name='pageNum']").val($(this).attr("href"));
            moveForm.submit();
        });
        $(function (){
            let $win = $(window)
            let top = $(window).scrollTop();

            let speed = 500
            let easing = 'linear' //linear,swing
            let $layer = $('.v1_1490')
            let $topLayer = $('.forTheTop')
            let layerTopOffset = 0 //px

            $layer.css('position','relative').css('z-index','1')
            $topLayer.css('position','relative').css('z-index','1')

            if(top > 0){ // 스크롤바를 내리고 새로고침을 했을 경우 대비
                $win.scrollTop(layerTopOffset + top)
            }else{
                $win.scrollTop(0)
            }

            //스크롤이벤트
            $(window).scroll(function (){
                yPosition = $win.scrollTop() - 10
                yPosition2 = $win.scrollTop()
                if (yPosition < 0){
                    yPosition = 0
                }
                if(yPosition2 < 0){
                    yPosition2 = 0
                }
                $layer.animate({"top":yPosition},{duration : speed, easing:easing, queue:false})
                $topLayer.animate({"top":yPosition},{duration : speed, easing:easing, queue:false})
            })
        })//사이드바 이동 스크립트 끝

        function clip(){
            let url = '';
            let textarea = document.createElement("textarea");
            document.body.appendChild(textarea);
            url = window.document.location.href;
            textarea.value = url;
            textarea.select();
            document.execCommand("copy");
            document.body.removeChild(textarea);
            alert("URL이 클립보드에 복사되었습니다.")
        }//클립보드에 복사 끝
    </script>
</body>
</html>
