package com.green.service;

import com.green.vo.CategoryVO;
import com.green.vo.Criteria;
import com.green.vo.ProductVO;

import java.util.List;

public interface AdminService {
    /* 상품 등록 */
    public void ProductEnroll(ProductVO product);

    /* 카테고리 리스트 */
    public List<CategoryVO> cateList();

    /* 상품 리스트 */
    public List<ProductVO> goodsGetList(Criteria cri);

    /* 상품 총 개수 */
    public int goodsGetTotal(Criteria cri);

    /* 상품 조회 페이지 */
    public ProductVO goodsGetDetail(int id);

    /* 상품 수정 */
    public int goodsModify(ProductVO vo);

    /* 상품 정보 삭제 */
    public int goodsDelete(int id);

    /* 지정 상품 이미지 정보 얻기 */
//    public List<AttachImageVO> getAttachInfo(int bookId);
}
