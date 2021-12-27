package com.green.service;

import com.green.mapper.AttachMapper;
import com.green.mapper.SearchMapper;
import com.green.vo.AttachImageVO;
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

    @Setter(onMethod_=@Autowired)
    private AttachMapper attachMapper;

    @Override
    public List<ProductVO> getProductList(Criteria cri) {
        log.info("서비스에서 product getList 검색 내림차순 + 10개씩---------------------------------");
        List<ProductVO> list = mapper.getProductList(cri);

        list.forEach(product -> {

            int id = product.getId();

            List<AttachImageVO> imageList = attachMapper.getAttachList(id);

            product.setImageList(imageList);

        });

        return list;
    }

    @Override
    public int getTotal(Criteria cri) {
        log.info("전체상품이 몇개있는지 가져옵니다...");
        return mapper.getTotal(cri);
    }

}
