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
    @Test
    public void getList(){
        mapper.getList().forEach(i->log.info(i));
    }
    @Test
    public void CategorySearch(){
        List<ProductVO> productVOList = mapper.getList();
        List<ProductVO> new_list = new ArrayList<>();
        String digital_homeapp = "digital/homeapp";
        for (int i = 0; i < productVOList.size(); i++) {
            if (mapper.getList().get(i).getCategory_name().equals(digital_homeapp)){
                new_list.add(mapper.read(i));
                log.info(new_list);
            }
        }
        log.info(new_list);
        log.info(mapper.getList().get(0).getCategory_name());
    }
}
