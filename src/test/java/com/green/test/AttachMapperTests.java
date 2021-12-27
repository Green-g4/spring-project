package com.green.test;

import com.green.mapper.AttachMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/spring/root-context.xml")
@Log4j

public class AttachMapperTests {

    @Setter(onMethod_=@Autowired)
    private AttachMapper mapper;

    /*이미지 정보 반환*/
    @Test
    public void getAttachListTests() {

        int id = 2;

        System.out.println("이미지 정보 : " + mapper.getAttachList(id));


    }

}
