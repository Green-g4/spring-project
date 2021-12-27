<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <%@ include file="/resources/header/Spheader.jsp" %>
  <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet" />
  <link href="/resources/css/login/findPw.css" rel="stylesheet" />
  <title>비밀번호 찾기 페이지 입니다.</title>
  <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
          crossorigin="anonymous"></script>
</head>

<body>
<form id="joinform">
  <div class="v1_1583">
    <span class="v1_1597">비밀번호 찾기</span>
    <input class="v1_1599" name="member_id" placeholder="아이디"></input>
    <span class="final_id_ck">아이디를 입력해주세요.</span>
    <input class="email_input" name="member_email" placeholder="이메일"></input>
    <input class="email_check_input" id="mail_check_input_box_false" disabled="disabled" placeholder="이메일 인증번호">
    <div class="emailchkbutton">인증메일 보내기</div>
    <span id="mail_check_input_box_warn"></span>
    <span class="final_mail_ck">이메일을 입력해주세요.</span>
    <sapn class="mail_input_box_warn"></sapn>
    <span class="res-success"></span>
    <span class="res-fail"></span>
    <input type="password" class="v1_1601" name="member_password" disabled="disabled" placeholder="새 비밀번호"></input>
    <input type="password" class="v1_1601-1" disabled="disabled" placeholder="비밀번호 확인"></input>
    <span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
    <span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
    <span class="final_pw_ck">비밀번호를 입력해주세요.</span>
    <span class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
    <span class="myButton">비밀번호 변경</span>
    <a href="login" class="myButton1">로그인하러 가기</a>
  </div>
