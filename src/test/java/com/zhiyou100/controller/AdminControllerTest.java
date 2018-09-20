package com.zhiyou100.controller;

import com.zhiyou100.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration//表示测试的是controller
public class AdminControllerTest {

    @Autowired
    WebApplicationContext wac;
    //controller测试核心类  mock:模拟
    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void admin() throws Exception {
        User user = new User();
        user.setUsId(2);
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/admin.do")
                .sessionAttr("login", user))
                .andDo(print())
                .andReturn();
    }

    @Test
    public void inform() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/inform.do")
                .param("state", "failed")
                .param("id", "1"))
                .andDo(print())
                .andReturn();
    }
}