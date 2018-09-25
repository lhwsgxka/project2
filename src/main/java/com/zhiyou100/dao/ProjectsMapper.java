package com.zhiyou100.dao;

import com.zhiyou100.pojo.Comments;
import com.zhiyou100.pojo.Projects;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectsMapper {
    int deleteByPrimaryKey(Integer psId);

    int insert(Projects record);

    int insertSelective(Projects record);

    Projects selectByPrimaryKey(Integer psId);

    //分页查询项目
    List<Projects> selectByPage();
    //分页查询审核中的项目
    List<Projects>  selectByAuditPage();
   //分页查询评论
    List<Comments> selectCommentByPage(int id);
    //分页查询众筹时间到的
    List<Projects> selectByFailed(String date);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);

}