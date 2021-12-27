package com.green.controller;


import com.green.service.AttachService;
import com.green.service.ProductService;
import com.green.vo.AttachImageVO;
import com.green.vo.Criteria;
import com.green.vo.PageDTO;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product/*")
@Log4j
public class ProductController {
    @Setter(onMethod_ = @Autowired)
    ProductService service;

    @Setter(onMethod_=@Autowired)
    private AttachService attachService;

    @GetMapping("/category_list")
    public String AllProduct(Criteria cri, Model model) {
        List<ProductVO> list = service.getList(cri);
        if(!list.isEmpty()){
            model.addAttribute("list",list);
        } else {
            model.addAttribute("list","empty");
        }
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate1(cri)));
        return "product/category_list";
    }
    @GetMapping("/category_list1")
    public String category1(Model model,Criteria cri){
        List<ProductVO> list1 = service.getListCategory1(cri);
        String categoryName = "digital/homeapp";
        if(!list1.isEmpty()){
            model.addAttribute("list1",list1);
        } else {
            model.addAttribute("list1","empty");
        }
        log.info(cri);
        log.info(list1);
        log.info(service.productGetTotalCate1(cri));
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate1(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_list2")
    public String category2(Model model,Criteria cri){
        List<ProductVO> list2 = service.getListCategory2(cri);
        String categoryName = "life/health";
        if(!list2.isEmpty()){
            model.addAttribute("list2",list2);
        } else {
            model.addAttribute("list2","empty");
        }
        log.info(cri);
        log.info(list2);
        log.info(service.productGetTotalCate2(cri));
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate2(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_list3")
    public String category3(Model model,Criteria cri){
        List<ProductVO> list3 = service.getListCategory3(cri);
        String categoryName = "sports/leisure";
        if(!list3.isEmpty()){
            model.addAttribute("list3",list3);
        } else {
            model.addAttribute("list3","empty");
        }
        log.info(cri);
        log.info(list3);
        log.info(service.productGetTotalCate3(cri));
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate3(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_desc1")
    public String category_desc1(Model model,Criteria cri){
        List<ProductVO> list1 = service.getListPriceDesc1(cri);
        String categoryName = "digital/homeapp";
        if(!list1.isEmpty()){
            model.addAttribute("list1",list1);
        } else {
            model.addAttribute("list1","empty");
        }
        log.info(cri);
        log.info(list1);
        log.info(service.productGetTotal(cri));
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate1(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_asc1")
    public String category_asc1(Model model,Criteria cri){
        List<ProductVO> list1 = service.getListPriceAsc1(cri);
        String categoryName = "digital/homeapp";
        if(!list1.isEmpty()){
            model.addAttribute("list1",list1);
        } else {
            model.addAttribute("list1","empty");
        }
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate1(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_desc2")
    public String category_desc2(Model model,Criteria cri){
        List<ProductVO> list2 = service.getListPriceDesc2(cri);
        String categoryName = "life/health";
        if(!list2.isEmpty()){
            model.addAttribute("list2",list2);
        } else {
            model.addAttribute("list2","empty");
        }
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate2(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_asc2")
    public String category_asc2(Model model,Criteria cri){
        List<ProductVO> list2 = service.getListPriceAsc2(cri);
        String categoryName = "life/health";
        if(!list2.isEmpty()){
            model.addAttribute("list2",list2);
        } else {
            model.addAttribute("list2","empty");
        }
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate2(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_desc3")
    public String category_desc3(Model model,Criteria cri){
        List<ProductVO> list3 = service.getListPriceDesc3(cri);
        String categoryName = "sports/leisure";
        if(!list3.isEmpty()){
            model.addAttribute("list3",list3);
        } else {
            model.addAttribute("list3","empty");
        }
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate3(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }
    @GetMapping("/category_asc3")
    public String category_asc3(Model model,Criteria cri){
        List<ProductVO> list3 = service.getListPriceAsc3(cri);
        String categoryName = "sports/leisure";
        if(!list3.isEmpty()){
            model.addAttribute("list3",list3);
        } else {
            model.addAttribute("list3","empty");
        }
        model.addAttribute("pageMaker",new PageDTO(cri, service.productGetTotalCate3(cri)));
        model.addAttribute("categoryName",categoryName);
        return "product/category_list";
    }

    //메인 페이지 이동
    @RequestMapping(value="/main", method = RequestMethod.GET)
    public void mainPageGET(Model model) {

        log.info("메인 페이지 진입");

    }

    @GetMapping("/display")
    public ResponseEntity<byte[]> getImage(String fileName){

        log.info("getImage()........" + fileName);

        File file = new File("c:\\upload\\" + fileName);

        ResponseEntity<byte[]> result = null;

        try {

            HttpHeaders header = new HttpHeaders();

            header.add("Content-type", Files.probeContentType(file.toPath()));

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    /* 이미지 정보 반환 */
    @GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<AttachImageVO>> getAttachList(int id){

        log.info("getAttachList.........." + id);

        return new ResponseEntity<List<AttachImageVO>>(attachService.getAttachList(id), HttpStatus.OK);

    }

    /* 상품 검색 */
    @GetMapping("/search")
    public String searchGoodsGET(Criteria cri, Model model) {

        log.info("cri : " + cri);

        List<ProductVO> list = service.getList(cri);
        log.info("pre list : " + list);
        if(!list.isEmpty()) {
            model.addAttribute("list", list);
            log.info("list : " + list);
        } else {
            model.addAttribute("listcheck", "empty");

            return "search";
        }

        model.addAttribute("pageMaker", new PageDTO(cri, service.productGetTotal(cri)));

        String[] typeArr = cri.getType().split("");

        for(String s : typeArr) {
            if(s.equals("T") || s.equals("A")) {
                model.addAttribute("filter_info", service.getCateInfoList(cri));
            }
        }

        return "search";

    }

    /* 상품 상세 */
    @GetMapping("/goodsDetail/{id}")
    public String goodsDetailGET(@PathVariable("id")int id, Model model) {

        log.info("goodsDetailGET()..........");

        model.addAttribute("goodsInfo", service.getGoodsInfo(id));

        return "/product/goodsDetail";
    }
}
