package com.green.service;

import com.green.mapper.EventMapper;
import com.green.vo.EventVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class EventServiceImpl implements EventService {
    @Setter(onMethod_ = @Autowired)
    private EventMapper mapper;


    @Override
    public int eventListCount() {
        return mapper.eventListCount();
    }

    @Override
    public List<EventVo> eventList(EventVo event) {
        return mapper.eventList(event);
    }

    @Override
    public EventVo eventOne(String event_id) {
        return mapper.eventOne(event_id);
    }

    @Override
    public int eventInsert(EventVo event) {
        return mapper.eventInsert(event);
    }

    @Override
    public int eventUpdate(EventVo event) {
        return mapper.eventUpdate(event);
    }

    @Override
    public int eventDelete(String event_id) {
        return mapper.eventDelete(event_id);
    }
}