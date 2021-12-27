package com.green.controller;

import com.green.service.EventService;
import com.green.service.MemberService;
import com.green.vo.EventVo;
import com.green.vo.PagingVo;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log4j
@RequestMapping("/event/*")
public class EventController {

    @Setter(onMethod_ = @Autowired)
    EventService service;
    @Setter(onMethod_ = @Autowired)
    MemberService memberService;

    @RequestMapping(value = "/eventList")
    public String eventList(@ModelAttribute("Event") EventVo event,
                            @RequestParam(defaultValue="1") int curPage,
                            Model model, HttpServletRequest request
    ) {
        log.info("eventList page");
        int listCnt = service.eventListCount();
        PagingVo paging = new PagingVo(listCnt, curPage);
        event.setStartIndex(paging.getStartIndex());
        event.setCntPerPage(paging.getPageSize());

        List<EventVo> eventList=service.eventList(event);
        model.addAttribute("eventList", eventList);
        model.addAttribute("listCnt", listCnt);
        model.addAttribute("paging", paging);

        HttpSession session = request.getSession();

        if(session.getAttribute("signedUser")==null){
            return "event/userEventList";
        }
        String memberId = session.getAttribute("signedUser").toString();

        if(memberService.adminCheck(memberId).equals("y")){
            return "event/eventList";
        }
        else{
            return "event/userEventList";
        }
    }

    @RequestMapping(value = "/eventRegi")
    public String eventRegi() {
        log.info("event Regi page");
        return "event/eventDetail";
    }

    @RequestMapping(value = "/eventDetail/{event_id}")
    public String eventEdit(@PathVariable String event_id, Model model) {
        log.info("event detail page [event_id = {}]"+event_id);
        model.addAttribute("event",service.eventOne(event_id));
        return "event/eventDetail";
    }
    @RequestMapping(value = "/userEventDetail/{event_id}")
    public String userEvent(@PathVariable String event_id, Model model) {
        log.info("event detail page [event_id = {}]"+event_id);
        model.addAttribute("event",service.eventOne(event_id));
        return "event/userEventDetail";
    }

    @ResponseBody
    @RequestMapping(value = "/eventInsert", method=RequestMethod.POST)
    public int noticeInsert(EventVo event) {
        log.info("event insert");
        return service.eventInsert(event);
    }

    @ResponseBody
    @RequestMapping(value = "/eventUpdate", method=RequestMethod.POST)
    public int eventUpdate(EventVo event) {
        log.info("event update {} "+ event.getEvent_id());
        return service.eventUpdate(event);
    }

    @ResponseBody
    @RequestMapping(value = "/eventDelete", method=RequestMethod.POST)
    public int eventDelete(EventVo event) {
        log.info("event delete {} "+ event.getEvent_id());
        return service.eventDelete(event.getEvent_id());
    }
}