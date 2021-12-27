package com.green.service;

import com.green.mapper.NoticeMapper;
import com.green.vo.NoticeVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class NoticeServiceImpl implements NoticeService{
    @Setter(onMethod_ = @Autowired)
    private NoticeMapper mapper;


    @Override
    public int noticeListCount() {
        return mapper.noticeListCount();
    }

    @Override
    public List<NoticeVo> noticeList(NoticeVo notice) {
        return mapper.noticeList(notice);
    }

    @Override
    public NoticeVo noticeOne(String notice_id) {
        return mapper.noticeOne(notice_id);
    }

    @Override
    public int noticeInsert(NoticeVo notice) {
        return mapper.noticeInsert(notice);
    }

    @Override
    public int noticeUpdate(NoticeVo notice) {
        return mapper.noticeUpdate(notice);
    }

    @Override
    public int noticeDelete(String notice_id) {
        return mapper.noticeDelete(notice_id);
    }

}
