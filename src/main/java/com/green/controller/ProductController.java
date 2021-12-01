package com.green.controller;


import com.green.service.ProductService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/*")
@Log4j
public class ProductController {
    @Setter(onMethod_=@Autowired)
    ProductService service;

    @PostMapping("/list")
    public String productList(int id){
        log.info(id+" 번 prdocutlist입니다");
        return "list";
    }

}

