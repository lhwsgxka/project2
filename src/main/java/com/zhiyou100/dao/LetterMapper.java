package com.zhiyou100.dao;

import com.zhiyou100.pojo.Letter;

public interface LetterMapper {
    int deleteByPrimaryKey(Integer leId);

    int insert(Letter record);

    int insertSelective(Letter record);

    Letter selectByPrimaryKey(Integer leId);

    int updateByPrimaryKeySelective(Letter record);

    int updateByPrimaryKey(Letter record);
}