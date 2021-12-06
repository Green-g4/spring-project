package com.green.controller;


import com.green.service.ProductService;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product/*")
@Log4j
public class ProductController {
    @Setter(onMethod_ = @Autowired)
    ProductService service;

    @GetMapping("/list")
    public String productListGet(Model model) {
        log.info("productlist입니다");
        model.addAttribute("list", service.getList());
        return "product/list";
    }

    @PostMapping("/list")
    public String productListPost(int id) {
        log.info(id + " 번 prdocutlist입니다");
        return "product/list";
    }

    @GetMapping("/category_list")
    public String Category_click(Model model) {
        log.info("디지털/가전 카테고리입니다");
        model.addAttribute("list",service.digital_homeappList());
        return "product/category_list";
    }
    @GetMapping("/category_list2")
    public String Category_click2(Model model) {
        log.info("생활/건강 카테고리입니다");
        model.addAttribute("list",service.life_healthList());
        return "product/category_list2";
    }
    @GetMapping("/category_list3")
    public String Category_click3(Model model) {
        log.info("스포츠/레저 카테고리입니다");
        model.addAttribute("list",service.sports_leisureList());
        return "product/category_list3";
    }
}


