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

    @GetMapping({"/main", "/main_develop"})
    public void goMain(Criteria cri,Model model){
        log.info("메인페이지로");
        List<ProductVO> productList = productService.getList(cri);
        List<ProductVO> productListAsc = productService.getListAsc(cri);
        List<ProductVO> list1 = productService.getListCategory("digital/homeapp");
        List<ProductVO> list2 = productService.getListCategory("life/health");
        List<ProductVO> list3 = productService.getListCategory("sports/leisure");
        log.info(productList);
        log.info(list1);
        log.info(list2);
        log.info(list3);
        if (!productList.isEmpty()){
            model.addAttribute("list",productList);
            model.addAttribute("list1",list1);
            model.addAttribute("list2",list2);
            model.addAttribute("list3",list3);
            model.addAttribute("list4",productListAsc);
        }else {
            model.addAttribute("listCheck","empty");
            return;
        }
        model.addAttribute("pageMaker",new PageDTO(cri,productService.productGetTotal(cri)));
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
}
