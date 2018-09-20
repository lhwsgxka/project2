package com.zhiyou100.service;

import com.zhiyou100.exception.CrowdFundingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
public class PageServiceTest {
@Autowired
PageService pageService;
    @Test
    public void selfMotionInform() throws IOException, CrowdFundingException {
    pageService.selfMotionInform();
    }
}