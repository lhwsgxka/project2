package com.zhiyou100.controller;

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

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration//表示测试的是controller
public class CommentTest {

    @Autowired
    WebApplicationContext wac;
    //controller测试核心类  mock:模拟
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
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