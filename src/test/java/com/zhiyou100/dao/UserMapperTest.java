package com.zhiyou100.dao;

import com.zhiyou100.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
@WebAppConfiguration//表示测试的是controller
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    WebApplicationContext wac;
    //controller测试核心类  mock:模拟
    MockMvc mockMvc;

    @Before//在所有测试执行之前，调用该方法 对mockmvc初始化
    public void setUp()  {
        mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void insertSelective() {
/*        User user = new User();
        user.setUsName("tom");
        user.setUsPassword("123");
        int insert = userMapper.insertSelective(user);
        System.out.println(insert);*/
      User tom = userMapper.selectBySelective("tom", "123");
        System.out.println(tom);
    }
}