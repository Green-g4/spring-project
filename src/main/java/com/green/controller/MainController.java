package com.green.controller;

import com.green.mapper.MemberMapper;
import com.green.mapper.ReviewMapper;
import com.green.service.*;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
@Log4j
public class MainController {

    @Setter(onMethod_=@Autowired)
    MemberService memberService;

    @Setter(onMethod_=@Autowired)
    CategoryService categoryService;

    @Setter(onMethod_=@Autowired)
    OrdersService ordersService;

    @Setter(onMethod_=@Autowired)
    ProductService productService;

    @Setter(onMethod_=@Autowired)
    ReviewService reviewService;

    @GetMapping("/main")
    public void goMain(){
        log.info("메인페이지로");
    }
}
