package com.green.controller;

import com.green.service.ProductService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/detail/*")
@Log4j
public class DetailController {
    @Autowired
    private ProductService service;


    @GetMapping("/detail/{id}")
    public void getDetail(@RequestParam("id") int id, Model model) {
        System.out.println("1) 컨트롤러 등록 get ");
        model.addAttribute("detail",service.read(id));

    }
}
