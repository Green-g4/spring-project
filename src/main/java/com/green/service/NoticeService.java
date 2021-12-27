package com.green.service;

import com.green.vo.NoticeVo;

import java.util.List;

public interface NoticeService {
    public int noticeListCount();
    public List<NoticeVo> noticeList(NoticeVo notice);
    public NoticeVo noticeOne(String notice_id);
    public int noticeInsert(NoticeVo notice);
    public int noticeUpdate(NoticeVo notice);
    public int noticeDelete(String notice_id);
}
