package com.zhiyou100.dao;

import com.zhiyou100.pojo.ProjectsType;

public interface ProjectsTypeMapper {
    int deleteByPrimaryKey(Integer pstId);

    int insert(ProjectsType record);

    int insertSelective(ProjectsType record);

    ProjectsType selectByPrimaryKey(Integer pstId);

    int updateByPrimaryKeySelective(ProjectsType record);

    int updateByPrimaryKey(ProjectsType record);
}