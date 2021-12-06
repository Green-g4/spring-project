package com.green.mapper;

import com.green.vo.Criteria;
import com.green.vo.ProductVO;

import java.util.List;

public interface SearchMapper {
    public List<ProductVO> getProductList(Criteria cri); //상품전체리스트 검색용 메서드
    public int getTotal(Criteria cri); //상품 총 개수 확인 메서드
    //public String[] getProductId(String keyword); //상품 id 리스트 요청
}
