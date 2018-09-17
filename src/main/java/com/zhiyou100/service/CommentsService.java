package com.zhiyou100.service;

import com.zhiyou100.dao.CommentsMapper;
import com.zhiyou100.pojo.Comments;
import com.zhiyou100.pojo.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {
    @Autowired
    CommentsMapper commentsMapper;

    public int deleteByPrimaryKey(Integer usId) {
        return commentsMapper.deleteByPrimaryKey(usId);
    }

    public int insert(Comments record) {
        return commentsMapper.insert(record);
    }

    public int insertSelective(Comments record) {
        return commentsMapper.insertSelective(record);
    }
    //查询
    public Comments selectByPrimaryKey(Integer usId) {
        return commentsMapper.selectByPrimaryKey(usId);
    }

    public int updateByPrimaryKeySelective(Comments record) {
        return commentsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Comments record) {
        return commentsMapper.updateByPrimaryKey(record);
    }
}