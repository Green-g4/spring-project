package com.green.service;

import com.green.vo.AuthorVO;
import com.green.vo.Criteria;

import java.util.List;

public interface AuthorService {
    /* 관리자 등록 */
    public void authorEnroll(AuthorVO author) throws Exception;

    /* 관리자 목록 */
    public List<AuthorVO> authorGetList(Criteria cri) throws Exception;

    /* 관리자 총 수 */
    public int authorGetTotal(Criteria cri) throws Exception;

    /* 관리자 상세 페이지 */
    public AuthorVO authorGetDetail(int authorId) throws Exception;

    /* 관리자 정보 수정 */
    public int authorModify(AuthorVO author) throws Exception;

    /* 작가 정보 삭제 */
    public int authorDelete(int authorId);
}
