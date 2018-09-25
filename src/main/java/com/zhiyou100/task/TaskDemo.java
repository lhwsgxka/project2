package com.zhiyou100.task;


import com.zhiyou100.exception.CrowdFundingException;
import com.zhiyou100.service.PageService;
import com.zhiyou100.service.RealCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaskDemo {
    @Autowired
    RealCheckService realCheckService;
    @Autowired
    PageService pageService;

    public static void main(String[] args) {

        new ClassPathXmlApplicationContext("spring.xml");
    }

    public void hello() {
        System.out.println("hello");
    }

    /***
     * 自动处理实名认证
     * @throws IOException
     * @throws CrowdFundingException
     */
    public void selfMotionInform() throws IOException, CrowdFundingException {
       pageService.selfMotionInform();
    }

}
