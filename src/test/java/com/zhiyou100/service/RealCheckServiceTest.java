package com.zhiyou100.service;

import com.zhiyou100.pojo.RealCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})
public class RealCheckServiceTest {
@Autowired
RealCheckService realCheckService;
    @Test
    public void selectByPage() {

        List<RealCheck> realChecks = realCheckService.selectByPage(1);
        System.out.println(realChecks);

    }
}