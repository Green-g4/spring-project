package com.green.controller;


import com.green.service.ProductService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/*")
@Log4j
public class ProductController {
    @Setter(onMethod_=@Autowired)
    ProductService service;

    @GetMapping("/list")
    public String productListGet(Model model){
        log.info("productlist입니다");
        model.addAttribute("list",service.getList());
        return "product/list";
    }

    @PostMapping("/list")
    public String productListPost(int id){
        log.info(id+" 번 prdocutlist입니다");
        return "product/list";
    }

}

