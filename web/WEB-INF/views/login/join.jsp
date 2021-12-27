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
  <link href="/resources/css/login/join.css" rel="stylesheet" />
  <title>회원가입 페이지 입니다.</title>
  <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
          crossorigin="anonymous"></script>
</head>

<body>
<form id="joinform">
  <div class="v1_1583">
    <span class="v1_1597">회원가입</span>
    <input class="v1_1598" name="member_name" placeholder="성명"></input>
    <span class="final_name_ck">이름을 입력해주세요.</span>
    <input class="v1_1599" name="member_id" placeholder="아이디"></input>
    <span class="id_input_re_1">사용 가능한 아이디입니다.</span>
    <span class="id_input_re_2">아이디가 이미 존재합니다.</span>
    <span class="final_id_ck">아이디를 입력해주세요.</span>
    <input class="email_input" name="member_email" placeholder="이메일"></input>
    <input class="email_check_input" id="mail_check_input_box_false" disabled="disabled" placeholder="이메일 인증번호">
    <span id="mail_check_input_box_warn"></span>
    <span class="final_mail_ck">이메일을 입력해주세요.</span>
    <sapn class="mail_input_box_warn"></sapn>
    <input class="v1_1600" name="member_phonenumber" placeholder="전화번호"></input>
    <span class="final_phone_ck">전화번호를 입력해주세요.</span>
    <input type="password" class="v1_1601" name="member_password" placeholder="비밀번호"></input>
    <input type="password" class="v1_1601-1" placeholder="비밀번호 확인"></input>
    <span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
    <span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
    <span class="final_pw_ck">비밀번호를 입력해주세요.</span>
    <span class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
    <input class="v1_1602" name="member_address" readonly="readonly" placeholder="우편번호"></input>
    <span class="final_addr_ck">주소를 입력해주세요.</span>
    <input class="v1_1603" name="member_address" readonly="readonly" placeholder="주소"></input>
    <input class="v1_1604" name="member_address" placeholder="상세주소"></input>
    <div class="myButton1" onclick="execution_daum_address()">우편번호 찾기</div>
    <div class="emailchkbutton">인증메일 보내기</div>
    <button class="myButton">회원가입</button>
  </div>
