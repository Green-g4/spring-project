package com.green.mapper;

import com.green.vo.AuthorVO;
import com.green.vo.Criteria;

import java.util.List;

public interface AuthorMapper {
    /* 관리자 등록 */
    public void authorEnroll(AuthorVO author);

    /* 관리자 목록 */
    public List<AuthorVO> authorGetList(Criteria cri);

    /* 관리자 총 수 */
    public int authorGetTotal(Criteria cri);

    /* 작가 상세 */
    public AuthorVO authorGetDetail(int authorId);

    /* 작가 정보 수정 */
    public int authorModify(AuthorVO author);

    /* 작가 정보 삭제 */
    public int authorDelete(int authorId);
}
