package com.green.controller;

import com.green.service.SearchService;
import com.green.vo.Criteria;
import com.green.vo.PageDTO;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/search/*")
@Log4j
public class SearchController {

    @Setter(onMethod_=@Autowired)
    private SearchService service;

    @GetMapping("/search")
    public String searchGet(Criteria cri, Model model){
        log.info("cri : " + cri);
        List<ProductVO> productList = service.getProductList(cri);

        log.info("pre list: " + productList);
        if (!productList.isEmpty()){
            model.addAttribute("list",productList);
            log.info("list: " + productList);
        }else{
            model.addAttribute("listcheck","empty");
            return "product/category_list";
        }
        model.addAttribute("pageMaker", new PageDTO(cri,service.getTotal(cri)));
        return "product/category_list";
    }

}
