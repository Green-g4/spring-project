package com.green.mapper;

import com.green.vo.ProductVO;

import java.util.List;

public interface ProductMapper {
    public List<ProductVO> getList();
    public List<ProductVO> digital_homeappList();
    public List<ProductVO> life_healthList();
    public List<ProductVO> sports_leisureList();
    public void insert(ProductVO vo);
    public ProductVO read(int id);
    public void update(ProductVO vo);
    public void delete(int id);
}
