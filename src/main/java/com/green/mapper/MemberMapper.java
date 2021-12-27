package com.green.mapper;


import com.green.vo.MemberVO;

import java.util.List;

public interface MemberMapper {

    public List<MemberVO> getList();
    public void insert(MemberVO vo);
    public MemberVO read(int id);
    public void update(MemberVO vo);
    public void delete(int id);
    public int idCheck(String member_id);
    public String findId(MemberVO vo);
    public void changePw(MemberVO vo);
    public String idMatchEmail(MemberVO vo);
    public String adminCheck(String member_id);
    /* 로그인 */
    public MemberVO memberLogin(MemberVO vo);
    public String getId(String member_id);
    public MemberVO getMemberInfo(String member_id);
}


