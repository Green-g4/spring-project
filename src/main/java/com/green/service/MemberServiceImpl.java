package com.green.service;

import com.green.mapper.MemberMapper;
import com.green.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class MemberServiceImpl implements MemberService {
    @Setter(onMethod_ = @Autowired)
    private MemberMapper mapper;

    @Override
    public List < MemberVO > getList() {
        log.info("서비스에서 member getList---------------------------------");
        return mapper.getList();
    }

    @Override
    public void insert(MemberVO vo) {
        log.info("서비스에서 member insert----------------------------------");
        mapper.insert(vo);
    }

    @Override
    public MemberVO read(int id) {
        log.info("서비스에서 member read------------------");
        return mapper.read(id);
    }

    @Override
    public void update(MemberVO vo) {
        log.info("서비스에서 member update------------------");
        mapper.update(vo);
    }

    @Override
    public void delete(int id) {
        log.info("서비스에서 member delete------------------");
        mapper.delete(id);
    }
    @Override
    public int idCheck(String member_id) throws Exception {

        return mapper.idCheck(member_id);
    }
    @Override
    public String findId(MemberVO vo) throws Exception {

        return mapper.findId(vo);
    }
    @Override
    public void changePw(MemberVO vo) throws Exception {

        mapper.changePw(vo);
    }

    @Override
    public String idMatchEmail(MemberVO vo) {
        return mapper.idMatchEmail(vo);
    }

    @Override
    public String adminCheck(String member_id) {
        return mapper.adminCheck(member_id);
    }

    /* 로그인 */
    @Override
    public MemberVO memberLogin(MemberVO vo) throws Exception {

        return mapper.memberLogin(vo);
    }

    @Override
    public String getId(String member_id) {
        return mapper.getId(member_id);
    }

}