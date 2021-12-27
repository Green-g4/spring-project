package com.green.controller;


import com.green.service.MemberService;
import com.green.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/login/*")
@Log4j
public class LoginController {
    @Setter(onMethod_ = @Autowired)
    MemberService service;
    @Setter(onMethod_ = @Autowired)
    JavaMailSender mailSender;
    @Setter(onMethod_ = @Autowired)
    BCryptPasswordEncoder pwEncoder;

    @GetMapping("/login")
    public void getLogin() {

    }

    /* 로그인 */
    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {
        HttpSession session = request.getSession();

        String rawPw = "";
        String encodePw = "";
        // 아이디 또는 비밀번호 공백 확인
        if (member.getMember_id().isEmpty() || member.getMember_password().isEmpty()) {
            rttr.addFlashAttribute("result", 1);
            return "redirect:/login/login";
        }
        MemberVO lvo = service.memberLogin(member); // 제출한아이디와 일치하는 아이디 있는지
        if (lvo != null) { // 일치하는 아이디 존재시

            rawPw = member.getMember_password(); // 사용자가 제출한 비밀번호
            encodePw = lvo.getMember_password(); // 데이터베이스에 저장한 인코딩된 비밀번호

            if (true == pwEncoder.matches(rawPw, encodePw)) { // 비밀번호 일치여부 판단
                log.info(lvo + "==========================================");
                lvo.setMember_password(""); // 인코딩된 비밀번호 정보 지움
                session.setAttribute("signedUser", lvo.getMember_id()); // session에 사용자의 정보 저장
                log.info(session.getAttribute("signedUser")+"==================");
                return "redirect:/main/main"; // 메인페이지 이동


            } else {

                rttr.addFlashAttribute("result", 0);
                return "redirect:/login/login"; // 로그인 페이지로 이동

            }

        } else { // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)

            rttr.addFlashAttribute("result", 0);
            return "redirect:/login/login"; // 로그인 페이지로 이동

        }
    }
    @GetMapping("/logout")
    public void getLogout(HttpServletRequest request) {

        HttpSession session = request.getSession();

        log.info(session.getAttribute("signedUser")+"==================");
        session.invalidate();//세션의 모든 속성 제거

    }

    @GetMapping("/join")
    public void getJoin() {

    }

    @PostMapping("/join")
    public String postJoin(MemberVO vo) {
        String rawPw = ""; // 인코딩 전 비밀번호
        String encodePw = ""; // 인코딩 후 비밀번호

        rawPw = vo.getMember_password(); // 비밀번호 데이터 얻음
        encodePw = pwEncoder.encode(rawPw); // 비밀번호 인코딩
        vo.setMember_password(encodePw); // 인코딩된 비밀번호 member객체에 다시 저장

        /* 회원가입 쿼리 실행 */
        service.insert(vo);
        return "redirect:login";
    }



    @RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
    @ResponseBody
    public String memberIdChkPOST(String member_id) throws Exception {
        int result = service.idCheck(member_id);

        if (result != 0) {

            return "fail"; // 중복 아이디가 존재

        } else {

            return "success"; // 중복 아이디 x

        }
    } // memberIdChkPOST() 종료


    @GetMapping("/findId")
    public void getFindid() {

    }

    @RequestMapping(value = "/findId", method = RequestMethod.POST)
    @ResponseBody
    public String postFindId(MemberVO vo) throws Exception {
        String result = service.findId(vo);

        if (result == null) {

            return "fail"; // 중복 아이디가 존재

        } else {

            return result; // 중복 아이디 x

        }
    } // memberIdChkPOST() 종료

    @RequestMapping(value = "/idMatchEmail", method = RequestMethod.POST)
    @ResponseBody
    public String idMatchEmail(MemberVO vo) throws Exception {
        String result = service.idMatchEmail(vo);

        if (result == null) {
            result = "fail";
            return result;
        } else {
            return result;
        }
    }
    @GetMapping("/findPw")
    public void getFindPw() {

    }

    @RequestMapping(value = "/findPw", method = RequestMethod.POST)
    public String postFindPw(MemberVO vo) throws Exception {
        String rawPw = ""; // 인코딩 전 비밀번호
        String encodePw = ""; // 인코딩 후 비밀번호

        rawPw = vo.getMember_password(); // 비밀번호 데이터 얻음
        encodePw = pwEncoder.encode(rawPw); // 비밀번호 인코딩
        vo.setMember_password(encodePw); // 인코딩된 비밀번호 member객체에 다시 저장

        log.info(vo);
        service.changePw(vo);
        return "redirect:login";
    } // memberIdChkPOST() 종료

    /* 이메일 인증 */
    @RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
    @ResponseBody
    public String mailCheckGET(String email) throws Exception {

        /* 뷰(View)로부터 넘어온 데이터 확인 */
        log.info("이메일 데이터 전송 확인");
        log.info("String email : " + email+"1");
        /* 인증번호(난수) 생성 */
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;
        log.info("인증번호 " + checkNum);
        /* 이메일 보내기 */
        String findPw = email.substring(email.indexOf(" ")+1,email.length());
        email = email.substring(0, email.indexOf(" "));

        String setFrom = "cando921019@gmail.com";
        String toMail = email;
        String title = "회원가입 인증 이메일 입니다.";
        String content =
                "홈페이지를 방문해주셔서 감사합니다." +
                        "<br><br>" +
                        "인증 번호는 " + checkNum + "입니다." +
                        "<br>" +
                        "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        if(findPw.equals("findPw")){
            title = "비밀번호 변경 인증 이메일 입니다.";
            content =
                    "비밀번호를 변경하시려면 아래의 인증번호를 정확히 입력해주세요." +
                            "<br><br>" +
                            "인증 번호는 " + checkNum + "입니다." +
                            "<br>" +
                            "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

        }
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true);
            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String num = Integer.toString(checkNum);
        return num;
    }


}