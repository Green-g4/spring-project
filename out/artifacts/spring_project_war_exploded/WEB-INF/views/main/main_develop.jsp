<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.14.0/css/all.css"
            integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc"
            crossorigin="anonymous"
    />
    <%@ include file="/resources/header/Spheader.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet"/>
    <link href="/resources/css/main/main_develop.css?after" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>NEOTREE</title>
</head>
<body>
<div class="v1_1356">
    <div class="v1_1357"></div>
    <span class="v1_1358">BEST ITEM</span><span class="v1_1359">ALL ITEMS</span><span class="v1_1360">NEW ITEM</span>
    <span class="v1_1361">최고의 인기상품들을 소개합니다</span><span class="v1_1362">전체 상품들을 소개합니다</span>
    <div class="name"></div>
    <div class="name"></div>
    <div class="name"></div>
    <div class="v1_1583">
        <div class="slide eventpicture active">
            <img src='http://drive.google.com/uc?export=view&id=1oPXYvlElEmHWu_d7wpmNEX9x0Pj8oy3n' /><br>
        </div>
        <div class="slide eventpicture">
            <img src='http://drive.google.com/uc?export=view&id=1CKI5myCbCVUc07r7eFKQCo5HJoZ4PYK7' /><br>
        </div>
        <div class="slide eventpicture">
            <img src='http://drive.google.com/uc?export=view&id=1_YSgo-65i-ppnl9pzpE32nJ8GRc1bQB8' /><br>
        </div>
        <a class="banner_prev" onclick="banner_prevSlide()">&#10094;</a>
        <a class="banner_next" onclick="banner_nextSlide()">&#10095;</a>
    </div>
    <div class="BestItem_div">
        <div class="v1_1367">
            <a class="best_prev" href="#">&#10094;</a>
        </div>
        <div class="v1_1368">
            <a class="best_next" href="#">&#10095;</a>
        </div>
        <div class="BestProduct">
            <c:if test="${listcheck != 'empty'}">
                <ul id="BestRow">
                    <c:forEach items="${list1}" var="list1">
                        <li class="BestLi_1">
                            <div class="img-box">
                                <img src='http://drive.google.com/uc?export=view&id=1hr8qc4m6hc8CgzECImzLQce3O2G5yCEI' alt="" class="BestImg"/><br>
                            </div>
                            <div class="product-name">${list1.product_name}</div>
                            <div class="product-price"><fmt:formatNumber value="${list1.product_price}" pattern="#,###" /></div>
                        </li>
                    </c:forEach>
                    <c:forEach items="${list2}" var="list2">
                        <li class="BestLi_2">
                            <div class="img-box">
                                <img src='http://drive.google.com/uc?export=view&id=1hr8qc4m6hc8CgzECImzLQce3O2G5yCEI' alt="" class="BestImg"/><br>
                            </div>
                            <div class="product-name">${list2.product_name}</div>
                            <div class="product-price"><fmt:formatNumber value="${list2.product_price}" pattern="#,###" /></div>
                        </li>
                    </c:forEach>
                    <c:forEach items="${list3}" var="list3">
                        <li class="BestLi_3">
                            <div class="img-box">
                                <img src='http://drive.google.com/uc?export=view&id=1hr8qc4m6hc8CgzECImzLQce3O2G5yCEI' alt="" class="BestImg"/><br>
                            </div>
                            <div class="product-name">${list3.product_name}</div>
                            <div class="product-price"><fmt:formatNumber value="${list3.product_price}" pattern="#,###" /></div>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>
    <div class="v1_1493">
        <span class="v1_1494">디지털/가전</span><span class="v1_1495">생활/전자</span><span class="v1_1496">스포츠/레저</span>
    </div>
    <div class="v1_1502">
        <span class="v1_1503">디지털/가전</span><span class="v1_1504">생활/전자</span><span class="v1_1505">스포츠/레저</span>
    </div>
    <div class="v1_1490">
        <div class="sidebar1">
            <button class="sidebar-button" onclick="">
                <i class="fas fa-truck fa-5x"></i>
            </button>
            <span class="sidebarText1">운송장 조회</span>
        </div>
        <div class="sidebar2">
            <button class="sidebar-button2" onclick="">
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
    <div class="NewItem_div">
        <div class="productlist conn">
            <c:if test="${listcheck != 'empty'}">
                <ul class="row">
                    <c:forEach items="${list}" var="list">
                        <li class="cell_04">
                            <div class="img-box">
                                <img src='http://drive.google.com/uc?export=view&id=1hr8qc4m6hc8CgzECImzLQce3O2G5yCEI' alt=""/><br>
                            </div>
                        <div class="product-name">${list.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list.product_price}" pattern="#,###" /></div>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>
    <div class="AllItems_div">
        <div class="productlist con">
            <c:if test="${listcheck != 'empty'}">
            <ul class="row">
                <c:forEach items="${list1}" var="list1">
                    <li class="cell_01">
                        <div class="img-box">
                            <img src='http://drive.google.com/uc?export=view&id=1hr8qc4m6hc8CgzECImzLQce3O2G5yCEI' alt=""/><br>
                        </div>
                        <div class="product-name">${list1.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list1.product_price}" pattern="#,###" /></div>
                    </li>
                </c:forEach>
                <c:forEach items="${list2}" var="list2">
                    <li class="cell_02">
                        <div class="img-box">
                            <img src='http://drive.google.com/uc?export=view&id=1hr8qc4m6hc8CgzECImzLQce3O2G5yCEI' alt=""/><br>
                        </div>
                        <div class="product-name">${list2.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list2.product_price}" pattern="#,###" /></div>
                    </li>
                </c:forEach>
                <c:forEach items="${list3}" var="list3">
                    <li class="cell_03">
                        <div class="img-box">
                            <img src='http://drive.google.com/uc?export=view&id=1hr8qc4m6hc8CgzECImzLQce3O2G5yCEI' alt=""/><br>
                        </div>
                        <div class="product-name">${list3.product_name}</div>
                        <div class="product-price"><fmt:formatNumber value="${list3.product_price}" pattern="#,###" /></div>
                    </li>
                </c:forEach>
            </ul>
          </c:if>
        </div>
    </div>
    <div class="v1_1549">
        <div class="v1_1550"></div>
        <span class="v1_1551">더보기</span>
    </div>
    <input class="hideValue" type="hidden" value="digital/homeapp">

