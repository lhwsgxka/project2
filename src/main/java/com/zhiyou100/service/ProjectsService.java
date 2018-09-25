package com.zhiyou100.service;

import com.github.pagehelper.PageHelper;
import com.zhiyou100.dao.ProjectsMapper;
import com.zhiyou100.pojo.Comments;
import com.zhiyou100.pojo.Projects;
import com.zhiyou100.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    //通过id查询项目
    public Projects selectByPrimaryKey(Integer usId) {
        return projectsMapper.selectByPrimaryKey(usId);
    }
    //分页查询审核中的项目
    public List<Projects> selectByAuditPage(int page) {
        PageHelper.startPage(page, 5);
        return projectsMapper.selectByAuditPage();
    }
    //分页查询众筹时间到的
    public List<Projects> selectByFailed(int page){
        //分页
        PageHelper.startPage(page, 5);
        //获取当前时间与数据库项目截止时间匹配
        String date = DateTimeUtil.dateToStr(new Date(),"yyyy-MM-dd");
        System.out.println("date"+date);
        return  projectsMapper.selectByFailed(date);
    }
    //分页查询项目
    public List<Projects> selectByPage(int page) {
        PageHelper.startPage(page, 5);
        return projectsMapper.selectByPage();
    }

    //分页查询指定项目评论
    public List<Comments> selectCommentByPage(int id, int page) {
        PageHelper.startPage(page, 5);
        return projectsMapper.selectCommentByPage(id);
    }



    public int updateByPrimaryKeySelective(Projects record) {
        return projectsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Projects record) {
        return projectsMapper.updateByPrimaryKey(record);
    }
}