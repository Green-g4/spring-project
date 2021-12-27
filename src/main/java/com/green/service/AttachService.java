package com.green.service;

import com.green.vo.AttachImageVO;

import java.util.List;

public interface AttachService {
    /* 이미지 데이터 반환 */
    public List<AttachImageVO> getAttachList(int id);
}
