package com.zhiyou100.dao;

import com.zhiyou100.pojo.QuestionAll;

public interface QuestionAllMapper {
    int deleteByPrimaryKey(Integer questionid);

    int insert(QuestionAll record);

    int insertSelective(QuestionAll record);

    QuestionAll selectByPrimaryKey(Integer questionid);

    int updateByPrimaryKeySelective(QuestionAll record);

    int updateByPrimaryKey(QuestionAll record);
}