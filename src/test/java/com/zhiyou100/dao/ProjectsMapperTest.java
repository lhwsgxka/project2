package com.zhiyou100.dao;


import com.github.pagehelper.PageHelper;
import com.zhiyou100.pojo.Projects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml"})

public class ProjectsMapperTest {
@Autowired
ProjectsMapper projectsMapper;
    @Test
    public void selectByPage() {
        PageHelper.startPage(0,1);
        List<Projects> projects = projectsMapper.selectByPage();
        System.out.println(projects);
        /*Page<Object> page = PageHelper.offsetPage(0, 1);
        System.out.println(page);
*/
    }
}