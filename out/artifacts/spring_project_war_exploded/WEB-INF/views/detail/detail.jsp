<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
                                                                                                   prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>상세 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous">
    </script>
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>

    <style>
        div.reviewModal { position:relative; z-index:1; display: none;}
        div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
        div.modal { position:fixed; top:20%; left:calc(50% - 250px); width:500px; height:250px; padding:20px 10px; background:#fff; border:2px solid #666; }
        div.modal textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:200px; }
        div.modal button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
        div.modal button.cancel_btn { margin-left:20px; }
    </style>
</head>
<body>
<header>
    <%@ include file="/resources/header/Spheader.jsp"%>
</header>
<section>
    <div class="line">
    </div>
    <div class="price">
        <div class="sale_price">가격 : <fmt:formatNumber value="${detail.product_price}" pattern="#,### 원" /> ${detail.product_price}</div>
    </div>
    <div class="line">
    </div>
    <div class="button">
        <div class="button_quantity">
            주문수량
            <input type="text" class="quantity_input" value="1">
            <span>
								<button class="plus_btn">+</button>
								<button class="minus_btn">-</button>
							</span>
        </div>
        <div class="button_set">
            <button class="btn_cart">장바구니 담기</button>
            <button class="btn_buy">바로구매</button>
        </div>
    </div>

    <div id="review">
        <c:if test="${signedUser==null}">
            <p>로그인을 해주세요</p>
        </c:if>
        <c:if test="${signedUser != null}">
            <div class="reviewForm">
                <form role="form" method="post" autocomplete="off">
                    <input type="hidden" name="product_id" id="product_id" value="${detail.id}">
                    <input type="hidden" name="pageNum" id="pageNum" value="${cri.pageNum}">
                    <input type="hidden" name="amount" id="amount" value="${cri.amount}">
                    <input type="hidden" name="keyword" id="keyword" value="${cri.keyword}">
                    <input type="hidden" name="type" id="type" value="${cri.type}">


                    <div class="input">
                        <textarea name="reviewContent" id="reviewContent"></textarea>
                    </div>
                    <div class="input">
                        <button type="button" id="review_btn">리뷰 작성하기</button>
                    </div>
                </form>
            </div>
        </c:if>

        <div class="reviewList">
            <ol>

            </ol>

        </div>

        <div class="reviewModal">
            <div class="modal">
                <div>
                    <textarea class="modal_review_content" name="modal_review_content"></textarea>
                </div>
                <div>
                    <button type="button" class="update_btn">수정</button>
                    <button type="button" class="cancel_btn">취소</button>
                </div>
            </div>
            <div class="modalBackground"></div>
        </div>
        <div class="review-footer"></div>
        <script>
            $(document).on("click",".update",function () {
                $(".reviewModal").attr("style", "display:block;");
            })
        </script>

    </div>


    <script type="text/javascript" src="/resources/js/review.js"></script>
</section>
<footer>
    <%@ include file="/resources/footer/footer.jsp"%>
