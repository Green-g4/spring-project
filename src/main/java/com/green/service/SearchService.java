package com.green.service;

import com.green.vo.Criteria;
import com.green.vo.ProductVO;

import java.util.List;

public interface SearchService {

    public List<ProductVO> getProductList(Criteria cri);
    public int getTotal(Criteria cri);
}