</div>
</div>
<%@ include file="/resources/footer/footer.jsp"%>
<script type="text/javascript">
$(document).ready(function (){
    !$(".slide").not(".active").hide(); //첫번째 slide div외에 숨김
    setInterval(banner_nextSlide,5000); //5초마다 다음슬라이드로

    $(".v1_1503").click(function (){
        $(".v1_1504").css('border-bottom','none')
        $(".v1_1504").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1505").css('border-bottom','none')
        $(".v1_1505").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1503").css('border-bottom','2px solid black')
        $(".v1_1503").css('color','black')

        let category_name = "digital/homeapp"
        show_layer(category_name)
    })
    $(".v1_1504").click(function (){
        $(".v1_1503").css('border-bottom','none')
        $(".v1_1503").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1505").css('border-bottom','none')
        $(".v1_1505").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1504").css('border-bottom','2px solid black')
        $(".v1_1504").css('color','black')

        let category_name = "life/health"
        show_layer(category_name)
    })
    $(".v1_1505").click(function (){
        $(".v1_1503").css('border-bottom','none')
        $(".v1_1503").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1504").css('border-bottom','none')
        $(".v1_1504").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1505").css('border-bottom','2px solid black')
        $(".v1_1505").css('color','black')

        let category_name = "sports/leisure"
        show_layer(category_name)
    })
    $(".v1_1494").click(function (){
        $(".v1_1495").css('border-bottom','none')
        $(".v1_1495").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1496").css('border-bottom','none')
        $(".v1_1496").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1494").css('border-bottom','2px solid black')
        $(".v1_1494").css('color','black')

        $('.hideValue').val("digital/homeapp")
        let category_name = "digital/homeapp"
        show_layer2(category_name)
    })
    $(".v1_1495").click(function (){
        $(".v1_1494").css('border-bottom','none')
        $(".v1_1494").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1496").css('border-bottom','none')
        $(".v1_1496").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1495").css('border-bottom','2px solid black')
        $(".v1_1495").css('color','black')

        $('.hideValue').val("life/health")
        let category_name = "life/health"
        show_layer2(category_name)
    })
    $(".v1_1496").click(function (){
        $(".v1_1494").css('border-bottom','none')
        $(".v1_1494").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1495").css('border-bottom','none')
        $(".v1_1495").css('color','rgba(159, 157, 157, 1)')
        $(".v1_1496").css('border-bottom','2px solid black')
        $(".v1_1496").css('color','black')

        $('.hideValue').val("sports/leisure")
        let category_name = "sports/leisure"
        show_layer2(category_name)
    })//카테고리 클릭 시 상품변경 css

    $('.best_next').click(function (){
        let $cateValue = $('.hideValue').val()
        switch ($cateValue){
            case "digital/homeapp":
                moveList('next','BestRow',3,1); return false
                break;

            case "life/health":
                moveList2('next','BestRow',3,1); return false
                break;

            case "sports/leisure":
                moveList3('next','BestRow',3,1); return false
                break;
        }
    })
    $('.best_prev').click(function (){
        let $cateValue = $('.hideValue').val()
        switch ($cateValue){
            case "digital/homeapp":
                moveList('prev','BestRow',3,1); return false
                break;

            case "life/health":
                moveList2('prev','BestRow',3,1); return false
                break;

            case "sports/leisure":
                moveList3('prev','BestRow',3,1); return false
                break;
        }
    })
})

