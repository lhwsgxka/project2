package com.zhiyou100.dao;

import com.zhiyou100.pojo.QuestionOther;

public interface QuestionOtherMapper {
    int deleteByPrimaryKey(Integer questionotherid);

    int insert(QuestionOther record);

    int insertSelective(QuestionOther record);

    QuestionOther selectByPrimaryKey(Integer questionotherid);

    int updateByPrimaryKeySelective(QuestionOther record);

    int updateByPrimaryKeyWithBLOBs(QuestionOther record);

    int updateByPrimaryKey(QuestionOther record);
}