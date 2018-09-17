package com.zhiyou100.controller;

import com.google.gson.Gson;
import com.zhiyou100.responsemessage.Response;
import com.zhiyou100.responsemessage.ResponseMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration//表示测试的是controller
public class ProjectTest {
    @Autowired
    WebApplicationContext wac;
    //controller测试核心类  mock:模拟
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void projectQueryPage() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/project/page.do").param("page", "0")
                .param("pageSize","1"))
                .andDo(print())//打印该次请求的结果
                .andExpect(status().isOk())//期待方法调用成功
                .andReturn();

        String responseString = mvcResult.getResponse().getContentAsString();
        ResponseMessage response = new Gson().fromJson(responseString, ResponseMessage.class);
        assertTrue(response.getCode() == 2);
        System.out.println(response);
    }

    @Test
    public void comment() {
    }

    @Test
    public void add() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }
}