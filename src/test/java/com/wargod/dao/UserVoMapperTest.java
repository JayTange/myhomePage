package com.wargod.dao;


import com.wargod.domain.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserVoMapperTest {

    @Autowired
    UserVoMapper userVoMapper;

    @Test
    public void testInsert() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setUserName("小w");
        userVo.setUserPassword("123456");
        userVo.setPhoneNumber("13345679876");
        int uid = userVoMapper.insert(userVo);
        System.out.println(userVo);
    }
}
