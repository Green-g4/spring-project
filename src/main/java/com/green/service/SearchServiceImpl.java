package com.green.service;

import com.green.mapper.SearchMapper;
import com.green.vo.Criteria;
import com.green.vo.ProductVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class SearchServiceImpl implements SearchService{

    @Setter(onMethod_=@Autowired)
    private SearchMapper mapper;

    @Override
    public List<ProductVO> getProductList(Criteria cri) {
        log.info("상품리스트를 불러옵니다...");
        return mapper.getProductList(cri);
    }

    @Override
    public int getTotal(Criteria cri) {
        log.info("전체상품이 몇개있는지 가져옵니다...");
        return mapper.getTotal(cri);
    }
}