function banner_prevSlide(){ //이전슬라이드
    $(".slide").hide()
    let allSlide = $(".slide")
    let currentIndex = 0

    $(".slide").each(function (index,item){
        if($(this).hasClass("active")){
            currentIndex = index
        }
    })
    let newIndex = 0
    if(currentIndex<=0){
        //현재 슬라이드의 index가 0일경우 마지막 슬라이드로보냄
        newIndex = allSlide.length-1
    }else {
        //현재 슬라이드의 index에서 한칸뒤 index 지정
        newIndex = currentIndex-1
    }
    $(".slide").removeClass("active") //active클래스 제거
    $(".slide").eq(newIndex).addClass("active")
    $(".slide").eq(newIndex).show()
}

function banner_nextSlide(){
    $(".slide").hide()
    let allSlide = $(".slide")
    let currentIndex = 0

    $(".slide").each(function (index,item){
        if($(this).hasClass("active")){
            currentIndex = index
        }
    })
    let newIndex = 0
    if(currentIndex >= allSlide.length-1){ //현재 슬라이드 index가 마지막 순서면 0번째로보냄
        newIndex = 0
    }else { //현재 슬라이드의 index에서 한칸 앞 index 지정
        newIndex = currentIndex+1
    }
    $(".slide").removeClass("active") //active클래스 제거
    $(".slide").eq(newIndex).addClass("active")
    $(".slide").eq(newIndex).show()
} // 이벤트 배너관련 스크립트 끝
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

function show_layer(cell_name){
    switch (cell_name) {
        case "digital/homeapp":
            $(".cell_01").css("display","")
            $(".cell_02").css("display","none")
            $(".cell_03").css("display","none")
            break
        case "life/health":
            $(".cell_01").css("display","none")
            $(".cell_02").css("display","")
            $(".cell_03").css("display","none")
            break
        case "sports/leisure":
            $(".cell_01").css("display","none")
            $(".cell_02").css("display","none")
            $(".cell_03").css("display","")
            break
    }
}// 카테고리클릭 시 상품변경 끝
function show_layer2(cell_name){
    switch (cell_name) {
        case "digital/homeapp":
            $(".BestLi_1").css("display","")
            $(".BestLi_2").css("display","none")
            $(".BestLi_3").css("display","none")
            break
        case "life/health":
            $(".BestLi_1").css("display","none")
            $(".BestLi_2").css("display","")
            $(".BestLi_3").css("display","none")
            break
        case "sports/leisure":
            $(".BestLi_1").css("display","none")
            $(".BestLi_2").css("display","none")
            $(".BestLi_3").css("display","")
            break
    }
}// 카테고리클릭 시 상품변경 끝

