package com.green.controller;

import com.green.service.ReviewService;
import com.green.vo.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@Slf4j
public class ReviewController {
    @Setter(onMethod_=@Autowired)
    ReviewService service;


    @GetMapping(value = "/pages/{product_id}/{page}", produces = {
            MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<ReviewPageDTO> getListPaging(
            @PathVariable("page") int page,@PathVariable("product_id") int product_id){
        log.info("1) Review Controller getListPaging=================");
        Criteria cri = new Criteria (page,5);
        log.info(""+cri);
        return new ResponseEntity<>((ReviewPageDTO) service.getListPaging(product_id, cri),HttpStatus.OK);
    }
    @ResponseBody
    @RequestMapping(value = "/detail/reviewList", method = RequestMethod.GET)
    public List<ReviewVO> getList(@RequestParam("id") int id) {
        log.info("getList review" + id);
        List<ReviewVO> review = service.getList(id);
        System.out.println(review);
        return review;
    }

    @ResponseBody
    @RequestMapping(value = "/detail/insertReview", method = RequestMethod.POST)
    public void insertReview(ReviewVO vo, HttpSession session){
        log.info("insert review");
        String member_id = (String) session.getAttribute("signedUser");
        vo.setMember_id(member_id);
        service.insert(vo);
    }
    @ResponseBody
    @RequestMapping(value = "/detail/deleteReview", method = RequestMethod.POST)
    public int deleteReview(ReviewVO vo, HttpSession session){
        log.info("delete review");
        int result = 0;
        MemberVO member = (MemberVO) session.getAttribute("signedUser");
        String memberId = service.idCheck(vo.getReview_num());
        if(member.getMember_id().equals(memberId)){
            result = service.delete(vo.getReview_num());
            log.info("delete review result : " + result);
            return result;
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/detail/updateReview", method =  RequestMethod.POST)
    public int updateReview(ReviewVO vo, HttpSession session){
        log.info("update review");
        int result =0;
        String sessionMemberId = (String) session.getAttribute("signedUser");
        System.out.println("vo review_num"+vo.getReview_num());
        String memberId = service.idCheck(vo.getReview_num());
        log.info("update review session memberId : " + sessionMemberId + "       memberId : " + memberId);
        if(sessionMemberId.equals(memberId)){
            result = service.update(vo);
            log.info("update review result : " + result);
            return result;
        }
        return result;
    }
}
