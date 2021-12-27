package com.green.service;

import com.green.mapper.AuthorMapper;
import com.green.vo.AuthorVO;
import com.green.vo.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class AuthorServiceImpl implements AuthorService{

    @Setter(onMethod_=@Autowired)
    private AuthorMapper mapper;

    @Override
    public void authorEnroll(AuthorVO author) throws Exception {
        log.info("서비스에서의 데이터 추가 : " + author);
        mapper.authorEnroll(author);
    }

    @Override
    public List<AuthorVO> authorGetList(Criteria cri) throws Exception {
        log.info("서비스에서의 리스트 가져오기 : " + cri);
        return mapper.authorGetList(cri);
    }

    @Override
    public int authorGetTotal(Criteria cri) throws Exception {
        log.info("서비스에서 관리자 총 수 가져오기 : " + cri);
        return mapper.authorGetTotal(cri);
    }

    @Override
    public AuthorVO authorGetDetail(int authorId) throws Exception {
        log.info("authorGetDetail........" + authorId);
        return mapper.authorGetDetail(authorId);
    }

    @Override
    public int authorModify(AuthorVO author) throws Exception {
        log.info("(service) authorModify........." + author);
        return mapper.authorModify(author);
    }

    @Override
    public int authorDelete(int authorId) {
        log.info("authorDelete..........");

        return mapper.authorDelete(authorId);
    }
}
