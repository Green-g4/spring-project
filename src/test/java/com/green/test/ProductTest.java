package com.green.test;

import com.green.mapper.ProductMapper;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductTest {
    @Setter(onMethod_=@Autowired)
    ProductMapper mapper;

    @Test
    public void insert(){
        ProductVO vo = new ProductVO();
        vo.setId(10);
        vo.setProduct_name("캠핑용 바베큐 그릴");
        vo.setProduct_price(230000);
        vo.setProduct_discount(0);
        vo.setProduct_totalprice(vo.getProduct_price());
        vo.setProduct_stock(530);
        vo.setProduct_img("Camping_Grill.jpg");
        vo.setProduct_date(new Date());
        mapper.insert(vo);
    }
}
