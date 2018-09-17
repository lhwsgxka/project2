package com.zhiyou100.service;

import com.zhiyou100.dao.ProjectsMapper;
import com.zhiyou100.pojo.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {
    @Autowired
    ProjectsMapper projectsMapper;

    public int deleteByPrimaryKey(Integer usId) {
        return projectsMapper.deleteByPrimaryKey(usId);
    }

    public int insert(Projects record) {
        return projectsMapper.insert(record);
    }

    public int insertSelective(Projects record) {
        return projectsMapper.insertSelective(record);
    }
    //查询
    public Projects selectByPrimaryKey(Integer usId) {
        return projectsMapper.selectByPrimaryKey(usId);
    }
    public List<Projects> selectByPage(Integer page){
        return projectsMapper.selectByPage(page);
    }

    public int updateByPrimaryKeySelective(Projects record) {
        return projectsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Projects record) {
        return projectsMapper.updateByPrimaryKey(record);
    }
}