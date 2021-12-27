package com.green.test;

import com.green.mapper.AdminMapper;
import com.green.mapper.ProductMapper;
import com.green.service.ProductService;
import com.green.vo.Criteria;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductTest {
    @Setter(onMethod_=@Autowired)
    ProductMapper mapper;

    @Setter(onMethod_=@Autowired)
    AdminMapper adminMapper;

    @Setter(onMethod_=@Autowired)
    ProductService productService;

    @Test
    public void getList(){
        Criteria cri = new Criteria();
        cri.setPageNum(2);
        cri.setAmount(16);
        int result = mapper.productGetTotal(cri);
        System.out.println("result................ "+result);
        List<ProductVO> list = mapper.getList(cri);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list: " + list.get(i).getId());
        }
    }
    @Test
    public void getList1(){
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setAmount(16);
        int result = mapper.productGetTotal(cri);
        System.out.println("result................ "+result);
        List<ProductVO> list = mapper.getListCategory1(cri);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list: " + list.get(i).getId());
        }
    }
    @Test
    public void getListCate(){
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setAmount(16);
        List<ProductVO> list = mapper.getListCategory("digital/homeapp");
        System.out.println(cri);
    }
    @Test
    public void getListCategory(){
        Criteria cri = new Criteria();
        cri.setPageNum(2);
        cri.setAmount(10);
        List<ProductVO> list = mapper.getListCategory1(cri);
        System.out.println(cri);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list: " + list.get(i).getId());
        }

    }
    @Test
    public void getGoodsInfo(){
        int id = 3;
        ProductVO goodsInfo = productService.getGoodsInfo(id);
        System.out.println("-------------------------------------------");
        System.out.println("전체 : " + goodsInfo);
        System.out.println("bookId: "+goodsInfo.getId());
        System.out.println("이미지 정보: " + goodsInfo.getImageList().isEmpty());
    }
    @Test
    public void getGoodsDe(){
        int id = 3;
        System.out.println(adminMapper.getAttachInfo(id));
    }
}