// 초기화 initView(ul엘리먼트의 id, 최초 보여지는 li 엘리먼트 갯수, display 값)
function initView(ul_id, view_item_count, style) {
    let menu = document.getElementById('BestRow');
    let menu_list = menu.getElementsByClassName('li');
    let menu_count = menu_list.length;
    style = (typeof(style) != 'undefined') ? style : 'block';

    for(let i=0;i<menu_count;i++){
        if(i<view_item_count) menu_list[i].style.display = style;
        else menu_list[i].style.display = 'none';
    }
}
function moveList(direction, ul_id, view_item_count, scroll_count, style) {
    var menu = document.getElementById('BestRow');
    var menu_list = menu.getElementsByClassName('BestLi_1');
    var menu_count = menu_list.length;
    var start_no = 0;

    style = (typeof(style) != 'undefined') ? style : 'block';

    // 현재 보여지고 있는 엘리먼트의 시작을 확인
    for(var i=0;i<menu_count;i++){
        if(menu_list[i].style.display == style){
            start_no = i;
            break;
        }
    }
    // 방향에 따른 이동
    if(direction == 'next'){
        if(menu_list[menu_count-1].style.display == style) return false;
        else{
            for(var i=0;i<menu_count;i++){
                if(i>=start_no + scroll_count && i<start_no + scroll_count + view_item_count){
                    menu_list[i].style.display = style;
                }else{
                    menu_list[i].style.display = 'none';
                }
            }
        }
    }else if(direction == 'prev'){
        if(menu_list[0].style.display == style) return false;
        else{
            for(var i=0;i<menu_count;i++){
                if(i>=start_no - scroll_count && i<start_no - scroll_count + view_item_count){
                    menu_list[i].style.display = style;
                }else{
                    menu_list[i].style.display = 'none';
                }
            }
        }
    }
}
function moveList2(direction, ul_id, view_item_count, scroll_count, style) {
    var menu = document.getElementById('BestRow');
    var menu_list = menu.getElementsByClassName('BestLi_2');
    var menu_count = menu_list.length;
    var start_no = 0;

    style = (typeof(style) != 'undefined') ? style : 'block';

    // 현재 보여지고 있는 엘리먼트의 시작을 확인
    for(var i=0;i<menu_count;i++){
        if(menu_list[i].style.display == style){
            start_no = i;
            break;
        }
    }
    // 방향에 따른 이동
    if(direction == 'next'){
        if(menu_list[menu_count-1].style.display == style) return false;
        else{
            for(var i=0;i<menu_count;i++){
                if(i>=start_no + scroll_count && i<start_no + scroll_count + view_item_count){
                    menu_list[i].style.display = style;
                }else{
                    menu_list[i].style.display = 'none';
                }
            }
        }
    }else if(direction == 'prev'){
        if(menu_list[0].style.display == style) return false;
        else{
            for(var i=0;i<menu_count;i++){
                if(i>=start_no - scroll_count && i<start_no - scroll_count + view_item_count){
                    menu_list[i].style.display = style;
                }else{
                    menu_list[i].style.display = 'none';
                }
            }
        }
    }
}
function moveList3(direction, ul_id, view_item_count, scroll_count, style) {
    var menu = document.getElementById('BestRow');
    var menu_list = menu.getElementsByClassName('BestLi_3');
    var menu_count = menu_list.length;
    var start_no = 0;

    style = (typeof(style) != 'undefined') ? style : 'block';

    // 현재 보여지고 있는 엘리먼트의 시작을 확인
    for(var i=0;i<menu_count;i++){
        if(menu_list[i].style.display == style){
            start_no = i;
            break;
        }
    }
    // 방향에 따른 이동
    if(direction == 'next'){
        if(menu_list[menu_count-1].style.display == style) return false;
        else{
            for(var i=0;i<menu_count;i++){
                if(i>=start_no + scroll_count && i<start_no + scroll_count + view_item_count){
                    menu_list[i].style.display = style;
                }else{
                    menu_list[i].style.display = 'none';
                }
            }
        }
    }else if(direction == 'prev'){
        if(menu_list[0].style.display == style) return false;
        else{
            for(var i=0;i<menu_count;i++){
                if(i>=start_no - scroll_count && i<start_no - scroll_count + view_item_count){
                    menu_list[i].style.display = style;
                }else{
                    menu_list[i].style.display = 'none';
                }
            }
        }
    }
}
</script>
</body>
</html>