package com.green.mapper;

import com.green.vo.Criteria;
import com.green.vo.ProductVO;

import java.util.List;

public interface SearchMapper {
    public List<ProductVO> getProductList(Criteria cri);
    public int getTotal(Criteria cri);
}
