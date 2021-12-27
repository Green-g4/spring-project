package com.green.mapper;

import com.green.vo.Criteria;
import com.green.vo.ReviewVO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ReviewMapper {
    public List<ReviewVO> getList(int product_id);
    public List<ReviewVO> getListPaging(@Param("product_id") int product_id,@Param("cri") Criteria cri);
    public ReviewVO read(int review_num);
    public void insert(ReviewVO vo);
    public int delete(int review_num);
    public int update(ReviewVO vo);
    public String idCheck(int review_num);
    public int countReview(int product_id);
}
