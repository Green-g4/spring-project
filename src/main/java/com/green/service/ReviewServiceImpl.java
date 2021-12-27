package com.green.service;

import com.green.mapper.ReviewMapper;
import com.green.vo.Criteria;
import com.green.vo.ReviewPageDTO;
import com.green.vo.ReviewVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class ReviewServiceImpl implements ReviewService{

    @Setter(onMethod_=@Autowired)
    private ReviewMapper mapper;


    @Override
    public List<ReviewVO> getList(int product_id) {
        return mapper.getList(product_id);
    }

    @Override
    public ReviewPageDTO getListPaging(int product_id, Criteria cri) {
        log.info("========review getListPaging : product_id : " + product_id + " cri : " + cri);
        return new ReviewPageDTO(mapper.countReview(product_id), mapper.getListPaging(product_id,cri));
    }

    @Override
    public ReviewVO read(int review_num) {
        log.info("---------review read-------------");
        return mapper.read(review_num);
    }

    @Override
    public void insert(ReviewVO vo) {
        log.info("--------------review insert--------------");
        mapper.insert(vo);
    }

    @Override
    public int delete(int review_num) {
        log.info("=============review delete=================");
        return mapper.delete(review_num);
    }

    @Override
    public int update(ReviewVO vo) {
        log.info("==============review update================");
        return mapper.update(vo);
    }

    @Override
    public String idCheck(int review_num) {
        return mapper.idCheck(review_num);
    }
}
