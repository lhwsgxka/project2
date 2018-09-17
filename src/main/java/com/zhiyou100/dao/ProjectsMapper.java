package com.zhiyou100.dao;

import com.zhiyou100.pojo.Projects;

import java.util.List;

public interface ProjectsMapper {
    int deleteByPrimaryKey(Integer psId);

    int insert(Projects record);

    int insertSelective(Projects record);

    Projects selectByPrimaryKey(Integer psId);
//查询分页
    List<Projects> selectByPage(Integer page);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);
}