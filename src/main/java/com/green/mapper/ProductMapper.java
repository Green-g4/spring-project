package com.green.mapper;

import com.green.vo.CateFilterDTO;
import com.green.vo.CategoryVO;
import com.green.vo.Criteria;
import com.green.vo.ProductVO;

import java.util.List;
import java.util.Map;

public interface ProductMapper {
    public List<ProductVO> getListAsc(Criteria cri); //상품 오름차순
    public List<ProductVO> getList(Criteria cri); //상품 내림차순 + 크리테리아
    public List<ProductVO> getListCategory1(Criteria cri); //디지털/가전상품 내림차순 + 크리테리아
    public List<ProductVO> getListCategory2(Criteria cri); //생활/건강 내림차순 + 크리테리아
    public List<ProductVO> getListCategory3(Criteria cri); //스포츠/레져 내림차순 + 크리테리아
    public List<ProductVO> getListCategory(String cateName); //"digital/homeapp" , "life/health" , "sports/leisure" 넣으면 맞는 카테고리 나오게하는 리스트

    public List<ProductVO> getListPriceDesc1(Criteria cri); //디지털/가전 높은가격순 + 크리테리아
    public List<ProductVO> getListPriceAsc1(Criteria cri); //디지털/가전 낮은가격순 + 크리테리아
    public List<ProductVO> getListPriceDesc2(Criteria cri); //생활/건강 높은가격순 + 크리테리아
    public List<ProductVO> getListPriceAsc2(Criteria cri); //생활/건강 낮은가격순 + 크리테리아
    public List<ProductVO> getListPriceDesc3(Criteria cri); //스포츠/레져 높은가격순 + 크리테리아
    public List<ProductVO> getListPriceAsc3(Criteria cri); //스포츠/레져 높은가격순 + 크리테리아

    public int productGetTotal(Criteria cri); //전체상품 개수
    public int productGetTotalCate1(Criteria cri); //디지털/가전상품 개수
    public int productGetTotalCate2(Criteria cri); //생활/건강상품 개수
    public int productGetTotalCate3(Criteria cri); //스포츠/레져상품 개수

    /* 상품 검색 */
    public List<ProductVO> getGoodsList(Criteria cri);

    /* 상품 총 갯수 */
    public int goodsGetTotal(Criteria cri);

    /* 작가 id 리스트 요청 */
    public String[] getAuthorIdList(String keyword);

    /* 국내 카테고리 리스트 */
    public List<CategoryVO> getCateCode1();

    /* 외국 카테고리 리스트 */
    public List<CategoryVO> getCateCode2();

    /* 검색 대상 카테고리 리스트 */
    public String[] getCateList(Criteria cri);

    //    /* 카테고리 정보(+검색대상 갯수) */
    public CateFilterDTO getCateInfo(Criteria cri);

    /* 상품 정보 */
    public ProductVO getGoodsInfo(int id);

    public void insert(ProductVO vo);
    public ProductVO read(int id);
    public void update(ProductVO vo);
    public void delete(int id);
}
