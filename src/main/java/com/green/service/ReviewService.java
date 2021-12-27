package com.green.service;

import com.green.vo.Criteria;
import com.green.vo.ReviewPageDTO;
import com.green.vo.ReviewVO;

import java.util.List;

public interface ReviewService {
    public List<ReviewVO> getList(int product_id);
    public ReviewPageDTO getListPaging(int product_id, Criteria cri);
    public ReviewVO read(int review_num);
    public void insert(ReviewVO vo);
    public int delete(int review_num);
    public int update(ReviewVO vo);
    public String idCheck(int review_num);



}
