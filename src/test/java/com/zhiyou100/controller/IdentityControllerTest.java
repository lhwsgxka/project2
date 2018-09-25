package com.zhiyou100.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mvc.xml"})
@WebAppConfiguration//表示测试的是controller
public class IdentityControllerTest {

    @Autowired
    WebApplicationContext wac;
    //controller测试核心类  mock:模拟
    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void pictureUpload() throws Exception {
        MockMultipartFile file1 = new MockMultipartFile("negative.jpg", "do.jpeg", "image/jpeg", new FileInputStream("C:\\Users\\Administrator\\Desktop\\negative.jpg"));
        MockMultipartFile file2 = new MockMultipartFile("positive.jpg", "do.jpeg", "image/jpeg", new FileInputStream("C:\\Users\\Administrator\\Desktop\\positive.jpg"));
        MockMultipartFile file3 = new MockMultipartFile("hand.jpg", "do.jpeg", "image/jpeg", new FileInputStream("C:\\Users\\Administrator\\Desktop\\hand.jpg"));
        MvcResult mvcResult = mockMvc
                .perform(fileUpload("/id/pictureUpload.do")
                        .file(file1)
                        .file(file2)
                        .file(file3).param("phone","17320114371").param("idCard","123123123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }
}