</footer>
<script>
    $(document).ready(function (){
        console.log("============")
        var product_id = "<c:out value='${detail.id}'/>"
        console.log(product_id)
        showList(1)
        function showList(page){
            reviewService.getListPaging({product_id: product_id ,page: page || 1},
                (reviewCnt,list)=>{
                    console.log("리뷰 갯수 " + reviewCnt)
                    console.log("리뷰 : " + list)
                    console.log("page 9: " + page)
                    if(page==-1){
                        pageNum=Math.ceil(reviewCnt/5.0)
                        console.log("pageNum : " +  pageNum)
                        showList(pageNum);
                        return;
                    }
                    var str =''
                    if(list==null || list.length==0){
                        $(".reviewList ol").html('');
                        return
                    }
                    for(var i =0, len = list.length || 0; i<len; i++){
                        str += "<li data-reivew_num='" + list[i].review_num + "'>"
                            +"<div class='userInfo'>"
                            +"<span class='review_replyer'>" + list[i].member_id + "</span>"
                            // +"<span class = 'date'>" + list[i].review_date +"</span>"
                            +"</div>"
                            +"<div class = 'review_content'>"+list[i].review_content+"</div>"
                            +"<c:if test='${signedUser != null}'>"
                            +"<div class = 'reviewFooter'>"
                            +"<button type='button' class='update' date-review_num='" + list[i].review_num +"'>수정하기</button>"
                            +"<button type='button' class='delete' date-review_num='" + list[i].review_num +"'>삭제하기</button>"
                            +"</div>"
                            +"</c:if>"
                            +"</li>";
                    }//for
                    $(".reviewList ol").html(str);
                    console.log(str);
                    showReviewPage(reviewCnt);
                });
        };
        var pageNum = 1;
        var reviewFooter =$(".review-footer")
        function showReviewPage(reviewCnt){//페이지 계산함수 정의
            console.log(reviewCnt + "showReviewPage!!!!!!!!!!!!!!!!!!!!")
            var endNum = Math.ceil(pageNum/5.0) * 5;
            var startNum = endNum -4;
            var prev = startNum != 1;
            var next = false;
            console.log("endNum = " + endNum)
            console.log("startNum = " + startNum)
            console.log("prev = " + prev)
            console.log("next = " + next)


            if(endNum *5>= reviewCnt){
                endNum = Math.ceil(reviewCnt/5.0);
            }
            console.log("endNum2 = " + endNum)
            if(endNum*5<reviewCnt) {
                next =true;
            }
            console.log("next = " + next)
            var str = "<ul class='pagination pull-right'>";
            if(prev){
                str+= "<li class='page-item'><a class='page-link' href='" +
                    (startNum-1) +"'>이전 페이지</a></li>";
            }
            for (var i = startNum; i <= endNum; i++) {
                var active = pageNum == i ? "active" : "";
                str += "<li class='page-item " + active + " '><a class='page-link' href='" + i + "'>" + i + "</a></li>";
            }
            if(next){
                str+= "<li class='page-item'><a class='page-link' href='" +
                    (endNum+1) +"'>다음 페이지</a></li>";
            }
            str+= "</ul></div>";
            console.log(str);
            reviewFooter.html(str);

        }
        $(".review-footer").on("click", "li a", function (e){
            e.preventDefault();
            console.log("click review-footer")
            var targetPageNum = $(this).attr("href");
            console.log("targetPageNum : " + targetPageNum)
            pageNum = targetPageNum;
            showList(pageNum);
        });


        //review update
        $(".update").on("click",function (){
            $(".reviewModal").fadeIn(200);
            var reviewNum = $(this).attr("data-review_num");
            console.log("수정 클릭")
            console.log(reviewNum)
            var reviewContent = $(this).parent().parent().children(".review_content").text();
            console.log(reviewContent)
            $(".modal_review_content").val(reviewContent);
            $(".update_btn").attr("data-review_num",reviewNum);
        })
        $(".cancel_btn").on("click",function (){
            $(".reviewModal").fadeOut(200);
        })
        $(".update_btn").on("click",function (){
            var updateConfirm = confirm("정말로 수정하시겠습니까?")
            if(updateConfirm){
                var data ={
                    review_num :$(this).attr("data-review_num"),
                    review_content: $(".modal_review_content").val()
                };
                console.log(data)
                $.ajax({
                    url:"/reviews/detail/updateReview",
                    type : "post",
                    data : data,
                    success : function (result){
                        console.log(result)
                        if(result==0) {
                            alert("작성자 본인만 할 수 있습니다.")
                        }else{
                            showList(1);
                            $(".reviewModal").fadeOut(200);
                            return;
                        }
                    },
                    error : function (){
                        alert("로그인 해주세요")
                    }
                })
            }
        })


        //review delete
        $(".delete").on("click",function (){
            var confirm = confirm("정말로 삭제하시겠습니까?")
            if(confirm){
                var data = {review_num: $(this).attr("data-review_num")};
                $.ajax({
                    url : "/reviews/detail/deleteReview",
                    type : "post",
                    data : data,
                    success : function (result){
                        if(result==1) {
                            showList(1);

                        }else{
                            alert("작성자 본인만 할 수 있습니다.")
                        }
                    },//success
                    error : function (){
                        alert("로그인 해주세요")
                    }
                })//ajax
            }
        })


        //review insert
        $("#review_btn").on("click",function (){
            <%--var form =${".reviewForm form[role='form']"};--%>
            var product_id = $("#product_id").val();
            var review_content = $("#reviewContent").val();
            console.log(review_content)
            console.log(product_id)
            var data = {
                product_id : product_id,
                review_content : review_content
            };
            $.ajax({
                url : "/reviews/detail/insertReview",
                type: "post",
                data : data,
                success : function(){
                    showList(1);
                    $("#reviewContent").val("")
                }
            });
        })


        //구매 수량
        let quantity = $(".quantity_input").val();
        $(".plus_btn").on("click", function(){
            $(".quantity_input").val(++quantity);
        });
        $(".minus_btn").on("click", function(){
            if(quantity > 1){
                $(".quantity_input").val(--quantity);
            }
        });

        //cart
        const form ={
            member_id : 'greent',
            product_id : '${detail.id}',
            cart_count : ''
        }
        $(".btn_cart").on("click",function (e){
            console.log("cart btn==================")
            form.cart_count = $(".quantity_input").val();
            console.log(form.cart_count);
            $.ajax({
                url:'/cart/add',
                type:'POST',
                data: form,
                success: function (result){
                    cartAlert(result);
                }
            })
        });
        function cartAlert(result){
            if(result == '0'){
                alert("장바구니에 추가하지 못했습니다")
            }else if(result=='1'){
                alert("장바구니에 추가되었습니다")
            }else if(result=='2'){
                alert("상품이 장바구니에 이미 존재합니다")
            }else if(result=='3'){
                alert("로그인이 필요합니다")
            }
        }


        var IMP = window.IMP;
        var code = "imp76854798"; //가맹점 식별코드
        IMP.init(code);
        $(".btn_buy").click(function(e){
            //결제요청
            IMP.request_pay({
                //name과 amout만있어도 결제 진행가능
                //pg : 'kakao', //pg사 선택 (kakao, kakaopay 둘다 가능)
                pg : 'html5_inicis',
                pay_method : 'card',
                merchant_uid : 'merchant_' + new Date().getTime(),
                name : '${detail.product_name}',
                amount : '${detail.product_price}',
                buyer_email : 'iamport@siot.do',
                buyer_name : '구매자',
                buyer_tel : '010-1234-5678',
                buyer_addr : '서울특별시 강남구 삼성동',
                buyer_postcode : '123-456',//필수항목
                m_redirect_url : 'http://localhost:8001/detail/detail?id='+'${detail.id}'
            }, function(rsp){
                if(rsp.success){//결제 성공시
                    var msg = '결제가 완료되었습니다';
                    var result = {
                        "imp_uid" : rsp.imp_uid,
                        "merchant_uid" : rsp.merchant_uid,
                        "biz_email" : rsp.buyer_email,
                        "pay_date" : new Date().getTime(),
                        "amount" : rsp.amount,
                        "card_no" : rsp.card_no,
                        "refund" : 'payed'
                    }
                    console.log("결제성공 " + msg);
                    $.ajax({
                        url : '/samsam/insertPayCoupon.do',
                        type :'POST',
                        data : JSON.stringify(result,
                            ['imp_uid', 'merchant_uid', 'biz_email',
                                'pay_date', 'amount', 'card_no', 'refund']),
                        contentType:'application/json;charset=utf-8',
                        dataType: 'json', //서버에서 보내줄 데이터 타입
                        success: function(res){

                            if(res == 1){
                                console.log("추가성공");
                                pay += 5;
                                $('#pay_coupon').html(pay);
                            }else{
                                console.log("Insert Fail!!!");
                            }
                        },
                        error:function(){
                            console.log("Insert ajax 통신 실패!!!");
                        }
                    }) //ajax

                }
                else{//결제 실패시
                    var msg = '결제에 실패했습니다';
                    msg += '에러 : ' + rsp.error_msg
                }
                console.log(msg);
            })//pay
        })
    })

</script>
</body>


</html>

