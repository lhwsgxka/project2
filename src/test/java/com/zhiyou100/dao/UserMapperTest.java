package com.zhiyou100.dao;

import com.zhiyou100.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void insertSelective() {
/*        User user = new User();
        user.setUsName("tom");
        user.setUsPassword("123");
        int insert = userMapper.insertSelective(user);
        System.out.println(insert);*/
        List<User> tom = userMapper.selectBySelective("tom", "123");
        System.out.println(tom);
    }
}