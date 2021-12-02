package com.green.test;

import com.green.mapper.SearchMapper;
import com.green.vo.Criteria;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/root-context.xml")
@Log4j
public class SearchTest {

    @Setter(onMethod_=@Autowired)
    private SearchMapper mapper;

    @Test
    public void getProductListTest(){
        Criteria cri = new Criteria();
        //System.out.println("cri: " + cri);
        List<ProductVO> list = mapper.getProductList(cri);
        System.out.println("list: " + list);
        System.out.println("==========================================");

        int productTotal = mapper.getTotal(cri);
        System.out.println("total: " + productTotal);
    }

}
