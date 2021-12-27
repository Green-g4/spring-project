package com.green.service;

import com.green.mapper.AdminMapper;
import com.green.vo.CategoryVO;
import com.green.vo.Criteria;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j
public class AdminServiceImpl implements AdminService{
    @Setter(onMethod_=@Autowired)
    private AdminMapper adminMapper;

    @Transactional
    @Override
    public void ProductEnroll(ProductVO product) {
        log.info("(service)ProductEnroll........");

        adminMapper.ProductEnroll(product);
        if(product.getImageList() == null || product.getImageList().size() <= 0) {
            return;
        }
        product.getImageList().forEach(attach ->{

            attach.setId(product.getId());
            adminMapper.imageEnroll(attach);

        });
    }

    @Override
    public List<CategoryVO> cateList() {
        log.info("(service)cateList........");

        return adminMapper.cateList();
    }

    @Override
    public List<ProductVO> goodsGetList(Criteria cri) {
        log.info("goodsGetTotalList()..........");
        return adminMapper.goodsGetList(cri);
    }

    @Override
    public int goodsGetTotal(Criteria cri) {
        log.info("goodsGetTotal().........");
        return adminMapper.goodsGetTotal(cri);
    }

    @Override
    public ProductVO goodsGetDetail(int id) {
        log.info("(service)bookGetDetail......." + id);

        return adminMapper.goodsGetDetail(id);
    }

    @Override
    public int goodsModify(ProductVO vo) {
        int result = adminMapper.goodsModify(vo);

        if(result == 1 && vo.getImageList() != null && vo.getImageList().size() > 0) {

            adminMapper.deleteImageAll(vo.getId());

            vo.getImageList().forEach(attach -> {

                attach.setId(vo.getId());
                adminMapper.imageEnroll(attach);

            });

        }

        return result;
    }


    @Override
    public int goodsDelete(int id) {
        log.info("goodsDelete..........");

        return adminMapper.goodsDelete(id);
    }
}