</form>
<%@ include file="/resources/footer/footer.jsp"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
  /* 유효성 검사 통과유무 변수 */
  var idCheck = false; // 아이디
  var idckCheck = false; // 아이디 중복 검사
  var pwCheck = false; // 비번
  var pwckCheck = false; // 비번 확인
  var pwckcorCheck = false; // 비번 확인 일치 확인
  var nameCheck = false; // 이름
  var mailCheck = false; // 이메일
  var mailnumCheck = false; // 이메일 인증번호 확인
  var addressCheck = false; // 주소
  var phoneCheck = false //전화번호

  $(document).ready(function () {
    $(".myButton").click(function () {
      /* 입력값 변수 */
      var id = $('.v1_1599').val(); // id 입력란
      var pw = $('.v1_1601').val(); // 비밀번호 입력란
      var pwck = $('.v1_1601-1').val(); // 비밀번호 확인 입력란
      var name = $('.v1_1598').val(); // 이름 입력란
      var mail = $('.email_input').val(); // 이메일 입력란
      var addr = $('.v1_1604').val(); // 주소 입력란
      var phone = $('.v1_1600').val(); // 전화번호 입력란

      /* 아이디 유효성검사 */
      if (id == "") {
        $('.final_id_ck').css('display', 'block');
        idCheck = false;
      } else {
        $('.final_id_ck').css('display', 'none');
        idCheck = true;
      }

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

      /* 이름 유효성 검사 */
      if (name == "") {
        $('.final_name_ck').css('display', 'block');
        nameCheck = false;
      } else {
        $('.final_name_ck').css('display', 'none');
        nameCheck = true;
      }

      /* 이메일 유효성 검사 */
      if (mail == "") {
        $('.final_mail_ck').css('display', 'block');
        mailCheck = false;
      } else {
        $('.final_mail_ck').css('display', 'none');
        mailCheck = true;
      }

      /* 주소 유효성 검사 */
      if (addr == "") {
        $('.final_addr_ck').css('display', 'block');
        addressCheck = false;
      } else {
        $('.final_addr_ck').css('display', 'none');
        addressCheck = true;
      }

      /* 전화번호 유효성 검사 */
      if (addr == "") {
        $('.final_phone_ck').css('display', 'block');
        phoneCheck = false;
      } else {
        $('.final_phone_ck').css('display', 'none');
        phoneCheck = true;
      }

      /* 최종 유효성 검사 */
      if (idCheck && idckCheck && pwCheck && pwckCheck && pwckcorCheck && nameCheck && mailCheck &&
              mailnumCheck && addressCheck && phoneCheck) {
        $("#joinform").attr("action", "/login/join");
        $("#joinform").attr("method", "post");
        $("#joinform").submit();
      }
      return false;
    });
  })

  $('.v1_1599').on("propertychange change keyup paste input", function () {
    // console.log("keyup 테스트");
    var member_id = $('.v1_1599').val(); // .id_input에 입력되는 값
    var data = {
      member_id: member_id
    } // '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'

    $.ajax({
      type: "post",
      url: "/login/memberIdChk",
      data: data,
      success: function (result) {
        // console.log("성공 여부" + result);
        if (result != 'fail') {
          $('.id_input_re_1').css("display", "inline-block");
          $('.id_input_re_2').css("display", "none");
          // 아이디 중복이 없는 경우
          idckCheck = true;
        } else {
          $('.id_input_re_2').css("display", "inline-block");
          $('.id_input_re_1').css("display", "none");
          // 아이디 중복된 경우
          idckCheck = false;
        }

      } // success 종료

    }); // ajax 종료
  });

  /* 비밀번호 확인 일치 유효성 검사 */

  $('.v1_1601-1').on("propertychange change keyup paste input", function () {
    var pw = $('.v1_1601').val();
    var pwck = $('.v1_1601-1').val();

    if (pw == pwck) {
      $('.pwck_input_re_1').css('display', 'block');
      $('.pwck_input_re_2').css('display', 'none');
      pwckcorCheck = true;
    } else {
      $('.pwck_input_re_1').css('display', 'none');
      $('.pwck_input_re_2').css('display', 'block');
      pwckcorCheck = false;
    }

  });

  /* 입력 이메일 형식 유효성 검사 */
  function mailFormCheck(email) {
    var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return form.test(email);
  }
  /* 다음 주소 연동 */
  function execution_daum_address() {

    new daum.Postcode({
      oncomplete: function (data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.

        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        var addr = ''; // 주소 변수
        var extraAddr = ''; // 참고항목 변수

        //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
          addr = data.roadAddress;
        } else { // 사용자가 지번 주소를 선택했을 경우(J)
          addr = data.jibunAddress;
        }

        // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
        if (data.userSelectedType === 'R') {
          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
          }
          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraAddr !== '') {
            extraAddr = ' (' + extraAddr + ')';
          }
          // 주소변수 문자열과 참고항목 문자열 합치기
          addr += extraAddr;

        } else {
          addr += ' ';
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        $(".v1_1602").val(data.zonecode);
        //$("[name=memberAddr1]").val(data.zonecode);    // 대체가능
        $(".v1_1603 ").val(addr);
        //$("[name=memberAddr2]").val(addr);            // 대체가능
        // 커서를 상세주소 필드로 이동한다.
        $(".v1_1604").attr("readonly", false);
        $(".v1_1604").focus();

      }
    }).open();
  }
  /* 인증번호 이메일 전송 */
  var code = ""; //이메일전송 인증번호 저장위한 코드
  $(".emailchkbutton").click(function () {

    var email = $(".email_input").val(); // 입력한 이메일
    var cehckBox = $(".email_check_input");
    var warnMsg = $(".mail_input_box_warn"); // 이메일 입력 경고글

    /* 이메일 형식 유효성 검사 */
    if (mailFormCheck(email)) {
      warnMsg.html("이메일이 전송 되었습니다. 이메일을 확인해주세요.").css("color","green");
      warnMsg.css("display", "inline-block");
    } else {
      warnMsg.html("올바르지 못한 이메일 형식입니다.").css("color","red");
      warnMsg.css("display", "inline-block");
      return false;
    }
    $.ajax({

      type: "GET",
      url: "mailCheck?email=" + email+" join",
      success: function (data) {

        console.log("data : " + data);
        cehckBox.attr("disabled", false);
        cehckBox.attr("id", "mail_check_input_box_true");
        code = data;
      }

    });

  });
  /* 인증번호 비교 */
  $(".email_check_input").blur(function () {

    var inputCode = $(".email_check_input").val(); // 입력코드
    var checkResult = $("#mail_check_input_box_warn"); // 비교 결과

    if (inputCode == code) { // 일치할 경우
      checkResult.html("인증번호가 일치합니다.");
      checkResult.attr("class", "correct");
      mailnumCheck = true; // 일치할 경우
    } else { // 일치하지 않을 경우
      checkResult.html("인증번호를 다시 확인해주세요.");
      checkResult.attr("class", "incorrect");
      mailnumCheck = false; // 일치하지 않을 경우
    }
  });
</script>
</body>

</html>