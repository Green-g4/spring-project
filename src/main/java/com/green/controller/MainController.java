package com.green.controller;

import com.green.mapper.MemberMapper;
import com.green.mapper.ReviewMapper;
import com.green.service.*;
import com.green.vo.Criteria;
import com.green.vo.PageDTO;
import com.green.vo.ProductVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Setter(onMethod_=@Autowired)
    SearchService searchService;

    @GetMapping("/main")
    public void goMain(){
        log.info("메인페이지로");
    }

    @GetMapping("/search")
    public String searchGet(Criteria cri, Model model){
        log.info("cri : " + cri);
        List<ProductVO> productList = searchService.getProductList(cri);

        log.info("pre list: " + productList);
        if (!productList.isEmpty()){
            model.addAttribute("list",productList);
            log.info("list: " + productList);
        }else{
            model.addAttribute("listcheck","empty");
            return "product/search";
        }
        model.addAttribute("pageMaker", new PageDTO(cri,searchService.getTotal(cri)));
        return "product/search";
    }
    @GetMapping("/urlFind")
    public String urlFind(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        if(request.getQueryString()!=null){
            url = url + "?" + request.getQueryString();
        }
        System.out.println(url);

        return "main/main";
    }
}
