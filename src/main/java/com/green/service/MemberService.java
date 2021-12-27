package com.green.service;

import com.green.vo.MemberVO;

import java.util.List;

public interface MemberService {
    public List<MemberVO> getList();
    public void insert(MemberVO vo); //데이터 추가
    public MemberVO read(int id);
    public void update(MemberVO vo);
    public void delete(int id);
    public int idCheck(String member_id) throws Exception;
    public String findId(MemberVO vo) throws Exception;
    public void changePw(MemberVO vo) throws Exception;
    public String idMatchEmail(MemberVO vo);
    public String adminCheck(String member_id);
    /* 로그인 */
    public MemberVO memberLogin(MemberVO vo) throws Exception;
    public String getId(String member_id);
}