</form>
<%@ include file="/resources/footer/footer.jsp"%>
<script>
  /* 유효성 검사 통과유무 변수 */
  var idCheck = false; // 아이디
  var idckCheck = false; // 아이디 중복 검사
  var pwCheck = false; // 비번
  var pwckCheck = false; // 비번 확인
  var pwckcorCheck = false; // 비번 확인 일치 확인
  var mailCheck = false; // 이메일
  var mailnumCheck = false; // 이메일 인증번호 확인
  var code = ""; //이메일전송 인증번호 저장위한 코드
  $(document).ready(function () {
    $(".v1_1601").css("background-color", "#ebebe4");
    $(".v1_1601-1").css("background-color", "#ebebe4");

  })
  $('.myButton').on("click", function () {
    var id = $('.v1_1599').val(); // id 입력란
    var pw = $('.v1_1601').val(); // 비밀번호 입력란
    var pwck = $('.v1_1601-1').val(); // 비밀번호 확인 입력란
    var mail = $('.email_input').val(); // 이메일 입력란
    /* 비밀번호 유효성 검사 */
    if (pw == "") {
      $('.final_pw_ck').css('display', 'block');
      pwCheck = false;
    } else {
      $('.final_pw_ck').css('display', 'none');
      pwCheck = true;
    }
    /* 비밀번호 확인 유효성 검사 */
    if (pwck == "") {
      $('.final_pwck_ck').css('display', 'block');
      pwckCheck = false;
    } else {
      $('.final_pwck_ck').css('display', 'none');
      pwckCheck = true;
    }
    /* 이메일 유효성 검사 */
    if (mail == "") {
      $('.final_mail_ck').css('display', 'block');
      mailCheck = false;
    } else {
      $('.final_mail_ck').css('display', 'none');
      mailCheck = true;
    }
    /* 아이디 유효성검사 */
    if (id == "") {
      $('.final_id_ck').css('display', 'block');
      idCheck = false;
    } else {
      $('.final_id_ck').css('display', 'none');
      idCheck = true;
    }
    if (idCheck && pwCheck && pwckCheck && pwckcorCheck && mailCheck && mailnumCheck) {
      $("#joinform").attr("action", "/login/findPw");
      $("#joinform").attr("method", "post");
      $("#joinform").submit();
    }
    return false;
  })


  /* 입력 이메일 형식 유효성 검사 */
  function mailFormCheck(email) {
    var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return form.test(email);
  }


  function sendchkcode() {

    $(".emailchkbutton").click(function () {

      var email = $(".email_input").val(); // 입력한 이메일

      var cehckBox = $(".email_check_input");
      var warnMsg = $(".mail_input_box_warn"); // 이메일 입력 경고글

      /* 이메일 형식 유효성 검사 */
      if (mailFormCheck(email)) {
        $('.res-success').hide()
        warnMsg.html("이메일이 전송 되었습니다. 이메일을 확인해주세요.");
        warnMsg.css("display", "inline-block");
      } else {
        warnMsg.html("올바르지 못한 이메일 형식입니다.");
        warnMsg.css("display", "inline-block");
        return false;
      }
      $.ajax({

        type: "GET",
        url: "mailCheck?email=" + email+" findPw",
        success: function (data) {
          console.log("data : " + data);
          cehckBox.attr("disabled", false);
          cehckBox.attr("id", "mail_check_input_box_true");
          code = data;
        }
      });
    });
  }
  /* 인증번호 비교 */
  $(".email_check_input").blur(function () {

    var inputCode = $(".email_check_input").val(); // 입력코드
    var checkResult = $("#mail_check_input_box_warn"); // 비교 결과

    if (inputCode == code) { // 일치할 경우
      checkResult.html("인증번호가 일치합니다.");
      checkResult.attr("class", "correct");
      mailnumCheck = true; // 일치할 경우
      $(".v1_1601").attr("disabled", false);
      $(".v1_1601-1").attr("disabled", false);
      $(".v1_1601").css("background-color", "white");
      $(".v1_1601-1").css("background-color", "white");
    } else { // 일치하지 않을 경우
      checkResult.html("인증번호를 다시 확인해주세요.");
      checkResult.attr("class", "incorrect");
      mailnumCheck = false; // 일치하지 않을 경우
    }
  });
  /* 아이디 입력 확인 */
  $('.v1_1599').on("propertychange change keyup paste input", function () {
    $('.final_id_ck').css('display', 'none');
  });
  /* 비밀번호 확인 일치 유효성 검사 */
  $('.v1_1601-1').on("propertychange change keyup paste input", function () {
    var pw = $('.v1_1601').val();
    var pwck = $('.v1_1601-1').val();
    $('.final_pw_ck').css('display', 'none');
    if (pw == pwck) {
      $('.pwck_input_re_1').css('display', 'block');
      $('.pwck_input_re_2').css('display', 'none');
      $('.final_pwck_ck').css('display', 'none');
      pwckcorCheck = true;
    } else {
      $('.pwck_input_re_1').css('display', 'none');
      $('.pwck_input_re_2').css('display', 'block');
      $('.final_pwck_ck').css('display', 'none');
      pwckcorCheck = false;
    }
  });

  $('.email_input').blur(function () {
    // $('.email_input').on("propertychange change keyup paste input", function () {
    console.log("keyup 테스트");
    var member_id = $('.v1_1599').val(); // .id_input에 입력되는 값
    var member_email = $('.email_input').val()
    var data = {
      member_id: member_id,
      member_email: member_email
    } // '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'

    $.ajax({
      type: "post",
      url: "/login/idMatchEmail",
      data: data,
      success: function (result) {
        console.log("성공 여부" + result);
        if (result != 'fail') {

          $('.res-success').css({
            "color": "green",
            "position": "relative",
            "top": "378px",
            "font-size": "16px",
            "left": "30%"
          }).text("입력하신 아이디와 이메일이 일치합니다. 이메일 인증 후 새로운 비밀번호를 입력하세요.");
          $('.res-fail').css("display", "none");
          $('.final_mail_ck').css('display', 'none');
          sendchkcode()
        } else {
          $('.res-fail').css({
            "color": "black",
            "position": "relative",
            "top": "378px",
            "font-size": "16px",
            "left": "30%"
          }).text("입력하신 정보로 조회된 아이디가 없습니다.");
          $('.res-success').css("display", "none");
          $(".emailchkbutton").css("disabled", "disabled")
        }
      } // success 종료
    });
  }); // ajax 종료
</script>
</body>

</html>