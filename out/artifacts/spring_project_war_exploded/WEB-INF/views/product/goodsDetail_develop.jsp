<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>NEOTREE</title>
    <link rel="stylesheet" href="/resources/css/goodsDetail_develop.css">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/resources/header/Spheader.jsp"%>
<div class="wrapper">
    <div class="img-Wrap" data-id="${goodsInfo.imageList[0].id}" data-path="${goodsInfo.imageList[0].uploadPath}" data-uuid="${goodsInfo.imageList[0].uuid}" data-filename="${goodsInfo.imageList[0].fileName}">
        <img>
    </div>
    <div class="product-Wrap">
        <div class="product-title">${goodsInfo.product_name}</div>
        <div class="sale_price"><fmt:formatNumber value="${goodsInfo.product_price}" pattern="#,### 원" /></div>
        <div class="price-info">
            <div class="button_quantity">
                주문수량
                <span class="numberButton">
                <button class="minus_btn">-</button>
                <input type="text" class="quantity_input" value="1">
								<button class="plus_btn">+</button>
                </span>
            </div>

            <div class="discount-price">판매가 :  <span class="discount_price_number"><fmt:formatNumber value="${goodsInfo.product_price - (goodsInfo.product_price*goodsInfo.product_discount)}" pattern="#,### 원" /></span>
                [<fmt:formatNumber value="${goodsInfo.product_discount*100}" pattern="###" />%
                <fmt:formatNumber value="${goodsInfo.product_price*goodsInfo.product_discount}" pattern="#,### 원" /> 할인]
            </div>
        </div>
        <div class="button_set">
            <a class="btn_cart">장바구니 담기</a>
            <a class="btn_buy">바로구매</a>
        </div>
    </div>
    <div class="product_detail">DETAILS</div>
    <div class="detail_down">
        <div class="book_intro">
            ${goodsInfo.product_intro}
        </div>
    </div>
    <div class="review_line">REVIEWS</div>
    <div class="review_detail">
        <span class="review_text">상품평을 남겨주세요</span><br>
        <textarea class="review_content"></textarea>
        <a class="review_register">등록</a>
    </div>
    <div class="review_reply">
        여기에 리뷰쓰면 들어가게해주시면됩니다
    </div>
</div>
</div>
    <!-- 주문 form -->
    <form action="/order/${member.member_id}" method="get" class="order_form">
        <input type="hidden" name="orders[0].id" value="${goodsInfo.id}">
        <input type="hidden" name="orders[0].Product_Count" value="">
    </form>
</div>
</div><!-- class="wrapper" -->
<%@ include file="/resources/footer/footer.jsp"%>
<script>
    $(document).ready(function(){

        /* 이미지 삽입 */
        const bobj = $(".image_wrap");

        if(bobj.data("id")){
            const uploadPath = bobj.data("path");
            const uuid = bobj.data("uuid");
            const fileName = bobj.data("filename");

            const fileCallPath = encodeURIComponent(uploadPath + "/" + uuid + "_" + fileName);

            bobj.find("img").attr('src', '/product/display?fileName=' + fileCallPath);
        } else {
            bobj.find("img").attr('src', '/resources/img/goodsNoImage.png');
        }

        /* 포인트 삽입 */
        let salePrice = "${goodsInfo.product_price - (goodsInfo.product_price*goodsInfo.product_discount)}"
        let point = salePrice*0.05;
        point = Math.floor(point);
        $(".point_span").text(point);

    });	//$(document).ready(function(){


    // 수량 버튼 조작
    let quantity = $(".quantity_input").val();
    $(".plus_btn").on("click", function(){
        $(".quantity_input").val(++quantity);
    });
    $(".minus_btn").on("click", function(){
        if(quantity > 1){
            $(".quantity_input").val(--quantity);
        }
    });

    // 서버로 전송할 데이터
    const form = {
        member_id : '${member.member_id}',
        bookId : '${goodsInfo.id}',
        bookCount : ''
    }
    // 장바구니 추가 버튼
    $(".btn_cart").on("click", function(e){
        form.bookCount = $(".quantity_input").val();
        $.ajax({
            url: '/cart/add',
            type: 'POST',
            data: form,
            success: function(result){
                cartAlert(result);
            }
        })
    });

    function cartAlert(result){
        if(result == '0'){
            alert("장바구니에 추가를 하지 못하였습니다.");
        } else if(result == '1'){
            alert("장바구니에 추가되었습니다.");
        } else if(result == '2'){
            alert("장바구니에 이미 추가되어져 있습니다.");
        } else if(result == '5'){
            alert("로그인이 필요합니다.");
        }
    }
    /* 바로구매 버튼 */
    $(".btn_buy").on("click", function(){
        let Product_Count = $(".quantity_input").val();
        $(".order_form").find("input[name='orders[0].product_Count']").val(Product_Count);
        $(".order_form").submit();
    });
</script>
</body>
</html>