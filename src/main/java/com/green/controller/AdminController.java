package com.green.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
@Log4j
public class AdminController {

    @GetMapping("/main")
    public void goMain(){
        log.info("관리자페이지 메인입니다");
    }
    @GetMapping("/authorDetail")
    public void goDetail(){
        log.info("관리자페이지 authorDetail 입니다");
    }
    @GetMapping("/authorEnroll")
    public void goEnroll(){
        log.info("관리자페이지 authorEnroll 입니다");
    }
}
