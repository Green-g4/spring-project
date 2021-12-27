package com.green.service;

import com.green.vo.*;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<ProductVO> getListAsc(Criteria cri);
    public List<ProductVO> getList(Criteria cri);
    public List<ProductVO> getListCategory(String cateName);
    public List<ProductVO> getListCategory1(Criteria cri);
    public List<ProductVO> getListCategory2(Criteria cri);
    public List<ProductVO> getListCategory3(Criteria cri);

    public List<ProductVO> getListPriceDesc1(Criteria cri);
    public List<ProductVO> getListPriceAsc1(Criteria cri);
    public List<ProductVO> getListPriceDesc2(Criteria cri);
    public List<ProductVO> getListPriceAsc2(Criteria cri);
    public List<ProductVO> getListPriceDesc3(Criteria cri);
    public List<ProductVO> getListPriceAsc3(Criteria cri);

    public int productGetTotal(Criteria cri);
    public int productGetTotalCate1(Criteria cri);
    public int productGetTotalCate2(Criteria cri);
    public int productGetTotalCate3(Criteria cri);

    /* 상품 검색 */
    public List<ProductVO> getGoodsList(Criteria cri);

    /* 상품 총 갯수 */
    public int goodsGetTotal(Criteria cri);

    /* 국내 카테고리 리스트 */
    public List<CategoryVO> getCateCode1();

    /* 외국 카테고리 리스트 */
    public List<CategoryVO> getCateCode2();

    //    /* 검색결과 카테고리 필터 정보 */
    public List<CateFilterDTO> getCateInfoList(Criteria cri);

    /* 상품 정보 */
    public ProductVO getGoodsInfo(int id);

    public void insert(ProductVO vo); //데이터 추가
    public ProductVO read(int id);
    public void update(ProductVO vo);
    public void delete(int id);
}
