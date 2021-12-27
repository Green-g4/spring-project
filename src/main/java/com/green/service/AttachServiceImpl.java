package com.green.service;

import com.green.mapper.AttachMapper;
import com.green.vo.AttachImageVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class AttachServiceImpl implements AttachService{
    @Setter(onMethod_=@Autowired)
    private AttachMapper mapper;

    @Override
    public List<AttachImageVO> getAttachList(int id) {
        log.info("getAttachList.........");

        return mapper.getAttachList(id);
    }
}
