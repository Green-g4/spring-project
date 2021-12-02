package com.green.test;

import com.green.mapper.CategoryMapper;
import com.green.mapper.MemberMapper;
import com.green.vo.CategoryVO;
import com.green.vo.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/root-context.xml")
@Log4j


public class MemberTest {
    @Setter(onMethod_=@Autowired)
    private MemberMapper mapper;


    @Test
    public void inserttest(){
       mapper.getList().forEach(i->log.info(i));
    }

    @Test
    public void addtest(){
        MemberVO vo = new MemberVO();
        vo.setId(1);
        vo.setMember_id("test");
        vo.setMember_password("test");
        vo.setMember_name("test");
        vo.setMember_address("test");
        vo.setMember_phonenumber("test");
        vo.setMember_gender("test");
        mapper.insert(vo);

    }

}
